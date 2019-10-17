package app;

import com.tavisca.dataconversion.converter.CSVConverter;
import com.tavisca.dataconversion.converter.JSONConverter;
import com.tavisca.dataconversion.converter.XMLConverter;
import com.tavisca.dataconversion.data.MysqlRepository;
import com.tavisca.dataconversion.model.Employee;
import com.tavisca.dataconversion.fileHandling.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner in;
    static MysqlRepository mysqlRepository;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        mysqlRepository = new MysqlRepository();

        ArrayList<Employee> allEmployee = getEmployees();

        HashMap<Integer, Runnable> myMap = new HashMap<Integer, Runnable>() {{
            put(1, () -> jsonHandler(allEmployee));
            put(2, () -> xmlHandler(allEmployee));
            put(3, () -> csvHandler(allEmployee));
        }};

        while (true) {
            displayConsoleMessage();
            int selectedOption = in.nextInt();
            if (!myMap.containsKey(selectedOption))
                break;
            myMap.get(selectedOption).run();
        }
    }

    private static ArrayList<Employee> getEmployees() {
        return mysqlRepository.getAllEmployee();
    }

    private static void xmlHandler(Object object) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();
        FileHandler fileHandler = new FileHandler(path, "xml");
        String xmlFormat = XMLConverter.getXMLFormat(object);
        try {
            fileHandler.createNewFile();
            fileHandler.writeToFile(xmlFormat);
            System.out.println("Created File " + fileHandler.getFullPathOfTheNewCreatedFile() + " and inserted Data\n\n\n");
        } catch (IOException e) {
            System.out.println("Unable to Create File in The Specified Path Please Try Again\n\n\n");
        }
    }

    private static void csvHandler(Object object) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();
        FileHandler fileHandler = new FileHandler(path, "csv");
        String xmlFormat = CSVConverter.getCSVFormat(object);
        try {
            fileHandler.createNewFile();
            fileHandler.writeToFile(xmlFormat);
            System.out.println("Created File " + fileHandler.getFullPathOfTheNewCreatedFile() + " and inserted Data\n\n\n");
        } catch (IOException e) {
            System.out.println("Unable to Create File in The Specified Path Please Try Again\n\n\n");
        }
    }

    private static void jsonHandler(Object object) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();
        FileHandler fileHandler = new FileHandler(path, "json");
        String xmlFormat = JSONConverter.getJSONFormat(object);
        try {
            fileHandler.createNewFile();
            fileHandler.writeToFile(xmlFormat);
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
