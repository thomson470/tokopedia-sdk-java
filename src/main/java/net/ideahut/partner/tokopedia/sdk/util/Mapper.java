package net.ideahut.partner.tokopedia.sdk.util;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public final class Mapper {
	
	private static final ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
	
	private Mapper() {}
	
	/*
	 * CREATE NODE
	 */
	public static ObjectNode createObjectNode() {
		return mapper.createObjectNode();
	}
	public static ArrayNode createArrayNode() {
		return mapper.createArrayNode();
	}
	
	
	/*
	 * WRITE VALUE
	 */
	public static byte[] writeValueAsBytes(Object value, boolean pretty) {
		try {
			if (pretty) {
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(value);
			} else {
				return mapper.writeValueAsBytes(value);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static byte[] writeValueAsBytes(Object value) {
		return writeValueAsBytes(value, false);
	}
	public static String writeValueAsString(Object value, boolean pretty) {
		try {
			if (pretty) {
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
			} else {
				return mapper.writeValueAsString(value);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static String writeValueAsString(Object value) {
		return writeValueAsString(value, false);
	}
	
	
	/*
	 * READ VALUE
	 */
	public static <T> T readValue(Class<T> type, byte[] value) {
		if (value == null) {
			return null;
		}
		try {
			return mapper.readValue(value, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static <T> T readValue(TypeReference<T> typeRef, byte[] value) {
		if (value == null) {
			return null;
		}
		try {
			return mapper.readValue(value, typeRef);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static <T> T readValue(Class<T> type, String value) {
		if (value == null) {
			return null;
		}
		try {
			return mapper.readValue(value, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static <T> T readValue(TypeReference<T> typeRef, String value) {
		if (value == null) {
			return null;
		}
		try {
			return mapper.readValue(value, typeRef);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/*
	 * COPY
	 */
	public static <T> T copy(Class<T> type, Object value) {
		if (value == null) {
			return null;
		}
		try {
			byte[] bytes = mapper.writeValueAsBytes(value);
			return mapper.readValue(bytes, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	public static <T> T copy(TypeReference<T> typeRef, Object value) {
		if (value == null) {
			return null;
		}
		try {
			byte[] bytes = mapper.writeValueAsBytes(value);
			return mapper.readValue(bytes, typeRef);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T copy(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof Collection) {
			TypeReference<Collection> typeRef = new TypeReference<Collection>() {};
			return (T) copy(typeRef, value);
		} 
		else if (value.getClass().isArray()) {
			TypeReference<Object[]> typeRef = new TypeReference<Object[]>() {};
			return (T) copy(typeRef, value);
		} else {
			return (T) copy(value.getClass(), value);
		}
	}
	
	
	
	/*
	 * CONVERT
	 */
	public static <T> T convert(Class<T> type, Object value) {
		return mapper.convertValue(value, type);
	}	
	public static <T> T convert(TypeReference<T> typeRef, Object value) {
		return mapper.convertValue(value, typeRef);
	}

}
