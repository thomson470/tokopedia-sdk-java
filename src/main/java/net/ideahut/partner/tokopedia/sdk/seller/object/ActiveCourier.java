package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActiveCourier {

	@JsonProperty("Shops") 
    public List<Shop> shops;

	public static class ShipmentInfo{
	    @JsonProperty("ShipmentID") 
	    public Long shipmentID;
	    @JsonProperty("ShipmentName") 
	    public String shipmentName;
	    @JsonProperty("ShipmentCode") 
	    public String shipmentCode;
	    @JsonProperty("ShipmentAvailable") 
	    public Integer shipmentAvailable;
	    @JsonProperty("ShipmentImage") 
	    public String shipmentImage;
	    @JsonProperty("ShipmentPackages") 
	    public List<ShipmentPackage> shipmentPackages;
	    @JsonProperty("AWBStatus") 
	    public Integer aWBStatus;
	}

	public static class ShipmentPackage{
	    @JsonProperty("IsAvailable") 
	    public Integer isAvailable;
	    @JsonProperty("ProductName") 
	    public String productName;
	    @JsonProperty("ShippingProductID") 
	    public Long shippingProductID;
	}

	public static class Shop{
	    @JsonProperty("ShopID") 
	    public Long shopID;
	    @JsonProperty("ShipmentInfos") 
	    public List<ShipmentInfo> shipmentInfos;
	}
	
}
