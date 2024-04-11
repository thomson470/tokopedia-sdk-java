package net.ideahut.partner.tokopedia.sdk.mitra.error;

public final class ErrorMitraProductAPI {
	
	public static enum GetProduct {
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private GetProduct(String message, String description) {
			this.message = message;
			this.description = description;
		}
		public String getMessage() {
			return message;
		}
		public String getDescription() {
			return description;
		}
	}
	
}
