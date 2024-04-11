package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

public class ProductChangeResult {

	public Integer total_data;
    public Integer success_data;
    public Integer fail_data;
    public ArrayList<SuccessRowsDatum> success_rows_data;
    
    public Integer succeed_rows;
    public Integer failed_rows;
    public ArrayList<FailedRowsDatum> failed_rows_data;

	public static class SuccessRowsDatum {
	    public Long product_id;
	    public String product_sku;
	}
	
	public static class FailedRowsDatum {
	    public String product_name;
	    public int product_price;
	    public String sku;
	    public ArrayList<String> error;
	}
	
}
