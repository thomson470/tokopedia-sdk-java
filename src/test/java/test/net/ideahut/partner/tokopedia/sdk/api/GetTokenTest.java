package test.net.ideahut.partner.tokopedia.sdk.api;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedToken;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetTokenTest {
	
	@Test
	public void test() {
		Tokopedia tokopedia = Tokopedia.newBuilder().build();		
		TokpedToken tptoken = tokopedia.getToken(TestConstants.clientId, TestConstants.clientSecret);
		TestConstants.logger.info(Mapper.writeValueAsString(tptoken, true));
	}

}
