<%@page import="java.util.ResourceBundle"%>
<%@page import="org.scribe.builder.*"%>
<%@page import="org.scribe.model.*"%>
<%@page import="org.scribe.oauth.*"%>
<%@page import="org.scribe.builder.api.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	ResourceBundle resourceBundle = ResourceBundle
			.getBundle("application");

	OAuthService service = new ServiceBuilder()
			.provider(TwitterApi.class)
			.apiKey(resourceBundle.getString("twitter_api_key"))
			.apiSecret(resourceBundle.getString("twitter_api_secret"))
			.callback("http://127.0.0.1:8080/sample-java-oauth-scribe/twitter/end.jsp")
			.build();

	Token requestToken = service.getRequestToken();
	String authUrl = service.getAuthorizationUrl(requestToken);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<a href="<%=authUrl%>">認証</a>
</body>
</html>