package singleton;


public final class TableSingleton{

    private TableSingleton(){} //le constructeur est privé

    private static TableSingleton instance=null;
    
    public static TableSingleton getInstance(){
        if(instance==null)
          instance = new TableSingleton();
        return instance;
    }
    
    
    
    // ---------------------------------------------------
    
    private int[] contenu;
    public void setContenu(int[] contenu){
        this.contenu = contenu;
    }
    
    public int[] getContenu(){
        return this.contenu;
    }
    
    
    
    // environnement avec threads...
    public static TableSingleton getInstanceSafe(){
      synchronized(instance){ // ou synchronized(TableSingleton.class)
          if(instance==null)
          instance = new TableSingleton();
        return instance;
      }
    }
}
