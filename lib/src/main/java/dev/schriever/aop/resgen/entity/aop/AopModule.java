package dev.schriever.aop.resgen.entity.aop;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AopModule {
  private String name;
  private String packageName;
}
