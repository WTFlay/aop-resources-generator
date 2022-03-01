package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.fieldtype.FieldType;
import dev.schriever.aop.resgen.entity.fieldtype.ManyToOneFieldType;
import dev.schriever.aop.resgen.entity.fieldtype.StringFieldType;

public class GetAopEntityFieldTypeImpl implements GetAopEntityFieldType {
  @Override
  public String execute(FieldType fieldType) {
    if (fieldType instanceof StringFieldType) {
      return "string";
    }
    if (fieldType instanceof ManyToOneFieldType) {
      return "many-to-one";
    }
    throw new IllegalArgumentException();
  }
}
