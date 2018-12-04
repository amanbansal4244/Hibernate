package com.aman;

public class Address {
 
 private int addressId;
 private String city;
 private String state;
 
 private Student s; 
 
 public Student getS() {
 return s;
 }
 public void setS(Student s) {
 this.s = s;
 }
 public int getAddressId() {
 return addressId;
 }
 public void setAddressId(int addressId) {
 this.addressId = addressId;
 }
 public String getCity() {
 return city;
 }
 public void setCity(String city) {
 this.city = city;
 }
 public String getState() {
 return state;
 }
 public void setState(String state) {
 this.state = state;
 }
 
}
