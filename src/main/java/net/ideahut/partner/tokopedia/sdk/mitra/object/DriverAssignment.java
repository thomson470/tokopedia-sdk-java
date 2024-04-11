package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class DriverAssignment {

	public Boolean success;
    public String message;
    public List<Assignment> assignments;
    
	public static class Assignment {
	    public String invoice_num;
	    public Double mitra_distance;
	    public String mitra_distance_display;
	    public Long mitra_user_id;
	    public String mitra_latitude;
	    public String mitra_longitude;
	    public String mitra_name;
	    public String mitra_sent_addr;
	}
	
}
