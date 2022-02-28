package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.action.AopActionView;
import dev.schriever.aop.resgen.entity.aop.action.AopActionViewField;
import dev.schriever.aop.resgen.entity.aop.view.AopFormView;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateAopActionViewWithGridAndFormViewsImplTest {

  private CreateAopActionViewWithGridAndFormViewsImpl createAopActionViewWithGridAndFormViews;

  @Before
  public void setUp() {
    GetAopActionNameConvention getAopActionNameConvention = new GetAopActionNameConventionImpl();
    createAopActionViewWithGridAndFormViews = new CreateAopActionViewWithGridAndFormViewsImpl(getAopActionNameConvention);
  }

  @Test
  public void execute() {
    String modelPackage = "com.axelor.contact.db.Contact";
    AopEntity entity = AopEntity.builder()
        .name("Contact")
        .build();
    AopGridView gridView = AopGridView.builder()
        .name("contact-grid")
        .title("Contact grid")
        .model(modelPackage)
        .build();
    AopFormView formView = AopFormView.builder()
        .name("contact-form")
        .title("Contact form")
        .model(modelPackage)
        .build();
    AopActionView expectedActionView = AopActionView.builder()
        .name("action.contact.view.all")
        .model(modelPackage)
        .view(AopActionViewField.builder()
            .type("grid")
            .name("contact-grid")
            .build())
        .view(AopActionViewField.builder()
            .type("form")
            .name("contact-form")
            .build())
        .build();
    AopActionView actionView = createAopActionViewWithGridAndFormViews.execute(entity, gridView, formView);
    assertEquals(expectedActionView, actionView);
  }
}