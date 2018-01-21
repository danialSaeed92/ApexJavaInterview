<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="/clock/dist/jquery-clockpicker.css">
<script type="text/javascript"
	src="/clock/dist/bootstrap-clockpicker.min.js"></script>

<c:url value="/css/Appointment.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />


</head>
<body>

	<div id="content">
		<div id="error"></div>
		<input type="button" value="NEW" id="new" onclick="showForm()">
		<form action="/addAppointment" id="frm" name="myfrm" method ="POST">
			<label id="lbl_1">Date </label> <input id="date" type="text" size="8"
				name="date" onchange="validateDate();">
			<div class="input-group clockpicker">
				<label for="time" id="lbl_2">Time</label> <input type="text"
					class="form-control" size="8" id="time" name="time"
					onchange="validateTimeHhMm();" readonly> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-time"></span>
				</span>
			</div>
			<label for="desc" id="lbl_3">Desc</label> <input id="desc"
				type="text" size="8" name="desc" required> <input
				type="button" value="CANCEL" id="cancel" onclick="hideForm()">
		</form>

		<div id="main">
			<input type="text" id="toSelect"> <input type="button"
				value="Search" id="search" onclick="getAppointments();">
		</div>
		<div id="mytbl"></div>
	</div>
	<script type="text/javascript" src="/js/Appointment.js"></script>
</body>

</html>
