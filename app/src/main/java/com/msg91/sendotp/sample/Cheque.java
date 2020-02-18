package com.msg91.sendotp.sample;

public class Cheque {

    private String name;
    private String work;
    private String phone;
    private String address;



    public Cheque(String name, String work, String phone, String address) {

        this.name = name;
        this.work = work;
        this.phone=phone;
        this.address=address;
    }




    public String getName() {
        return name;
    }
    public String getWork() {
        return work;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
}}
