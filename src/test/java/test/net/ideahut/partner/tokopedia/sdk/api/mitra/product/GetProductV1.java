package test.net.ideahut.partner.tokopedia.sdk.api.mitra.product;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.mitra.object.ProductGetV1;
import net.ideahut.partner.tokopedia.sdk.mitra.object.ProductInputV1;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetProductV1 {

	@Test
	public void test() {
		ProductInputV1 input = new ProductInputV1();
		input.shop_id = 14645432L;
		TokpedResponse<ProductGetV1> response = TestConstants.tokopedia.getMitraApi().getProductApi().getProductV1(input);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
