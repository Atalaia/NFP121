package composant_logiciel;

import java.util.concurrent.SynchronousQueue;

public interface ComposantI<T>{
      
      public SynchronousQueue<T> getIn();
      public SynchronousQueue<T> getOut();
      
      public void start();
      public void stop();
      public boolean isAlive();

}
