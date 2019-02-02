package org.sterling.api.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    
    
  	@Override
	public OrderXSDType getOrderDetails(String orderHeaderKey) {
		
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
	    List messageConverters = new ArrayList();
	    messageConverters.add(new FormHttpMessageConverter());
	    messageConverters.add(new StringHttpMessageConverter());
	
		restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_XML));
		mappingJackson2HttpMessageConverter.setObjectMapper(mapper);
		messageConverters.add(mappingJackson2HttpMessageConverter);
	    restTemplate.setMessageConverters(messageConverters);
	    
	    
	    
		//restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		
		 logger.info("< getOrderDetails");
		 
		 logger.info("----->: "+this.restTemplate.getForObject(
	                "http://domsrvaqa/smcfs/restapi/order/detail?OrderHeaderKey={orderHeaderKey}",
	                String.class, orderHeaderKey));
		 
				 
		 OrderXSDType orderXSDType = this.restTemplate.getForObject(
	                "http://domsrvaqa/smcfs/restapi/order/detail?OrderHeaderKey={orderHeaderKey}",
	                OrderXSDType.class, orderHeaderKey);
		 
		
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
