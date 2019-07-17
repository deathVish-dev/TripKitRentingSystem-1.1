package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name = "CartTable")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long id;
	
	
	@Column(name = "product_id")
	private long pid;
	
	
	@Column(name = "quantity")
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer custid;


	public Cart(long id, long pid, int quantity, Customer custid) {
		super();
		this.id = id;
		this.pid = pid;
		this.quantity = quantity;
		this.custid = custid;
	}


	public Cart(long pid, int quantity, Customer custid) {
		super();
		this.pid = pid;
		this.quantity = quantity;
		this.custid = custid;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getPid() {
		return pid;
	}


	public void setPid(long pid) {
		this.pid = pid;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Customer getCustid() {
		return custid;
	}


	public void setCustid(Customer custid) {
		this.custid = custid;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", pid=" + pid + ", quantity=" + quantity + ", custid=" + custid + "]";
	}
	
	
	
	
	

}
