<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page session="false" %>
<html>

<head>
    <title>Welcome</title>
</head>

<body>
<h1>Welcome to My Servlet</h1>
<c:set var="numberOfVisits" value="${applicationScope['numberOfVisits']+1}" scope="application"/>

<h3>Number of visits: ${applicationScope['numberOfVisits']}</h3>
<h3>Number of online users: ${applicationScope['onlineUsers']}</h3>
<p>
    <a href="HelloServlet">Go to HelloServlet</a>
</p>
<p>
    <a href="SetterAttributeServlet">Go to set attribute</a>
</p>
<p>
    <a href="GetterAttributeServlet">Go to get attribute</a>
</p>
</p>
<p>
    <a href="SetterCookiesServlet">Go to set cookie</a>
</p>
<p>
    <a href="GetterCookiesServlet">Go to get cookie</a>
</p>
<p>
    <a href="login.html">Go to Login page</a>
</p>
<p>
    <a href="register.html">Go to register page</a>
</p>
<p>
    <a href="registerJsp.html">Go to register JSP page</a>
</p>
<p>
    <a href="name.jsp">Say hello JSP</a>
</p>
<p>
    <a href="double.jsp">Double custom tag</a>
</p>
<p>
    <a href="login-mvc.jsp">Login using MVC</a>
</p>
<p>
    <a href="FilteredServlet">Go to filtered servlet</a>
</p>
<p>
    <a href="DownloadServlet">Download file</a>
</p>
<p>
    <a href="upload-file.jsp">Upload file</a>
</p>
<p>
    <a href="login-success.jsp">Restricted access</a>
</p>
</body>

</html>