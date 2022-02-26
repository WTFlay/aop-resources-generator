package com.axelor.cli.resgen;

import com.axelor.cli.resgen.entity.Field;
import com.axelor.cli.resgen.entity.Model;
import com.axelor.cli.resgen.entity.aop.AopEntity;
import com.axelor.cli.resgen.entity.aop.AopEntityField;
import com.axelor.cli.resgen.entity.fieldtype.StringFieldType;

public class App {
    public static void main(String[] args) {
        Model model = Model.builder()
            .name("title")
            .field(Field.builder().name("code").type(new StringFieldType()).build())
            .field(Field.builder().name("name").type(new StringFieldType()).build())
            .build();
        AopEntity entity = AopEntity.builder()
            .name("Title")
            .field(AopEntityField.builder().name("code").type("string").build())
            .field(AopEntityField.builder().name("name").type("string").build())
            .build();
        System.out.println(model);
        System.out.println(entity);
    }
}
