package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.view.AopFormView;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;
import dev.schriever.aop.resgen.entity.aop.view.AopView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetAopViewNameConventionImplTest {

  private final Model contactModel = Model.builder().name("contact").build();
  private GetAopViewNameConventionImpl getAopViewNameConvention;

  @Before
  public void setUp() {
    getAopViewNameConvention = new GetAopViewNameConventionImpl();
  }

  @Test
  public void executeForGridView() {
    String gridViewName = getAopViewNameConvention.execute(contactModel, AopGridView.builder().build());
    assertEquals("contact-grid", gridViewName);
  }

  @Test
  public void executeForFormView() {
    String formViewName = getAopViewNameConvention.execute(contactModel, AopFormView.builder().build());
    assertEquals("contact-form", formViewName);
  }

  @Test
  public void executeForView() {
    String viewName = getAopViewNameConvention.execute(contactModel, new AopView() {
      @Override
      public String getViewName() {
        return "superview";
      }
    });
    assertEquals("contact-superview", viewName);
  }
}