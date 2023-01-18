<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<html>
<body onload="makeActive('empwise')">
<form action="date-menu" method="post">
	<div class="container mt-3">
		<select class="form-select" id="sel1" name="eid">
			<c:forEach var="emp" items="${elist}">
			 <option value="${emp.eid}">${emp.name}(${emp.eid})</option>
			</c:forEach>
		</select>
	</div>
	<div class="dv">
	 <button class="btn btn-primary">Submit</button>
	</div>
</form>
</body>
</html>