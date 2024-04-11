package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	public Basic basic;
    public Price price;
    public Weight weight;
    public Stock stock;
    public Integer main_stock;
    public Integer reserve_stock;
    public Variant variant;
    public Menu menu;
    public Preorder preorder;
    public ExtraAttribute extraAttribute;
    public ArrayList<CategoryTree> categoryTree;
    public ArrayList<Picture> pictures;
    @JsonProperty("GMStats") 
    public GMStats gMStats;
    public Stats stats;
    public Other other;
    public Campaign campaign;
    public ArrayList<Warehouse> warehouses;
	
	public static class Basic {
	    public Long productID;
	    public Long shopID;
	    public Integer status;
	    @JsonProperty("Name") 
	    public String name;
	    public Integer condition;
	    public Integer childCategoryID;
	    public String shortDesc;
	}

	public static class Campaign {
	    @JsonProperty("StartDate") 
	    public String startDate;
	    @JsonProperty("EndDate") 
	    public String endDate;
	}

	public static class CategoryTree {
	    public Long id;
	    @JsonProperty("Name") 
	    public String name;
	    public String title;
	    public String breadcrumbURL;
	}

	public static class ExtraAttribute {
	    public Integer minOrder;
	    public Integer lastUpdateCategory;
	    public Boolean isEligibleCOD;
	}

	public static class GMStats {
	    public Integer transactionSuccess;
	    public Integer transactionReject;
	    public Integer countSold;
	}

	public static class Menu {
	    public Long id;
	    @JsonProperty("Name") 
	    public String name;
	}

	public static class Other {
	    public String sku;
	    public String url;
	    public String mobileURL;
	}

	public static class Picture {
	    public Long picID;
	    public String fileName;
	    public String filePath;
	    public Integer status;
	    @JsonProperty("OriginalURL") 
	    public String originalURL;
	    @JsonProperty("ThumbnailURL") 
	    public String thumbnailURL;
	    public Integer width;
	    public Integer height;
	    @JsonProperty("URL300") 
	    public String uRL300;
	}

	public static class Preorder {
	}

	public static class Price {
	    public Double value;
	    public Integer currency;
	    @JsonProperty("LastUpdateUnix") 
	    public Integer lastUpdateUnix;
	    public Integer idr;
	}

	public static class Stats {
	    public Integer countView;
	}

	public static class Stock {
	    public Integer value;
	    public String stockWording;
	    public Boolean useStock;
	}

	public static class Variant {
	    public Boolean isParent;
	    public Boolean isVariant;
	    public ArrayList<Integer> childrenID;
	}

	public static class Warehouse {
	    public Long productID;
	    public Long warehouseID;
	    public Price price;
	    public Stock stock;
	}

	public static class Weight {
	    public Integer value;
	    public Integer unit;
	}
	
}
