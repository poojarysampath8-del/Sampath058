<%-- User Input Form with Client-side Validation --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>User Form</title>

<script>
function validateForm() {
let name = document.forms["myForm"]["username"].value;
let email = document.forms["myForm"]["email"].value;
let desig = document.forms["myForm"]["designation"].value;

if (name == "") {
alert("Username must be filled out");
return false;
}
if (!email.includes("@")) {
alert("Enter valid email");
return false;
}
if (desig == "") {
alert("Designation must be filled");
return false;
}
return true;
}
</script>

<style>
.form-container {
width:300px;
margin:50px auto;
padding:20px;
border:1px solid #ccc;
}
</style>

</head>

<body>

<div class="form-container">
<h2>Enter User Data</h2>

<form name="myForm" action="processUser" method="post" onsubmit="return validateForm()">

Username: <input type="text" name="username"><br><br>
Email: <input type="text" name="email"><br><br>
Designation: <input type="text" name="designation"><br><br>

<input type="submit" value="Submit">

</form>

</div>

</body>
</html>
