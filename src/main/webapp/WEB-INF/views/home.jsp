<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>Home.</h2>
    <h1>${message}</h1>
    <c:if test="${not empty userList}">
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Id code</th>
            <th>Name</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th>Dob</th>
            <th>Gender</th>
            <th>Status</th>
            <th>Created by</th>
            <th>Created date</th>
            <th>Updated by</th>
            <th>Update date</th>
            <th>Deleted by</th>
            <th>Deleted date</th>
             <th colspan="2"></th>
        </tr>
        <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.idCode}</td>
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.dob}</td>
            <td>${user.gender}</td>
            <td>${user.status}</td>
            <td>${user.createdby}</td>
            <td>${user.createddate}</td>
            <td>${user.updatedby}</td>
            <td>${user.updateddate}</td>
            <td>${user.deletedby}</td>
            <td>${user.deleteddate}</td>
            <td><a href="#">Update</a></td>
            <td><a href="#">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
    </c:if>
    <c:if test="${empty userList}">
        <p>No users found.</p>
    </c:if>
</body>
</html>
