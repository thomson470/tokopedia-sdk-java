package test.net.ideahut.partner.tokopedia.sdk.api.seller.finance;

import java.util.List;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.SaldoHistory;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetSaldoHistoryTest {

	@Test
	public void test() {
		Boolean export = false;
		TokpedInquiry inquiry = new TokpedInquiry();
		inquiry.shop_id = 14645432L;
		inquiry.from_date = "1664609444000";
		inquiry.to_date = "1672471844000";
		inquiry.page = 1;
		inquiry.per_page = 10;		
		TokpedResponse<List<SaldoHistory>> response = TestConstants.tokopedia.getSellerApi().getFinanceApi().getSaldoHistory(inquiry, export);
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
