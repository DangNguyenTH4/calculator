package StackExpression;

import java.util.Stack;
import model.CalculateElement;

public class StackElementExpression {

  Stack<CalculateElement> stack;

  public void setStack(Stack<CalculateElement> stack) {
    this.stack = stack;
  }

  public Stack getStack() {
    return this.stack;
  }

  public void pushExpression(CalculateElement ex) {
    this.stack.push(ex);
  }

  public CalculateElement popExpression() {
    return this.stack.pop();
  }
}
