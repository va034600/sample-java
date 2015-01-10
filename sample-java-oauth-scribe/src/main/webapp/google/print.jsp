<%@page import="org.scribe.model.Response"%>
<%@page import="org.scribe.model.Verb"%>
<%@page import="org.scribe.model.OAuthRequest"%>
<%@page import="org.scribe.model.Token"%>
<%@page import="org.scribe.oauth.OAuthService"%>
<%@page import="org.scribe.builder.ServiceBuilder"%>
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
	.build();

Token accessToken = (Token)session.getAttribute("accessToken");

OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, "https://www.googleapis.com/oauth2/v1/userinfo");
oAuthService.signRequest(accessToken, oAuthRequest);

Response resp = oAuthRequest.send();
String json = resp.getBody();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	json:<%=json%><br>
</body>
</html>
