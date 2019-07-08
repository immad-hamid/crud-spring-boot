package com.mysqlconnection.connectmysql.controller;

import com.mysqlconnection.connectmysql.dataclient.DataClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberConversionController {
    @GetMapping("/numToWords/{num}")
    public String numToWords(@PathVariable("num") String num) {
        return DataClient.numToWords(num);
    }

    @GetMapping("/numToDollar/{num}")
    public String numToDollar(@PathVariable("num") String num) {
        return DataClient.numToDollar(num);
    }
}
