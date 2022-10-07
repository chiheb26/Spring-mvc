<%@ include file="includes/header.jspf" %>
<body>



<%@ include file="includes/navbar.jspf" %>



<div class="container">
<c:if test="${errorName.length()>0}">
<div class="alert alert-danger" role="alert">
	${errorName}
</div>
</c:if>

<form action="add?${_csrf.parameterName}=${_csrf.token}" method="POST">
  <div class="mb-3">
   
 <!--    <input type="hidden" name="${_csrf.parameterName} value="${_csrf.token}" /> -->
 <label for="name" class="form-label">Name</label>
   
    <input required type="text" class="form-control" name="name" id="name" >
     </div>


  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>

<%@ include file="includes/footer.jspf" %>