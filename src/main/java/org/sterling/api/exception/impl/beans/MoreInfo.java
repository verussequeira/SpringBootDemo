package org.sterling.api.exception.impl.beans;
//
//package org.sterling.api.service;
//
//import java.util.HashMap;
//import java.util.Map;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;
//import org.apache.commons.lang.builder.ToStringBuilder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "DocumentType",
//    "OrderNo",
//    "OrderHeaderKey",
//    "EnterpriseCode"
//})
//public class MoreInfo {
//
//    @JsonProperty("DocumentType")
//    private String documentType;
//    @JsonProperty("OrderNo")
//    private String orderNo;
//    @JsonProperty("OrderHeaderKey")
//    private String orderHeaderKey;
//    @JsonProperty("EnterpriseCode")
//    private String enterpriseCode;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    @JsonProperty("DocumentType")
//    public String getDocumentType() {
//        return documentType;
//    }
//
//    @JsonProperty("DocumentType")
//    public void setDocumentType(String documentType) {
//        this.documentType = documentType;
//    }
//
//    public MoreInfo withDocumentType(String documentType) {
//        this.documentType = documentType;
//        return this;
//    }
//
//    @JsonProperty("OrderNo")
//    public String getOrderNo() {
//        return orderNo;
//    }
//
//    @JsonProperty("OrderNo")
//    public void setOrderNo(String orderNo) {
//        this.orderNo = orderNo;
//    }
//
//    public MoreInfo withOrderNo(String orderNo) {
//        this.orderNo = orderNo;
//        return this;
//    }
//
//    @JsonProperty("OrderHeaderKey")
//    public String getOrderHeaderKey() {
//        return orderHeaderKey;
//    }
//
//    @JsonProperty("OrderHeaderKey")
//    public void setOrderHeaderKey(String orderHeaderKey) {
//        this.orderHeaderKey = orderHeaderKey;
//    }
//
//    public MoreInfo withOrderHeaderKey(String orderHeaderKey) {
//        this.orderHeaderKey = orderHeaderKey;
//        return this;
//    }
//
//    @JsonProperty("EnterpriseCode")
//    public String getEnterpriseCode() {
//        return enterpriseCode;
//    }
//
//    @JsonProperty("EnterpriseCode")
//    public void setEnterpriseCode(String enterpriseCode) {
//        this.enterpriseCode = enterpriseCode;
//    }
//
//    public MoreInfo withEnterpriseCode(String enterpriseCode) {
//        this.enterpriseCode = enterpriseCode;
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//    public MoreInfo withAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//        return this;
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(documentType).append(orderNo).append(orderHeaderKey).append(enterpriseCode).append(additionalProperties).toHashCode();
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof MoreInfo) == false) {
//            return false;
//        }
//        MoreInfo rhs = ((MoreInfo) other);
//        return new EqualsBuilder().append(documentType, rhs.documentType).append(orderNo, rhs.orderNo).append(orderHeaderKey, rhs.orderHeaderKey).append(enterpriseCode, rhs.enterpriseCode).append(additionalProperties, rhs.additionalProperties).isEquals();
//    }
//
//}
