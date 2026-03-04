<head>
    <title>Register</title>
</head>

<body>
<jsp:useBean id="userBean" scope="session" class="gov.iti.jets.entity.User"/>
<jsp:setProperty name="userBean" property="*"/>

<h2>User Data</h2>

First Name:
<jsp:getProperty name="userBean" property="firstName"/><br>

Last Name:
<jsp:getProperty name="userBean" property="lastName"/><br>

Username:
<jsp:getProperty name="userBean" property="username"/><br>

Password:
<jsp:getProperty name="userBean" property="password"/><br>

Age:
<jsp:getProperty name="userBean" property="age"/><br>

</body>