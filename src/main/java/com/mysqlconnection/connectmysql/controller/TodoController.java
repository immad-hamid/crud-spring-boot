package com.mysqlconnection.connectmysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TodoController {

    final String uri = "https://jsonplaceholder.typicode.com/todos";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/getTodos")
    public ResponseEntity<Object> getTodos() {
        ResponseEntity<Object> response = restTemplate.exchange(uri,
                HttpMethod.GET, null, Object.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/getTodos/{id}")
    public ResponseEntity<Object> getTodo(@PathVariable Integer id) {
        ResponseEntity<Object> response = restTemplate.exchange(uri + "/" + id,
                HttpMethod.GET, null, Object.class);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
