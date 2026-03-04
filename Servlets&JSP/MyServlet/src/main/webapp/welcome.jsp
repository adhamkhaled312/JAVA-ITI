<%@ page import="gov.iti.jets.util.RandomUtil" %>
<%
    String user = request.getParameter("userName");
    if (user != null) {
        out.println("<h2>Welcome " + user + "</h2>");
    }
%>
<html>
<body>

<h2>Generate Random Number</h2>

<form method="post">
    Enter range:
    <input type="number" name="range" required>
    <button type="submit">Generate</button>
</form>

<div>
<%
    String rangeParam = request.getParameter("range");

    if (rangeParam != null) {

        int range = Integer.parseInt(rangeParam);
        RandomUtil util = new RandomUtil();
        int result = util.generateRandom(range);
        out.println("<h3>Random Number: " + result + "</h3>");
    }
%>
</div>

</body>
</html>