
<%@ include file="includes/header.jspf" %>
<body>

<%@ include file="includes/navbar.jspf" %>

<div class="container">

<h4>Hello ${name}</h4>

<br>
<table class="table table-striped">
<thead>
<tr>
<th scope="col">ID</th>
<th scope="col">Name</th>
<th scope="col">isActive</th>
<th scope="col">Actions</th>

</tr>

</thead>
<tbody>
<c:forEach items="${students}" var="student">
<tr>
<th scope="row">
${student.id}
</th>
<td>
${student.name}
</td>
<td>
${student.isActive}
</td>
<td>
<a class="btn btn-danger mr-4" href="/delete?id=${student.id}">Delete</a> <a class="btn btn-success mr-4" href="/edit?id=${student.id}">Edit</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div class="container">
<a href="/add" class="btn btn-primary">Add Student</a>
</div>
<%@ include file="includes/footer.jspf" %>