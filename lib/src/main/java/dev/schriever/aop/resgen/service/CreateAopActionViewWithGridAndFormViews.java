package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.action.AopActionView;
import dev.schriever.aop.resgen.entity.aop.view.AopFormView;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;

public interface CreateAopActionViewWithGridAndFormViews {
  AopActionView execute(AopEntity entity, AopGridView gridView, AopFormView formView);
}
