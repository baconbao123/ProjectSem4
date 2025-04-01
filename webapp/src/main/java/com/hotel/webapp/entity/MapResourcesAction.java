package com.hotel.webapp.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.query.Order;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MapResourcesAction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;
  Integer resourceId;
  Integer actionId;
  Timestamp createdAt;
  @Nullable
  Timestamp updatedAt;
  Integer createdBy;
  @Nullable
  Integer updatedBy;
  @Nullable
  LocalDateTime deletedAt;
}
