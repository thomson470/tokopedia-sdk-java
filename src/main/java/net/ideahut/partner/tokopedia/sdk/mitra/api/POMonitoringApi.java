package net.ideahut.partner.tokopedia.sdk.mitra.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.mitra.object.MitraResponse;
import net.ideahut.partner.tokopedia.sdk.mitra.object.POInput;
import net.ideahut.partner.tokopedia.sdk.mitra.object.POResult;
import net.ideahut.partner.tokopedia.sdk.mitra.object.ProductUOM;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class POMonitoringApi extends Tokopedia.Api {

	protected POMonitoringApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public MitraResponse<POResult> createNewPO(POInput input) {
		Assert.notNull(input, "input required");
		Assert.hasLength(input.po_number, "po_number required");		
		byte[] json = Mapper.writeValueAsBytes(input);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/po/monitor")
		.method(TokpedRequest.Method.POST)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<POResult> result = MitraResponse.parse(POResult.class, response.data);
		return result;
	}
	
	public MitraResponse<POResult> editPO(POInput input) {
		Assert.notNull(input, "input required");
		Assert.hasLength(input.po_number, "po_number required");		
		byte[] json = Mapper.writeValueAsBytes(input);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/po/monitor")
		.method(TokpedRequest.Method.PATCH)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<POResult> result = MitraResponse.parse(POResult.class, response.data);
		return result;
	}
	
	public MitraResponse<POResult> submitPO(POInput input) {
		Assert.notNull(input, "input required");
		Assert.hasLength(input.po_number, "po_number required");		
		byte[] json = Mapper.writeValueAsBytes(input);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/po/monitor/submit")
		.method(TokpedRequest.Method.PATCH)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<POResult> result = MitraResponse.parse(POResult.class, response.data);
		return result;
	}
	
	public MitraResponse<POResult> goodsReceived(POInput input) {
		Assert.notNull(input, "input required");
		Assert.hasLength(input.po_number, "po_number required");		
		byte[] json = Mapper.writeValueAsBytes(input);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/po/monitor/submit")
		.method(TokpedRequest.Method.PATCH)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<POResult> result = MitraResponse.parse(POResult.class, response.data);
		return result;
	}
	
	public MitraResponse<POResult> cancelPO(POInput input) {
		Assert.notNull(input, "input required");
		Assert.hasLength(input.po_number, "po_number required");		
		byte[] json = Mapper.writeValueAsBytes(input);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/po/monitor/cancel")
		.method(TokpedRequest.Method.POST)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<POResult> result = MitraResponse.parse(POResult.class, response.data);
		return result;
	}
	
	public MitraResponse<List<ProductUOM>> getProductUOM(String barcode) {
		Assert.hasLength(barcode, "barcode required");
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/products/" + barcode + "/units");
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<List<ProductUOM>> result = MitraResponse.parse(new TypeReference<List<ProductUOM>>() {}, response.data);
		return result;
	}

}
