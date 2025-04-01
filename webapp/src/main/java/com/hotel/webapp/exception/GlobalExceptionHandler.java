package com.hotel.webapp.exception;

import com.hotel.webapp.dto.admin.Response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  ResponseEntity<ApiResponse> runtimeExceptionHandler(Exception e) {
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
    apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
    return ResponseEntity.status(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode()).body(apiResponse);
  }

  @ExceptionHandler(value = AppException.class)
  ResponseEntity<ApiResponse> appExceptionHandler(AppException e) {
    ErrorCode errorCode = e.getErrorCode();
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setCode(errorCode.getCode());
    apiResponse.setMessage(errorCode.getMessage());
    return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  ResponseEntity<ApiResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
    String enumKey = e.getFieldError().getDefaultMessage();
    ErrorCode errorCode = ErrorCode.KEY_INVALID;

    try {
      errorCode = ErrorCode.valueOf(enumKey);
    } catch (IllegalArgumentException exception) {
    }

    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setCode(errorCode.getCode());
    apiResponse.setMessage(errorCode.getMessage());
    return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
  }

  @ExceptionHandler(value = AuthorizationDeniedException.class)
  ResponseEntity<ApiResponse> authorizationDeniedExceptionHandler(AuthorizationDeniedException e) {
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setCode(ErrorCode.ACCESS_DENIED.getCode());
    apiResponse.setMessage(ErrorCode.ACCESS_DENIED.getMessage());
    return ResponseEntity.status(ErrorCode.ACCESS_DENIED.getStatusCode()).body(apiResponse);
  }
}
