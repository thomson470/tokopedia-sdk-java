package test.net.ideahut.partner.tokopedia.sdk.api;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.object.TokpedWhitelistIP;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetWhitelistIPTest {
	
	@Test
	public void test() {
		TokpedResponse<TokpedWhitelistIP> response = TestConstants.tokopedia.getWhitelistIP();
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
