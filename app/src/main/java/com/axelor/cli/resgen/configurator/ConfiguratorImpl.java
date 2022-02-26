package com.axelor.cli.resgen.configurator;

import com.axelor.cli.resgen.service.*;

public class ConfiguratorImpl implements Configurator {
  @Override
  public GetAopEntityFieldType getAopEntityFieldType() {
    return new GetAopEntityFieldTypeImpl();
  }

  @Override
  public GetAopEntityNameConvention getAopEntityNameConvention() {
    return new GetAopEntityNameConventionImpl();
  }

  @Override
  public TransformModelToAopEntity transformModelToAopEntity() {
    return new TransformModelToAopEntityImpl(getAopEntityFieldType(), getAopEntityNameConvention());
  }
}
