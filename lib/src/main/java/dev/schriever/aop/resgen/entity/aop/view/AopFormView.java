package dev.schriever.aop.resgen.entity.aop.view;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class AopFormView implements AopView {
  private String name;
  private String title;
  private String model;
  @Singular private List<AopPanel> panels;

  @Override
  public String getViewName() {
    return "form";
  }
}
