package com.aman;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "STUDENT")
public class Student {
 
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private long id;
 
    @Column(name = "FIRST_NAME")
    private String firstName;
 
    @Column(name = "LAST_NAME")
    private String lastName;
 
    @Column(name = "SECTION")
    private String section;
 
    /****
     * @JoinColumn(name="UNIVERSITY_ID_ANYNAME")  -> Using this annotation University table reference(FK) name will be "UNIVERSITY_ID_ANYNAME" 
     * in 'STUDENT' table.
     * @JoinColumn says that Student table will contain a separate column UNIVERSITY_ID_ANYNAME which will eventually act as a foreign key reference 
     * to primary key of University table.
     * If we don't use @JoinColumn(name="UNIVERSITY_ID_ANYNAME")  then hibernate will automatically give column name : tableName_tablePKName
     * 
     * @ManyToOne says that multiple Student tuples can refer to 
     * same University Tuples(Multiple students can register in same university).
     * 
     * Additionally, with optional=false we make sure that no Student tuple can exist without a University tuple.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "UNIVERSITY_ID_ANYNAME")
    private University university;
 
    public Student() {
    }
 
    public Student(String firstName, String lastName, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getSection() {
        return section;
    }
 
    public void setSection(String section) {
        this.section = section;
    }
 
    public University getUniversity() {
        return university;
    }
 
    public void setUniversity(University university) {
        this.university = university;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Student))
            return false;
        Student other = (Student) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", section=" + section + "]";
    }
 
}
