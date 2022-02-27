package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Field;
import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.AopEntityField;
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
