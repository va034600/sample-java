<%@page import="org.scribe.model.Token"%>
<%@page import="org.scribe.model.Verifier"%>
<%@page import="eu.sample.java.oauth.GoogleDriveOauthApi"%>
<%@page import="org.scribe.builder.ServiceBuilder"%>
<%@page import="org.scribe.oauth.OAuthService"%>
<%@page import="java.util.ResourceBundle"%>
<%
ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

OAuthService oAuthService = new ServiceBuilder()
	.provider(GoogleDriveOauthApi.class)
	.apiKey(resourceBundle.getString("google_api_key"))
	.apiSecret(resourceBundle.getString("google_api_secret"))
	.callback("http://localhost:8080/sample-java-oauth-scribe/google/redirect.jsp")
	.build();

String oauthVerifier = request.getParameter("code");

Verifier verifier = new Verifier(oauthVerifier);

Token accessToken = oAuthService.getAccessToken(null, verifier);

session.setAttribute("accessToken", accessToken);
session.setAttribute("oauthVerifier", oauthVerifier);

response.sendRedirect("http://localhost:8080/sample-java-oauth-scribe/google/end.jsp");
%>

