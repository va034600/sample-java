<%@page import="org.scribe.builder.ServiceBuilder"%>
<%@page import="org.scribe.oauth.OAuthService"%>
<%@page import="eu.sample.java.oauth.GoogleDriveOauthApi"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

OAuthService oAuthService = new ServiceBuilder()
	.provider(GoogleDriveOauthApi.class)
	.apiKey(resourceBundle.getString("google_api_key"))
	.apiSecret(resourceBundle.getString("google_api_secret"))
	.callback("http://127.0.0.1:8080/sample-java-oauth-scribe/google/redirect.jsp")
	.scope("https://www.googleapis.com/auth/plus.login")
	.build();

String authUrl = oAuthService.getAuthorizationUrl(null);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<a href="<%=authUrl%>">認証</a>
</body>
</html>