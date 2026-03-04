<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Search Form</title>
    <style>
        body { text-align: center; font-family: Arial; }
        table { border:1px solid black; margin: auto; border-collapse: collapse; }
        th, td { padding: 5px 10px; border: 1px solid black; }
    </style>
</head>
<body>

<c:if test="${not empty loggedUser}">
    <h2>Welcome, ${loggedUser.firstName}!</h2>
</c:if>

<h1>Search Form</h1>
<p>Please enter the first name, last name, or part of any.</p>

<form action="SearchServlet" method="GET">
    <label><b>Name:</b></label>
    <input type="text" name="keyword">
    <button type="submit">Submit</button>
</form>

<br>

<c:if test="${empty users}">
    <p>No results found</p>
</c:if>

<c:if test="${not empty users}">
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Password</th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>

    </table>
</c:if>

</body>
