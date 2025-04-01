package com.hotel.webapp.controller.admin;

import com.hotel.webapp.dto.admin.Request.ActionResourceReq;
import com.hotel.webapp.dto.admin.Request.ActionResourceUpdate;
import com.hotel.webapp.dto.admin.Response.ApiResponse;
import com.hotel.webapp.entity.Actions;
import com.hotel.webapp.entity.Resources;
import com.hotel.webapp.service.admin.ActionService;
import com.hotel.webapp.service.admin.AuthService;
import com.hotel.webapp.service.admin.ResourceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceController {
  AuthService authService;
  ResourceService resourceService;

  @PostMapping("/create")
  public ApiResponse<Resources> create(ActionResourceReq actionResourceReq) {
    return ApiResponse.<Resources>builder()
                      .result(resourceService.create(actionResourceReq, authService.getAuthLogin()))
                      .build();
  }

  @PutMapping("/update")
  public ApiResponse<Resources> update(ActionResourceUpdate updateReq) {
    return ApiResponse.<Resources>builder()
                      .result(resourceService.update(updateReq, authService.getAuthLogin()))
                      .build();
  }

  @GetMapping("/get-all")
  public ApiResponse<List<Resources>> getAll() {
    return ApiResponse.<List<Resources>>builder()
                      .result(resourceService.getAll())
                      .build();
  }

  @GetMapping("/find-by-id/{id}")
  public ApiResponse<Resources> findById(@PathVariable int id) {
    return ApiResponse.<Resources>builder()
                      .result(resourceService.getById(id))
                      .build();
  }

  @GetMapping("/delete/{id}")
  public ApiResponse<Void> deleteById(@PathVariable int id) {
    resourceService.delete(id, authService.getAuthLogin());
    return ApiResponse.<Void>builder()
                      .message("Deleted resource with id " + id + " successfully")
                      .build();
  }
}
