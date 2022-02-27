package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Field;
import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;
import dev.schriever.aop.resgen.entity.aop.view.AopViewField;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TransformModelToAopGridViewImpl implements TransformModelToAopGridView {

  private GetAopEntityNameConvention getAopEntityNameConvention;
  private GetAopViewNameConvention getAopViewNameConvention;

  @Override
  public AopGridView execute(Model model, AopModule module) {
    String gridName = generateGridName(model);
    String entityName = getAopEntityNameConvention.execute(model);
    String gridModelName = generateGridModelNameWithPackage(model, module);
    List<AopViewField> fields = model.getFields().stream()
        .map(this::buildAopViewFieldFromField)
        .collect(Collectors.toList());
    return AopGridView.builder()
        .name(gridName)
        .title(String.format("%s grid", entityName))
        .model(gridModelName)
        .fields(fields)
        .build();
  }

  private String generateGridName(Model model) {
    return getAopViewNameConvention.execute(model, AopGridView.builder().build());
  }

  private String generateGridModelNameWithPackage(Model model, AopModule module) {
    String entityName = getAopEntityNameConvention.execute(model);
    return module.getPackageName() + "." + entityName;
  }

  private AopViewField buildAopViewFieldFromField(Field field) {
    return AopViewField.builder().name(field.getName()).build();
  }
}
