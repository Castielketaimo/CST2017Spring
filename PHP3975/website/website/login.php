<?php 
session_start();

function checkUserAndPassword($u, $p)
    {
        $f = fopen('users.txt', 'a+') or die('file opening error');
        fwrite($f, "comp,3975" . PHP_EOL);
        fwrite($f, "user,pass" . PHP_EOL);
        fwrite($f, "a,b" . PHP_EOL);
        $file_contents = file_get_contents('./users.txt', FILE_USE_INCLUDE_PATH);
        $loginInfoByLine = explode("\n", $file_contents);
        fclose($f);
        for ($i = 0; $i < count($loginInfoByLine); $i++) {
            $singleLineInfo = preg_split("/[\s,]+/", $loginInfoByLine[$i]);
            if ($u === $singleLineInfo[0] && $p === $singleLineInfo[1]) {
                echo "<a href='private.php'>private</a><br>
	                <a href='secret.php'>secret</a><br>
	                <a href='logout.php'>log out</a>";
                $_SESSION['loggedin'] = 1;
                die();
            } else {
                die('invalid username/password');
            }
        }
    }

function drawForm($u, $p)
    {
        echo "
	<form action='index.html' method='get'>
	username:<input type='text' name='u' value='$u'><br>
	password:<input type='text' name='p' value= '$p'><br>
	<input type='submit'>
	</form>
	";
    }

    if (isset($_SESSION['loggedin'])) { // already logged in
        echo "<a href='private.php'>private</a><br>
	<a href='secret.php'>secret</a><br>
	<a href='logout.php'>log out</a>";
        die();
    } else if (isset($_GET['u'])) { // trying to log in
        drawForm($_GET['u'], $_GET['p']);
        checkUserAndPassword($_GET['u'], $_GET['p']);

    } else {
        drawForm('', '');
    }
?>

