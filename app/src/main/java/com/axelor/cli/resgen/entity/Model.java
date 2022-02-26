package com.axelor.cli.resgen.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Model {
  private String name;
  @Singular private List<Field> fields;
}
