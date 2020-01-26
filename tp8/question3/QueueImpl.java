package question3;

import java.util.*;
import question3.fifo.*;
import java.util.stream.*;

public class QueueImpl implements QueueI {
    private Queue<Integer> innerQueue;
    private int capacity;

    public QueueImpl(int capacity){
        this(capacity, new LinkedList<Integer>());
    }

    protected QueueImpl(int capacity, Queue<Integer> queueInstance){
        if(capacity <= 0){
            throw new RuntimeException();
        }
        this.capacity = capacity;
        innerQueue = queueInstance;
    }

    protected Queue<Integer> getInnerQueue(){
        return innerQueue;
    }

    public void add(int i){
        if((size() + 1) > capacity){
            throw new RuntimeException();
        }
        innerQueue.add(i);
    }

    public int capacity(){
        return capacity;
    }

    public int remove(){
        if(size() == 0){
            throw new RuntimeException();
        }
        return innerQueue.remove();
    }

    public int element(){
        if(size() == 0){
            throw new RuntimeException();
        }
        return innerQueue.element();
    }

    public void clear(){
        innerQueue.clear();
    }

    public int size(){
        return innerQueue.size();
    }

    public boolean contains(int i){
        return innerQueue.contains(i);
    }

    public Iterator<Integer> iterator(){
        return innerQueue.iterator();
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer("[");
        Iterator it = this.iterator();
        while(it.hasNext()){
            Integer item = (Integer)it.next();
            buffer.append(item);
            if(it.hasNext()){
                buffer.append(",");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public boolean equals(Object o){
        if(!(o instanceof QueueI)) return false;
        QueueImpl q = (QueueImpl)o;
        if(this.capacity()!=q.capacity())return false;
        if(this.size()!=q.size())return false;
        
        Iterator<Integer> thisIt = iterator();
        Iterator<Integer> targetIt = q.iterator();
        while(thisIt.hasNext() && targetIt.hasNext()){
            Integer i1 = thisIt.next();
            Integer i2 = targetIt.next();
            if(i1 != i2){
                return false;
            }
        }
        
        return true;
    }

    public int hashCode(){
        return toString().hashCode();
    }

    public FileI<Integer> af(){
        FileI<Integer> fifo = Fabrique.creerFile(capacity);
        for(Integer item : this){
            fifo.enfiler(item);
        }
        return fifo;
    }

    public boolean repOk(){
        return  innerQueue != null && capacity()>0 && size()<=capacity();
    }

}
