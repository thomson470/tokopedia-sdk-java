package test.net.ideahut.partner.tokopedia.sdk.api.seller.product;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductChangeResult;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductNew;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class CreateProductTest {
	
	private static String jproduct = "{\r\n" + 
			"   \"products\":[\r\n" + 
			"      {\r\n" + 
			"         \"Name\":\"Hape-" + System.currentTimeMillis() + "\",\r\n" + 
			"         \"condition\":\"NEW\",\r\n" + 
			"         \"Description\":\"Hape terbaru buat kamu\",\r\n" + 
			"         \"sku\":\"TST2255\",\r\n" + 
			"         \"price\":50000,\r\n" + 
			"         \"status\":\"LIMITED\",\r\n" + 
			"         \"stock\":50,\r\n" + 
			"         \"min_order\":1,\r\n" + 
			"        \"category_id\":3058,\r\n" + 
			"        \"dimension\":{\r\n" + 
			"                \"height\":2,\r\n" + 
			"                \"width\":3,\r\n" + 
			"                \"length\":4\r\n" + 
			"        },\r\n" + 
			"        \"custom_product_logistics\":[24,4,64],\r\n" + 
			"        \"annotations\":[\"1\"],\r\n" + 
			"         \"price_currency\":\"IDR\",\r\n" + 
			"         \"weight\":200,\r\n" + 
			"         \"weight_unit\":\"GR\",\r\n" + 
			"         \"is_free_return\":false,\r\n" + 
			"         \"is_must_insurance\":false,\r\n" + 
			//"         \"etalase\":{\r\n" + 
			//"            \"id\":1402922\r\n" + 
			//"         },\r\n" + 
			"         \"pictures\":[\r\n" + 
			"            {\r\n" + 
			"               \"file_path\":\"https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//90/MTA-4607071/aldo_handphone_aldo_s12_6_inch_full09_oeleaik5.jpg\"\r\n" + 
			"            }\r\n" + 
			"         ],\r\n" + 
			"         \"wholesale\":[\r\n" + 
			"            {\r\n" + 
			"               \"min_qty\":2,\r\n" + 
			"               \"price\":9500\r\n" + 
			"            },\r\n" + 
			"            {\r\n" + 
			"               \"min_qty\":3,\r\n" + 
			"               \"price\":9000\r\n" + 
			"            }\r\n" + 
			"         ]\r\n" + 
			"      }\r\n" + 
			"   ]\r\n" + 
			"}";

	@Test
	public void test() {
		Long shopId = 14645432L;
		ProductNew productNew = Mapper.readValue(ProductNew.class, jproduct);	
		TokpedResponse<ProductChangeResult> response = TestConstants.tokopedia.getSellerApi().getProductApi().createProduct(shopId, productNew);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}

}
