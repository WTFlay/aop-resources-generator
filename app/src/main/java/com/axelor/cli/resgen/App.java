package com.axelor.cli.resgen;

import com.axelor.cli.resgen.configurator.Configurator;
import com.axelor.cli.resgen.configurator.ConfiguratorImpl;
import com.axelor.cli.resgen.entity.Field;
import com.axelor.cli.resgen.entity.Model;
import com.axelor.cli.resgen.entity.aop.AopEntity;
import com.axelor.cli.resgen.entity.aop.AopModule;
import com.axelor.cli.resgen.entity.fieldtype.StringFieldType;

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
        System.out.println(model);
        System.out.println(module);
        System.out.println(entity);
    }
}
