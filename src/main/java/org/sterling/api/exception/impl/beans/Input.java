
package org.sterling.api.exception.impl.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "errors"
})
public class Input {

    @JsonProperty("errors")
    private List<Error> errors = new ArrayList<Error>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public Input withErrors(List<Error> errors) {
        this.errors = errors;
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

    public Input withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(errors).append(additionalProperties).toHashCode();
//    }

//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//        if ((other instanceof Input) == false) {
//            return false;
//        }
//        Input rhs = ((Input) other);
//        return new EqualsBuilder().append(errors, rhs.errors).append(additionalProperties, rhs.additionalProperties).isEquals();
//    }

}
