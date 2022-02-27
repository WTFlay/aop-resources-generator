package dev.schriever.aop.resgen.entity.fieldtype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class FieldType {
  @Getter private String name;
}
