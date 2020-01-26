package composant_logiciel;
import java.util.concurrent.SynchronousQueue;
public class Composants<T> implements ComposantI<T>{
  private Command<T> command;
  private Command<T> exception;
  private Composant<T>[] composants;

  public void setComposants(Composant<T>[] composants){
      this.composants = composants;
  }
  
  public SynchronousQueue<T> getIn(){
      return composants[0].getIn();
  }
  public SynchronousQueue<T> getOut(){
      return composants[composants.length-1].getOut();
  }
  
  public boolean isAlive(){
      for(ComposantI<T> composant: composants){
          if(!composant.isAlive())return false;
      }
      return true;
    }
  public void start(){
    for(ComposantI<T> composant: composants){
        try{
            if(!composant.isAlive())composant.start();
        }catch(Exception e){}
    }
  }
  // à terminer, à vérifier ...
  public void stop(){
    for(ComposantI<T> composant: composants){
        try{
            composant.stop();
        }catch(Exception e){}
    }
  }
  
}
