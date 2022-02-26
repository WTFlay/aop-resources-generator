package com.axelor.cli.resgen.entity.fieldtype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class FieldType {
  @Getter private String name;
}
