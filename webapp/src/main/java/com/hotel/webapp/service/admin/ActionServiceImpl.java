package com.hotel.webapp.service.admin;

import com.hotel.webapp.dto.admin.Request.ActionResourceReq;
import com.hotel.webapp.dto.admin.Request.ActionResourceUpdate;
import com.hotel.webapp.entity.Actions;
import com.hotel.webapp.exception.AppException;
import com.hotel.webapp.exception.ErrorCode;
import com.hotel.webapp.mapper.admin.ActionMapper;
import com.hotel.webapp.repository.ActionRepository;
import com.hotel.webapp.util.ValidateDataInput;
import jakarta.transaction.Transactional;
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
public class ActionServiceImpl implements ActionService {
  ValidateDataInput validateDataInput;
  ActionMapper actionMapper;
  ActionRepository actionRepository;

  @Override
  @Transactional
  public Actions create(ActionResourceReq createDto, int authId) {
    if (actionRepository.existsByNameAndDeletedAtIsNull(createDto.getName())) {
      throw new AppException(ErrorCode.ACTION_EXISTED);
    }
    createDto.setName(validateDataInput.lowercaseFirstLetter(createDto.getName()));

    var action = actionMapper.addAction(createDto);
    action.setCreatedAt(new Timestamp(System.currentTimeMillis()));
    action.setCreatedBy(authId);
    return actionRepository.save(action);
  }

  @Override
  public Actions update(ActionResourceUpdate updateDto, int authId) {
    var actions = getById(updateDto.getId());

    boolean exists = actionRepository.existsByNameAndIdNotAndDeletedAtIsNull(updateDto.getName(), updateDto.getId());

    if (exists) {
      throw new AppException(ErrorCode.ACTION_EXISTED);
    }

    updateDto.setName(validateDataInput.lowercaseFirstLetter(updateDto.getName()));

    actions = actionMapper.updateAction(actions, updateDto);
    actions.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    actions.setUpdatedBy(authId);
    return actionRepository.save(actions);
  }

  @Override
  public List<Actions> getAll() {
    return actionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                           .stream()
                           .filter(a -> a.getDeletedAt() == null).toList();
  }

  @Override
  public Actions getById(int id) {
    return actionRepository.findById(id)
                           .filter(a -> a.getDeletedAt() == null)
                           .orElseThrow(() -> new AppException(ErrorCode.ACTION_NOTFOUND));
  }

  @Override
  public void delete(int id, int authId) {
    var actions = getById(id);
    actions.setDeletedAt(LocalDateTime.now());
    actions.setUpdatedBy(authId);
    actionRepository.save(actions);
  }
}
