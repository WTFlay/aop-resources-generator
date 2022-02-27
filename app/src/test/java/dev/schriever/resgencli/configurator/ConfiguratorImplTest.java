package dev.schriever.resgencli.configurator;

import dev.schriever.aop.resgen.service.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConfiguratorImplTest {

  private ConfiguratorImpl configurator;

  @Before
  public void setUp() {
    configurator = new ConfiguratorImpl();
  }

  @Test
  public void getAopEntityFieldType() {
    assertTrue(configurator.getAopEntityFieldType() instanceof GetAopEntityFieldTypeImpl);
  }

  @Test
  public void getAopEntityNameConvention() {
    assertTrue(configurator.getAopEntityNameConvention() instanceof GetAopEntityNameConventionImpl);
  }

  @Test
  public void getAopViewNameConvention() {
    assertTrue(configurator.getAopViewNameConvention() instanceof GetAopViewNameConventionImpl);
  }

  @Test
  public void transformModelToAopEntity() {
    assertTrue(configurator.transformModelToAopEntity() instanceof TransformModelToAopEntityImpl);
  }

  @Test
  public void transformModelToAopFormView() {
    assertTrue(configurator.transformModelToAopFormView() instanceof TransformModelToAopFormViewImpl);
  }

  @Test
  public void transformModelToAopGridView() {
    assertTrue(configurator.transformModelToAopGridView() instanceof TransformModelToAopGridViewImpl);
  }
}