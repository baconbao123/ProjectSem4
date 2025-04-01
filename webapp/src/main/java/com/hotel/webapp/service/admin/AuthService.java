package com.hotel.webapp.service.admin;

import com.hotel.webapp.dto.admin.Request.AuthReq;
import com.hotel.webapp.dto.admin.Response.AuthResponse;

public interface AuthService {
  AuthResponse authenticate(AuthReq authReq);

  int getAuthLogin();
}
