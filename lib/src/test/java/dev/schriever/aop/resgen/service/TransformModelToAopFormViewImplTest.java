package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Field;
import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import dev.schriever.aop.resgen.entity.aop.view.AopFormView;
import dev.schriever.aop.resgen.entity.aop.view.AopPanel;
import dev.schriever.aop.resgen.entity.aop.view.AopViewField;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransformModelToAopFormViewImplTest {

  private TransformModelToAopFormViewImpl transformModelToAopFormView;

  @Before
  public void setUp() {
    GetAopViewNameConvention getAopViewNameConvention = new GetAopViewNameConventionImpl();
    GetAopEntityNameConvention getAopEntityNameConvention = new GetAopEntityNameConventionImpl();
    transformModelToAopFormView = new TransformModelToAopFormViewImpl(getAopEntityNameConvention, getAopViewNameConvention);
  }

  @Test
  public void execute() {
    Model model = Model.builder()
        .name("contact")
        .field(Field.builder().name("fullName").build())
        .field(Field.builder().name("email").build())
        .field(Field.builder().name("phone").build())
        .field(Field.builder().name("dateOfBirth").build())
        .build();
    AopModule module = AopModule.builder()
        .name("contact")
        .packageName("com.axelor.contact.db")
        .build();
    AopFormView expectedFormView = AopFormView.builder()
        .name("contact-form")
        .title("Contact form")
        .model("com.axelor.contact.db.Contact")
        .panel(AopPanel.builder()
            .name("mainPanel")
            .field(AopViewField.builder().name("fullName").build())
            .field(AopViewField.builder().name("email").build())
            .field(AopViewField.builder().name("phone").build())
            .field(AopViewField.builder().name("dateOfBirth").build())
            .build())
        .build();
    AopFormView formView = transformModelToAopFormView.execute(model, module);
    assertEquals(expectedFormView, formView);
  }

}