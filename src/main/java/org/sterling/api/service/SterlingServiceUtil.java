package org.sterling.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SterlingServiceUtil {
	
	 /**
     * The RestTemplate used to retrieve data from the remote Quote API.
     */
    private static RestTemplate restTemplate;
    
    
    public  static RestTemplate restemplateBuilder(RestTemplate restTemplate){
    	
    	
    	ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
	    List messageConverters = new ArrayList();
	    messageConverters.add(new FormHttpMessageConverter());
	    messageConverters.add(new StringHttpMessageConverter());
	
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_XML));
		mappingJackson2HttpMessageConverter.setObjectMapper(mapper);
		messageConverters.add(mappingJackson2HttpMessageConverter);
	    restTemplate.setMessageConverters(messageConverters);
	    
	    return restTemplate;
    	
    }

}
