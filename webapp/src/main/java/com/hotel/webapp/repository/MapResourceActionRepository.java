package com.hotel.webapp.repository;

import com.hotel.webapp.entity.MapResourcesAction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface MapResourceActionRepository extends JpaRepository<MapResourcesAction, Integer> {
  @Query("select mr.id from MapResourcesAction mr where mr.resourceId = :resourceId and mr.actionId = :actionId")
  Optional<Integer> findIdByResourceIdAndActionId(int resourceId, int actionId);

  @Modifying
  @Transactional
  @Query(value = "insert into MapResourcesAction (resourceId, actionId, createdAt, createdBy)" +
        "values (:resourceId, :actionId, :createdAt, :createdBy)")
  void insertMapping(int resourceId, int actionId, Timestamp createdAt, int createdBy);
}
