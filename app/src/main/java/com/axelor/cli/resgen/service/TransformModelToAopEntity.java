package com.axelor.cli.resgen.service;

import com.axelor.cli.resgen.entity.Model;
import com.axelor.cli.resgen.entity.aop.AopEntity;

public interface TransformModelToAopEntity {
  AopEntity execute(Model model);
}
