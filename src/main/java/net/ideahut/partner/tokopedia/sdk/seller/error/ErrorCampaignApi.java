package net.ideahut.partner.tokopedia.sdk.seller.error;

public class ErrorCampaignApi {
	
	public static enum ViewSlashPrice {
		PRD_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		PRD_GRPC_002 	("There Are Error From Ext Service", "Failed getting response from upstream"),
		SHP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SHP_GRPC_003 	("Data Not Found", "Failed finding data from upstream"),
		SPE_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "FS ID is not associated, please kindly check"),
		SPE_USC_002 	("Product ID does not belong to Shop ID or Warehouse ID", "Product ID is not associated, please kindly check"),
		SPE_USC_003 	("Warehouse ID Information Not Found", "Warehouse information not found, please kindly check"),
		SPE_USC_004 	("Cannot View Slash Price Information Parent Product Variant", ""),
		SPE_DLV_001 	("fs_id cannot be empty", "FS ID is empty"),
		SPE_DLV_005 	("Invalid field %s format, value %v should be %s", "Invalid field format, please kindly check"),
		SPE_DLV_006 	("Invalid request body, please check again", "Invalid reequest body, please kindly check"),
		SPE_DLV_007 	("Value of field %s exceed limit %s=%d", "Invalid field value, please kindly check"),
		SPE_DLV_008 	("Value %s of field %s is not allowed, the allowed fields are %s", "Invalid field value, please kindly check"),
		SPE_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		SPE_GRPC_003 	("Data Not Found", "Data not found"),
		SPE_GRPC_004 	("Failed Marshalling JSON", "Failed processing request to upstream"),
		SPE_GRPC_005 	("Failed Unmarshal JSON", "Failed prorcessing response from upstream"),
		;
		private final String message;
		private final String description;
		private ViewSlashPrice(String message, String description) {
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
	
	public static enum ViewCampaignProducts {
		PRD_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		PRD_GRPC_002 	("There Are Error From Ext Service", "Failed getting response from upstream"),
		CMP_GRPC_001 	("Failed Send GRPC Request", "Failed sending request to upstream"),
		CMP_GRPC_003 	("Data Not Found", "Data not found from upstream"),
		CMP_GRPC_004 	("Failed Marshalling JSON", "Failed processing request to upstream"),
		CMP_GRPC_005 	("Failed Unmarshal JSON", "Failed prorcessing response from upstream"),
		CMP_USC_001 	("fs_id Is Not Associated With Shop ID or Warehouse ID", "FS ID is not associated"),
		CMP_USC_002 	("Some Product ID Is Not Own By Current Shop ID", "Some Product ID is not owned by current Shop ID"),
		CMP_USC_003 	("Invalid Product ID Format", "Invalid Product ID format, please kindly check"),
		CMP_DLV_001 	("Invalid field %s format, value %v should be %s", "There is invalid request format"),
		CMP_DLV_002 	("Product IDs must be numeric and comma separated", "Invalid Product IDs format, please kindly check"),
		CMP_DLV_003 	("Value of field %s exceed limit %s=%d", "There is invalid request format"),
		CMP_DLV_004 	("product_id cannot be empty", "Product ID is empty, please kindly check"),		
		;
		private final String message;
		private final String description;
		private ViewCampaignProducts(String message, String description) {
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
