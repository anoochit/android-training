<?php

header("content-type:application/json");

$method=$_SERVER["REQUEST_METHOD"];

switch($method) {
	case "POST":
		$data=array("result"=>"Hello, ".$_POST["name"]);
		break;
	default:
		$data=array("result"=>"Wrong request");
		break;
}

echo json_encode($data);