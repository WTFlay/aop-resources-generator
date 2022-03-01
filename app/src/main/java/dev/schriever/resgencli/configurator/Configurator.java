package dev.schriever.resgencli.configurator;

import dev.schriever.aop.resgen.service.*;

import javax.xml.parsers.ParserConfigurationException;

public interface Configurator {
  TransformModelToAopEntity transformModelToAopEntity();
  TransformModelToAopFormView transformModelToAopFormView();
  TransformModelToAopGridView transformModelToAopGridView();
  WriteAopToDocument writeAopToDocument() throws ParserConfigurationException;
}
