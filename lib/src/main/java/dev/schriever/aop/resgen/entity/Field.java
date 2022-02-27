package dev.schriever.aop.resgen.entity;

import dev.schriever.aop.resgen.entity.fieldtype.FieldType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Field {
  private String name;
  private FieldType type;
}
