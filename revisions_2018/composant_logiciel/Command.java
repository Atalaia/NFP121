package composant_logiciel;

public interface Command<T>{
   public void execute(T t);
   public void undo(T t);
}
