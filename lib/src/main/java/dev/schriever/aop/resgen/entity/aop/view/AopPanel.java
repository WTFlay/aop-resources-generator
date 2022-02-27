package dev.schriever.aop.resgen.entity.aop.view;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class AopPanel {
  private String name;
  private String title;
  @Singular private List<AopViewField> fields;
}
