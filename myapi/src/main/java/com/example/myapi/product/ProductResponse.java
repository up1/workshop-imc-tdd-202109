package com.example.myapi.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductResponse that = (ProductResponse) o;
		return id == that.id && price == that.price && Objects.equals(productName, that.productName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, productName, price);
	}
}