package net.ideahut.partner.tokopedia.sdk.object;

import java.math.BigDecimal;

public class TokpedResponse<T> {
	
	public static class Header {
		public BigDecimal process_time;
		public String messages;		
		public String reason;		
		public String error_code;		
		
		public Header() {
			this(null, null);
		}		
		public Header(String error_code, String reason) {
			this.error_code = error_code;
			this.reason = reason;
		}		
	}
	
	public static class RateLimit {
		public BigDecimal full_reset_after;		
		public String limit;		
		public Integer remaining;		
		public BigDecimal reset_after;		
	}
	
	public Header header;
	public RateLimit rate_limit;
	public T data;
	
}
