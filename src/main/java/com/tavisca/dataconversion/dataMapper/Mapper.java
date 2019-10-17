package com.tavisca.dataconversion.dataMapper;

import com.tavisca.dataconversion.model.DepartmentV2;
import com.tavisca.dataconversion.model.DepartmentWithEmployee;
import com.tavisca.dataconversion.model.EmployeeV2;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Mapper {
    public static ArrayList<DepartmentWithEmployee> map(ArrayList<DepartmentV2> departments, ArrayList<EmployeeV2> employees){
        ArrayList<DepartmentWithEmployee> list = new ArrayList<>();
        departments.stream().forEach((departmentV2 -> {
            int deptId = departmentV2.getDeptId();
            ArrayList<EmployeeV2> allEmployee =(ArrayList<EmployeeV2>)employees.stream().filter((employeeV2) -> employeeV2.getDeptId() == deptId).collect(Collectors.toList());
            list.add(new DepartmentWithEmployee(departmentV2.getName(), departmentV2.getDeptId(),allEmployee));
        }));

        return list;
    }
}
