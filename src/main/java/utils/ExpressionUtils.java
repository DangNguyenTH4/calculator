package utils;

import java.util.Map;
import model.OperatorElement;

public class ExpressionUtils {

  public static  boolean isResult(String result) {
    if (result == null || "".equals(result) || result.contains("+") || result.contains("-")
        || result.contains("*") || result.contains("/") || result.contains("(") || result
        .contains(")")) {
      return false;
    }
    return true;
  }

  /**
   *
   * @param expression
   * @return
   */
  public static OperatorElement getFirstOperator(String expression){
    OperatorElement fistOperator = null ;
    if(StringUtils.isEmpty(expression)){
      return new OperatorElement();
    }
    char tempChar ;
    for(int i=0;i<expression.length();i++){
      tempChar = expression.charAt(i);
      if(isAddOperator(tempChar) || isMinusOperator(tempChar)){
        fistOperator = new OperatorElement();
        fistOperator.setOperator(tempChar);
        fistOperator.setPosition(i);
        break;
      }
    }
    if(fistOperator!=null){
      return fistOperator;
    }
    for(int i=0;i<expression.length();i++){
      tempChar = expression.charAt(i);
      if(isMultipleOperator(tempChar) || isDeviceOperator(tempChar)){
        fistOperator = new OperatorElement();
        fistOperator.setOperator(tempChar);
        fistOperator.setPosition(i);
        break;
      }
    }
    return fistOperator;
  }

  /**
   * @param c
   * @return
   */
  private static boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
  }

  private static boolean isAddOperator(char c) {
    return c == '+';
  }

  private static boolean isMinusOperator(char c) {
    return c == '-';
  }

  private static boolean isMultipleOperator(char c) {
    return c == '*';
  }

  private static boolean isDeviceOperator(char c) {
    return c == '/';
  }

  public static int getFirstOpen(String expression) {
    if (StringUtils.isEmpty(expression)) {
      return -1;
    }
    return expression.indexOf(')');
  }
}
