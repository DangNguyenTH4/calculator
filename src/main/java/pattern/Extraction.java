package pattern;

public interface Extraction<I extends  Object, O extends  Object> {

  O extract(I inObject, Object... cusArgs);
}
