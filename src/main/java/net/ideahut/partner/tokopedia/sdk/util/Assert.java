package net.ideahut.partner.tokopedia.sdk.util;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

public final class Assert {

	private Assert() {}
	
	public static void state(boolean expression, String message) {
		if (!expression) {
			throw new IllegalStateException(message);
		}
	}

	public static void state(boolean expression, Supplier<String> messageSupplier) {
		if (!expression) {
			throw new IllegalStateException(nullSafeGet(messageSupplier));
		}
	}

	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void isTrue(boolean expression, Supplier<String> messageSupplier) {
		if (!expression) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}

	public static void isNull(@Nullable Object object, String message) {
		if (object != null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void isNull(@Nullable Object object, Supplier<String> messageSupplier) {
		if (object != null) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}

	public static void notNull(@Nullable Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void notNull(@Nullable Object object, Supplier<String> messageSupplier) {
		if (object == null) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}

	public static void hasLength(@Nullable String text, String message) {
		if (!stringHasLength(text)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void hasLength(@Nullable String text, Supplier<String> messageSupplier) {
		if (!stringHasLength(text)) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}
	
	public static void hasText(@Nullable String text, String message) {
		if (!stringHasText(text)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void hasText(@Nullable String text, Supplier<String> messageSupplier) {
		if (!stringHasText(text)) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}
	
	public static void doesNotContain(@Nullable String textToSearch, String substring, String message) {
		if (stringHasLength(textToSearch) && stringHasLength(substring) && textToSearch.contains(substring)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void doesNotContain(@Nullable String textToSearch, String substring, Supplier<String> messageSupplier) {
		if (stringHasLength(textToSearch) && stringHasLength(substring) && textToSearch.contains(substring)) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}
	
	public static void notEmpty(@Nullable Object[] array, String message) {
		if (isObjectEmpty(array)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notEmpty(@Nullable Object[] array, Supplier<String> messageSupplier) {
		if (isObjectEmpty(array)) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}

	public static void noNullElements(@Nullable Object[] array, String message) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}

	public static void noNullElements(@Nullable Object[] array, Supplier<String> messageSupplier) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new IllegalArgumentException(nullSafeGet(messageSupplier));
				}
			}
		}
	}

	public static void notEmpty(@Nullable Collection<?> collection, String message) {
		if (isCollectionEmpty(collection)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void notEmpty(@Nullable Collection<?> collection, Supplier<String> messageSupplier) {
		if (isCollectionEmpty(collection)) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}

	public static void noNullElements(@Nullable Collection<?> collection, String message) {
		if (collection != null) {
			for (Object element : collection) {
				if (element == null) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}

	public static void noNullElements(@Nullable Collection<?> collection, Supplier<String> messageSupplier) {
		if (collection != null) {
			for (Object element : collection) {
				if (element == null) {
					throw new IllegalArgumentException(nullSafeGet(messageSupplier));
				}
			}
		}
	}

	public static void notEmpty(@Nullable Map<?, ?> map, String message) {
		if (isCollectionEmpty(map)) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void notEmpty(@Nullable Map<?, ?> map, Supplier<String> messageSupplier) {
		if (isCollectionEmpty(map)) {
			throw new IllegalArgumentException(nullSafeGet(messageSupplier));
		}
	}

	public static void isInstanceOf(Class<?> type, @Nullable Object obj, String message) {
		notNull(type, "Type to check against must not be null");
		if (!type.isInstance(obj)) {
			instanceCheckFailed(type, obj, message);
		}
	}
	
	public static void isInstanceOf(Class<?> type, @Nullable Object obj, Supplier<String> messageSupplier) {
		notNull(type, "Type to check against must not be null");
		if (!type.isInstance(obj)) {
			instanceCheckFailed(type, obj, nullSafeGet(messageSupplier));
		}
	}
	
	public static void isInstanceOf(Class<?> type, @Nullable Object obj) {
		isInstanceOf(type, obj, "");
	}
	
	public static void isAssignable(Class<?> superType, @Nullable Class<?> subType, String message) {
		notNull(superType, "Super type to check against must not be null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			assignableCheckFailed(superType, subType, message);
		}
	}
	
	public static void isAssignable(Class<?> superType, @Nullable Class<?> subType, Supplier<String> messageSupplier) {
		notNull(superType, "Super type to check against must not be null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			assignableCheckFailed(superType, subType, nullSafeGet(messageSupplier));
		}
	}
	
	public static void isAssignable(Class<?> superType, Class<?> subType) {
		isAssignable(superType, subType, "");
	}


	private static void instanceCheckFailed(Class<?> type, @Nullable Object obj, @Nullable String msg) {
		String className = (obj != null ? obj.getClass().getName() : "null");
		String result = "";
		boolean defaultMessage = true;
		if (stringHasLength(msg)) {
			if (endsWithSeparator(msg)) {
				result = msg + " ";
			}
			else {
				result = messageWithTypeName(msg, className);
				defaultMessage = false;
			}
		}
		if (defaultMessage) {
			result = result + ("Object of class [" + className + "] must be an instance of " + type);
		}
		throw new IllegalArgumentException(result);
	}

	private static void assignableCheckFailed(Class<?> superType, @Nullable Class<?> subType, @Nullable String msg) {
		String result = "";
		boolean defaultMessage = true;
		if (stringHasLength(msg)) {
			if (endsWithSeparator(msg)) {
				result = msg + " ";
			}
			else {
				result = messageWithTypeName(msg, subType);
				defaultMessage = false;
			}
		}
		if (defaultMessage) {
			result = result + (subType + " is not assignable to " + superType);
		}
		throw new IllegalArgumentException(result);
	}

	private static boolean endsWithSeparator(String msg) {
		return (msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith("."));
	}

	private static String messageWithTypeName(String msg, @Nullable Object typeName) {
		return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
	}

	@Nullable
	private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
		return (messageSupplier != null ? messageSupplier.get() : null);
	}
	
	private static boolean stringHasLength(String str) {
		return (str != null && !str.isEmpty());
	}
	
	public static boolean stringHasText(@Nullable String str) {
		return (str != null && !str.isEmpty() && containsText(str));
	}

	private static boolean containsText(CharSequence str) {
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isObjectEmpty(@Nullable Object[] array) {
		return (array == null || array.length == 0);
	}
	
	private static boolean isCollectionEmpty(@Nullable Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}
	
	private static boolean isCollectionEmpty(@Nullable Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}
	
	
}
