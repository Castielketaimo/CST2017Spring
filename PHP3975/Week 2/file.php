<?php
$f = fopen('books.txt', 'w') or die('file error');
/*
fopen can fail:
no such file
no such path
out of memory
file locked
no permission
*/
fwrite($f, "think and grow rich" . PHP_EOL);
fwrite($f, 'four hour workweek' . PHP_EOL);
fwrite($f, '7 habits' . PHP_EOL);
fwrite($f, 'getting real' . PHP_EOL);
fclose($f);
/*
if you do not close the file:
memory leak
**** nothing gets written
file could be corrupted
file could remain locked
*/
$file_contents = file('books.txt');
foreach($file_contents as $one_line){
	echo $one_line;
}
