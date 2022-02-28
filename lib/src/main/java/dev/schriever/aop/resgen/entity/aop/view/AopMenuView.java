package dev.schriever.aop.resgen.entity.aop.view;

import dev.schriever.aop.resgen.entity.aop.action.AopAction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AopMenuView {
  private String name;
  private String title;
  private AopAction action;
}
