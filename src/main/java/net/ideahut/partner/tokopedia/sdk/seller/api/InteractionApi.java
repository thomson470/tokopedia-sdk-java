package net.ideahut.partner.tokopedia.sdk.seller.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import net.ideahut.partner.tokopedia.sdk.Tokopedia;
import net.ideahut.partner.tokopedia.sdk.object.TokpedInquiry;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.seller.object.InitiateChat;
import net.ideahut.partner.tokopedia.sdk.seller.object.Message;
import net.ideahut.partner.tokopedia.sdk.seller.object.Reply;
import net.ideahut.partner.tokopedia.sdk.seller.object.ReplyInput;
import net.ideahut.partner.tokopedia.sdk.seller.object.ReplyResult;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.RequestBody;

public class InteractionApi extends Tokopedia.Api {
	
	private static final String[] FILTERS = {"all", "read", "unread"};

	protected InteractionApi(Tokopedia tokopedia) {
		super(tokopedia);
	}
	
	public TokpedResponse<List<Message>> getListMessage(TokpedInquiry inquiry, Integer filter) {
		Assert.notNull(inquiry, "inquiry required");
		Assert.notNull(inquiry.shop_id, "shop_id required");
		Integer page = inquiry.page;
		if (page == null) {
			page = 1;
		}
		Integer per_page = inquiry.per_page;
		if (per_page == null) {
			per_page = 10;
		}
		String query = "shop_id=" + inquiry.shop_id + "&page=" + page + "&per_page=" + per_page;
		if (filter != null && filter >= 0 && filter < FILTERS.length) {
			query += "&filter=" + FILTERS[filter];
		}
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/chat/fs/" + fs_id + "/messages?" + query);		
		return execute(new TypeReference<List<Message>>() {}, request);
	}
	
	public TokpedResponse<List<Reply>> getListReply(TokpedInquiry inquiry, Long msg_id) {
		Assert.notNull(inquiry, "inquiry required");
		Assert.notNull(inquiry.shop_id, "shop_id required");
		Assert.notNull(msg_id, "msg_id required");
		Integer page = inquiry.page;
		if (page == null) {
			page = 1;
		}
		Integer per_page = inquiry.per_page;
		if (per_page == null) {
			per_page = 10;
		}
		String query = "shop_id=" + inquiry.shop_id + "&page=" + page + "&per_page=" + per_page;
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/chat/fs/" + fs_id + "/messages/" + msg_id + "/replies?" + query);		
		return execute(new TypeReference<List<Reply>>() {}, request);
	}
	
	public TokpedResponse<InitiateChat> initiateChat(Long order_id) {
		Assert.notNull(order_id, "order_id required");
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/chat/fs/" + fs_id + "/initiate?order_id=" + order_id);		
		return execute(InitiateChat.class, request);
	}
	
	public TokpedResponse<ReplyResult> sendReply(Long msg_id, ReplyInput replyInput) {
		Assert.notNull(msg_id, "msg_id required");
		Assert.notNull(replyInput, "replyInput required");
		Assert.notNull(replyInput.shop_id, "shop_id required");
		byte[] json = Mapper.writeValueAsBytes(replyInput);
		RequestBody body = RequestBody.create(json, JSON);
		TokpedRequest request = TokpedRequest.create()
		.path("/v1/chat/fs/" + fs_id + "/messages/" + msg_id + "/reply")
		.method(TokpedRequest.Method.POST)
		.body(body);		
		return execute(ReplyResult.class, request);
	}

}
