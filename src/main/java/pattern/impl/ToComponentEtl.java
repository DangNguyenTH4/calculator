package pattern.impl;

import StackExpression.StackComponentExpression;
import StackExpression.StackElementExpression;
import pattern.Etl;
import pattern.Extraction;
import pattern.Loader;
import pattern.Transformer;

public class ToComponentEtl implements Etl<String, StackComponentExpression> {

  @Override
  public Object extract(String inObject, Extraction extraction, Object... cusArgs) {
        // validate inObject
    if (inObject == null) {
      return null;
    }

    if (extraction == null) {
      return inObject;
    }

    return extraction.extract(inObject, cusArgs);
  }

  @Override
  public Object transform(Object inObject, Transformer transformer, Object... cusArgs) {
        // validate inObject
    if (inObject == null) {
      return null;
    }

    if (transformer == null) {
      return inObject;
    }

    return transformer.transform(inObject, cusArgs);
  }

  @Override
  public StackComponentExpression load(Object inObject, Loader loader, Object... cusArgs) {
    // validate inObject
    if (inObject == null) {
      return null;
    }

    if (loader == null) {
      return (StackComponentExpression) inObject;
    }

    Object output = loader.load(inObject, cusArgs);
    return (StackComponentExpression) output;
  }


}
