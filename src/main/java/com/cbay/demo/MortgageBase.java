package com.cbay.demo;

public class MortgageBase {
    private String name;
    private Integer age;
    private Double saggle;
    private String address;


    public MortgageBase() {
    }

    public MortgageBase(String name, Integer age, Double saggle, String address) {
        this.name = name;
        this.age = age;
        this.saggle = saggle;
        this.address = address;
    }

    @Override
    public String toString() {
        return "MortgageBase{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", saggle=" + saggle +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSaggle() {
        return saggle;
    }

    public void setSaggle(Double saggle) {
        this.saggle = saggle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
