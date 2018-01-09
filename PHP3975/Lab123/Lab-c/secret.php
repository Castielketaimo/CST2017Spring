<?php
ob_start();
session_start();

if(!(isset($_SESSION['loggedin']))){
    $_SESSION['lastPage'] = "secret";
	die("<a href='login.php'>log in</a> first");
}
autoEndSession();
echo "hamish is an alcoholic<br>";

function autoEndSession(){
    $time = time();
    $timeout_duration = 10;
    $timeDiffer = $time - $_SESSION['LAST_ACTIVITY'];
    if (isset($_SESSION['LAST_ACTIVITY']) && ($timeDiffer > $timeout_duration)) {
        setcookie("timeout", "now", time()+ (60) );
        header('Location:logout.php');
        die();
    }
    $_SESSION['LAST_ACTIVITY'] = $time;
}

function LogInInformations(){
    $loggedInDate = date('Y/m/d H:i:s' , $_SESSION['time']);
    $curDate = date('Y/m/d H:i:s' , time());
    $CurrentDate = new DateTime($curDate);
    $loginDate = new DateTime($loggedInDate);
    $loggedInTime = $loginDate->diff($CurrentDate);
    echo "Loged in as: " . $_SESSION['username'] . "<br>";
    echo "<br>for: " . $loggedInTime->format('%h')." Hours ".$loggedInTime->format('%i')." Minutes".$loggedInTime->format('%s')." Seconds<br>";
    echo "Since: ".  $date = date('Y/m/d H:i:s' , $_SESSION['time']) . "<br>";
}

LogInInformations();
echo "<a href='private.php'>private</a><br>
	<a href='secret.php'>secret</a><br>
	<a href='logout.php'>log out</a>";

ob_end_flush();
?>