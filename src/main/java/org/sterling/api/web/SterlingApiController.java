package org.sterling.api.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sterling.api.service.SterlingService;
import org.sterlng.ws.web.api.BaseController;

import com.sterlingcommerce.documentation.yfs.getorderdetails.output.OrderXSDType;


@RestController
public class SterlingApiController extends BaseController{
	
	@Autowired
	private SterlingService sterlingService;
	
	@RequestMapping(
            value = "/api/getOrderDetails",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<OrderXSDType> getOrderDetails(@RequestParam(value="OrderHeaderKey") String orderHeaderKey) {
        logger.info("> getOrderDetails");

        OrderXSDType order = sterlingService.getOrderDetails(orderHeaderKey);

        if (order == null) {
            return new ResponseEntity<OrderXSDType>(HttpStatus.NOT_FOUND);
        }
        logger.info("< getOrderDetails");
        return new ResponseEntity<OrderXSDType>(order, HttpStatus.OK);
    }

}
