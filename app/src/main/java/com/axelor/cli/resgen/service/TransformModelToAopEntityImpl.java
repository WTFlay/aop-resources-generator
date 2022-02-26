package com.axelor.cli.resgen.service;

import com.axelor.cli.resgen.entity.Field;
import com.axelor.cli.resgen.entity.Model;
import com.axelor.cli.resgen.entity.aop.AopEntity;
import com.axelor.cli.resgen.entity.aop.AopEntityField;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TransformModelToAopEntityImpl implements TransformModelToAopEntity {

  private GetAopEntityFieldType getAopEntityFieldType;
  private GetAopEntityNameConvention getAopEntityNameConvention;

  @Override
  public AopEntity execute(Model model) {
    List<AopEntityField> fields = model.getFields().stream()
        .map(this::buildAopEntityFieldFromField)
        .collect(Collectors.toList());
    String entityName = getAopEntityNameConvention.execute(model);
    return AopEntity.builder()
        .name(entityName)
        .fields(fields)
        .build();
  }

  private AopEntityField buildAopEntityFieldFromField(Field field) {
    String fieldType = getAopEntityFieldType.execute(field.getType());
    return AopEntityField.builder()
        .name(field.getName())
        .type(fieldType)
        .build();
  }
}
