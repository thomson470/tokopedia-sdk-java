package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class ProductGetV2 {

	public List<Datum> data;
	
	public static class Datum{
	    public Long product_id;
	    public String name;
	    public String sku;
	    public Long shop_id;
	    public String shop_name;
	    public Long category_id;
	    public String desc;
	    public Integer stock;
	    public Double price;
	    public String status;
	}
	
}
