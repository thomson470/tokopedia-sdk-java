package net.ideahut.partner.tokopedia.sdk.seller.object.webhook;

import java.util.List;

public class ProductCreationNotification {

	public Long upload_id;
    public Long shop_id;
    public Long user_id;
    public Long fs_id;
    public String status;
    public Integer total_data;
    public List<SuccessRowsDatum> success_rows_data;

	public static class SuccessRowsDatum {
	    public Long product_id;
	}


	
}
