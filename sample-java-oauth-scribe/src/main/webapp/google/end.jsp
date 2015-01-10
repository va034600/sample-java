<%@page import="org.scribe.model.Token"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String oauthVerifier = (String)session.getAttribute("oauthVerifier");
Token accessToken = (Token)session.getAttribute("accessToken");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	token: <%=accessToken%><br>
	tokenSecret: <%=oauthVerifier%><br>
	<a href="print.jsp">print.jsp</a><br>
</body>
</html>
