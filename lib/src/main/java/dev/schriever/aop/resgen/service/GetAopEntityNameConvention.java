package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;

public interface GetAopEntityNameConvention {
  String execute(Model model);
}
