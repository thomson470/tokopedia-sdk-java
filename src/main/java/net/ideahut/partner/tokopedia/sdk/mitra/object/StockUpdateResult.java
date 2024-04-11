package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class StockUpdateResult {

	public Integer total_data;
	public Integer failed_rows;
    public List<FailedRowsDatum> failed_rows_data;
    public Integer succeed_rows;
    public List<SucceedRowsDatum> succeed_rows_data;
	
	public static class FailedRowsDatum {
	    public Long product_id;
	    public String sku;
	    public String product_url;
	    public Integer new_stock;
	    public String message;
	}
	
	public static class SucceedRowsDatum {
	    public Long productID;
	    public Long warehouseID;
	    public Long shopID;
	    public Integer stock;
	    public Double price;
	}
	
}
