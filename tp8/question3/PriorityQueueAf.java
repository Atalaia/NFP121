package question3;


import question3.fifo.*;

public class PriorityQueueAf extends QueueAf{
  
  public PriorityQueueAf( QueueI q){
    super(q);
    assert q instanceof PriorityQueueImpl : " QueueAf invalide !";
   // assert true : " QueueAf invalide !";
  }

 

}
