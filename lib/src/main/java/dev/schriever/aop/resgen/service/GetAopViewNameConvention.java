package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.view.AopView;

public interface GetAopViewNameConvention {
  String execute(Model model, AopView view);
}
