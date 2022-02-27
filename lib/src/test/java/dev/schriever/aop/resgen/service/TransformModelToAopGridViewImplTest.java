package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Field;
import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;
import dev.schriever.aop.resgen.entity.aop.view.AopViewField;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransformModelToAopGridViewImplTest {

  private TransformModelToAopGridViewImpl transformModelToAopGridView;

  @Before
  public void setUp() {
    GetAopEntityNameConvention getAopEntityNameConvention = new GetAopEntityNameConventionImpl();
    GetAopViewNameConvention getAopViewNameConvention = new GetAopViewNameConventionImpl();
    transformModelToAopGridView = new TransformModelToAopGridViewImpl(getAopEntityNameConvention, getAopViewNameConvention);
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
    AopGridView expectedGridView = AopGridView.builder()
        .name("contact-grid")
        .title("Contact grid")
        .model("com.axelor.contact.db.Contact")
        .field(AopViewField.builder().name("fullName").build())
        .field(AopViewField.builder().name("email").build())
        .field(AopViewField.builder().name("phone").build())
        .field(AopViewField.builder().name("dateOfBirth").build())
        .build();
    AopGridView gridView = transformModelToAopGridView.execute(model, module);
    assertEquals(expectedGridView, gridView);
  }
}