package dev.schriever.aop.resgen.entity.aop;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AopEntityField {
  private String name;
  private String type;
}
