package com.axelor.cli.resgen.service;

import com.axelor.cli.resgen.entity.Model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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