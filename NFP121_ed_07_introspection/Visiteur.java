import java.lang.reflect.*;

public abstract class Visiteur<T>{
  public T visite(Expression expr){
    Class<?> cl = this.getClass();
    while(cl != Object.class){
      try{
        Method m = cl.getDeclaredMethod("visite",expr.getClass());
        return (T)m.invoke(this, expr);
      }catch(Exception e){
        cl = cl.getSuperclass();
      }
    }
    throw new UnsupportedOperationException();
  }
}