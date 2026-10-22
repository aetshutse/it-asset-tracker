package com.itmanager.model;

public class Employee {
    private int id;
    private String fullName;
    private String department;
    private String email;

    public Employee(int id, String fullName, String department, String email) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}