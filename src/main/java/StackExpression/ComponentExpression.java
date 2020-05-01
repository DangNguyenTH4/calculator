package StackExpression;

public class ComponentExpression {
  private String component;
  //transfer component to stackElementExpression
  private StackElementExpression stackElementExpression;


  public String getComponent() {
    return component;
  }

  public StackElementExpression getStackElementExpression() {
    return stackElementExpression;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public void setStackElementExpression(StackElementExpression stackElementExpression) {
    this.stackElementExpression = stackElementExpression;
  }
}
