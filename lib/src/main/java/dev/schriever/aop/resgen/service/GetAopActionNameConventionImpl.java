package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.action.AopAction;
import dev.schriever.aop.resgen.entity.aop.action.AopActionView;

public class GetAopActionNameConventionImpl implements GetAopActionNameConvention {

  @Override
  public String execute(AopAction action, String modelName) {
    if (action instanceof AopActionView) {
      String formattedName = "";
      for (int i = 0; i < modelName.length(); i++) {
        if (i > 0 && Character.isUpperCase(modelName.charAt(i))) {
          formattedName += "." + modelName.charAt(i);
        } else {
          formattedName += modelName.charAt(i);
        }
      }
      return String.format("action.%s.view.all", formattedName.toLowerCase());
    }
    throw new IllegalArgumentException("Action unknown for get name convention");
  }
}
