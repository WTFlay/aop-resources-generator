package com.axelor.cli.resgen.service;

import com.axelor.cli.resgen.entity.Model;

public class GetAopEntityNameConventionImpl implements GetAopEntityNameConvention {
  @Override
  public String execute(Model model) {
    String modelName = model.getName();
    return modelName.substring(0, 1).toUpperCase() + modelName.substring(1);
  }
}
