package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.Field;
import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.AopEntityField;
import dev.schriever.aop.resgen.entity.fieldtype.StringFieldType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransformModelToAopEntityImplTest {

  private TransformModelToAopEntityImpl transformModelToAopEntity;

  @Before
  public void setUp() {
    GetAopEntityFieldType getAopEntityFieldType = new GetAopEntityFieldTypeImpl();
    GetAopEntityNameConventionImpl getAopEntityNameConvention = new GetAopEntityNameConventionImpl();
    transformModelToAopEntity = new TransformModelToAopEntityImpl(getAopEntityFieldType, getAopEntityNameConvention);
  }

  @Test
  public void execute() {
    Model model = Model.builder()
        .name("title")
        .field(Field.builder().name("code").type(new StringFieldType()).build())
        .field(Field.builder().name("name").type(new StringFieldType()).build())
        .build();
    AopEntity expectedEntity = AopEntity.builder()
        .name("Title")
        .field(AopEntityField.builder().name("code").type("string").build())
        .field(AopEntityField.builder().name("name").type("string").build())
        .build();
    AopEntity entity = transformModelToAopEntity.execute(model);
    assertEquals(expectedEntity, entity);
  }
}