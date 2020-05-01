package pattern;

public interface Loader<I extends  Object,O extends  Object> {
  O load(I inObject,Object... cusArgs);

}
