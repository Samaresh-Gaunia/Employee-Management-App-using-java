<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Employee List</h2>
<a href="add">Add Employee</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Role</th><th>Salary</th><th>Action</th></tr>
<c:forEach var="e" items="${list}">
<tr>
<td>${e.id}</td>
<td>${e.name}</td>
<td>${e.role}</td>
<td>${e.salary}</td>
<td>
<a href="edit/${e.id}">Edit</a>
<a href="delete/${e.id}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
