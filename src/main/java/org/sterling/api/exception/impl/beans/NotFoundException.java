package org.sterling.api.exception.impl.beans;

import java.util.Map;


public class NotFoundException extends RuntimeException {
	
	
	  private static final long serialVersionUID = -2859292084648724403L;
	  private String status;
	  private Map<String, Object> mapException;
	  
	  
	  
	  public NotFoundException(String status, Map<String, Object> mapException){
		  
		  this.status = status;
		  this.mapException =  mapException;
		  
	  }
	  
	  
	public String getStatus() {
		return status;
	}


	public Map<String, Object> getMapException() {
		return mapException;
	}


	public void setMapException(Map<String, Object> mapException) {
		this.mapException = mapException;
	}
	  
	  
	/*Map<String, String> propertiesMap = new  HashMap<String, String>();

	public Map<String, String> getPropertiesMap() {
		return propertiesMap;
	}

	public void setPropertiesMap(Map<String, String> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}*/
	
	
}