package com.tavisca.dataconversion.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;

import static com.tavisca.dataconversion.converter.JSONConverter.getJSONFormatWithOutFormat;

public class DepartmentWithEmployee {
    private String deptName;
    private int deptId;
    private String allEmployee;
    @JsonIgnore
    private ArrayList<EmployeeV2> allEmployeeList;

    public DepartmentWithEmployee(String deptName, int deptId, ArrayList<EmployeeV2> allEmployeeList) {
        this.deptName = deptName;
        this.deptId = deptId;
        this.allEmployeeList = allEmployeeList;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @JsonGetter("allEmployee")
    public String getAllEmployee() {
        return getJSONFormatWithOutFormat(this.allEmployeeList);
    }

    @JsonSetter("allEmployee")
    public void setAllEmployee(String allEmployee) {
        this.allEmployee = allEmployee;
    }

    public ArrayList<EmployeeV2> getAllEmployeeList() {
        return allEmployeeList;
    }

    public void setAllEmployeeList(ArrayList<EmployeeV2> allEmployeeList) {
        this.allEmployeeList = allEmployeeList;
    }
}
