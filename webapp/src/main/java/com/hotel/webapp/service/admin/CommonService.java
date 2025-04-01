package com.hotel.webapp.service.admin;

import java.util.List;

public interface CommonService<T, C, U> {
  T create(C createDto, int authId);
  T update(U updateDto, int authId);
  List<T> getAll();
  T getById(int id);
  void delete(int id, int authId);
}
