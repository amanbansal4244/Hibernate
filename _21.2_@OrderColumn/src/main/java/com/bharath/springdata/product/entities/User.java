package com.bharath.springdata.product.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    /****
     * @ElementCollection is the feature which gets the columns values from another table without mapping two tables.
	 *  We have taken two entity student and college. In college entity, we will fetch students without mapping student and college entity. 
	 *  I believe @ElementCollection is mainly for mapping non-entities (embeddable or basic) while @OneToMany is used to map entities.
	 *  
	 *  @CollectionTable will join the two tables for the given primary and foreign key. 
	 *  				Specifies the table that is used for the mapping of collections of basic or embeddable types.
	 *  			    Applied to the collection-valued field or property.
	 *  
	 *  @OrderColumn -> An ordered collection(like : List) that permits duplicate elements is called a indexed List.
	 *  @OrderColumn is used to store list index. As list is ordered collection so to maintain the list index there can be a column in 
	 *  					database and while inserting the data list index will be stored in that column
	 *  
	 *  					Specifies a column that is used to maintain the persistent order of a list. The persistence provider is responsible for maintaining the order 
	 *  					upon retrieval and in the database. The persistence provider is responsible for updating the ordering upon flushing to the database to reflect 
	 *  					any insertion, deletion, or reordering affecting the list.
	 *  					The OrderColumn annotation is specified on a OneToMany or ManyToMany relationship or on an element collection.
	 *  					The OrderColumn annotation is specified on the side of the relationship that references the collection that is to be ordered. 
	 *  					The order column is not visible as part of the state of the entity or embeddable class.
	 *  					The OrderBy annotation should be used for ordering that is visible as persistent state and maintained by the application. 
	 *  					The OrderBy annotation is not used when OrderColumn is specified.
     */
    @ElementCollection
    @CollectionTable(name = "user_phone_numbers", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone_number")
    @OrderColumn(name="phoneNumber_Index")
    private List<String> phoneNumbers = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "user_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Set<Address> addresses = new HashSet<>();


    public User() {

    }

    public User(String name, String email, List<String> phoneNumbers, Set<Address> addresses) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
