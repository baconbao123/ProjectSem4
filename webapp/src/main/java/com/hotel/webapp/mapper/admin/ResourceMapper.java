package com.hotel.webapp.mapper.admin;

import com.hotel.webapp.dto.admin.Request.ActionResourceReq;
import com.hotel.webapp.dto.admin.Request.ActionResourceUpdate;
import com.hotel.webapp.entity.Resources;
import com.hotel.webapp.util.MapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ResourceMapper extends MapperUtil {
  @Mapping(target = "name", expression = "java(trimValue(actionResourceReq.getName()))")
  Resources addResources(ActionResourceReq actionResourceReq);

  @Mapping(target = "name", expression = "java(trimOrToKeep(resources.getName(), updateReq.getName()))")
  Resources updateResources(@MappingTarget Resources resources, ActionResourceUpdate updateReq);
}
