package exemples;

import java.util.Collection;

public class Table{
    private Collection<Integer> collection;

    public void setCollection(Collection<Integer> collection){
        this.collection = collection;
    }
    public void ajouter(int i){
        collection.add(i);
    }
    public int taille(){
        return collection.size();
    }
}
