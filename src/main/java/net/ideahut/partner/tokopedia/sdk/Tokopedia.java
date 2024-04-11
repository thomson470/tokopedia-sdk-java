package net.ideahut.partner.tokopedia.sdk;

import java.math.BigDecimal;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

import net.ideahut.partner.tokopedia.sdk.mitra.api.MitraApi;
import net.ideahut.partner.tokopedia.sdk.object.TokpedRequest;
import net.ideahut.partner.tokopedia.sdk.object.TokpedResponse;
import net.ideahut.partner.tokopedia.sdk.object.TokpedToken;
import net.ideahut.partner.tokopedia.sdk.object.TokpedWhitelistIP;
import net.ideahut.partner.tokopedia.sdk.seller.api.SellerApi;
import net.ideahut.partner.tokopedia.sdk.util.Assert;
import net.ideahut.partner.tokopedia.sdk.util.Mapper;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/*
 * https://json2csharp.com/code-converters/json-to-pojo
 */

public class Tokopedia {
	
	public static final class Builder {
		private Proxy proxy;
		private String accountUrl;
		private String baseUrl;
		private String token;
		private Long fs_id;
		private Integer connectTimeout;
		private Integer callTimeout;		
		public Builder proxy(Proxy proxy) {
			this.proxy = proxy;
			return this;
		}		
		public Builder accountUrl(String accountUrl) {
			this.accountUrl = accountUrl;
			return this;
		}		
		public Builder baseUrl(String baseUrl) {
			this.baseUrl = baseUrl;
			return this;
		}		
		public Builder token(String token) {
			this.token = token;
			return this;
		}		
		public Builder fs_id(Long fs_id) {
			this.fs_id = fs_id;
			return this;
		}		
		public Builder connectTimeout(Integer connectTimeout) {
			this.connectTimeout = connectTimeout;
			return this;
		}		
		public Builder callTimeout(Integer callTimeout) {
			this.callTimeout = callTimeout;
			return this;
		}		
		public Tokopedia build() {
	      return new Tokopedia(this);
	    }
	}
	
	public static abstract class Api {
		private final Tokopedia tokopedia;
		protected final MediaType JSON;		
		protected final Long fs_id;
		protected Api(Tokopedia tokopedia) {
			this.tokopedia = tokopedia;
			this.fs_id = tokopedia.builder.fs_id;
			this.JSON = MediaType.parse("application/json");
		}
		private Request prepare(TokpedRequest tokpedRequest) {
			TokpedRequest.Method method = tokpedRequest.getMethod();
			if (method == null) {
				method = TokpedRequest.Method.GET;
			}
			RequestBody body = null;
			if (method.isBodyMandatory()) {
				body = tokpedRequest.getBody();
				if (body == null) {
					body = RequestBody.create(new byte[0]);
				}
			}
			Builder tpBuilder = tokopedia.builder;
			String baseUrl = tpBuilder.baseUrl != null ? tpBuilder.baseUrl : "https://fs.tokopedia.net";			
			Request.Builder reqBuilder = new Request.Builder()
			.url(baseUrl + tokpedRequest.getPath())
			.method(method.name(), body);
			Map<String, String> headers = tokpedRequest.getHeaders();
			if (headers != null) {
				for (String name : headers.keySet() ) {
					reqBuilder.header(name, headers.get(name));
				}
			}
			reqBuilder.header("Authorization", "Bearer " + tpBuilder.token);
			Request request = reqBuilder.build();
			return request;
		}
		
		@SuppressWarnings("unchecked")
		protected <T> TokpedResponse<T> execute(TypeReference<T> typeRef, TokpedRequest tokpedRequest) {
			Response response = null;
			try {
				Request request = prepare(tokpedRequest);
				Call call = tokopedia.client.newCall(request);
			    response = call.execute();
			    TokpedResponse.RateLimit rate_limit = new TokpedResponse.RateLimit();
			    rate_limit.full_reset_after = new BigDecimal(response.header("X-Ratelimit-Full-Reset-After", "0"));
			    rate_limit.limit = response.header("X-Ratelimit-Limit", "");		
			    rate_limit.remaining = Integer.valueOf(response.header("X-Ratelimit-Remaining", "0"));		
			    rate_limit.reset_after = new BigDecimal(response.header("X-Ratelimit-Reset-After", "0"));			    
			    TokpedResponse<T> tokpedResponse = new TokpedResponse<T>();
			    tokpedResponse.rate_limit = rate_limit;
			    
			    byte[] body = response.body().bytes();
			    
			    if (response.code() != 200) {
			    	try {
			    		JsonNode node = Mapper.readValue(JsonNode.class, body);
			    		tokpedResponse.header = Mapper.convert(TokpedResponse.Header.class, node.get("header"));
			    	} catch (Exception e) {
			    		tokpedResponse.header = new TokpedResponse.Header("9999", "Http-" + response.code());
			    	}
			    	return tokpedResponse;
			    }			    
			    if (byte[].class.equals(typeRef.getType())) {
			    	tokpedResponse.data = (T) body;
			    } else {
			    	JsonNode node = Mapper.readValue(JsonNode.class, body);
				    if (node.has("header")) {
				    	tokpedResponse.header = Mapper.convert(TokpedResponse.Header.class, node.get("header"));
				    }
				    if (node.has("data")) {
				    	tokpedResponse.data = Mapper.convert(typeRef, node.get("data"));
				    }
			    }			    
			    return tokpedResponse;
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (response != null) {
					response.close();
				}
			}
		}
		
		@SuppressWarnings("unchecked")
		protected <T> TokpedResponse<T> execute(Class<T> type, TokpedRequest tokpedRequest) {
			Response response = null;
			try {
				Request request = prepare(tokpedRequest);
				Call call = tokopedia.client.newCall(request);
			    response = call.execute();
			    TokpedResponse.RateLimit rate_limit = new TokpedResponse.RateLimit();
			    rate_limit.full_reset_after = new BigDecimal(response.header("X-Ratelimit-Full-Reset-After", "0"));
			    rate_limit.limit = response.header("X-Ratelimit-Limit", "");		
			    rate_limit.remaining = Integer.valueOf(response.header("X-Ratelimit-Remaining", "0"));		
			    rate_limit.reset_after = new BigDecimal(response.header("X-Ratelimit-Reset-After", "0"));			    
			    TokpedResponse<T> tokpedResponse = new TokpedResponse<T>();
			    tokpedResponse.rate_limit = rate_limit;
			    
			    byte[] body = response.body().bytes();
			    
			    if (response.code() != 200) {
			    	try {
			    		JsonNode node = Mapper.readValue(JsonNode.class, body);
			    		tokpedResponse.header = Mapper.convert(TokpedResponse.Header.class, node.get("header"));
			    	} catch (Exception e) {
			    		tokpedResponse.header = new TokpedResponse.Header("9999", "Http-" + response.code());
			    	}
			    	return tokpedResponse;
			    }
			    if (byte[].class.equals(type)) {
			    	tokpedResponse.data = (T) body;
			    } else {
			    	JsonNode node = Mapper.readValue(JsonNode.class, body);
				    if (node.has("header")) {
				    	tokpedResponse.header = Mapper.convert(TokpedResponse.Header.class, node.get("header"));
				    }
				    if (node.has("data")) {
				    	tokpedResponse.data = Mapper.convert(type, node.get("data"));
				    }
			    }
			    return tokpedResponse;
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (response != null) {
					response.close();
				}
			}
		}
	}
	
	private final Builder builder;
	private final OkHttpClient client;	
	
	public Tokopedia() {
		this(new Builder());
	}
	
	Tokopedia(Builder builder) {
		this.builder = builder;
		OkHttpClient.Builder okBuilder = new OkHttpClient().newBuilder();
		if (builder.proxy != null) {
			okBuilder.proxy(builder.proxy);
		}
		if (builder.connectTimeout != null && builder.connectTimeout > 0) {
			okBuilder.connectTimeout(builder.connectTimeout, TimeUnit.SECONDS);
		} else {
			okBuilder.connectTimeout(5, TimeUnit.SECONDS);
		}
		if (builder.callTimeout != null && builder.callTimeout > 0) {
			okBuilder.callTimeout(builder.callTimeout, TimeUnit.SECONDS);
		} else {
			okBuilder.callTimeout(5, TimeUnit.SECONDS);
		}
		this.client = okBuilder.build();
	}
	
	public static Builder newBuilder() {
		return new Builder();
	}
	
	
	public TokpedToken getToken(String clientId, String clientSecret) {
		String url = builder.accountUrl != null ? builder.accountUrl : "https://accounts.tokopedia.com/token?grant_type=client_credentials";
		String authorization = "Basic " + Base64.encodeBase64String((clientId + ":" + clientSecret).getBytes());
		Request request = new Request.Builder()
		.url(url)
		.post(RequestBody.create(new byte[0]))
		.header("Authorization", authorization)
		.build();
		Response response = null;
		try {
			Call call = client.newCall(request);
		    response = call.execute();
		    if (response.code() != 200) {
		    	throw new Exception("HTTP-" + response.code());
		    }
		    byte[] body = response.body().bytes();
		    return Mapper.readValue(TokpedToken.class, body);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}
	
	public void updateToken(String token) {
		builder.token = token;
	}
	
	public TokpedResponse<TokpedWhitelistIP> getWhitelistIP() {
		Assert.notNull(builder.fs_id, "fs_id required");
		Assert.hasLength(builder.token, "token required");		
		String url = (builder.baseUrl != null ? builder.baseUrl : "https://fs.tokopedia.net") + "/v1/fs/" + builder.fs_id + "/whitelist";
		String authorization = "Bearer " + builder.token;
		Request request = new Request.Builder()
		.url(url)
		.get()
		.header("Authorization", authorization)
		.build();
		Response response = null;
		try {
			Call call = client.newCall(request);
		    response = call.execute();
		    if (response.code() != 200) {
		    	throw new Exception("HTTP-" + response.code());
		    }
		    byte[] body = response.body().bytes();
		    return Mapper.readValue(new TypeReference<TokpedResponse<TokpedWhitelistIP>>() {}, body);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}
	
	
	private SellerApi sellerApi;	
	public SellerApi getSellerApi() {
		if (sellerApi == null) {
			sellerApi = new SellerApi(this);
		}
		return sellerApi;
	}
	
	private MitraApi mitraApi;	
	public MitraApi getMitraApi() {
		if (mitraApi == null) {
			mitraApi = new MitraApi(this);
		}
		return mitraApi;
	}
	
}
