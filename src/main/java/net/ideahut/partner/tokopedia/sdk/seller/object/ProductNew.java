package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductNew {
	
	public ArrayList<Product> products;

	public static class Dimension {
	    public Integer height;
	    public Integer width;
	    public Integer length;
	}

	public static class Etalase{
	    public Integer id;
	}

	public static class Picture {
	    public String file_path;
	}

	public static class Product {
	    @JsonProperty("Name") 
	    public String name;
	    public String condition;
	    @JsonProperty("Description") 
	    public String description;
	    public String sku;
	    public Integer price;
	    public String status;
	    public Integer stock;
	    public Integer min_order;
	    public Long category_id;
	    public Dimension dimension;
	    public ArrayList<Long> custom_product_logistics;
	    public ArrayList<String> annotations;
	    public String price_currency;
	    public Integer weight;
	    public String weight_unit;
	    public Boolean is_free_return;
	    public Boolean is_must_insurance;
	    public Etalase etalase;
	    public ArrayList<Picture> pictures;
	    public ArrayList<Wholesale> wholesale;
	}

	public static class Wholesale {
	    public Integer min_qty;
	    public Integer price;
	}
	
}
