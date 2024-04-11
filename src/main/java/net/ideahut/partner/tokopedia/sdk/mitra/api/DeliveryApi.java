package net.ideahut.partner.tokopedia.sdk.mitra.api;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DeliveryAssign;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DeliveryCancelConfirm;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DeliveryFullConfirm;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DeliveryOrder;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DeliveryPartialConfirm;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DeliveryReschedule;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DeliveryStatus;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DriverAssignment;
import net.ideahut.partner.tokopedia.sdk.mitra.object.DriverInfo;
import net.ideahut.partner.tokopedia.sdk.mitra.object.MasterReason;
import net.ideahut.partner.tokopedia.sdk.mitra.object.MitraResponse;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class DeliveryApi extends Tokopedia.Api {

	protected DeliveryApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public MitraResponse<DriverInfo> registerDriver(Long shop_id, String phone_number, String email) {
		Assert.notNull(shop_id, "shop_id required");
		Assert.hasLength(phone_number, "phone_number required");
		Assert.hasLength(email, "email required");
		ObjectNode jnode = Mapper.createObjectNode();
		jnode.put("shop_id", shop_id);
		jnode.put("phone_number", phone_number);		
		jnode.put("email", email);
		byte[] json = Mapper.writeValueAsBytes(jnode);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/driver")
		.method(TokpedRequest.Method.POST)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DriverInfo> result = MitraResponse.parse(DriverInfo.class, response.data);
		return result;
	}
	
	public MitraResponse<DriverInfo> updateDriverStatus(String phone_number, Integer status) {
		Assert.hasLength(phone_number, "phone_number required");
		Assert.notNull(status, "status required");
		ObjectNode jnode = Mapper.createObjectNode();
		jnode.put("phone_number", phone_number);		
		jnode.put("status", status);
		byte[] json = Mapper.writeValueAsBytes(jnode);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/driver")
		.method(TokpedRequest.Method.PATCH)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DriverInfo> result = MitraResponse.parse(DriverInfo.class, response.data);
		return result;
	}
	
	public MitraResponse<DriverInfo> getDriverInformation(String phone_number) {
		Assert.hasLength(phone_number, "phone_number required");
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/drivers/" + phone_number);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DriverInfo> result = MitraResponse.parse(DriverInfo.class, response.data);
		return result;
	}
	
	public MitraResponse<DeliveryAssign> assignDelivery(String phone_number, String invoice_num) {
		Assert.hasLength(phone_number, "phone_number required");
		Assert.hasLength(invoice_num, "invoice_num required");		
		ObjectNode jnode = Mapper.createObjectNode();
		jnode.put("invoice_num", invoice_num);
		byte[] json = Mapper.writeValueAsBytes(jnode);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/drivers/" + phone_number + "/delivery/assignment")
		.method(TokpedRequest.Method.POST)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DeliveryAssign> result = MitraResponse.parse(DeliveryAssign.class, response.data);
		return result;
	}
	
	public MitraResponse<DriverAssignment> getDriverAssignment(String phone_number, String latitude, String longitude) {
		Assert.hasLength(phone_number, "phone_number required");
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/drivers/" + phone_number + "/delivery/assignment");
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DriverAssignment> result = MitraResponse.parse(DriverAssignment.class, response.data);
		return result;
	}
	
	public MitraResponse<DeliveryOrder> getOrderInformation(String phone_number, String invoice_num) {
		Assert.hasLength(phone_number, "phone_number required");
		Assert.hasLength(invoice_num, "invoice_num required");
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/drivers/" + phone_number + "/delivery/order?invoice_num=" + invoice_num);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DeliveryOrder> result = MitraResponse.parse(DeliveryOrder.class, response.data);
		return result;
	}
	
	public MitraResponse<MasterReason> getMasterReason() {
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/delivery/reason");
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<MasterReason> result = MitraResponse.parse(MasterReason.class, response.data);
		return result;
	}
	
	public MitraResponse<DeliveryStatus> confirmFullDelivery(String phone_number, DeliveryFullConfirm confirm) {
		Assert.hasLength(phone_number, "phone_number required");
		byte[] json = Mapper.writeValueAsBytes(confirm);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/drivers/" + phone_number + "/delivery/confirm")
		.method(TokpedRequest.Method.PUT)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DeliveryStatus> result = MitraResponse.parse(DeliveryStatus.class, response.data);
		return result;
	}
	
	public MitraResponse<DeliveryStatus> confirmPartialDelivery(String phone_number, DeliveryPartialConfirm confirm) {
		Assert.hasLength(phone_number, "phone_number required");
		byte[] json = Mapper.writeValueAsBytes(confirm);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/drivers/" + phone_number + "/delivery/confirm")
		.method(TokpedRequest.Method.PUT)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DeliveryStatus> result = MitraResponse.parse(DeliveryStatus.class, response.data);
		return result;
	}
	
	public MitraResponse<DeliveryStatus> cancelOrderDelivery(String phone_number, DeliveryCancelConfirm confirm) {
		Assert.hasLength(phone_number, "phone_number required");
		byte[] json = Mapper.writeValueAsBytes(confirm);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/drivers/" + phone_number + "/delivery/confirm")
		.method(TokpedRequest.Method.PUT)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DeliveryStatus> result = MitraResponse.parse(DeliveryStatus.class, response.data);
		return result;
	}
	
	public MitraResponse<DeliveryStatus> rescheduleDelivery(String phone_number, DeliveryReschedule reschedule) {
		Assert.hasLength(phone_number, "phone_number required");
		byte[] json = Mapper.writeValueAsBytes(reschedule);
		RequestBody body = RequestBody.create(json, JSON);		
		TokpedRequest request = TokpedRequest.create()
		.path("/mitra/integration/v1/fs/" + fs_id + "/drivers/" + phone_number + "/delivery/reschedule")
		.method(TokpedRequest.Method.PUT)
		.body(body);
		TokpedResponse<byte[]> response = execute(byte[].class, request);
		MitraResponse<DeliveryStatus> result = MitraResponse.parse(DeliveryStatus.class, response.data);
		return result;
	}

}
