package com.hotel.webapp.util;

public interface MapperUtil {
  default String trimOrToKeep(String oldValue, String newValue) {
    return newValue != null && !newValue.isEmpty() ? newValue.trim() : oldValue;
  }

  default String trimValue(String value) {
    return value != null && !value.isEmpty() ? value.trim() : null;
  }
}
