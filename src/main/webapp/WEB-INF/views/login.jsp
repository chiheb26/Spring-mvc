
<%@ include file="includes/header.jspf" %>
<body>


<%@ include file="includes/navbar.jspf" %>




<div class="container">

<c:if test="${errorMsg.length()>0}">
<div class="alert alert-danger" role="alert">
	${errorMsg}
</div>
</c:if>

<form action="login" method="post">
  <div class="mb-3">
    <label for="name" class="form-label">UserName</label>
    <input required type="text" class="form-control" name="name" id="name" >
     </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input required type="password" class="form-control" name="password" id="password">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>



<%@ include file="includes/footer.jspf" %>