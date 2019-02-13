package org.sterling.api.service;

import com.sterlingcommerce.documentation.yfs.getorderdetails.output.OrderXSDType;



public interface SterlingService {
	
	
	OrderXSDType getOrderDetails(String orderHeaderKey);
	
	

}
