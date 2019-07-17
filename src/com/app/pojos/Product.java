package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ProductTable")
public class Product {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;



    @Column(name = "name", nullable = false, unique = true)
    @Length(min = 3)
    private String name;



    @Column(name = "description")
    private String description;


    @Column(name = "category")
    private String category;

    
    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.00")
    private Double price;
    
    
    @Column(name = "rent", nullable = false)
    @DecimalMin(value = "0.00")
    private Double rent;
    
    @Column(name = "image")
    private byte[] img;
    
    
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	public byte[] getImg() {
		return img;
	}


	public void setImg(byte[] img) {
		this.img = img;
	}


	public Product() {
		super();
	}




	public Product(Long id, String name, String description, String category, Double price, Double rent, byte[] img) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.rent = rent;
		this.img = img;
	}


	public Product(String name, String description, String category, Double price, Double rent, byte[] img) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.rent = rent;
		this.img = img;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", rent=" + rent + "]";
	}
	
	
	
}
