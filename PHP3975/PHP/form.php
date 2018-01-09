<?php 
if((strip_tags($_GET['u'])) != $_GET['u']){
	echo ('error');
}else{
	$u = $_GET['u'];
	if(strlen(trim($u)) == 0){
		echo('error again');
	}else{
		echo "hello $u";
	}
}

if(isset($_GET['adult'])){
	echo 'you checked the box';
}

if(isset($_GET['u']) && (!empty($_GET['u']))){
	echo 'you typed a username';
}

echo (3 == 3);		// 1 true
echo (3 == 3.0);	// 1 true
echo (3 == "3");	// 1 true

echo (3 === "3");	// "" false


/*
"" (an empty string)
0 (0 as an integer)
0.0 (0 as a float)
"0" (0 as a string)
NULL
FALSE
array() (an empty array)
$var; (a variable declared, but without a value)
*/

echo "bcit" . "the end";

$x = "bcit";
$x++;
echo $x;

