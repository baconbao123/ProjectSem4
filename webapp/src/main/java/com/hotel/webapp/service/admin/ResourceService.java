package com.hotel.webapp.service.admin;

import com.hotel.webapp.dto.admin.Request.ActionResourceReq;
import com.hotel.webapp.dto.admin.Request.ActionResourceUpdate;
import com.hotel.webapp.entity.Resources;

public interface ResourceService extends CommonService<Resources, ActionResourceReq, ActionResourceUpdate> {
}
