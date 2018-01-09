<?php
define('PI', 3.1);
echo PI;
// comments
#comments
/* comments
comments
*/
$_ = 'whatever';
$whatever_something5 = 'hi';
$x = 5;
echo $x;   // 5
echo "$x"; // 5
echo '$x'; // $x
echo "\$x is $x!";
echo "hello";
echo 'hello';
print 'hello';
?>
<br>
<?php
echo "bye";
?>

<?php

$today = date('l, F jS, Y');

echo $today;

?>

<?php
$xdate = mktime(0, 0, 0, 12, 26, 2017);

$difference = $xdate - $today;
echo "There are ". floor($difference/60/60/24)." days tell xmas";
?>

<br>
<br>

<?php
$begin = new DateTime('1996-04-05');
$end = new DateTime('2017-09-13');

$daterange = new DatePeriod($begin, new DateInterval('P1D'), $end);

foreach($daterange as $date){
    echo $date->format('l, F jS, Y') . "<br>";
}
?>
<hr>