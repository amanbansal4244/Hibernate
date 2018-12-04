package com.aman;
import java.util.List;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "UNIVERSITY")
public class University {
 
    @Id
    @GeneratedValue
    @Column(name = "UNIVERSITY_ID")
    private long id;
 
    @Column(name = "NAME")
    private String name;
 
    @Column(name = "COUNTRY")
    private String country;
	 /****
	  * Now we don't want to have separate table to save the relationship between Vendor and Customer.
	 *  In the mapping file of that parent POJO class, we need to configure the collection
	 *	and University class can't have reference variable of Student class because University can have multiple Student.
	 *	but Student class can have reference variable of University class because Each Student can be part of only one University.
	 *
	 *	mappedBy -> The mappedBy property is what we use to tell Hibernate which variable we are using to represent 
	 *				the parent class in our child class.
	 *				Use the mappedBy property when creating a bidirectional relationship in Hibernate.
	 *				@OneToMany(mappedBy = "university") , This @OneToMany will not do any mapping(means won't create separate table 
	 *				to save the relationship between Vendor and Customer) because mappedBy says to hibernate that 
	 *				you don't need to do the mapping,it's been mapped by other entity i.e. Student Entity using  @ManyToOne 
	 *				
	 *				The annotation mappedBy ideally should always be used in the Parent side (University class) of the bi-directional relationship.
	 *
	 * @OneToMany on list property here denotes that one University can have multiple students.
	 * With students property defined in University class, we can now navigate from University to students. 
	 * mappedBy says that it’s the inverse side of relationship.
	 * Also note the cascade attribute, which means the dependent object(Student) will be 
	 * persisted/updated/deleted automatically on subsequent persist/update/delete on University object.
	 * No need to perform operation separately on Student.
	 */
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Student> students;
 
    public University() {
 
    }
 
    public University(String name, String country) {
        this.name = name;
        this.country = country;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public List<Student> getStudents() {
        return students;
    }
 
    public void setStudents(List<Student> students) {
        this.students = students;
    }
 
    @Override
    public String toString() {
        return "University [id=" + id + ", name=" + name + ", country="
                + country + "]";
    }
 
}
