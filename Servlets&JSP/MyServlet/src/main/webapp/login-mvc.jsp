<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<div>
    <h2>Login</h2>
    <form action="ControllerServlet" method="POST">
        <label>Username:</label>
        <input type="text" name="username" placeholder="Enter your name" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" placeholder="Enter your password" required><br><br>

        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>