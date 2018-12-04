package com.aman;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="categories")
public class Categories
{
	@Id
	@Column(name="catid")
	private int categoryId;
	
	@Column(name="catname",length=10)
	private String categoryName;
	
	/****targetEntity=Item.class : 
	 * 				(Optional) The entity class that is the target of the association. Optional only if the collection property is defined 
	 *  				using Java generics. Must be specified otherwise. In this case, collection property is not defined using Java generics, 
	 * 				so we have to use 'targetEntity=Item.class' , if we don't use the we would get below exception:
	 * 				org.hibernate.AnnotationException: Collection has neither generic type or OneToMany.targetEntity() defined.
	 ****/
	@ManyToMany(targetEntity=Item.class,cascade=CascadeType.ALL)
	@JoinTable(name="categories_items",joinColumns=@JoinColumn(name="cat_id_fk",referencedColumnName="catid"),inverseJoinColumns=@JoinColumn(name="item_id_fk",referencedColumnName="itemid"))
	private Set items;

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Set getItems() {
		return items;
	}
	public void setItems(Set items) {
		this.items = items;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryname) {
		this.categoryName = categoryname;
	}

}
