<?php
session_start();
ob_start();
function checkUserAndPassword($u, $p)
{

    $f = fopen('users.txt', 'a+') or die('file opening error');
    $file_contents = file_get_contents('./users.txt', FILE_USE_INCLUDE_PATH);
    $loginInfoByLine = explode("\n", $file_contents);

    fclose($f);

    for ($i = 0; $i < count($loginInfoByLine); $i++) {
        $singleLineInfo = preg_split("/[\s,]+/", $loginInfoByLine[$i]);
        if ($u === $singleLineInfo[0] && $p === $singleLineInfo[1]) {
            rewriteFile($singleLineInfo[0], $singleLineInfo[1]);
            if(isset($_SESSION['lastPage']))
            {
                redirectToB4();
            }else {
                showLinks();
            }
            $_SESSION['LAST_ACTIVITY'] = time();
            $_SESSION['loggedin'] = 1;
            $_SESSION['username'] = $singleLineInfo[0];
            $_SESSION['time'] = time();
            die();
        }
    }
    die('invalid username/password');
}

function rewriteFile($u, $p)
{
    $f =fopen('temp.txt', 'w') or die('file opening error temp');
    $u;
    $file_contents = file('users.txt');
    foreach($file_contents as $one_line) {
        $singleLineInfo = preg_split("/[\s,]+/", $one_line);
        if ($u !== $singleLineInfo[0]) {
            fwrite($f, $one_line);
        }
    }
    $newUserWithTimeStamp = $u . ',' . $p . ',' . date('Y/m/d H:i:s') . PHP_EOL;
    fwrite($f, $newUserWithTimeStamp);
    fclose($f);
    $f =fopen('users.txt', 'w') or die('file opening error temp');
    $file_contents = file('temp.txt');
    foreach($file_contents as $one_line) {
        fwrite($f, $one_line);
    }
    fclose($f);
}

function drawForm($u, $p)
{

    echo "
	<form method='get' action=''>
	username:<input type='text' name='u' value='$u'><br>
	password:<input type='text' name='p' value= '$p'><br>
	<input type='submit' value='login'>
	</form>";
    lastLogInNote();
}

function lastLogInNote()
{
    $line = '';

    $f = fopen('users.txt', 'r');
    $cursor = -1;

    fseek($f, $cursor, SEEK_END);
    $char = fgetc($f);

    /**
     * Trim trailing newline chars of the file
     */
    while ($char === "\n" || $char === "\r") {
        fseek($f, $cursor--, SEEK_END);
        $char = fgetc($f);
    }

    /**
     * Read until the start of file or first newline char
     */
    while ($char !== false && $char !== "\n" && $char !== "\r") {
        /**
         * Prepend the new char
         */
        $line = $char . $line;
        fseek($f, $cursor--, SEEK_END);
        $char = fgetc($f);
    }

    $singleLineInfo = preg_split("/,/", $line);

    echo "Last login Since: " . $singleLineInfo[2] .  "<br>";
}

function redirectToB4(){
    if($_SESSION['lastPage'] === "secret") {
        echo "click here to go back to <a href='secret.php'>secret</a><br>";
    } else if($_SESSION['lastPage'] === "private") {
        echo "click here to go back to <a href='private.php'>private</a><br>";
    } else {
        showLinks();
    }
}

function showLinks(){
    echo "<a href='private.php'>private</a><br>
	<a href='secret.php'>secret</a><br>
	<a href='logout.php'>log out</a>";
}

if (isset($_SESSION['loggedin'])) { // already logged in
    showLinks();
    die();
} else if (isset($_GET['u'])) { // trying to log in
    drawForm($_GET['u'], $_GET['p']);
    checkUserAndPassword($_GET['u'], $_GET['p']);
} else {
    drawForm('', '');
}

ob_end_flush();
?>



