package com.samyak.jain.crudapi.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.samyak.jain.crudapi.Mapper.EmployeeMapper;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "address_id")
    private int id;
    @Column(name="house_no")
    private String houseNo;

    @Column(name="city")
    private String city;

    @Column(name="pincode")
    private int pincode;

    @Column(name="phone_no")
    private long mobileNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    @NonNull
    private Employee employee;
    public Address(){
        houseNo="";
        city="";
        pincode=0;
        mobileNo=0;
    }
    public Address(String houseNo, String city, int pincode, long mobileNo, Employee employee) {
        this.houseNo = houseNo;
        this.city = city;
        this.pincode = pincode;
        this.mobileNo = mobileNo;
        this.employee=employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }
}
