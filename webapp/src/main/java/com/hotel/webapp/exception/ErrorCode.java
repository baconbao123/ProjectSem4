package com.hotel.webapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
  UNCATEGORIZED_EXCEPTION(9999, "Unauthorized exception", HttpStatus.INTERNAL_SERVER_ERROR),
  KEY_INVALID(9998, "Invalid key", HttpStatus.BAD_REQUEST),
  //  Exists - Bad Request
  ACTION_EXISTED(400, "Action already exists", HttpStatus.BAD_REQUEST),
  RESOURCE_EXISTED(400, "Resource already exists", HttpStatus.BAD_REQUEST),
  //  Invalid - 401
  UNAUTHENTICATED(401, "Unauthenticated", HttpStatus.UNAUTHORIZED),
  AUTHENTICATION_FAILED(401, "Invalid email or password", HttpStatus.UNAUTHORIZED),
  ACCESS_DENIED(403, "Access Denied", HttpStatus.FORBIDDEN),
  //  Not Found - 404
  ACTION_NOTFOUND(404, "Action Not Found", HttpStatus.NOT_FOUND),
  USER_NOTFOUND(404, "User Not Found", HttpStatus.NOT_FOUND),
  ROLE_NOTFOUND(404, "Role Not Found", HttpStatus.NOT_FOUND),
  RESOURCE_NOTFOUND(404, "Resource Not Found", HttpStatus.NOT_FOUND);
  int code;
  String message;
  HttpStatusCode statusCode;
}
