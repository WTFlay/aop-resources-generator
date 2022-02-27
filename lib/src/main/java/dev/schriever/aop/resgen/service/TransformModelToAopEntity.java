package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopEntity;

public interface TransformModelToAopEntity {
  AopEntity execute(Model model);
}
