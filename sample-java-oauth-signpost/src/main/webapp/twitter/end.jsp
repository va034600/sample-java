<%@page import="oauth.signpost.http.HttpParameters"%>
<%@page import="oauth.signpost.OAuthProvider"%>
<%@page import="oauth.signpost.OAuthConsumer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	OAuthConsumer oAuthConsumer = (OAuthConsumer) session.getAttribute("consumer");
	OAuthProvider oAuthProvider = (OAuthProvider) session.getAttribute("provider");

	String oauthVerifier = request.getParameter("oauth_verifier");
	oAuthProvider.retrieveAccessToken(oAuthConsumer, oauthVerifier);

	String token = oAuthConsumer.getToken();
	String tokenSecret = oAuthConsumer.getTokenSecret();

	HttpParameters httpParameters = oAuthProvider.getResponseParameters();
	String userId = httpParameters.get("user_id").first();
	String screenName = httpParameters.get("screen_name").first();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
token: <%=token%><br>
tokenSecret: <%=tokenSecret%><br>
userId: <%=userId%><br>
screenName: <%=screenName%><br>
</body>
</html>