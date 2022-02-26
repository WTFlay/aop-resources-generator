package com.axelor.cli.resgen.entity.fieldtype;

import lombok.Builder;

@Builder
public class StringFieldType extends FieldType {
  public StringFieldType() {
    super("string");
  }
}
