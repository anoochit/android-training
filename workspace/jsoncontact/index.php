<?php

header("content-type:application/json");

$data = array("results" => 
		array(
			array("firstname" => "Anuchit", "lastname" => "Chalothorn"),
			array("firstname" => "Sira", "lastname" => "Nokyongthong"),
			array("firstname" => "Pakpoom", "lastname" => "Iamjitkusol")
		)
		);

echo json_encode($data);

