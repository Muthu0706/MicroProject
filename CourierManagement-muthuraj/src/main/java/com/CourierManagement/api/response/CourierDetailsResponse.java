package com.CourierManagement.api.response;

import java.util.List;
import java.util.Random;

import com.CourierManagement.api.entity.CourierStaff;
import com.CourierManagement.api.entity.Parcel;

public class CourierDetailsResponse {

	 private String senderName;
	    private String receiverName;
	    private Long parcelId;
	    private Double cost;
	    private String staffName;
	    private String status;
    
    
	
	public String getSenderName() {
			return senderName;
		}
		public void setSenderName(String senderName) {
			this.senderName = senderName;
		}
		public String getReceiverName() {
			return receiverName;
		}
		public void setReceiverName(String receiverName) {
			this.receiverName = receiverName;
		}
		public Long getParcelId() {
			return parcelId;
		}
		public void setParcelId(Long parcelId) {
			this.parcelId = parcelId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public void setCost(Double cost) {
			this.cost = cost;
		}
	
	public String getStaffName() {
			return staffName;
		}
		public void setStaffName(String staffName) {
			this.staffName = staffName;
		}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	  public void setStaffNameFromParcel(List<CourierStaff> availableStaffList) {
	        
	        if (availableStaffList != null && !availableStaffList.isEmpty()) {
	            
	            Random random = new Random();
	            CourierStaff randomStaff = availableStaffList.get(random.nextInt(availableStaffList.size()));

	           
	            this.staffName = randomStaff.getStaffName();
	        } else {
	            
	            this.staffName = "No Staff Available";
	        }
	    }
	

	 
    
    

}
