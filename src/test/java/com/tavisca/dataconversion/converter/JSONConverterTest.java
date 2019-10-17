package com.tavisca.dataconversion.converter;

import com.tavisca.dataconversion.data.MysqlRepository;
import com.tavisca.dataconversion.model.Department;
import com.tavisca.dataconversion.model.Employee;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class JSONConverterTest {
    private static MysqlRepository mysqlRepository;
    private static ArrayList<Employee> list;

    @BeforeClass
    public static void initialise(){
        mysqlRepository = Mockito.mock(MysqlRepository.class);
        list = new ArrayList<Employee>(){{
            add(new Employee(1,"Pixel","pixel@gmail.com","Kolkata",new Department("CSE",1)));
        }};
    }

    @Test
    public void willConvertGroupOfObjectToJSONFormat(){
        when(mysqlRepository.getAllEmployee()).thenReturn(list);
        String jsonFormat = JSONConverter.getJSONFormat(mysqlRepository.getAllEmployee());
        System.out.println(jsonFormat);
    }
}
