<html>
  <head>
  	<link href='CSS/style.css' rel='stylesheet'>
  	<link href='CSS/bootstrap.min.css' rel='stylesheet'>
  </head>
<body>
	<table class="ta" style="margin-top: 30px;" border="1">
		<tr style="background-color: orange; color: white;">
			<td colspan="2">Employee Details</td>
		</tr>
		<tr>
			<th>Employee Id</th>
			<td>${employee.eid}</td>
		</tr>
		<tr>
			<th>Employee Name</th>
			<td>${employee.name}</td>
		</tr>
		<tr>
			<th>Employee Department</th>
			<td>${employee.name}</td>
		</tr>
	</table>
	<div class="dvv">
	 <button class="btn btn-success" onclick='history.back()'>Back</button>
	</div>
</body>
</html>