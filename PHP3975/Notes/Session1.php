<?php
/**
 * Created by PhpStorm.
 * User: castiel
 * Date: 2017-10-05
 * Time: 10:16 AM
 */
session_start();
echo session_id();
$_SESSION['username'] = 'Castiel';