package test.net.ideahut.partner.tokopedia.sdk.api.seller.webhook;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.WebhookRegister;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetRegisteredWebhookTest {

	@Test
	public void test() {
		TokpedResponse<WebhookRegister> response = TestConstants.tokopedia.getSellerApi().getWebhookApi().getRegisteredWebhook();
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}

}
