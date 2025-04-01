package com.hotel.webapp.repository;

import com.hotel.webapp.entity.Permissions;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Integer> {
  int countPermissionsByMapResourcesActionIdAndMapUserRolesId(int mapResourcesActionId, int mapUserRolesId);

  @Modifying
  @Transactional
  @Query("insert into Permissions (mapResourcesActionId, mapUserRolesId, createdAt, createdBy) values " +
        "(:mapResourcesActionId, :mapUserRolesId, :createdAt, :createdBy)")
  void insertPermissions(int mapResourcesActionId, int mapUserRolesId, Timestamp createdAt, int createdBy);
}
