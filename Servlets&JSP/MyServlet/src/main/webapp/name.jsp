<html>
    <body>
        <%@include file="header.html"%><br>
        <form action = "welcome.jsp">
            Enter your name: <input type="text" name="userName" required>
            <input type="submit">
        </form>
        <jsp:include page="footer.html"/>
    </body>
</html>