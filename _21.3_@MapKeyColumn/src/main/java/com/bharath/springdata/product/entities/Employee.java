package com.bharath.springdata.product.entities;
import java.util.HashMap;
import java.util.Map;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
 
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
 
	@TableGenerator(name = "employee_gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	private int idemployee;
 
	@Column(name = "FIRST_NAME")
	private String firstName;
 
	@Column(name = "LAST_NAME", table = "EMPLOYEE")
	private String lastName;
 
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	@MapKeyColumn(name = "phones_keys")
	private Map<String, Phone> phones = new HashMap<String, Phone>();
 
	public int getIdemployee() {
		return idemployee;
	}
 
	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
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
 
	public Map<String, Phone> getPhones() {
		return phones;
	}
 
	public void setPhones(Map<String, Phone> phones) {
		this.phones = phones;
	}
 
}
