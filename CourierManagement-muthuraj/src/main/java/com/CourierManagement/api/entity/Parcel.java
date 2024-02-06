package com.CourierManagement.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Parcel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String recipientName;
    private String fromAddress;
    private String recipientAddress;
    private String parcelName;
    private String productImage;
    private double weight;
    private String recipientPhoneNumber;
    private double cost;
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    
    
   
  

	@ManyToOne
    @JoinColumn(name = "staff_id")
    private CourierStaff courierStaff;
    
    
    
    
//    @ManyToOne
//    @JoinColumn(name = "admin_id")
//    private Admin admin;

  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public CourierStaff getCourierStaff() {
		return courierStaff;
	}

	public void setCourierStaff(CourierStaff courierStaff) {
		this.courierStaff = courierStaff;
	}
//
//	public Admin getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	  public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}


    
}
