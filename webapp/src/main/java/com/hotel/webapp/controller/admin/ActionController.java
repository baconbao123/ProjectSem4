package com.hotel.webapp.controller.admin;

import com.hotel.webapp.dto.admin.Request.ActionResourceReq;
import com.hotel.webapp.dto.admin.Request.ActionResourceUpdate;
import com.hotel.webapp.dto.admin.Response.ApiResponse;
import com.hotel.webapp.entity.Actions;
import com.hotel.webapp.service.admin.ActionService;
import com.hotel.webapp.service.admin.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/action")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ActionController {
  AuthService authService;
  ActionService actionService;

  @PostMapping("/create")
  public ApiResponse<Actions> create(ActionResourceReq actionResourceReq) {
    return ApiResponse.<Actions>builder()
                      .result(actionService.create(actionResourceReq, authService.getAuthLogin()))
                      .build();
  }

  @PutMapping("/update")
  public ApiResponse<Actions> update(ActionResourceUpdate updateReq) {
    return ApiResponse.<Actions>builder()
                      .result(actionService.update(updateReq, authService.getAuthLogin()))
                      .build();
  }

  @GetMapping("/get-all")
  public ApiResponse<List<Actions>> getAll() {
    return ApiResponse.<List<Actions>>builder()
                      .result(actionService.getAll())
                      .build();
  }

  @GetMapping("/find-by-id/{id}")
  public ApiResponse<Actions> findById(@PathVariable int id) {
    return ApiResponse.<Actions>builder()
                      .result(actionService.getById(id))
                      .build();
  }

  @GetMapping("/delete/{id}")
  public ApiResponse<Void> deleteById(@PathVariable int id) {
    actionService.delete(id, authService.getAuthLogin());
    return ApiResponse.<Void>builder()
                      .message("Deleted action with id " + id + " successfully")
                      .build();
  }
}
