package com.CourierManagement.api.service;

import com.CourierManagement.api.request.CourierDetails;

public class EmailService {
    private CourierDetails courierDetails;

	public CourierDetails getCourierDetails() {
		return courierDetails;
	}

	public void setCourierDetails(CourierDetails courierDetails) {
		this.courierDetails = courierDetails;
	}

	public EmailService(CourierDetails courierDetails) {
		super();
		this.courierDetails = courierDetails;
	}

    public EmailService() {
		// TODO Auto-generated constructor stub
	}
}
