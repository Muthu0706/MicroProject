package com.CourierManagement.api.request;

import org.springframework.stereotype.Component;

@Component
public class ParcelRequest {

    private String recipientName;
    private String fromAddress;
    private String recipientAddress;
    private String parcelName;
    private String productImage;
    private double weight;
    private String recipientPhoneNumber;
    private double cost;
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getParcelName() {
		return parcelName;
	}
	public void setParcelName(String parcelName) {
		this.parcelName = parcelName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getRecipientPhoneNumber() {
		return recipientPhoneNumber;
	}
	public void setRecipientPhoneNumber(String recipientPhoneNumber) {
		this.recipientPhoneNumber = recipientPhoneNumber;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public ParcelRequest(String recipientName, String fromAddress, String recipientAddress, String parcelName,
			String productImage, double weight, String recipientPhoneNumber, double cost) {
		super();
		this.recipientName = recipientName;
		this.fromAddress = fromAddress;
		this.recipientAddress = recipientAddress;
		this.parcelName = parcelName;
		this.productImage = productImage;
		this.weight = weight;
		this.recipientPhoneNumber = recipientPhoneNumber;
		this.cost = cost;
	}

   public ParcelRequest() {
	// TODO Auto-generated constructor stub
}
}
