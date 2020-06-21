package com.prongzz.sagatutorial.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Order {
  @Id private String id;

  private LocalDateTime createdOn;

  private String createdBy;
}
