package com.tavisca.dataconversion.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.tavisca.dataconversion.model.DepartmentWithEmployee;
import com.tavisca.dataconversion.model.Employee;

public class CSVConverter {
    public static String getCSVFormat(Object object) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema columns = mapper.schemaFor(Employee.class);
        try {
            return mapper.writer(columns).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }



    public static String getCSVFormatV2(Object object) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema columns = mapper.schemaFor(DepartmentWithEmployee.class);
        try {
            String finalString = mapper.writer(columns).writeValueAsString(object);
            return finalString.replace("\"\"","\\\"");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
