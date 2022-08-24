package com.cbay.demo;

import java.util.Objects;

public class User {

    private int id;
    private String Name;
    private String address;
    private Integer age;
    private Double salary;
    private Status status;

    public User(int id, String name, String address, Integer age, Double salary,Status status) {
        this.id = id;
        Name = name;
        this.address = address;
        this.age = age;
        this.salary = salary;this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        ASS,DUU,SFF;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) && Objects.equals(getAddress(), user.getAddress()) && Objects.equals(getAge(), user.getAge()) && Objects.equals(getSalary(), user.getSalary()) && getStatus() == user.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress(), getAge(), getSalary(), getStatus());
    }
}
