package test.net.ideahut.partner.tokopedia.sdk.api.seller.webhook;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.WebhookPayload;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetWebhookPayloadTest {

	@Test
	public void test() {
		Long order_id = 1234L;
		Integer type = 0;
		TokpedResponse<WebhookPayload> response = TestConstants.tokopedia.getSellerApi().getWebhookApi().getWebhookPayload(order_id, type);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
