package test.net.ideahut.partner.tokopedia.sdk.api.seller.product;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.ProductChangeResult;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class SetActiveProductTest {

	@Test
	public void test() {
		Long shop_id = 14645432L;
		List<Long> product_ids = Arrays.asList(6878809451L);
		TokpedResponse<ProductChangeResult> response = TestConstants.tokopedia.getSellerApi().getProductApi().setActiveProduct(shop_id, product_ids);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}

}
