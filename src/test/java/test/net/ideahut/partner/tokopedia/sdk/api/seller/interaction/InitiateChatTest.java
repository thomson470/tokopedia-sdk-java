package test.net.ideahut.partner.tokopedia.sdk.api.seller.interaction;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.InitiateChat;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class InitiateChatTest {

	@Test
	public void test() {
		Long order_id = 1411070828L;	
		TokpedResponse<InitiateChat> response = TestConstants.tokopedia.getSellerApi().getInteractionApi().initiateChat(order_id);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
