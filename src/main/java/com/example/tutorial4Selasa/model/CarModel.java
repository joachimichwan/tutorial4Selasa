package com.example.tutorial4Selasa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class CarModel {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "type", nullable = false)
	private String type;

    @Column(name = "price", nullable = false)
	private Long price;

    @Column(name = "amount", nullable = false)
	private Integer amount;


	public CarModel(String id, String brand, String type, Long price, Integer amount) {
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.amount = amount;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Long getPrice() {
		return price;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
