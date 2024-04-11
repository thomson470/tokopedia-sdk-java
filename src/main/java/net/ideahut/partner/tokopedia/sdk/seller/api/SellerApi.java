package net.ideahut.partner.tokopedia.sdk.seller.api;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;

public class SellerApi extends Tokopedia.Api {
	
	private final Tokopedia tokopedia;
	public SellerApi(Tokopedia tokopedia) {
		super(tokopedia);
		this.tokopedia = tokopedia;
	}

	private ProductApi productApi;
	public ProductApi getProductApi() {
		if (productApi == null) {
			productApi = new ProductApi(tokopedia);
		}
		return productApi;
	}
	
	private ShopApi shopApi;
	public ShopApi getShopApi() {
		if (shopApi == null) {
			shopApi = new ShopApi(tokopedia);
		}
		return shopApi;
	}
	
	private OrderApi orderApi;
	public OrderApi getOrderApi() {
		if (orderApi == null) {
			orderApi = new OrderApi(tokopedia);
		}
		return orderApi;
	}
	
	private CategoryApi categoryApi;
	public CategoryApi getCategoryApi() {
		if (categoryApi == null) {
			categoryApi = new CategoryApi(tokopedia);
		}
		return categoryApi;
	}
	
	private LogisticApi logisticApi;
	public LogisticApi getLogisticApi() {
		if (logisticApi == null) {
			logisticApi = new LogisticApi(tokopedia);
		}
		return logisticApi;
	}
	
	private CampaignApi campaignApi;
	public CampaignApi getCampaignApi() {
		if (campaignApi == null) {
			campaignApi = new CampaignApi(tokopedia);
		}
		return campaignApi;
	}	
	
	private BundleApi bundleApi;
	public BundleApi getBundleApi() {
		if (bundleApi == null) {
			bundleApi = new BundleApi(tokopedia);
		}
		return bundleApi;
	}
	
	private WebhookApi webhookApi;
	public WebhookApi getWebhookApi() {
		if (webhookApi == null) {
			webhookApi = new WebhookApi(tokopedia);
		}
		return webhookApi;
	}
	
	private InteractionApi interactionApi;
	public InteractionApi getInteractionApi() {
		if (interactionApi == null) {
			interactionApi = new InteractionApi(tokopedia);
		}
		return interactionApi;
	}
	
	private FinanceApi financeApi;
	public FinanceApi getFinanceApi() {
		if (financeApi == null) {
			financeApi = new FinanceApi(tokopedia);
		}
		return financeApi;
	}

}
