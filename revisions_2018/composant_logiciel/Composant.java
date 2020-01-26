package composant_logiciel;

import java.util.*;
import java.util.concurrent.*;

public class Composant<T> implements ComposantI<T>, Runnable{
  private SynchronousQueue<T>   in;
  private SynchronousQueue<T>   out;
  private Command<T> command;
  private Command<T> exceptionCommand;
  private Command<T> interruptedCommand;
  
  private Thread thread=null;
  
  
  public void setIn(SynchronousQueue<T> queue){
      this.in = queue;
  }
  
  public void setOut(SynchronousQueue<T> queue){
      this.out = queue;
      this.start();
  }
  
  public SynchronousQueue<T> getIn(){return this.in;}
  public SynchronousQueue<T> getOut(){return this.out;}
  
  public void setCommand(Command<T> cmd){
    this.command = cmd;
  }
  
  public void setException(Command<T> cmd){
    this.exceptionCommand = cmd;
  }
    
  public void setInterrupted(Command<T> cmd){
    this.interruptedCommand = cmd;
  }
  
  public void start(){
      if(thread==null){
        this.thread = new Thread(this);
        this.thread.start();
    }
  }
  
  public boolean isAlive(){
      return (thread!=null && thread.isAlive());
  }
  
  public void stop(){
      try{
        if(thread!=null && thread.isAlive())thread.interrupt();
    }catch(Exception e){
    }
  }
  public void run(){
      T t = null;
      while(!thread.isInterrupted()){
          try{
              t = in.take();
              command.execute(t);
              out.offer(t);
            }catch(InterruptedException ie){
                 thread.interrupt();
            }catch(Exception e){
                if(exceptionCommand!=null) exceptionCommand.execute(t);
            }
      }
      if(interruptedCommand!=null) interruptedCommand.execute(t);
      this.thread = null;
    }  
}
