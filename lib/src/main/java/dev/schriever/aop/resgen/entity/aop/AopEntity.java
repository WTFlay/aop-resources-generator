package dev.schriever.aop.resgen.entity.aop;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class AopEntity {
  private String name;
  @Singular private List<AopEntityField> fields;
}
