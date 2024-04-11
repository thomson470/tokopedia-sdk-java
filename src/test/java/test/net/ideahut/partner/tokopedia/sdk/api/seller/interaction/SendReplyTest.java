package test.net.ideahut.partner.tokopedia.sdk.api.seller.interaction;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.ReplyInput;
import net.ideahut.partner.tokopedia.sdk.seller.object.ReplyResult;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class SendReplyTest {

	@Test
	public void test() {
		Long msg_id = 2267576597L;
		ReplyInput replyInput = new ReplyInput();
		replyInput.shop_id = 14645432L;
		replyInput.message = "Gak kena ayu tingting";
		TokpedResponse<ReplyResult> response = TestConstants.tokopedia.getSellerApi().getInteractionApi().sendReply(msg_id, replyInput);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
