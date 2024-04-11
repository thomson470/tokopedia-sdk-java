package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class DeliveryFullConfirm {

	public String invoice_number;
    public List<OrderDetail> order_detail;
    public List<EvidenceDetail> evidence_detail;
	
	public static class EvidenceDetail {
	    public Long evidence_id;
	    public String value;
	}

	public static class OrderDetail{
	    public Long product_id;
	    public Integer new_quantity;
	}
	
}
