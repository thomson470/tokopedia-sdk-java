package test.net.ideahut.partner.tokopedia.sdk.api.seller.webhook;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.WebhookRegister;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class RegisterWebhookTest {

	@Test
	public void test() {
		WebhookRegister webhook = new WebhookRegister();
		webhook.campaign_notification_url = "http://yourstore.com/v1/order/notification";
		webhook.chat_notification_url = "http://yourstore.com/v1/chat/notification";
		/*
		webhook.order_actions_url = "";
		webhook.order_cancellation_url = "";
		webhook.order_confirm_delivery_notification_url = "";
		webhook.order_notification_url = "";
		webhook.order_request_cancellation_url = "";
		webhook.order_status_url = "";
		webhook.product_changes_url = "";
		webhook.product_creation_url = "";
		webhook.product_discussion_url = "";
		webhook.product_edit_url = "";
		webhook.webhook_secret = "";
		*/
		TokpedResponse<String> response = TestConstants.tokopedia.getSellerApi().getWebhookApi().registeredWebhook(webhook);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}

}
