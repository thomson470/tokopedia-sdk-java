package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResolutionTicket {

	public Boolean is_success;
    public String startdate;
    public String enddate;
    public ArrayList<Shop> shops;
    
	public static class ComplaintProduct {
	    public Integer id;
	    @JsonProperty("Name") 
	    public String name;
	    public Integer qty;
	    public Double price;
	    public Double final_price;
	    public String image;
	}

	public static class Shop {
	    public Long shop_id;
	    public String shop_name;
	    public ArrayList<Ticket> ticket;
	}

	public static class Ticket {
	    public Long id;
	    public String problem_type;
	    public String status;
	    public String open_date;
	    public String sla_date;
	    public String close_date;
	    public String invoice_number;
	    public String solution;
	    public ArrayList<ComplaintProduct> complaint_product;
	    public String fault;
	    public Integer shipping_amt;
	    public Integer total_issued_funds;
	}
	
}
