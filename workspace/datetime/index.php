<?php

header("content-type:application/json");

$method=$_SERVER["REQUEST_METHOD"];

switch($method) {
	case "GET":
		$data=array("result" => date("d/M/Y H:i:s"));
		break;
	default:
		$data=array("result" => "wrong request");	
		break;
}

echo json_encode($data);