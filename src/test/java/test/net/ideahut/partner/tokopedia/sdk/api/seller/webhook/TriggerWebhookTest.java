package test.net.ideahut.partner.tokopedia.sdk.api.seller.webhook;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.WebhookTrigger;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class TriggerWebhookTest {

	@Test
	public void test() {
		WebhookTrigger trigger = new WebhookTrigger();
		trigger.is_encrypted = true;
		trigger.order_id = 1992191442L;
		trigger.url = "https://webhook.site/662b4823-599f-4455-b349-32c43701f72b";
		trigger.type = 0;
		TokpedResponse<String> response = TestConstants.tokopedia.getSellerApi().getWebhookApi().triggerWebhook(trigger);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
