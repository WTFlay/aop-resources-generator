package dev.schriever.resgencli.configurator;

import dev.schriever.aop.resgen.service.*;

public interface Configurator {
  TransformModelToAopEntity transformModelToAopEntity();
  TransformModelToAopFormView transformModelToAopFormView();
  TransformModelToAopGridView transformModelToAopGridView();
}
