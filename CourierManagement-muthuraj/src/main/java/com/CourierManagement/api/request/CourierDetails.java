package com.CourierManagement.api.request;

public class CourierDetails {
    private String staffName;
    private String staffPhoneNumber;
    private String courierDetails;
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}
	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}
	public String getCourierDetails() {
		return courierDetails;
	}
	public void setCourierDetails(String courierDetails) {
		this.courierDetails = courierDetails;
	}
	public CourierDetails(String staffName, String staffPhoneNumber, String courierDetails) {
		super();
		this.staffName = staffName;
		this.staffPhoneNumber = staffPhoneNumber;
		this.courierDetails = courierDetails;
	}

    public CourierDetails() {
		// TODO Auto-generated constructor stub
	}
}

