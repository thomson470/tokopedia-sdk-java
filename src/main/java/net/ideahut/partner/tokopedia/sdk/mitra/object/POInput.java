package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class POInput {

	public String po_number;
    public String vendor_name;
    public String po_date;
    public String po_expired_date;
    public String gr_date;
    public List<Detail> detail;
	
	public static class Detail {
	    public String barcode;
	    public Double buy_price;
	    public Long product_unit_id;
	    public Integer po_qty;
	    public Integer gr_qty;
	    public String product_expiry_date;
	}
	
}
