package com.aman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="FOUR_WHEELER")
public class FourWheeler extends Vehicle
{
 @Column(name="STEERING_TYPE")
 private String steeringFourWheeler;

 public String getSteeringFourWheeler() 
 {
  return steeringFourWheeler;
 }

 public void setSteeringFourWheeler(String steeringFourWheeler) 
 {
  this.steeringFourWheeler = steeringFourWheeler;
 }
}