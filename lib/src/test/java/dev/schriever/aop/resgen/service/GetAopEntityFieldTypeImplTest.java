package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.fieldtype.FieldType;
import dev.schriever.aop.resgen.entity.fieldtype.ManyToOneFieldType;
import dev.schriever.aop.resgen.entity.fieldtype.StringFieldType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetAopEntityFieldTypeImplTest {

  private GetAopEntityFieldTypeImpl getAopEntityFieldType;

  @Before
  public void setUp() {
    getAopEntityFieldType = new GetAopEntityFieldTypeImpl();
  }

  @Test
  public void executeWithStringFieldType() {
    String entityFieldType = getAopEntityFieldType.execute(new StringFieldType());
    assertEquals("string", entityFieldType);
  }

  @Test(expected = IllegalArgumentException.class)
  public void executeWithUnknownFieldType() {
    String fieldType = "unknown";
    getAopEntityFieldType.execute(new FieldType(fieldType) {
      @Override
      public String getName() {
        return fieldType;
      }
    });
  }

  @Test
  public void executeWithManyToOneFieldType() {
    String entityFieldType = getAopEntityFieldType.execute(new ManyToOneFieldType());
    assertEquals("many-to-one", entityFieldType);
  }
}