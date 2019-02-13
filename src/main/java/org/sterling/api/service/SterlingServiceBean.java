package org.sterling.api.service;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.sterling.api.exception.impl.RestTemplateResponseErrorHandler;
import org.sterling.api.exception.impl.beans.NotFoundException;

import com.sterlingcommerce.documentation.yfs.getorderdetails.output.OrderXSDType;
import com.sterlingcommerce.documentation.yfs.getorderdetails.output.OrderXSDType.OrderLines.OrderLine;



@Service
public class SterlingServiceBean implements SterlingService{
	
	
	 /**
     * The Logger for this class.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    /**
     * The RestTemplate used to retrieve data from the remote Quote API.
     */
    private RestTemplate restTemplate;
    
    
    @Autowired
    public SterlingServiceBean(RestTemplateBuilder restTemplateBuilder) {
           restTemplate = restTemplateBuilder
          .errorHandler(new RestTemplateResponseErrorHandler())
          .build();
    }
       
    
  	@Override
	public OrderXSDType getOrderDetails(String orderHeaderKey) {
		
		
  		OrderXSDType orderXSDType = null;
  		restTemplate = SterlingServiceUtil.restemplateBuilder(restTemplate);
  		  		
		//restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		
		 logger.info("< getOrderDetails");
			 
		 try
		 {
		 orderXSDType = this.restTemplate.getForObject(
	                "http://domsrvaqa/smcfs/restapi/order/detail?OrderHeaderKey={orderHeaderKey}",
	                OrderXSDType.class, orderHeaderKey);
		 }
		 catch(Exception notFoundException)
		 {
			 //logger.error(notFoundException.getPropertiesMap().get("code"));
			 throw notFoundException;
		 }
		
		 if(orderXSDType != null)
		 {
			 logger.info("Document Type :"+ orderXSDType.getDocumentType());
			 logger.info("Order No :" + orderXSDType.getOrderNo());
			 OrderLine orderLine = orderXSDType.getOrderLines().getOrderLine().get(0);
			 logger.info("Prime Line No :"+String.valueOf((BigInteger)orderLine.getPrimeLineNo()));
		 
			 logger.info("> getOrderDetails");
		 }
		 else
		 {
			 logger.info("Null");
		 }
		 
		 
		 
		return orderXSDType;
	}

}
