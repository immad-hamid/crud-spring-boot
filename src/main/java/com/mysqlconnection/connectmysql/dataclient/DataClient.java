package com.mysqlconnection.connectmysql.dataclient;

import com.test.soap.NumberConversion;
import com.test.soap.NumberConversionSoapType;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DataClient {

    public static String numToWords(String num) {

        NumberConversion numberConversion = new NumberConversion();
        NumberConversionSoapType service = numberConversion.getNumberConversionSoap();
        return service.numberToWords(new BigInteger(num));
    }

    public static String numToDollar(String num) {

        NumberConversion numberConversion = new NumberConversion();
        NumberConversionSoapType service = numberConversion.getNumberConversionSoap();
        return service.numberToDollars(new BigDecimal(num));
    }
}
