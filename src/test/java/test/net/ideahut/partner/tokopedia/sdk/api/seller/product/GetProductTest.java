package test.net.ideahut.partner.tokopedia.sdk.api.seller.product;

import java.util.List;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductGet;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetProductTest {

	@Test
	public void test() {
		Long product_id = 6877767379L;
		TokpedResponse<List<ProductGet>> response = TestConstants.tokopedia.getSellerApi().getProductApi().getProduct(product_id);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}

}
