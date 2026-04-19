<%-- Student Result Form with Client-side Validation --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Student Result</title>

<script>
function validateForm() {
let fields = ["roll","name","sub1","sub2","sub3","sub4","sub5"];

for (let i=0;i<fields.length;i++) {
let val = document.forms["f"][fields[i]].value;
if (val == "") {
alert("All fields must be filled");
return false;
}
}

// marks range check
for (let i=1;i<=5;i++) {
let m = document.forms["f"]["sub"+i].value;
if (m < 0 || m > 100) {
alert("Marks must be between 0 and 100");
return false;
}
}

return true;
}
</script>

</head>

<body>

<h2>Enter Student Details</h2>

<form name="f" action="processResult" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="roll"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="number" name="sub1"><br><br>
Sub2: <input type="number" name="sub2"><br><br>
Sub3: <input type="number" name="sub3"><br><br>
Sub4: <input type="number" name="sub4"><br><br>
Sub5: <input type="number" name="sub5"><br><br>

<input type="submit" value="Calculate Result">

</form>

</body>
</html>