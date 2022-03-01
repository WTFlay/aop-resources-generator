package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.action.AopActionView;
import dev.schriever.aop.resgen.entity.aop.view.AopMenuView;
import org.w3c.dom.Document;

public interface WriteAopMenuToOutput<T> {
  T execute(AopMenuView menuView, AopActionView actionView);
}
