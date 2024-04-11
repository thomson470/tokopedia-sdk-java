package net.ideahut.partner.tokopedia.sdk.object;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import okhttp3.RequestBody;

@Getter
public class TokpedRequest {
	
	public enum Method {
		GET 	(false),
		POST	(true),
		PUT		(true),
		PATCH	(true),
		DELETE	(false),
		;
		private final boolean bodyMandatory;
		Method(boolean bodyMandatory) {
			this.bodyMandatory = bodyMandatory;
		}
		public boolean isBodyMandatory() {
			return bodyMandatory;
		}		
	}

	private String path;
	private Method method;
	private Map<String, String> headers;
	private RequestBody body;
	
	private TokpedRequest() {}
	
	public TokpedRequest path(String path) {
		this.path = path;
		return this;
	}
	
	public TokpedRequest method(Method method) {
		this.method = method;
		return this;
	}
	
	public TokpedRequest header(String name, String value) {
		if (this.headers == null) {
			this.headers = new HashMap<String, String>();
		}
		this.headers.put(name, value);
		return this;
	}
	
	public TokpedRequest body(RequestBody body) {
		this.body = body;
		return this;
	}
	
	public static TokpedRequest create() {
		return new TokpedRequest();
	}
	
}
