package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class DeliveryPartialConfirm {

	public String invoice_number;
    public List<OrderDetail> order_detail;
	
	public static class EvidenceDetailInfo{
	    public Long evidence_id;
	    public String value;
	}

	public static class OrderDetail {
	    public Long product_id;
	    public Integer new_quantity;
	    public List<ReasonDetail> reason_detail;
	}

	public static class ReasonDetail {
	    public Long reason_id;
	    public String reason;
	    public List<EvidenceDetailInfo> evidence_detail_info;
	}
	
}
