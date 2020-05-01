package StackExpression;

import java.util.Stack;

public class StackComponentExpression {

  private Stack<ComponentExpression> componentExpressionStack;

  public Stack<ComponentExpression> getComponentExpressionStack() {
    return componentExpressionStack;
  }

  public void setComponentExpressionStack(
      Stack<ComponentExpression> componentExpressionStack) {
    this.componentExpressionStack = componentExpressionStack;
  }
}
