<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Appointments</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    
    </head>
<body>

    <h2>Appointments</h2>

    <table class="data-contacts-js table table-striped" >
        <tr>
            <th>Date</th>
            <th>Time</th>
            <th>Description</th>
       
    </table>

<button id = "fetchAll">Show All</button>
<br/>
 <input type="text" id="toSelect">
    <button id="fetchAppointments" class="btn btn-default" >Search</button>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
     <script type="text/javascript">

        $("#fetchAppointments").bind("click", function() {
        	var toSelect = $('#toSelect').val(); 
            $.get("getAppointmentTest?toSelect"+toSelect, function(data) {

                $.each(data, function(i, appointment) {

                    $(".data-contacts-js").append(
                        "<tr><td>" + appointment.date + "</td>" +
                        "<td>" + appointment.time + "</td>" +
                        "<td>" + appointment.desc + "</td></tr>");
                });

            });
        });
        
       
    </script> 
    
    <script type="text/javascript">

        $("#fetchAll").bind("click", function() {
        	var toSelect = ''; 
            $.get("getAppointmentTest?toSelect"+toSelect, function(data) {

                $.each(data, function(i, appointment) {

                    $(".data-contacts-js").append(
                        "<tr><td>" + appointment.date + "</td>" +
                        "<td>" + appointment.time + "</td>" +
                        "<td>" + appointment.desc + "</td></tr>");
                });

            });
        });
        
       
    </script> 
</body>
  
</html>