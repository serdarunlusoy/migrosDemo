<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head>
      <title>Stores</title>
   </head>
   <body>

      <h2>Store List</h2>
      <table>
      	<tr>
      		<th>Store Id</th>
      		<th>Name</th>
      		<th>Latitude</th>
      		<th>Longitude</th>
      	</tr>
      <c:forEach items = "${storeList}" var = "store">
         <tr>
            <td>${store.storeId}</td>
            <td>${store.name}</td>
            <td>${store.latitude}</td>
            <td>${store.longitude}</td>
         </tr>
     </c:forEach>
      </table>

      <form action="/MigrosDemo/" method="GET">
       <input type="submit" value="Go Back"/>
      </form>
   </body>
</html>