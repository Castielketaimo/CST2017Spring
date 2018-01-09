<?php
ob_start();
$answer = $_GET['selection'];
if ($answer == "write") {
    header("Location:form.html");
    die();
} else if ($answer == "read"){
    $file_contents = file('input.txt');
    foreach($file_contents as $one_line) {
        echo $one_line . "<br>";
    }
} else {
    header("Location:index.html");
    die();
}
?>
<html>
<style>
    body {
        background: url("bgimage.jpg");
        background-size: 1200px 800px;
        background-repeat: no-repeat;
        padding-top: 40px;
    }
</style>
<body><form action="index.html">
    <input type="submit" value="Home" />
</form></body>

</html>


