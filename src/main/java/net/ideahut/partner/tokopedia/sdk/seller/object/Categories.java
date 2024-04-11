package net.ideahut.partner.tokopedia.sdk.seller.object;

import java.util.List;

public class Categories {

	public List<Category> categories;
	
	public static class Category {
	    public String name;
	    public String id;
	    public List<Child> child;
	}

	public static class Child {
	    public String name;
	    public String id;
	    public List<Child> child;
	}
	
}
