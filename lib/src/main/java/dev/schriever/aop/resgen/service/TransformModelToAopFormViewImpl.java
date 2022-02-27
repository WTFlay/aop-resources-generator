package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Field;
import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import dev.schriever.aop.resgen.entity.aop.view.AopFormView;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;
import dev.schriever.aop.resgen.entity.aop.view.AopPanel;
import dev.schriever.aop.resgen.entity.aop.view.AopViewField;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TransformModelToAopFormViewImpl implements TransformModelToAopFormView {

  private GetAopEntityNameConvention getAopEntityNameConvention;
  private GetAopViewNameConvention getAopViewNameConvention;

  @Override
  public AopFormView execute(Model model, AopModule module) {
    String formName = generateFormName(model);
    String entityName = getAopEntityNameConvention.execute(model);
    String gridModelName = generateGridModelNameWithPackage(model, module);
    List<AopViewField> fields = model.getFields().stream()
        .map(this::buildAopViewFieldFromField)
        .collect(Collectors.toList());
    return AopFormView.builder()
        .name(formName)
        .title(String.format("%s form", entityName))
        .model(gridModelName)
        .panel(AopPanel.builder()
            .name("mainPanel")
            .fields(fields)
            .build())
        .build();
  }

  private String generateFormName(Model model) {
    return getAopViewNameConvention.execute(model, AopFormView.builder().build());
  }

  private String generateGridModelNameWithPackage(Model model, AopModule module) {
    String entityName = getAopEntityNameConvention.execute(model);
    return module.getPackageName() + "." + entityName;
  }

  private AopViewField buildAopViewFieldFromField(Field field) {
    return AopViewField.builder().name(field.getName()).build();
  }
}
