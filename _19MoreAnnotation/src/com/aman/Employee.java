package com.aman;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Index;


@Entity
@Table(name ="Employee_MoreAnnotation")
public class Employee {
	
	/****
	 * @Id makes a field a primary key in DB.
	 * 
	 * @GeneratedValue means hibernate will generate the unique value using some strategy for us based on data type of field.
	 * 	1. @GeneratedValue(strategy=GenerationType.AUTO)
	 * 	2. @GeneratedValue(strategy=GenerationType.IDENTITY)
	 * 	3. @GeneratedValue(strategy=GenerationType.SEQUENCE)
	 * 	4. @GeneratedValue(strategy=GenerationType.TABLE)
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EID")
	private int id;
	
	/****
	 * @Index applies the index at property level. If the property of an entity is annotated with @Index, 
	 * an index with the given name will be applied on the column.
	 * The above @Index code is equivalent to below SQL code:
	 * 		create index nameIndex on Employee(firstName);	
	 * 
	 * To see the indexing .. go to the table structure.
	 * 

	 */
	@Column(name="EFirstName")
	@Index(name="nameIndex")
	private String firstName;
	
	/****
	 * If we don't add @Column annotation then hibernate automatically created column with field name .
	 * or we can add @Basic annotation or don't write any annotation when we don't want to give new name as column name.
	 */
	private String lastName;
	
	@Basic
	private int age;
	
	@Column(name="ESalary")
	private double salary;
	
	/****
	 * If we don't want that hibernate stores automatically java field to DB column then we should write  
	 * @Transient annotation. 
	 */
	@Transient
	private String fatherName;

	/****
	 * Now we know that, If we don't add @Column annotation then hibernate automatically created column with field name .  
	 * but in this case hibernate will store the date with time stamp in DB
	 */
	private Date joinedDate;
	
	/****
	 * If we don't want hibernate stores the date with time stamp in DB, then we should use  
	 * @Temporal(TemporalType.DATE)  -- if we want only date 
	 * @Temporal(TemporalType.TIME) -- if we want only time
	 * @Temporal(TemporalType.TIMESTAMP) -- if we want both date and time  and this is by default annotation as well.
	 * 
	 */
	@Temporal(TemporalType.DATE)
	private Date lastDate;
	
	/****
	 * Hibernate will stores the default value of description field is varchar(255) but if want to add more description then 
	 * we will have error once we crossed the varchar(255). So we should use @Lob annotation (Large Object) when we don't have 
	 * control on text field. and hibernate automatically figure outs that weather it should be 'BLOB' or 'CLOB'
	 * if @Lob annotation at String field then hibernate treats as 'CLOB'
	 * if @Lob annotation at Byte field then hibernate treats as 'BLOB'
	 */
	@Lob
	private String description;
	
	
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
