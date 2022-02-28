package dev.schriever.aop.resgen.entity.aop.action;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AopActionViewField {
  private String type;
  private String name;
}
