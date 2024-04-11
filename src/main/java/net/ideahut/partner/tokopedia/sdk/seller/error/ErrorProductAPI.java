package net.ideahut.partner.tokopedia.sdk.seller.error;

public final class ErrorProductAPI {
	
	public static enum GetProduct {
		PRD_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		PRD_GRPC_002 	("There Are Error From Ext Service", "Failed getting response from upstream"),
		PRD_USC_024 	("Error Convert number format into string", "Failed getting response from upstream"),
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
	
	public static enum GetProductVariant {		
		VRT_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "fs_id not assosiated, please check again"),
		VRT_USC_002 	("Category ID Not Found", "Category ID not found, please check again"),
		VRT_DLV_001 	("fs_id cannot be empty", "There is invalid request params"),
		VRT_DLV_002 	("invalid fs_id format", "There is invalid request params"),
		VRT_DLV_005 	("invalid product_id format", "There is invalid request params"),
		VRT_DLV_004 	("Invalid cat_id formatt", "There is invalid request params"),
		;
		private final String message;
		private final String description;
		private GetProductVariant(String message, String description) {
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
	
	public static enum CreateProducts {		
		PRD_API_003 	("Failed To Fetching Request", "Failed fetching request from upstream"),
		PRD_API_006 	("There Are Error From Ext Service", "There is error from external service"),
		PRD_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "fs_id not assosiated please check again"),
		PRD_DLV_038 	("Value %s of field %s is not allowed, the allowed fields are %s", "There is something wrong with the request body"),
		PRD_DLV_042 	("Invalid field %s format, value %v should be %s", "There is something wrong with the request body"),
		PRD_DLV_043 	("Invalid request body, please check again", "There is something wrong with the request body"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private CreateProducts(String message, String description) {
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
	
	public static enum EditProduct {		
		PRD_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		PRD_GRPC_002 	("There Are Error From Ext Service", "Failed getting response from upstream"),
		PRD_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "fs_id not assosiated, please check again"),
		PRD_USC_028 	("Product Status Not In Active or Warehouse. Edit Process Canceled", "Unable to edit product because the status is not active or warehouse"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private EditProduct(String message, String description) {
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
	
	public static enum CheckUploadStatus {		
		PRD_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "fs_id not assosiated, please check again"),
		PRD_USC_025 	("Shop ID is not associated with upload id", "Shop ID not assosiated, please check again"),
		PRD_CACHE_005 	("Data Not Found", "Error on processing data"),
		PRD_CACHE_006 	("Failed to retrieve cache data", "Error on processing data"),
		PRD_CACHE_007 	("Failed Unrmashall cache response", "Error on processing data"),
		PRD_DLV_045 	("Field %s should not be empty, please fill the empty field", "Please check the request params again"),
		;
		private final String message;
		private final String description;
		private CheckUploadStatus(String message, String description) {
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
	
	public static enum SetActiveProduct {		
		PRD_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		PRD_GRPC_002 	("There Are Error From Ext Service", "Failed getting response from upstream"),
		PRD_API_001 	("Failed To Initialize Request", "Failed initialize request to upstream"),
		PRD_API_003 	("Failed To Fetching Request", "Failed fetching request from upstream"),
		PRD_API_004 	("Failed To Reading Response Body", "Error on processing data"),
		PRD_API_005 	("Failed To Parsing Json Response", "Error on processing data"),
		PRD_API_007 	("Failed Marshalling JSON", "Error on processing data"),
		PRD_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "fs_id not assosiated please check again"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private SetActiveProduct(String message, String description) {
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
	
	public static enum SetInactiveProduct {		
		PRD_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		PRD_GRPC_002 	("There Are Error From Ext Service", "Failed getting response from upstream"),
		PRD_API_001 	("Failed To Initialize Request", "Failed initialize request to upstream"),
		PRD_API_003 	("Failed To Fetching Request", "Failed fetching request from upstream"),
		PRD_API_004 	("Failed To Reading Response Body", "Error on processing data"),
		PRD_API_005 	("Failed To Parsing Json Response", "Error on processing data"),
		PRD_API_007 	("Failed Marshalling JSON", "Error on processing data"),
		PRD_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "fs_id not assosiated please check again"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private SetInactiveProduct(String message, String description) {
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
	
	public static enum UpdatePriceOnly {		
		PRD_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		PRD_GRPC_002 	("There Are Error From Ext Service", "Failed getting response from upstream"),
		PRD_API_007 	("Failed Marshalling JSON", "Error on processing data"),
		PRD_DB_001 		("Failed To Query DB Data", "Failed getting data from database"),
		PRD_DB_002 		("Failed To Scan DB Data", "Failed getting data from database"),
		PRD_DB_003 		("Data Not Found", "Failed getting data from database"),
		PRD_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "fs_id not assosiated, please check again"),
		PRD_USC_008 	("Mandatory To Fill Warehouse ID", "warehouse_id is empty, please check again"),
		PRD_DLV_001 	("fs_id cannot be empty", "fs_id field is empty, please check again"),
		PRD_DLV_002 	("invalid fs_id format", "fs_id is in the wrong format, please check again"),
		PRD_DLV_003 	("invalid shop_id format", "shop_id is in the wrong format, please check again"),
		PRD_DLV_015 	("failed read body request", "Failed reading the body request"),
		PRD_DLV_016 	("shop_id cannot be empty", "shop_id field is empty, please check agai"),
		PRD_DLV_018 	("Max allowed products per-update are %d products", "The request has exceed the max allowed product price edit per request"),
		PRD_DLV_019 	("invalid warehouse_id format", "warehouse_id is in the wrong format, please check again"),
		PRD_DLV_055 	("warehouse_id is not eligible to perform this operation", "warehouse_id is not eligible, please check again"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private UpdatePriceOnly(String message, String description) {
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
