package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class DeliveryReschedule {

	public String invoice_number;
    public List<ReasonReschedule> reason_reschedule;
	
	public class EvidenceDetailInfo{
	    public Long evidence_id;
	    public String value;
	}

	public class ReasonReschedule{
	    public Long reason_id;
	    public String reason;
	    public List<EvidenceDetailInfo> evidence_detail_info;
	}
	
}
