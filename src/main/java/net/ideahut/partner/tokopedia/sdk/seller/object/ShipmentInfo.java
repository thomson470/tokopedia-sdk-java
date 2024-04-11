package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

public class ShipmentInfo {

    public Long shipper_id;
    public String shipper_name;
    public String logo;
    public ArrayList<Service> services;

	public static class Service {
	    public Long service_id;
	    public String service_name;
	    public String service_desc;
	}
	
}
