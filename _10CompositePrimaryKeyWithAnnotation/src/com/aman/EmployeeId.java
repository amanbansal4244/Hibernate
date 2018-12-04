package com.aman;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**In this Embeddable Composite Primary Key example, we will be declaring the IDs (Primary Key fields) as a 
 * separate class annotated with @Embeddable annotation. 
 * An Employee is identified by its EmployeeId, which is defined by empId and department. In short, we are making the 
 * composite primary key using 'empId' and 'department'.
 * 
 * In order to implement Composite Key in Hibernate, we need to override the equals() and hashCode() method and 
 * also implement the Serializable interface. Our EmployeeId class act as the ID class and 
 * we have marked it with @Embeddable annotation so that this class is eligible to be an embeddable class.
 */

@Embeddable
public class EmployeeId implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Column(name = "EMP_ID")
    private int empId;
    @Column(name = "DEPARTMENT")
    private String department;

    public EmployeeId()
    {
        super();
    }
    public EmployeeId(int empId, String department)
    {
        super();
        this.empId = empId;
        this.department = department;
    }

    public int getEmpId()
    {
        return empId;
    }
    public void setEmpId(int empId)
    {
        this.empId = empId;
    }
    public String getDepartment()
    {
        return department;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((department == null) ? 0 : department.hashCode());
        result = prime * result + empId;
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmployeeId other = (EmployeeId) obj;
        if (department == null)
        {
            if (other.department != null)
                return false;
        } else if (!department.equals(other.department))
            return false;
        if (empId != other.empId)
            return false;
        return true;
    }
}
