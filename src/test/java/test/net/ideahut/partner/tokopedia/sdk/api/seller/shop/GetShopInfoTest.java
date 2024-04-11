package test.net.ideahut.partner.tokopedia.sdk.api.seller.shop;

import java.util.List;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.Shop;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetShopInfoTest {

	@Test
	public void test() {
		TokpedInquiry inquiry = new TokpedInquiry();
		inquiry.page = 1;
		inquiry.per_page = 10;		
		TokpedResponse<List<Shop>> response = TestConstants.tokopedia.getSellerApi().getShopApi().getShopInfo(inquiry);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}

}
