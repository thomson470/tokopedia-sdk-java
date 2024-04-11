package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class DeliveryOrder {

	public Boolean success;
    public String message;
    public String invoice_num;
    public Long order_id;
    public Long payment_id;
    public MitraDetailInfo mitra_detail_info;
    public DriverDetailInfo driver_detail_info;
    public Integer order_status;
    public String payment_method;
    public Double old_total_price;
    public Double new_total_price;
    public Double unsend_price;
    public List<OrderDetailInfo> order_detail_info;
    public List<PromoDetailInfo> promo_detail_info;
    public List<ReasonHeaderInfo> reason_header_info;
    public List<ReasonRescheduleInfo> reason_reschedule_info;
    public List<EvidenceDetailInfo> evidence_detail_info;
    public String created_time;
    public String updated_time;
	
	
	public static class DriverDetailInfo {
	    public Long driver_user_id;
	    public String driver_name;
	}

	public static class EvidenceDetailInfo {
	    public Long evidence_id;
	    public String evidence_name;
	    public String value;
	}

	public static class MitraDetailInfo {
	    public Long mitra_user_id;
	    public String mitra_name;
	    public String mitra_phone_num;
	    public String mitra_sent_addr;
	    public String mitra_pic_url;
	    public String mitra_latitude;
	    public String mitra_longitude;
	}

	public static class OrderDetailInfo {
	    public Long product_id;
	    public String product_name;
	    public String pic_url;
	    public String short_desc;
	    public Integer old_quantity;
	    public Integer new_quantity;
	    public Double price;
	    public Double sub_total_price;
	    public Boolean is_wholesale;
	    public List<ReasonDetailInfo> reason_detail_info;
	}

	public static class PromoDetailInfo {
	    public Long promo_id;
	    public String promo_type;
	    public String promo_code;
	    public Double promo_amount;
	}

	public static class ReasonDetailInfo {
	    public Long reason_id;
	    public String reason;
	    public Integer reason_type;
	    public Integer reason_category;
	    public String reason_category_name;
	    public String reason_value;
	    public Boolean is_selected;
	    public List<EvidenceDetailInfo> evidence_detail_info;
	}

	public static class ReasonHeaderInfo {
	    public Long reason_id;
	    public String reason;
	    public Integer reason_type;
	    public Integer reason_category;
	    public String reason_category_name;
	    public String reason_value;
	    public Boolean is_selected;
	    public List<EvidenceDetailInfo> evidence_detail_info;
	}

	public static class ReasonRescheduleInfo {
	    public Long reason_id;
	    public String reason;
	    public Integer reason_type;
	    public Integer reason_category;
	    public String reason_category_name;
	    public String reason_value;
	    public Boolean is_selected;
	    public List<EvidenceDetailInfo> evidence_detail_info;
	}

	
}
