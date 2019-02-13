package org.sterling.api.exception.impl.beans;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ErrorDescription",
    "ErrorCode",
    //"MoreInfo",
    "httpcode"
})
public class Error {

    @JsonProperty("ErrorDescription")
    private String errorDescription;
    @JsonProperty("ErrorCode")
    private String errorCode;
//    @JsonProperty("MoreInfo")
//    private MoreInfo moreInfo;
    @JsonProperty("httpcode")
    private Integer httpcode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ErrorDescription")
    public String getErrorDescription() {
        return errorDescription;
    }

    @JsonProperty("ErrorDescription")
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Error withErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    @JsonProperty("ErrorCode")
    public String getErrorCode() {
        return errorCode;
    }

    @JsonProperty("ErrorCode")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Error withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

//    @JsonProperty("MoreInfo")
//    public MoreInfo getMoreInfo() {
//        return moreInfo;
//    }
//
//    @JsonProperty("MoreInfo")
//    public void setMoreInfo(MoreInfo moreInfo) {
//        this.moreInfo = moreInfo;
//    }
//
//    public Error withMoreInfo(MoreInfo moreInfo) {
//        this.moreInfo = moreInfo;
//        return this;
//    }

    @JsonProperty("httpcode")
    public Integer getHttpcode() {
        return httpcode;
    }

    @JsonProperty("httpcode")
    public void setHttpcode(Integer httpcode) {
        this.httpcode = httpcode;
    }

    public Error withHttpcode(Integer httpcode) {
        this.httpcode = httpcode;
        return this;
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Error withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(errorDescription).append(errorCode).append(moreInfo).append(httpcode).append(additionalProperties).toHashCode();
//    }

//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof Error) == false) {
//            return false;
//        }
//        Error rhs = ((Error) other);
//        return new EqualsBuilder().append(errorDescription, rhs.errorDescription).append(errorCode, rhs.errorCode).append(moreInfo, rhs.moreInfo).append(httpcode, rhs.httpcode).append(additionalProperties, rhs.additionalProperties).isEquals();
//    }

}
