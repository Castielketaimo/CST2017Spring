<?php 

session_start();

if(!(isset($_SESSION['loggedin']))){
	die("<a href='login.php'>log in</a> first");
}

echo "my dog bit my hand<br>";


echo "<a href='private.php'>private</a><br>
	<a href='secret.php'>secret</a><br>
	<a href='logout.php'>log out</a>";