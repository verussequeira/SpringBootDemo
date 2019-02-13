package org.sterling.api.exception.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.sterling.api.exception.impl.beans.Input;
import org.sterling.api.exception.impl.beans.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestTemplateResponseErrorHandler 
  implements ResponseErrorHandler {
 
	
	 /**
     * The Logger for this class.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @Override
    public boolean hasError(ClientHttpResponse httpResponse) 
      throws IOException {
 
        return (
          httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR 
          || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }
 
    @Override
    public void handleError(ClientHttpResponse httpResponse) 
      throws IOException {
 
        if (httpResponse.getStatusCode()
          .series() == HttpStatus.Series.SERVER_ERROR) {
            // handle SERVER_ERROR
        	logger.error(httpResponse.getStatusCode().getReasonPhrase());
        	logger.error(httpResponse.getBody().toString());
        	logger.error(httpResponse.getStatusText());
        } else if (httpResponse.getStatusCode()
          .series() == HttpStatus.Series.CLIENT_ERROR) {
        	logger.error("In Client error handler");
        	logger.error(httpResponse.getStatusCode().getReasonPhrase());
        	//logger.error(readBody(httpResponse));
        	logger.error(httpResponse.getStatusText());
        	Map<String, Object> map = readResponseBody(httpResponse);
        	NotFoundException exception = new NotFoundException(httpResponse.getStatusText(), map);
        	throw exception;
            
        }
    }
    
    
    
    private  String readBody(final ClientHttpResponse response) throws IOException {
        BufferedReader responseBodyReader = null;

        try {
        	
        
          responseBodyReader = new BufferedReader(new InputStreamReader(response.getBody()));

          StringBuilder buffer = new StringBuilder();
          String line;

          while ((line = responseBodyReader.readLine()) != null) {
            buffer.append(line).append(System.getProperty("line.separator"));
          }

          
        
          return buffer.toString().trim();
        } finally {
          IOUtils.closeQuietly(responseBodyReader);
        }
      }
    
    
    
    private Map<String, Object> readResponseBody(ClientHttpResponse response) throws IOException
    {
    	String jsonString = readBody(response);
    	ObjectMapper objectMapper = new ObjectMapper();
    	Input errorResponse = (Input) objectMapper.readValue(jsonString, Input.class);
    	logger.error(errorResponse.getErrors().get(0).getErrorDescription());
    	logger.error(errorResponse.getErrors().get(0).getErrorCode());
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("errorDescription", errorResponse.getErrors().get(0).getErrorDescription());
    	map.put("errorCode",errorResponse.getErrors().get(0).getErrorCode());
    	
    	return map;
    	
    	
    	
    }
}