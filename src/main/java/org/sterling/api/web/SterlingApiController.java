package org.sterling.api.web;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sterling.api.exception.impl.beans.NotFoundException;
import org.sterling.api.service.SterlingService;

import com.sterlingcommerce.documentation.yfs.getorderdetails.output.OrderXSDType;


@RestController
public class SterlingApiController{
	
	/**
     * The Logger for this class.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SterlingService sterlingService;
	
	@RequestMapping(
            value = "/api/getOrderDetails",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderXSDType> getOrderDetails(@RequestParam(value="OrderHeaderKey") String orderHeaderKey) throws Exception {
		
		logger.info("> getOrderDetails");

        OrderXSDType order = sterlingService.getOrderDetails(orderHeaderKey);

        if (order == null) {
            //return new ResponseEntity<OrderXSDType>(HttpStatus.NOT_FOUND);
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("orderHeaderKey", orderHeaderKey);
        	throw new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase(),map);
        }
        logger.info("< getOrderDetails");
        return new ResponseEntity<OrderXSDType>(order, HttpStatus.OK);
		
    }

}
