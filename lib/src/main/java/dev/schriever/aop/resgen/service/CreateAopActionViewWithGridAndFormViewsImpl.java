package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.action.AopActionView;
import dev.schriever.aop.resgen.entity.aop.action.AopActionViewField;
import dev.schriever.aop.resgen.entity.aop.view.AopFormView;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;
import dev.schriever.aop.resgen.entity.aop.view.AopView;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CreateAopActionViewWithGridAndFormViewsImpl implements CreateAopActionViewWithGridAndFormViews {

  private GetAopActionNameConvention getAopActionNameConvention;

  @Override
  public AopActionView execute(AopEntity entity, AopGridView gridView, AopFormView formView) {
    String viewName = getAopActionNameConvention.execute(AopActionView.builder().build(), entity.getName());
    return AopActionView.builder()
        .name(viewName)
        .model(getModelName(gridView, formView))
        .view(createFromAopView(entity, gridView))
        .view(createFromAopView(entity, formView))
        .build();
  }

  private String getModelName(AopGridView gridView, AopFormView formView) {
    if (gridView.getModel() != null && !gridView.getModel().equals(formView.getModel())) {
      throw new RuntimeException("Form view model is different from grid view model");
    }
    return gridView.getModel();
  }

  private AopActionViewField createFromAopView(AopEntity entity, AopView aopView) {
    String entityName = entity.getName().toLowerCase();
    String type = aopView.getViewName();
    return AopActionViewField.builder()
        .type(type)
        .name(String.format("%s-%s", entityName, type))
        .build();
  }
}
