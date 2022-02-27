package dev.schriever.resgencli;

import dev.schriever.aop.resgen.entity.Field;
import dev.schriever.aop.resgen.entity.Model;
import dev.schriever.aop.resgen.entity.aop.AopEntity;
import dev.schriever.aop.resgen.entity.aop.AopModule;
import dev.schriever.aop.resgen.entity.aop.view.AopFormView;
import dev.schriever.aop.resgen.entity.aop.view.AopGridView;
import dev.schriever.aop.resgen.entity.fieldtype.StringFieldType;
import dev.schriever.resgencli.configurator.Configurator;
import dev.schriever.resgencli.configurator.ConfiguratorImpl;

public class App {
    public static void main(String[] args) {
        Configurator configurator = new ConfiguratorImpl();
        Model model = Model.builder()
            .name("title")
            .field(Field.builder().name("code").type(new StringFieldType()).build())
            .field(Field.builder().name("name").type(new StringFieldType()).build())
            .build();
        AopModule module = AopModule.builder()
            .name("contact")
            .packageName("com.axelor.contact.db")
            .build();
        AopEntity entity = configurator.transformModelToAopEntity().execute(model);
        AopFormView formView = configurator.transformModelToAopFormView().execute(model, module);
        AopGridView gridView = configurator.transformModelToAopGridView().execute(model, module);
        System.out.println(model);
        System.out.println(module);
        System.out.println(entity);
        System.out.println(formView);
        System.out.println(gridView);
    }
}
