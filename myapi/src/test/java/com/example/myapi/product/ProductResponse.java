package com.example.myapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse{

	@JsonProperty("price")
	private int price;

	@JsonProperty("id")
	private int id;

	@JsonProperty("product_name")
	private String productName;

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}
}