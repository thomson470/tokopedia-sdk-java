package test.net.ideahut.partner.tokopedia.sdk.api.seller.category;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.Categories;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetAllCategoriesTest {

	@Test
	public void test() {
		String keyword = "";
		TokpedResponse<Categories> response = TestConstants.tokopedia.getSellerApi().getCategoryApi().getAllCategories(keyword);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
