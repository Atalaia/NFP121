
import java.util.*;

public class Sac<E> extends IncompleteCollection<E>
{
    //implementer ajouter et iterator
    List<E> maListe = new ArrayList<E>();

    public  boolean ajouter(E e){

        boolean res = false;
        if(e!= null)
        {
            this.maListe.add(e);
            res = true;
        }

        return res;
    }

    public Iterator<E> iterator()
    {
        return maListe.iterator();
    }
}