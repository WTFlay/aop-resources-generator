package com.axelor.cli.resgen.configurator;

import com.axelor.cli.resgen.service.GetAopEntityFieldType;
import com.axelor.cli.resgen.service.GetAopEntityNameConvention;
import com.axelor.cli.resgen.service.TransformModelToAopEntity;

public interface Configurator {
  GetAopEntityFieldType getAopEntityFieldType();
  GetAopEntityNameConvention getAopEntityNameConvention();
  TransformModelToAopEntity transformModelToAopEntity();
}
