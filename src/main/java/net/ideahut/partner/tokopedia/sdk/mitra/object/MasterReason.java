package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class MasterReason {

	public List<Reason> reasons;
	
	public static class EvidenceDetailInfo {
	    public Long evidence_id;
	    public String evidence_name;
	}

	public static class Reason {
	    public Long reason_id;
	    public String reason;
	    public Integer reason_type;
	    public Integer reason_category;
	    public String reason_category_name;
	    public List<EvidenceDetailInfo> evidence_detail_info;
	}
	
}
