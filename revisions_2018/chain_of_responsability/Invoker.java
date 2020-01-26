package chain_of_responsability;


public class Invoker<T>{
  private Handler<T>[] handlers;
  
  public void setHandlers(Handler<T>[] handlers){
      this.handlers = handlers;
  }
  
  public void envoyer(T t){
      for(Handler<T> handler: handlers){
          if(handler.handleRequest(t)) return;
      }
    }
}
