<?php

header("content-type:application/json");

$data = array("msg" => "Hello World JSON");

echo json_encode($data);