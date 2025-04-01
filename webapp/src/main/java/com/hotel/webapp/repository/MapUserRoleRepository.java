package com.hotel.webapp.repository;

import com.hotel.webapp.entity.MapUserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapUserRoleRepository extends JpaRepository<MapUserRoles, Integer> {
  Optional<MapUserRoles> findByRoleIdAndUserId(int roleId, int userId);

  @Query("select mur.id from MapUserRoles mur where mur.roleId = :roleId and mur.userId = :userId")
  int findIdByRoleIdAndUserId(int roleId, int userId);

  List<MapUserRoles> findAllByUserId(int userId);
}
