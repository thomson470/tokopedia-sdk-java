package net.ideahut.partner.tokopedia.sdk.seller.error;

public class ErrorBundleApi {

	public static enum CreateBundle {
		PRD_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		PRD_GRPC_002 	("There Are Error From Ext Service", "Failed getting response from upstream"),
		PRD_USC_029 	("Warehouse ID Information Not Found", "Failed to get warehouse information"),
		BDL_USC_001 	("FS ID is not associated with Shop ID or Warehouse ID", "fs_id is not associated, please check again"),
		BDL_USC_002 	("Shop Info not found", "Shop information cannot be found"),
		BDL_USC_003 	("Too many or too few bundle items given for this type of bundle", "The number of bundle item is not right for this type of bundle"),
		BDL_USC_004 	("2 or more same products in bundle", "Multiple bundle must consist of minimum two different products"),
		BDL_USC_005 	("Different products in single bundle", "Single bundle only accept same products"),
		BDL_USC_006 	("Please use different min order for each bundleitem", "Please use different min order"),
		BDL_USC_007 	("Min Order of single type bundle must be greater than 1", "Please set the minimum order more than 1"),
		BDL_USC_009 	("Bundle item price must be lower than its original price", "Please set the bundle item price lower than the original price"),
		BDL_USC_010 	("Bundle item stock cannot be empty", "Please add the bundle item stock"),
		BDL_USC_012 	("One of the product variant is invalid", "There is invalid product variant on the bundle"),
		BDL_DLV_001 	("Invalid request body, please check again", "Invalid request body, please check again"),
		BDL_DLV_002 	("Invalid field %s format, value %v should be %s", "Invalid params, please check again"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private CreateBundle(String message, String description) {
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
	
	public static enum CancelBundle {
		PRD_USC_029 	("Warehouse ID Information Not Found", "Failed to get warehouse information"),
		BDL_USC_001 	("FS ID is not associated with Shop ID or Warehouse ID", "fs_id is not associated, please check again"),
		BDL_USC_002 	("Shop Info not found", "Shop information cannot be found"),
		BDL_DLV_001 	("Invalid request body, please check again", "Invalid request body, please check again"),
		BDL_DLV_002 	("Invalid field %s format, value %v should be %s", "Invalid params, please check again"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private CancelBundle(String message, String description) {
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
	
	public static enum GetBundleInfo {
		PRD_USC_029 	("Warehouse ID Information Not Found", "Failed to get warehouse information"),
		BDL_USC_001 	("FS ID is not associated with Shop ID or Warehouse ID", "fs_id is not associated, please check again"),
		BDL_USC_002 	("Shop Info not found", "Shop information cannot be found"),
		BDL_DLV_001 	("Invalid request body, please check again", "Invalid request body, please check again"),
		PRD_DLV_001 	("fs_id cannot be empty", "fs_id field is empty, please check again"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private GetBundleInfo(String message, String description) {
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
	
	public static enum GetBundleList {
		PRD_USC_029 	("Warehouse ID Information Not Found", "Failed to get warehouse information"),
		BDL_USC_001 	("FS ID is not associated with Shop ID or Warehouse ID", "fs_id is not associated, please check again"),
		BDL_USC_002 	("Shop Info not found", "Shop information cannot be found"),
		BDL_DLV_001 	("Invalid request body, please check again", "Invalid request body, please check again"),
		BDL_DLV_013 	("Filter type must be 1 or 2 and cannot be empty", "Invalid filter value, please check again"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		;
		private final String message;
		private final String description;
		private GetBundleList(String message, String description) {
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
