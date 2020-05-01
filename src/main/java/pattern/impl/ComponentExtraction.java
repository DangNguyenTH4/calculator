package pattern.impl;

import StackExpression.StackComponentExpression;
import java.util.List;
import pattern.Extraction;

public class ComponentExtraction implements Extraction<String, List<String>> {

  /**
   * Extract expression to the list Component contain many sub expression.
   * @param inObject
   * @param cusArgs
   * @return
   */
  @Override
  public List<String> extract(String inObject, Object... cusArgs) {
    return null;
  }

}
