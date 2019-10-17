package app;

import com.tavisca.dataconversion.converter.CSVConverter;
import com.tavisca.dataconversion.converter.JSONConverter;
import com.tavisca.dataconversion.converter.XMLConverter;
import com.tavisca.dataconversion.data.MysqlRepository;
import com.tavisca.dataconversion.dataMapper.Mapper;
import com.tavisca.dataconversion.fileHandling.FileHandler;
import com.tavisca.dataconversion.model.DepartmentV2;
import com.tavisca.dataconversion.model.DepartmentWithEmployee;
import com.tavisca.dataconversion.model.EmployeeV2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainV2 {
    private static MysqlRepository mysqlRepository;
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        mysqlRepository = new MysqlRepository();

        ArrayList<DepartmentV2> departmentV2List = mysqlRepository.getAdvancedDepartmentList();
        ArrayList<EmployeeV2> employeeV2List = mysqlRepository.getAdvancedEmployeeList();
        ArrayList<DepartmentWithEmployee> map = Mapper.map(departmentV2List, employeeV2List);

        HashMap<Integer, Runnable> myMap = new HashMap<Integer, Runnable>() {{
            put(1, () -> jsonHandler(map));
            put(2, () -> xmlHandler(map));
            put(3, () -> csvHandler(map));
        }};

        while (true) {
            displayConsoleMessage();
            int selectedOption = in.nextInt();
            if (!myMap.containsKey(selectedOption))
                break;
            myMap.get(selectedOption).run();
        }
    }

    private static void csvHandler(ArrayList<DepartmentWithEmployee> map) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();
        FileHandler fileHandler = new FileHandler(path, "csv");
        String csvFormat = CSVConverter.getCSVFormatV2(map);
        try {
            fileHandler.createNewFile();
            fileHandler.writeToFile(csvFormat);
            System.out.println("Created File " + fileHandler.getFullPathOfTheNewCreatedFile() + " and inserted Data\n\n\n");
        } catch (IOException e) {
            System.out.println("Unable to Create File in The Specified Path Please Try Again\n\n\n");
        }
    }

    private static void xmlHandler(ArrayList<DepartmentWithEmployee> map) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();
        FileHandler fileHandler = new FileHandler(path, "xml");
        String xmlFormat = XMLConverter.getXMLFormat(map);
        try {
            fileHandler.createNewFile();
            fileHandler.writeToFile(xmlFormat);
            System.out.println("Created File " + fileHandler.getFullPathOfTheNewCreatedFile() + " and inserted Data\n\n\n");
        } catch (IOException e) {
            System.out.println("Unable to Create File in The Specified Path Please Try Again\n\n\n");
        }
    }

    private static void jsonHandler(ArrayList<DepartmentWithEmployee> map) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();
        FileHandler fileHandler = new FileHandler(path, "json");
        String jsonFormat = JSONConverter.getJSONFormat(map);
        try {
            fileHandler.createNewFile();
            fileHandler.writeToFile(jsonFormat);
            System.out.println("Created File " + fileHandler.getFullPathOfTheNewCreatedFile() + " and inserted Data\n\n\n");
        } catch (IOException e) {
            System.out.println("Unable to Create File in The Specified Path Please Try Again\n\n\n");
        }
    }

    private static void displayConsoleMessage() {
        System.out.println("1. Get The Data In JSON Format\n" +
                "2. Get The Data In XML Format\n" +
                "3. Get The Data in CSV Format\n" +
                "4. Exit \n");
    }
}
