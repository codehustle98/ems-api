package com.codehustle.ems.enums;

public enum EmployeeType {
    ADMIN("A"),
    HR("HR"),
    ENGINEER("E");

    private final String empType;

     EmployeeType(String name){
         this.empType = name;
    }

    public String getEmpType() {
        return empType;
    }
}
