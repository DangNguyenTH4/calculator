package pattern;

public interface Etl<I extends Object, O extends Object> {

  default O doTemplating(I inObject, Extraction extraction, Transformer transformer, Loader loader,
      Object... cusArgs) {
    Object extractedObject = this.extract(inObject, extraction, cusArgs);
    Object transformObject = this.transform(extractedObject, transformer, cusArgs);
    return this.load(transformObject, loader, cusArgs);
  }

  Object extract(I inObject, Extraction extraction, Object... cusArgs);

  Object transform(Object inObject, Transformer transformer, Object... cusArgs);

  O load(Object inObject, Loader loader, Object... cusArgs);

}
