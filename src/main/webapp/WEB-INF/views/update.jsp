
<%@ include file="includes/header.jspf" %>
<body>

<%@ include file="includes/navbar.jspf" %>

<div class="container">
<c:if test="${errorName.length()>0}">
<div class="alert alert-danger" role="alert">
	${errorName}
<!--	<c:out value="${errorName}"></c:out>  -->
</div>
</c:if>
<form action="update" method="POST">

  <div class="mb-3">
    <label for="name" class="form-label">ID</label>
    <input value="${student.getId()}" type="text" class="form-control" disabled >
     <input value="${student.getId()}" type="text" class="form-control" hidden name="id" id="id" >
    
     </div>
  <div class="mb-3">
    <label for="name" class="form-label">Name</label>
    <input required value="${student.getName()}" type="text" class="form-control" name="name" id="name" >
     </div>


  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>


<%@ include file="includes/footer.jspf" %>