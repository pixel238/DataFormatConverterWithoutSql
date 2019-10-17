package com.tavisca.dataconversion.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONConverter {
    public static String getJSONFormat(Object inputData){

        ObjectMapper obj = new ObjectMapper();
        String result = "";
        try {
            result = obj.writerWithDefaultPrettyPrinter().writeValueAsString(inputData);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getJSONFormatWithOutFormat(Object inputData){

        ObjectMapper obj = new ObjectMapper();
        String result = "";
        try {
            result = obj.writeValueAsString(inputData);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
