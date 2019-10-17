package com.tavisca.dataconversion.converter;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.tavisca.dataconversion.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XMLConverter {
    public static String getXMLFormat(Object object) {
        try {
            ObjectMapper objectMapper = new XmlMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void serializeToXML (Employee object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("data.xml");
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOutputStream));
        encoder.writeObject(object);
        encoder.close();
        fileOutputStream.close();
    }

    public static void serializeToXML (ArrayList<Employee> object) throws IOException{
        Employee[] employees = object.toArray(new Employee[object.size()]);
        FileOutputStream fileOutputStream = new FileOutputStream("data.xml");
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fileOutputStream));
        encoder.writeObject(employees);
        encoder.close();
        fileOutputStream.close();
    }
}
