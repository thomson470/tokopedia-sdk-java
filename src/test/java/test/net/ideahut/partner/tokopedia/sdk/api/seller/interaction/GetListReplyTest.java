package test.net.ideahut.partner.tokopedia.sdk.api.seller.interaction;

import java.util.List;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.Reply;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetListReplyTest {

	@Test
	public void test() {
		Long msg_id = 2267576597L;
		TokpedInquiry inquiry = new TokpedInquiry();
		inquiry.shop_id = 14645432L;
		inquiry.page = 1;
		inquiry.per_page = 10;		
		TokpedResponse<List<Reply>> response = TestConstants.tokopedia.getSellerApi().getInteractionApi().getListReply(inquiry, msg_id);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
