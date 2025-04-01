package com.hotel.webapp.dto.admin.Request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActionResourceUpdate {
  int id;
  String name;
}
