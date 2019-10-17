package com.tavisca.dataconversion.model;

import java.util.ArrayList;

public class EmployeeV2 {
    private String empName;
    private int empId;
    private String email;
    private String address;
    private ArrayList<String> hobbies;
    private int deptId;

    public EmployeeV2() {
    }

    public EmployeeV2(String empName, int empId, String email, String address, ArrayList<String> hobbies, int deptId) {
        this.empName = empName;
        this.empId = empId;
        this.email = email;
        this.address = address;
        this.hobbies = hobbies;
        this.deptId = deptId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
