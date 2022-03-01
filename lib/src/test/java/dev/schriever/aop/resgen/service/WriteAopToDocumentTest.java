package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.AopEntityField;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.junit.Assert.*;

public class WriteAopToDocumentTest {

  private WriteAopToDocument writeAopToDocument;

  @Before
  public void setUp() throws Exception {
    writeAopToDocument = new WriteAopToDocument();
  }

  @Test
  public void executeWithModuleAndEntity() {
    AopModule module = AopModule.builder()
        .name("contact")
        .packageName("com.axelor.contact.db")
        .build();
    AopEntity entity = AopEntity.builder()
        .name("Title")
        .field(AopEntityField.builder().name("code").type("string").build())
        .field(AopEntityField.builder().name("name").type("string").build())
        .build();

    Document document = writeAopToDocument.execute(module, entity);

    Element domainModelElement = document.getDocumentElement();
    assertEquals("domain-models", domainModelElement.getTagName());
    assertEquals("http://axelor.com/xml/ns/domain-models", domainModelElement.getAttribute("xmlns"));
    assertEquals("http://www.w3.org/2001/XMLSchema-instance", domainModelElement.getAttribute("xmlns:xsi"));
    assertEquals(
        "http://axelor.com/xml/ns/domain-models http://axelor.com/xml/ns/domain-models/domain-models_5.4.xsd",
        domainModelElement.getAttribute("xsi:schemaLocation"));

    NodeList moduleList = document.getElementsByTagName("module");
    assertEquals(1, moduleList.getLength());
    Element moduleElement = (Element) moduleList.item(0);
    assertEquals("contact", moduleElement.getAttribute("name"));
    assertEquals("com.axelor.contact.db", moduleElement.getAttribute("package"));

    NodeList entityList = document.getElementsByTagName("entity");
    assertEquals(1, entityList.getLength());
    Element entityElement = (Element) entityList.item(0);
    assertEquals("Title", entityElement.getAttribute("name"));
    assertEquals(2, entityElement.getChildNodes().getLength());
    Element codeFieldElement = (Element) entityElement.getChildNodes().item(0);
    assertEquals("string", codeFieldElement.getTagName());
    assertEquals("code", codeFieldElement.getAttribute("name"));
    Element nameFieldElement = (Element) entityElement.getChildNodes().item(1);
    assertEquals("string", nameFieldElement.getTagName());
    assertEquals("name", nameFieldElement.getAttribute("name"));
  }
}