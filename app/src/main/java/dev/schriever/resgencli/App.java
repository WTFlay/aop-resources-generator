package dev.schriever.resgencli;

import dev.schriever.aop.resgen.entity.Field;
import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import dev.schriever.aop.resgen.entity.fieldtype.StringFieldType;
import dev.schriever.resgencli.configurator.Configurator;
import dev.schriever.resgencli.configurator.ConfiguratorImpl;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class App {
    public static void main(String[] args) throws ParserConfigurationException {
        Configurator configurator = new ConfiguratorImpl();
        Model title = Model.builder()
            .name("title")
            .field(Field.builder().name("code").type(new StringFieldType()).build())
            .field(Field.builder().name("name").type(new StringFieldType()).build())
            .build();
        AopModule module = AopModule.builder()
            .name("contact")
            .packageName("com.axelor.contact.db")
            .build();
        AopEntity titleEntity = configurator.transformModelToAopEntity().execute(title);
        Document titleDocument = configurator.writeAopToDocument().execute(module, titleEntity);

        try (FileOutputStream output = new FileOutputStream("Title.xml")) {
            writeXml(titleDocument, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeXml(Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }
}
