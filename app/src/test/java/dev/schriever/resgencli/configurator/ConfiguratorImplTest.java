package dev.schriever.resgencli.configurator;

import dev.schriever.aop.resgen.service.GetAopEntityFieldTypeImpl;
import dev.schriever.aop.resgen.service.GetAopEntityNameConventionImpl;
import dev.schriever.aop.resgen.service.TransformModelToAopEntityImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
  public void transformModelToAopEntity() {
    assertTrue(configurator.transformModelToAopEntity() instanceof TransformModelToAopEntityImpl);
  }
}