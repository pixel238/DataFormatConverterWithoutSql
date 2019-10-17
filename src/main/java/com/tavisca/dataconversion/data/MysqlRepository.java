package com.tavisca.dataconversion.data;

import com.tavisca.dataconversion.connection.MySQLConnection;
import com.tavisca.dataconversion.model.Department;
import com.tavisca.dataconversion.model.DepartmentV2;
import com.tavisca.dataconversion.model.Employee;
import com.tavisca.dataconversion.model.EmployeeV2;

import java.sql.*;
import java.util.ArrayList;

public class MysqlRepository {
    Connection connection;

    public MysqlRepository(){
        try {
            this.connection = MySQLConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> list = new ArrayList<>();
        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from employee");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Employee employee = new Employee();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String address = resultSet.getString(4);
                int deptId = resultSet.getInt(5);
                String hobbiesData = resultSet.getString(6);
                ArrayList<String> hobbies = new ArrayList<>();
                for(String hobby : hobbiesData.split(",")){
                    hobbies.add(hobby);
                }

                employee.setId(id);
                employee.setName(name);
                employee.setEmail(email);
                employee.setAddress(address);
                employee.setHobbies(hobbies);

                PreparedStatement statement1 = this.connection.prepareStatement("select * from department where deptId = ?");
                statement1.setInt(1, deptId);
                ResultSet resultSet1 = statement1.executeQuery();
                if(resultSet1.next()){
                    String deptName = resultSet1.getString(2);
                    Department department = new Department(deptName,deptId);
                    employee.setDepartment(department);
                }
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Employee> getAllEmployeeByInnerJoin(){
        ArrayList<Employee> list = new ArrayList<>();
        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from employee inner join department on employee.deptId = department.deptId");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String address = resultSet.getString(4);
                int deptId = resultSet.getInt(5);

                String hobbiesData = resultSet.getString(6);
                ArrayList<String> hobbies = new ArrayList<>();
                for(String hobby : hobbiesData.split(",")){
                    hobbies.add(hobby);
                }

                String deptName = resultSet.getString(8);
                Department department = new Department(deptName,deptId);
                Employee employee = new Employee(id,name,email,address,department);
                employee.setHobbies(hobbies);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<EmployeeV2> getAdvancedEmployeeList(){
        ArrayList<EmployeeV2> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from employee");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                int empId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String address = resultSet.getString(4);
                int deptId = resultSet.getInt(5);
                String hobbies = resultSet.getString(6);

                ArrayList<String> hobbylist = new ArrayList<String>();
                for(String hobby : hobbies.split(";")){
                    hobbylist.add(hobby);
                }

                EmployeeV2 employee = new EmployeeV2(name,empId,email,address,hobbylist,deptId);
                list.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<DepartmentV2> getAdvancedDepartmentList(){
        ArrayList<DepartmentV2> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from department");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int deptId = resultSet.getInt(1);
                String deptName = resultSet.getString(2);

                DepartmentV2 employee = new DepartmentV2(deptName,deptId);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
