package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.view.AopFormView;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;

public interface WriteAopViewToOutput<T> {
  T execute(AopGridView gridView, AopFormView formView);
}
