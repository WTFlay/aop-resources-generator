package com.axelor.cli.resgen.service;

import com.axelor.cli.resgen.entity.fieldtype.FieldType;
import com.axelor.cli.resgen.entity.fieldtype.StringFieldType;

public class GetAopEntityFieldTypeImpl implements GetAopEntityFieldType {
  @Override
  public String execute(FieldType fieldType) {
    if (fieldType instanceof StringFieldType) {
      return "string";
    }
    throw new IllegalArgumentException();
  }
}
