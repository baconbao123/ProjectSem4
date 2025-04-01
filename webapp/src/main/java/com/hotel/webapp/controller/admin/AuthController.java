package com.hotel.webapp.controller.admin;

import com.hotel.webapp.dto.admin.Request.AuthReq;
import com.hotel.webapp.dto.admin.Response.ApiResponse;
import com.hotel.webapp.dto.admin.Response.AuthResponse;
import com.hotel.webapp.service.admin.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
  AuthService authService;

  @PostMapping("/login")
  public ApiResponse<AuthResponse> authentication(AuthReq authReq) {
    return ApiResponse.<AuthResponse>builder()
                      .result(authService.authenticate(authReq))
                      .build();
  }
}
