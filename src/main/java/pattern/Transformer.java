package pattern;

public interface Transformer<I extends  Object> {

  Object transform(I inObject,Object... cusArgs);

}
