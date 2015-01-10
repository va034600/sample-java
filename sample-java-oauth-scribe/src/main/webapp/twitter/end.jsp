<%@page import="java.util.ResourceBundle"%>
<%@page import="org.scribe.builder.api.*"%>
<%@page import="org.scribe.builder.*"%>
<%@page import="org.scribe.oauth.*"%>
<%@page import="org.scribe.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

	OAuthService oAuthService = new ServiceBuilder()
			.provider(TwitterApi.class)
			.apiKey(resourceBundle.getString("api_key"))
			.apiSecret(resourceBundle.getString("api_secret")).build();

	String oauthVerifier = request.getParameter("oauth_verifier");
	Token oauthToken = new Token(request.getParameter("oauth_token"), oauthVerifier);

	Verifier verifier = new Verifier(oauthVerifier);

	Token accessToken = oAuthService.getAccessToken(oauthToken, verifier);
	OAuthRequest req = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
	oAuthService.signRequest(accessToken, req);

	Response resp = req.send();
	String json = resp.getBody();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	token: <%=accessToken.getToken()%><br>
	tokenSecret: <%=accessToken.getSecret()%><br>
	json:<%=json%><br>
</body>
</html>
