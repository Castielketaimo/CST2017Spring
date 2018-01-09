<?php
$header = $_GET['header'];
$content = $_GET['contents'];
$swear = str_getcsv(file_get_contents("badwordsnew.txt") , ",");
$noSwear = true;

foreach($swear as $word){ //comparing each word in input and bad word database
    if(!(stripos($header, $word) === false)){
        echo "How dare you swear at me!!!!!!!!!";
        $noSwear = false;
    }
}
if((strip_tags($header)) != $header || strip_tags($content) != $content){
    echo "Don't try to tag me!!!";
}else if(strlen(trim($header)) == 0 || strlen(trim($content)) == 0) {
    echo "Put something in header please";
} else if ($noSwear){
    $date = strtotime("December 26, 2017 12:00 AM");
    $remaining = $date - time();
    $days_remaining = floor($remaining / 86400);
    $f = fopen('input.txt', 'a') or die('file opening error');
    fwrite($f, date('l, F jS, Y') . PHP_EOL);
    fwrite($f, "There's " . $days_remaining . " till Xmas" .PHP_EOL);
    fwrite($f, $header . PHP_EOL);
    fwrite($f, "------------------------------------------------------------------------------------" . PHP_EOL);
    fwrite($f, $content . PHP_EOL);
    fwrite($f, "************************************************************************************" . PHP_EOL);
    fclose($f);
    $message = "Input recorded!";
    echo "<script type='text/javascript'>alert('$message');</script>";
}
?>
<html>
<form action="index.html">
    <input type="submit" value="Home" />
</form>
<form action="form.html">
    <input type="submit" value="Write Again" />
</form>
</html>
