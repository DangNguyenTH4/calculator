package service;

import java.util.Stack;
import model.OperatorElement;
import utils.ExpressionUtils;
import utils.StringUtils;

public class CalculateService {

//  public static void main(String[] args) {
//    CalculateService c = new CalculateService();
////    String express = "(((1+2)*(2+3)*4)+5*6-7/2)";
//    String express = "1.2+2.3+(((1.3+2)*(2+3)*4)+5*6-7/2.5)";
////    String express = "1.2+2*3+5*6";
//    double result = c.calculate(express);
//    System.out.println(result);
//
//  }

  public static final char OPENBRRACKET = '(';
  public static final char CLOSEBRRACKET = ')';

  public double calculate(String expression){
    try{
      return calculateExpression(expression);
    }catch (Exception ex){
      System.out.println(ex.getMessage());
      return Double.MAX_VALUE;
    }
  }

  /**
   *
   * @param expression
   * @return
   */
  private double calculateExpression(String expression) {
    if (ExpressionUtils.isResult(expression)) {
      return Double.parseDouble(expression);
    }
    int indexOfOpen = expression.indexOf("(");
    //start with "("
    if (indexOfOpen==0) {
      String subBoxExpression = this.getSubExpression(expression);
      String parrent = expression.substring(subBoxExpression.length() + 2);

      //Case "((1+2))"
      if(StringUtils.isEmpty(parrent)){
        return this.calculate(subBoxExpression);
      }
      else{
        char operator = parrent.charAt(0);
        String secondBox = parrent.substring(1);
        return this.calculate(subBoxExpression,secondBox,operator);
      }
    }
    //case 9/(1+2) - case contain (
    else if(indexOfOpen>0){
      String firstBox = expression.substring(0,indexOfOpen-1);
      char operator = expression.charAt(indexOfOpen-1);

      String tempBox = expression.substring(indexOfOpen);

      String subBoxExpression = this.getSubExpression(tempBox);

      String finalExpression = tempBox.substring(subBoxExpression.length() + 2);
      //case 9/(2+3)
      if(StringUtils.isEmpty(finalExpression)){
        return this.calculate(firstBox,subBoxExpression,operator);
      }
      //case 9/(2+3)-4
      else{
        char secondOperator = finalExpression.charAt(0);
        String finalBox = finalExpression.substring(1);

        String calculateForEx1 = this.calculate(firstBox,subBoxExpression,operator)+"";
        return this.calculate(calculateForEx1,finalBox,secondOperator);
      }
    }
    else {
      //My rule : in this case start with a number
      OperatorElement firstOpreator = ExpressionUtils.getFirstOperator(expression);
      String firstNumber = expression.substring(0,firstOpreator.getPosition());
      String sencondNumber = expression.substring(firstOpreator.getPosition()+1);
      return this.calculate(firstNumber,sencondNumber,firstOpreator.getOperator());
    }
  }

  private double calculate(String firstExpression ,String secondExpression,char operator){
    switch (operator){
      case '+' : return this.add(this.calculate(firstExpression),this.calculate(secondExpression));
      case '-' : return this.minus(this.calculate(firstExpression),this.calculate(secondExpression));
      case '*' : return this.multiply(this.calculate(firstExpression),this.calculate(secondExpression));
      case '/' : return this.divide(this.calculate(firstExpression),this.calculate(secondExpression));
      default: return 0;
    }
  }
  private String getSubExpression(String expression) {
    Stack<Character> openStack = new Stack<>();
    int closePosition = 0;
    openStack.push(OPENBRRACKET);
    for (int i = 1; i < expression.length(); i++) {
      if (expression.charAt(i) == OPENBRRACKET) {
        openStack.push(OPENBRRACKET);
      } else if (expression.charAt(i) == CLOSEBRRACKET) {
        openStack.pop();
        if (openStack.isEmpty()) {
          closePosition = i;
          break;
        }
      }
    }
    if (closePosition != 0) {
      //Remove '(' and ')'
      String subExpression = expression.substring(1, closePosition);
      System.out.println(">>>>> subExpression: " + subExpression);
      return subExpression;
    }
    return expression;
  }

  private double add(double a, double b) {
    return a + b;
  }

  private double minus(double a, double b) {
    return a - b;
  }

  private double multiply(double a, double b) {
    return a * b;
  }

  private double divide(double a, double b) {
    if(b==0){
      throw new ArithmeticException("Devid");
    }
    return a / b;
  }

  private double sqrt(double a) {
    return Math.sqrt(a);
  }

}