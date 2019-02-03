package org.sterling.ws.web.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.sterling.api.service.SterlingService;
import org.sterling.ws.AbstractControllerTest;


public class SterlingAPIControlerTest extends AbstractControllerTest{
	 
	 @Value("${test.orderheaderkey}")
	 private String orderHeaderKey;
	 
	 
	 @Before
	    public void setUp() {
	        super.setUp();	      
	    }
	 
	 
	 @Test
	    public void testGetOrderDetails() throws Exception {

	        String uri = "/api/getOrderDetails?OrderHeaderKey={orderHeaderKey}";
	        
	        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, orderHeaderKey)
	                .accept(MediaType.APPLICATION_XML)).andReturn();

	        String content = result.getResponse().getContentAsString();
	        int status = result.getResponse().getStatus();

	        Assert.assertEquals("failure - expected HTTP status", 200, status);
	        Assert.assertTrue(
	                "failure - expected HTTP response body to have a value",
	                content.trim().length() > 0);

	    }
	 

}
