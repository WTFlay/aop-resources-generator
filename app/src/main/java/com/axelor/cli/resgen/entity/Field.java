package com.axelor.cli.resgen.entity;

import com.axelor.cli.resgen.entity.fieldtype.FieldType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Field {
  private String name;
  private FieldType type;
}
