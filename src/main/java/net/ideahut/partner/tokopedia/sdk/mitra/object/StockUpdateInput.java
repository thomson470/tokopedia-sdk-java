package net.ideahut.partner.tokopedia.sdk.mitra.object;

public class StockUpdateInput {

	public Long product_id;
	public String sku;
	
	public Integer new_stock; // untuk update
	public Integer stock_value; // untuk increment/decrement
	
}
