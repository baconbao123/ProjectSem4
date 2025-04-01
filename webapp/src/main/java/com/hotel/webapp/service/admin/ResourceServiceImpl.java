package com.hotel.webapp.service.admin;

import com.hotel.webapp.dto.admin.Request.ActionResourceReq;
import com.hotel.webapp.dto.admin.Request.ActionResourceUpdate;
import com.hotel.webapp.entity.Resources;
import com.hotel.webapp.exception.AppException;
import com.hotel.webapp.exception.ErrorCode;
import com.hotel.webapp.mapper.admin.ResourceMapper;
import com.hotel.webapp.repository.ResourcesRepository;
import com.hotel.webapp.util.ValidateDataInput;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResourceServiceImpl implements ResourceService {
  ValidateDataInput validateDataInput;
  ResourceMapper resourceMapper;
  ResourcesRepository resourcesRepository;

  @Override
  public Resources create(ActionResourceReq createDto, int authId) {
    if (resourcesRepository.existsByNameAndDeletedAtIsNull(createDto.getName()))
      throw new AppException(ErrorCode.RESOURCE_EXISTED);

    createDto.setName(validateDataInput.capitalizeFirstLetter(createDto.getName()));

    var resources = resourceMapper.addResources(createDto);
    resources.setCreatedAt(new Timestamp(System.currentTimeMillis()));
    resources.setCreatedBy(authId);
    return resourcesRepository.save(resources);
  }

  @Override
  public Resources update(ActionResourceUpdate updateDto, int authId) {
    var resource = getById(updateDto.getId());

    if(resourcesRepository.existsByNameAndIdNotAndDeletedAtIsNull(updateDto.getName(),resource.getId()))
      throw new AppException(ErrorCode.RESOURCE_EXISTED);

    updateDto.setName(validateDataInput.capitalizeFirstLetter(updateDto.getName()));
    resource = resourceMapper.updateResources(resource, updateDto);
    resource.setName(updateDto.getName());
    resource.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    resource.setUpdatedBy(authId);
    return resourcesRepository.save(resource);
  }

  @Override
  public List<Resources> getAll() {
    return resourcesRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                              .stream()
                              .filter(r -> r.getDeletedAt() == null)
                              .toList();
  }

  @Override
  public Resources getById(int id) {
    return resourcesRepository.findById(id)
                              .filter(r -> r.getDeletedAt() == null)
                              .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOTFOUND));
  }

  @Override
  public void delete(int id, int authId) {
    var resource = getById(id);
    resource.setDeletedAt(LocalDateTime.now());
    resource.setUpdatedBy(authId);
    resourcesRepository.save(resource);
  }
}
