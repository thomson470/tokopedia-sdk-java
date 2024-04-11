package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.ArrayList;

public class ProductVariant {

	public Long category_id;
    public ArrayList<ArrayList<Long>> variant_id_combinations;
    public ArrayList<VariantDetail> variant_details;

	public static class Unit{
	    public Long variant_unit_id;
	    public Integer status;
	    public String unit_name;
	    public String unit_short_name;
	    public ArrayList<UnitValue> unit_values;
	}

	public static class UnitValue{
	    public Long variant_unit_value_id;
	    public Integer status;
	    public String value;
	    public Long equivalent_value_id;
	    public String english_value;
	    public String hex;
	    public String icon;
	}

	public static class VariantDetail{
	    public Long variant_id;
	    public Integer has_unit;
	    public String identifier;
	    public String name;
	    public Integer status;
	    public ArrayList<Unit> units;
	    public Integer is_primary;
	}
	
}
