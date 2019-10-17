package com.tavisca.dataconversion.model;

public class DepartmentV2 {
    String name;
    int deptId;

    public DepartmentV2() {
    }

    public DepartmentV2(String name, int deptId) {
        this.name = name;
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
