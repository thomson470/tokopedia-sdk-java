package test.net.ideahut.partner.tokopedia.sdk.api.mitra.delivery;

import org.junit.Test;

import net.ideahut.partner.tokopedia.sdk.mitra.object.MasterReason;
import net.ideahut.partner.tokopedia.sdk.mitra.object.MitraResponse;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import test.net.ideahut.partner.tokopedia.sdk.TestConstants;

public class GetMasterReason {

	@Test
	public void test() {
		MitraResponse<MasterReason> response = TestConstants.tokopedia.getMitraApi().getDeliveryApi().getMasterReason();
		TestConstants.logger.info(Mapper.writeValueAsString(response, true));
	}
	
}
