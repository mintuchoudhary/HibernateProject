package com.m2.hibernate.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * SINGLE_TABLE - 
 * The Single Table strategy creates one table for each class hierarchy
 * NOTE: DTYPE - new column will be added to MyProduct for identification
 * 
 * TABLE_PER_CLASS - every entity class has its own table.The data for Vehicle is duplicated in both the tables.
 * */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name= "type")  //To change the discriminator column DTYPE name
public class MyProduct {
	@Id
	@GeneratedValue
    private long productId;
	private String name;
	
    public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
