package dev.schriever.aop.resgen.entity.aop.action;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class AopActionView implements AopAction {
  private String name;
  private String model;
  @Singular private List<AopActionViewField> views;

  @Override
  public String getActionType() {
    return "view";
  }
}
