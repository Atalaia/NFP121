package chain_of_responsability;



public abstract class Handler<T>{
  private Handler<T> successor;
  
  public void setSuccessor(Handler<T> successor){
      this.successor = successor;
  }
  
  public boolean handleRequest(T t){
    if ( successor == null )  return false;
    return successor.handleRequest(t);
  }
}
