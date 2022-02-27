package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.view.AopView;

public class GetAopViewNameConventionImpl implements GetAopViewNameConvention {

  @Override
  public String execute(Model model, AopView view) {
    return model.getName() + "-" + view.getViewName();
  }
}
