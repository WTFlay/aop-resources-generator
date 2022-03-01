package dev.schriever.aop.resgen.service;

import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.AopEntityField;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class WriteAopToDocument implements WriteAopEntityToOutput<Document> {

  private static final String XMLNS = "http://axelor.com/xml/ns/domain-models";
  private static final String XSI = "http://www.w3.org/2001/XMLSchema-instance";
  private static final String DOMAIN_MODELS = "http://axelor.com/xml/ns/domain-models/domain-models_5.4.xsd";
  private static final String SCHEMA_LOCATION = String.format("%s %s", XMLNS, DOMAIN_MODELS);

  private DocumentBuilder documentBuilder;

  public WriteAopToDocument() throws ParserConfigurationException {
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    documentBuilder = builderFactory.newDocumentBuilder();
  }

  @Override
  public Document execute(AopModule module, AopEntity entity) {
    Document document = documentBuilder.newDocument();
    Element rootElement = createDomainModelsElement(document);
    rootElement.appendChild(createModuleElement(document, module));
    rootElement.appendChild(createEntityElement(document, entity));
    document.appendChild(rootElement);
    return document;
  }

  private Element createDomainModelsElement(Document document) {
    Element domainModelsElement = document.createElement("domain-models");
    domainModelsElement.setAttribute("xmlns", XMLNS);
    domainModelsElement.setAttribute("xmlns:xsi", XSI);
    domainModelsElement.setAttribute("xsi:schemaLocation", SCHEMA_LOCATION);
    return domainModelsElement;
  }

  private Element createModuleElement(Document document, AopModule module) {
    Element moduleElement = document.createElement("module");
    moduleElement.setAttribute("name", module.getName());
    moduleElement.setAttribute("package", module.getPackageName());
    return moduleElement;
  }

  private Element createEntityElement(Document document, AopEntity entity) {
    Element entityElement = document.createElement("entity");
    entityElement.setAttribute("name", entity.getName());
    entity.getFields().stream()
        .map(field -> createFieldElement(document, field))
        .forEach(entityElement::appendChild);
    return entityElement;
  }

  private Element createFieldElement(Document document, AopEntityField entityField) {
    Element fieldElement = document.createElement(entityField.getType());
    fieldElement.setAttribute("name", entityField.getName());
    return fieldElement;
  }
}
