package model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

public class OperatorElement implements CalculateElement {

  private char operator;
  private Integer position;

  public void setOperator(char operator) {
    this.operator = operator;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public char getOperator() {
    return operator;
  }

  public Integer getPosition() {
    return position;
  }
}
