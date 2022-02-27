package dev.schriever.resgencli.configurator;

import dev.schriever.aop.resgen.service.GetAopEntityFieldType;
import dev.schriever.aop.resgen.service.GetAopEntityNameConvention;
import dev.schriever.aop.resgen.service.TransformModelToAopEntity;

public interface Configurator {
  GetAopEntityFieldType getAopEntityFieldType();
  GetAopEntityNameConvention getAopEntityNameConvention();
  TransformModelToAopEntity transformModelToAopEntity();
}
