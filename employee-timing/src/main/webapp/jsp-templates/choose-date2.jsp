<html>
 <%@ include file="add-css.jsp" %>
 <body>
  <div style="background-color: #e4ffd8;" class="dvv">
   <label class="lah">View datewise Report of <i>${name}</i> </label>
  </div>
  <table class="ta" border="1" style="margin-top: 30px">
   <tr style="background-color: #ffd8e4;">
    <td>
     <form action="emp-current-date">
     <input type="hidden" name="eid" value="${eid}">
      <table style="width: 100%; font-size: 20px">
       <tr>
        <td>Current Date</td>
        <td align="right"><button class="btn btn-primary">Go</button></td>
       </tr>
      </table>
     </form>
    </td>
   </tr>
   <tr style="background-color: #ffd8e4;">
    <td>
     <form action="emp-any-date">
     <input type="hidden" name="eid" value="${eid}">
      <table style="width: 100%; font-size: 20px">
       <tr>
        <td>Any Date</td>
        <td><input type="date" max="${dt}" name="date" required="required"></td>
        <td align="right"><button class="btn btn-primary">Go</button></td>
       </tr>
      </table>
     </form>
    </td>
   </tr>
   <tr style="background-color: #ffd8e4;">
    <td>
     <form action="emp-date-between">
     <input type="hidden" name="eid" value="${eid}">
      <table style="width: 100%; font-size: 20px">
       <tr>
        <td>Date Between</td>
        <td>From :<input type="date" max="${dt}" name="date1"></td>
        <td>To :<input type="date" max="${dt}" name="date2"></td>
        <td align="right"><button class="btn btn-primary">Go</button></td>
       </tr>
      </table>
     </form>
    </td>
   </tr>
  </table>
   <div class="dvv">
    <a class="la text-outline" href="/employee-timing">Home</a>
   </div>
 </body>
</html>