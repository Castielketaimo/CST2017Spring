<?php
ob_start();

function name() {
    if ((isset($_GET['name'])) && isset($_GET['rememberme']))
    {
        setcookie("name", $_GET['name'], time()+ (60) );
        echo $_GET['name'];
    }
    else if (!(isset($_GET['name'])) && isset($_COOKIE['name']))
    {
        echo $_COOKIE['name'];
    }
    else
    {
        echo '';
    }
}

function check() {
    if(isset($_GET['rememberme']) || isset($_COOKIE['checkBox']))
    {
        echo 'checked';
    }
    else if(!(isset($_GET['rememberme'])))
    {
        unset($_COOKIE['name']);
        setcookie("name", 0, time()-1 );
        unset($_COOKIE['checkBox']);
        setcookie("checkBox", 0, time()-1 );
    }
}

?>

<form action = "Cookies.php" method = "GET">
    <input type="text" name="name" value = <?php echo name() ?> >
    <input type="checkbox" name="rememberme" <?php echo check()?>>
    <input type = "submit" name ="submit">
    <?php ob_end_flush()?>


