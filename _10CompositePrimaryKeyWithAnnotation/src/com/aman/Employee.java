package com.aman;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="Employee_Composite_Primary_Key")
public class Employee implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    EmployeeId id;
    
    @Column(name="EMP_NAME")
    private String empName;
    
    public Employee()
    {
        super();
    }
    public Employee(EmployeeId id, String empName)
    {
        super();
        this.id = id;
        this.empName = empName;
    }
    public EmployeeId getId()
    {
        return id;
    }
    public void setId(EmployeeId id)
    {
        this.id = id;
    }
    public String getEmpName()
    {
        return empName;
    }
    public void setEmpName(String empName)
    {
        this.empName = empName;
    }
}