 <html>
 <head>
 <title>Migros Demo App</title>
 </head>
 <body>
 <h2>Migros Demo App - Author : Serdar</h2>
 <form action="/MigrosDemo/stores" method="POST">
 <input type="submit" value="List Stores"/>
</form>
<form action="/MigrosDemo/putLocation" method="GET">
       <label for="courier">Courier Id</label><br>
       <input type="text" id="courier" name="courier"><br>
       <label for="time">Current Time in Miliseconds</label><br>
       <input type="text" id="time" name="time"><br>
       <label for="lat">Latitude</label><br>
       <input type="lat" id="lat" name="lat"><br>
       <label for="lng">Longitude</label><br>
       <input type="lng" id="lng" name="lng"><br>
       <input type="submit" value="Enter Record">

</form>
 <h2>${resultMessage}</h2>
 <form action="/MigrosDemo/getTotalTravelDistance" method="GET">
 <label for="courier">Courier Id</label><br>
        <input type="courier" id="courier" name="courier"><br>
        <input type="submit" value="Get Total Travel Distance For Courier">
 </form>
 <h2>${totalTravelDistanceForCourier}</h2>

  <h3>
  References<br>
  <li>https://medium.com/@yuntianhe/create-a-web-project-with-maven-spring-mvc-b859503f74d7</li><br>
  <li>https://www.tutorialspoint.com/springmvc/springmvc_form_handling.htm</li><br>
  <li>https://www.websparrow.org/spring/how-to-fetch-data-from-database-in-spring-mvc</li><br>
  <li>https://spring.io/guides/gs/rest-service/</li><br>
  <li>https://howtodoinjava.com/java8/intstream-examples/</li><br>
  <li>https://www.w3schools.com/html/html_forms.asp</li><br>
  <li>https://stackoverflow.com/questions/639695/how-to-convert-latitude-or-longitude-to-meters</li><br>
  </h3>
 </body>
 </html>