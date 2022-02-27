package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetAopEntityNameConventionImplTest {

  private GetAopEntityNameConventionImpl getAopEntityNameConvention;

  @Before
  public void setUp() {
    getAopEntityNameConvention = new GetAopEntityNameConventionImpl();
  }

  @Test
  public void execute() {
    String aopEntityName = getAopEntityNameConvention.execute(Model.builder().name("title").build());
    assertEquals("Title", aopEntityName);
  }
}