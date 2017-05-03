package com.ilyasov.util;

import org.hibernate.validator.constraints.NotBlank;

public class WorkerForm {
    @NotBlank
    private String name;
    private int age = 0;
    @NotBlank
    private String companyName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String regalias;
    private int workExperience =0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegalias() {
        return regalias;
    }

    public void setRegalias(String regalias) {
        this.regalias = regalias;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}
