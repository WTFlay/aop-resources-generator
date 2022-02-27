package dev.schriever.resgencli.configurator;

import dev.schriever.aop.resgen.service.*;

public class ConfiguratorImpl implements Configurator {
  public GetAopEntityFieldType getAopEntityFieldType() {
    return new GetAopEntityFieldTypeImpl();
  }

  public GetAopEntityNameConvention getAopEntityNameConvention() {
    return new GetAopEntityNameConventionImpl();
  }

  public GetAopViewNameConvention getAopViewNameConvention() {
    return new GetAopViewNameConventionImpl();
  }

  @Override
  public TransformModelToAopEntity transformModelToAopEntity() {
    return new TransformModelToAopEntityImpl(getAopEntityFieldType(), getAopEntityNameConvention());
  }

  @Override
  public TransformModelToAopFormView transformModelToAopFormView() {
    return new TransformModelToAopFormViewImpl(getAopEntityNameConvention(), getAopViewNameConvention());
  }

  @Override
  public TransformModelToAopGridView transformModelToAopGridView() {
    return new TransformModelToAopGridViewImpl(getAopEntityNameConvention(), getAopViewNameConvention());
  }
}
