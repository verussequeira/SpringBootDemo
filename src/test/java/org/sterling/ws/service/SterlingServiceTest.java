package org.sterling.ws.service;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.sterling.api.service.SterlingService;
import org.sterling.ws.AbstractTest;

import com.sterlingcommerce.documentation.yfs.getorderdetails.output.OrderXSDType;


public class SterlingServiceTest extends AbstractTest{
	
	
	/**
     * The Logger for this class.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @Autowired
	 private SterlingService service;
	 
	 @Value("${test.orderheaderkey}")
	 private String orderHeaderKey;
	 
	 @Test
	 public void testGetOrderDetails()
	 {
		 
		 logger.info("OrderHeaderKey :" + orderHeaderKey);
		 
		 OrderXSDType orderXSDType = service.getOrderDetails(orderHeaderKey);
		 
		 Assert.assertNotNull("failure - expected not null", orderXSDType);
		 Assert.assertEquals("failure - expected not null", orderXSDType.getOrderHeaderKey(),orderHeaderKey);
		 
	 }
	

}
