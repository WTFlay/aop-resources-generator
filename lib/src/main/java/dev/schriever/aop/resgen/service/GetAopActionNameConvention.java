package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.action.AopAction;

public interface GetAopActionNameConvention {
  String execute(AopAction action, String modelName);
}
