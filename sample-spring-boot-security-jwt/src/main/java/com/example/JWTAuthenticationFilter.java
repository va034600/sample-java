package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.example.JWTAuthorizationFilter.HEADER_STRING;
import static com.example.JWTAuthorizationFilter.TOKEN_PREFIX;
import static com.example.WebSecurityConfig.LOGIN_URL;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final String LOGIN_ID = "loginId";
    private static final String PASSWORD = "password";
    private static final int EXPIRATION_TIME = 100000;

    private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(LOGIN_URL, "POST"));

        // ログイン用のID/PWのパラメータ名を変更する
        setUsernameParameter(LOGIN_ID);
        setPasswordParameter(PASSWORD);
    }

    // 認証の処理
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            // requestパラメータからユーザ情報を読み取る
            UserForm userForm = new ObjectMapper().readValue(req.getInputStream(), UserForm.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userForm.getLoginId(),
                            userForm.getPass(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    // 認証に成功した場合の処理
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((User)auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, JWTAuthorizationFilter.SECRET.getBytes())
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

    }

}
