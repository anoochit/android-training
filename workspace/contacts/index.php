<?php

header("content-type:application/json");

$method = $_SERVER["REQUEST_METHOD"];

switch ($method) {

	case "GET":
		$data=array("msg" => "GET request");
		echo json_encode($data);
		break;
	case "POST":
		$data=array("msg" => "POST request");
		echo json_encode($data);
		break;
	case "PUT":
		$data=array("msg" => "PUT request");
		echo json_encode($data);
		break;
	case "DELETE":
		$data=array("msg" => "DELETE request");
		echo json_encode($data);
		break;
	default:
		$data=array("msg" => "Error: wrong request");
		echo json_encode($data);
		break;

}