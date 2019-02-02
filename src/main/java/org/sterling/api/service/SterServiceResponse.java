package org.sterling.api.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sterlingcommerce.documentation.yfs.getorderdetails.output.OrderXSDType;


public class SterServiceResponse {
	
	private OrderXSDType orderXSDType;
	
	public SterServiceResponse(){
		
	}

	public OrderXSDType getOrderXSDType() {
		return orderXSDType;
	}

	public void setOrderXSDType(OrderXSDType orderXSDType) {
		this.orderXSDType = orderXSDType;
	}

}
