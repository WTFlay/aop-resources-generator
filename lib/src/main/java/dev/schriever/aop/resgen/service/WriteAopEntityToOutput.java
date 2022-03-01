package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.AopModule;

public interface WriteAopEntityToOutput<T> {
   T execute(AopModule module, AopEntity entity);
}
