package com.axelor.cli.resgen.service;

import com.axelor.cli.resgen.entity.fieldtype.FieldType;
import com.axelor.cli.resgen.entity.fieldtype.StringFieldType;
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
}