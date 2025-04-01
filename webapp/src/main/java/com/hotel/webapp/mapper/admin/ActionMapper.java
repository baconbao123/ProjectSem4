package com.hotel.webapp.mapper.admin;

import com.hotel.webapp.dto.admin.Request.ActionResourceReq;
import com.hotel.webapp.dto.admin.Request.ActionResourceUpdate;
import com.hotel.webapp.entity.Actions;
import com.hotel.webapp.util.MapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ActionMapper extends MapperUtil {
  @Mapping(target = "name", expression = "java(trimValue(actionResourceReq.getName()))")
  Actions addAction(ActionResourceReq actionResourceReq);

  @Mapping(target = "name", expression = "java(trimOrToKeep(actions.getName(), updateReq.getName()))")
  Actions updateAction(@MappingTarget Actions actions, ActionResourceUpdate updateReq);
}
