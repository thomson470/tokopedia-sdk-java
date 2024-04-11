package net.ideahut.partner.tokopedia.sdk.mitra.api;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;

public class MitraApi extends Tokopedia.Api {

	private final Tokopedia tokopedia;
	public MitraApi(Tokopedia tokopedia) {
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
	
	private OrderMitraApi orderMitraApi;
	public OrderMitraApi getOrderMitraApi() {
		if (orderMitraApi == null) {
			orderMitraApi = new OrderMitraApi(tokopedia);
		}
		return orderMitraApi;
	}
	
	private DeliveryApi deliveryApi;
	public DeliveryApi getDeliveryApi() {
		if (deliveryApi == null) {
			deliveryApi = new DeliveryApi(tokopedia);
		}
		return deliveryApi;
	}
	
	private POMonitoringApi poMonitoringApi;
	public POMonitoringApi getPOMonitoringApi() {
		if (poMonitoringApi == null) {
			poMonitoringApi = new POMonitoringApi(tokopedia);
		}
		return poMonitoringApi;
	}

}
