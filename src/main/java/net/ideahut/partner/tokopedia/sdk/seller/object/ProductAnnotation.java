package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductAnnotation {

	public String variant;
    public Integer sort_order;
    public ArrayList<Value> values;

	public class Value{
	    public Integer id;
	    @JsonProperty("Name") 
	    public String name;
	    public String data;
	}
	
}
