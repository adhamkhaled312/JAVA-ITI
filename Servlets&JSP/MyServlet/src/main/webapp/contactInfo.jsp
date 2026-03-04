<head>
    <title>Register</title>
</head>

<body>
    <jsp:useBean id="userBean" scope="session" class="gov.iti.jets.entity.User"/>
    <jsp:setProperty name="userBean" property="*"/>


    <form action="afterRegister.jsp" method="POST">

        <label>Username:</label>
        <input type="text" name="username" placeholder="Enter your username" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" placeholder="Enter your password" required><br><br>

        <button type="submit">Register</button>

    </form>

</body>
