package com.aman;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;


@Entity
@Table(name ="Employee_11")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EID")
	private int id;
	
	private String name;
	
	/****
	 * 
	 * Earlier we used to use : @ElementCollection is the feature which gets the columns values from another table without mapping two tables.
	 *  We have taken two entity student and college. In college entity, we will fetch students without mapping student and college entity. 
	 *  I believe @ElementCollection is mainly for mapping non-entities (embeddable or basic) while @OneToMany is used to map entities.
	 *  
	 *  @CollectionTable will join the two tables for the given primary and foreign key. 
	 *  				Specifies the table that is used for the mapping of collections of basic or embeddable types.
	 *  			    Applied to the collection-valued field or property.
	 *  
	 *  Note : @ElementCollection is a part of JPA 2.0, which is supported by Hibernate since version 3.5.
	 *  If you version of Hibernate is older, you either need to upgrade it, or use similar Hibernate-specific annotation (@CollectionOfElements) instead.
	 *  
	 *  
	 * @CollectionOfElements annotation used to mark a collection as a collection of elements or a collection of embedded objects.
	 * 
	 * @JoinTable(name="USER_ADDRESS")  -> Using this annotation Address table name will be "USER_ADDRESS"
	 * 
	 * joinColumns=@JoinColumn(name="USER_ID")) -> using this foreign key name of Address table("USER_ADDRESS") will be "USER_ID".
	 * 
	 * @CollectionId(columns= @Column(name="ADDRESS_ID"), generator="hilo-gen", type=@Type(type="long"))  -> this helps to declare PK 
	 * from the list of collection. We need to mention what should be column name, generator to generate PK and type of PK column.
	 * "ADDRESS_ID" is not present in 'Address' class so we can set the "ADDRESS_ID". So PK should be auto generated thats why we used 
	 * 'hilo' strategy and for that we need to below annotation:
	 *  @GenericGenerator(name="hilo-gen", strategy ="hilo")  -> its says that generate the PK using 'hilo' strategy for column name
	 *  "ADDRESS_ID" of 'listOfAddress'
	 *  
	 *  
	 */
	

	/*@ElementCollection
	@CollectionTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	*Note: Above code has been replaced by below code in these days.
	*/
	
	@CollectionOfElements
	@JoinTable(name="USER_ADDRESS1",
			joinColumns=@JoinColumn(name="USER_ID"))
	@OrderColumn(name="ADDRESS_INDEX")
	private Set<Address> listOfAddress = new HashSet<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
