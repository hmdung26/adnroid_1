package com.example.all_lab.Lab5;

import java.io.Serializable;

public class StudenModelph18450 implements Serializable {
     private String branch , name,address;

    public StudenModelph18450(String branch, String name, String address) {
        this.branch = branch;
        this.name = name;
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
