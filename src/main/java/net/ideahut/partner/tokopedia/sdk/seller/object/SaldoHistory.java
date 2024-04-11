package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoHistory {

	public boolean have_next_page;
    public List<History> saldo_history;

	public static class History {
	    public Long deposit_id;
	    public String type_description;
	    @JsonProperty("Type") 
	    public Integer type;
	    @JsonProperty("class") 
	    public String myclass;
	    public Double amount;
	    public String note;
	    public String create_time;
	    public String withdrawal_date;
	    public Integer withdrawal_status;
	    public Integer saldo;
	    public String image;
	}
	
}
