package validate;

import utils.StringUtils;

public class ValidateExpression {

  public static boolean isExpressionValid(String express) {
    String expression = express;
    if (expression == null || "".equals(expression)) {
      return false;
    }
    boolean isValid = true;
    expression = expression.replace('+', '-');
    expression = expression.replace('*', '-');
    expression = expression.replace('/', '-');
    if (expression.startsWith("-") || expression.endsWith("-") || expression.contains("--")
        || expression.contains("(-") || expression.contains("-)")
        || isOpenEqualClose(expression)) {
      isValid = false;
    }
    return isValid;
  }

  private static  boolean isOpenEqualClose(String expression) {
    int openCount = StringUtils.countMatches(expression, '(');
    int closeCount = StringUtils.countMatches(expression, ')');
    return openCount == closeCount;
  }

  public static  boolean isResult(String result) {
    if (result == null || "".equals(result) || result.contains("+") || result.contains("-")
        || result.contains("*") || result.contains("/") || result.contains("(") || result
        .contains(")")) {
      return false;
    }
    return true;
  }
}
