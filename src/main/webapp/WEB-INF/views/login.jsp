<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<style>
    <%@include file="/WEB-INF/css/style.css"%>
</style>
<script type="text/javascript">
    <%@include file="/WEB-INF/js/script.js" %>
</script>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <input type="submit" />
        </form>

        <c:if test="${not empty errorMessage}">
            <div class="error">
                ${errorMessage}
            </div>
        </c:if>
    </div>
</body>
</html>
