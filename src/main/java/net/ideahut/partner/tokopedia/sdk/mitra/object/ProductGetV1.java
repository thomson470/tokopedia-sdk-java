package net.ideahut.partner.tokopedia.sdk.mitra.object;

import java.util.List;

public class ProductGetV1 {

	public Integer total_data;
    public Shop shop;
    public List<Product> products;
	
	public static class Badge {
	    public String title;
	    public String image_url;
	}

	public static class Product {
	    public Long id;
	    public String name;
	    public String childs; // di dokumen tidak ada definisi
	    public String url;
	    public String image_url;
	    public String image_url_700;
	    public String price;
	    public Shop shop;
	    public List<Wholesale> wholesale_price; // di dokumen tidak ada definisi
	    public Integer courier_count;
	    public Integer condition;
	    public Long category_id;
	    public String category_name;
	    public String category_breadcrumb;
	    public Long department_id;
	    public List<String> labels;
	    public List<Badge> badges;
	    public Integer is_featured;
	    public Integer rating;
	    public Integer count_review;
	    public String original_price;
	    public String discount_expired;
	    public Integer discount_percentage;
	    public String sku;
	    public Integer stock;
	}

	public static class Shop {
	    public Long id;
	    public String name;
	    public String uri;
	    public String location;
	    public String url;
	    public Boolean is_gold;
	    public String city;
	    public String reputation;
	    public String clover;
	}
	
	public static class Wholesale {
	    public Integer min_qty;
	    public Integer price;
	}
	
}
