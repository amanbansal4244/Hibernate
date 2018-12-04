package com.aman;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="items")
public class Item
{
	@Id
	@Column(name="itemid")
	private int itemId;
	
	@Column(name="itemname",length=10)
	private String itemName;
	
	/****(Optional) The entity class that is the target of the association. Optional only if the collection property is defined 
	 *  using Java generics. Must be specified otherwise. In this case, collection property is not defined using Java generics, 
	 *  so we have to use 'targetEntity=Categories.class' , if we don't use the we would get below exception:
	 *  org.hibernate.AnnotationException: Collection has neither generic type or OneToMany.targetEntity() defined.
	 ****/
	@ManyToMany(targetEntity=Categories.class,mappedBy="items")
	private Set  categories;

	public Set getCategories() {
		return categories;
	}
	public void setCategories(Set  categories) {
		this.categories = categories;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}