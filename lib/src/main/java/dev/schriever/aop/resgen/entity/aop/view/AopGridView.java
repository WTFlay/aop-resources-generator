package dev.schriever.aop.resgen.entity.aop.view;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder
@Data
public class AopGridView implements AopView {
  private String name;
  private String title;
  private String model;
  @Singular private List<AopViewField> fields;

  @Override
  public String getViewName() {
    return "grid";
  }
}
