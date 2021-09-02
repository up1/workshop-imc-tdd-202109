package com.example.myapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse{


	@JsonProperty("id")
	private int id;

	@JsonProperty("product_name")
	private String productName;

	@JsonProperty("price")
	private int price;

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