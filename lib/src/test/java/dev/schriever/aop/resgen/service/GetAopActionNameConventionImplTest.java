package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.action.AopActionView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetAopActionNameConventionImplTest {

  private GetAopActionNameConventionImpl getAopActionNameConvention;

  @Before
  public void setUp() {
    getAopActionNameConvention = new GetAopActionNameConventionImpl();
  }

  @Test
  public void executeWithActionView() {
    AopActionView actionView = AopActionView.builder().build();
    String name = getAopActionNameConvention.execute(actionView, "contact");
    assertEquals("action.contact.view.all", name);
  }

  @Test
  public void executeWithActionViewAndModelNamePascalCase() {
    AopActionView actionView = AopActionView.builder().build();
    String name = getAopActionNameConvention.execute(actionView, "Country");
    assertEquals("action.country.view.all", name);
  }

  @Test
  public void executeWithActionViewAndModelNamePascalCaseComposed() {
    AopActionView actionView = AopActionView.builder().build();
    String name = getAopActionNameConvention.execute(actionView, "SaleOrder");
    assertEquals("action.sale.order.view.all", name);
  }

  @Test
  public void executeWithActionViewAndModelNamePascalCase3NameComposed() {
    AopActionView actionView = AopActionView.builder().build();
    String name = getAopActionNameConvention.execute(actionView, "SaleOrderLine");
    assertEquals("action.sale.order.line.view.all", name);
  }
}