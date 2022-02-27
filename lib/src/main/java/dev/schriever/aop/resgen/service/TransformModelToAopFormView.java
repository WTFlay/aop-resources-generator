package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import dev.schriever.aop.resgen.entity.aop.view.AopFormView;

public interface TransformModelToAopFormView {
  AopFormView execute(Model model, AopModule module);
}
