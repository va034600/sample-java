<%@page import="oauth.signpost.OAuthConsumer"%>
<%@page import="oauth.signpost.OAuthProvider"%>
<%@page import="oauth.signpost.basic.DefaultOAuthProvider"%>
<%@page import="oauth.signpost.basic.DefaultOAuthConsumer"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	ResourceBundle resourceBundle = ResourceBundle
			.getBundle("application");

	OAuthConsumer oAuthConsumer = new DefaultOAuthConsumer(
			resourceBundle.getString("twitter_api_key"),
			resourceBundle.getString("twitter_api_secret"));

	OAuthProvider oAuthProvider = new DefaultOAuthProvider(
			"https://api.twitter.com/oauth/request_token",
			"https://api.twitter.com/oauth/access_token",
			"https://api.twitter.com/oauth/authorize");

	session.setAttribute("consumer", oAuthConsumer);
	session.setAttribute("provider", oAuthProvider);

	String callbackUri = "http://127.0.0.1:8080/sample-java-oauth-signpost/twitter/end.jsp";
	String authUrl = oAuthProvider.retrieveRequestToken(oAuthConsumer,
			callbackUri);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<a href="<%=authUrl%>">認証</a>
</body>
</html>