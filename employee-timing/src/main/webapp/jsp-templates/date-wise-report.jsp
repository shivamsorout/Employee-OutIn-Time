<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <%@ include file="add-css.jsp" %>
 <body onload='makeActive("all")'>
  <div class="dvv">
   <label class="lah">${msg}</label>
  </div>
  <div class="container">
   <div class="card col-md-12 mx-auto">
    <div class="card-body">
     <c:if test="${elist=='[]'}">
      <div class="dv">
       <h2 style="color:red;">${noout}</h2>
      </div>
     </c:if>
     <c:if test="${elist!='[]'}">
     <table class='table table-hover'>
      <thead>
       <tr>
        <th class='las'>S.No</th><th class='las'>Employee id</th>
        <th class='las'>Out Time</th><th class='las'>In Time</th>
        <th class='las'>Total Time</th><th class='las'>Date</th>
       </tr>
      </thead>
      <tbody>
       <c:set var="ctr" value="0"/>
       <c:forEach var="emp" items="${elist}">
        <tr>
         <td class="las">${ctr=ctr+1}</td>
         <td class="las">
          <a href="emp-details?eid=${emp.eid}" style="text-decoration: underline;" title="Click to see employee details">${emp.eid}</a>
         </td>
         <td>${emp.outgoingTime}</td>
         <c:if test="${emp.incomingTime==null}">
          <td class="las">Not In</td>
         </c:if>
         <c:if test="${emp.incomingTime!=null}">
          <td class="las">${emp.incomingTime}</td> 
         </c:if>
         <c:if test="${emp.totalTime==null}">
          <td class="las">Not In</td>
         </c:if>
         <c:if test="${emp.totalTime!=null}">
          <td class="las">${emp.totalTime}</td>
         </c:if>
         <td class="las">${emp.date}</td>
        </tr>
       </c:forEach>
      </tbody>
     </table>
     </c:if>
    </div>
   </div>
  </div>
  <div class="dvv">
   <button class="btn btn-outline-primary btn-lg" onclick="history.back()">Back</button>
  </div>
 </body>
</html>