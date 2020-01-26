import java.util.Iterator;

public abstract class IncompleteCollection<E> implements CollectionI<E>{
    public abstract boolean ajouter(E e);

    public abstract Iterator<E> iterator();

    public boolean ajouter(CollectionI<E> c){
        boolean res = false;

        Iterator<E> e = c.iterator();//iterator() défini dans la classe concrète Sac<E>
        while(e.hasNext())
        {
            if (ajouter(e.next())) //ajouter défini dans la classe concrète Transpa 46
                res = true;
            else
                res = false;
        }
        return res;
    }

    public boolean supprimer(E e){
        if(e==null) throw new NullPointerException();

        Iterator<E> it = this.iterator();
        if(e!=null)
        {
            while(it.hasNext())
            {
                if(e.equals(it.next())){
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean supprimer(CollectionI<E> c){
        boolean res = false;

        Iterator<E> e = iterator();
        while(e.hasNext()){
            if(c.contient(e.next()))
            { //appel de contains
                e.remove();
                res = true;
            }
        }
        return res;
    }

    public boolean contient(E e){
        Iterator<E> it = iterator();
        if(e == null){
            //si l'element est egale a null
            while(it.hasNext())
                if(it.next()==null)
                //alors usage de ==
                    return true;
        }else{
            while(it.hasNext())
                if(e.equals(it.next()))
                //sinon usage de equals
                    return true;
        }

        return false;
    }
    //transpa 44
    public boolean contient(CollectionI<E> c){
        for (E e : c){ //pour tout element e de la CollectionI<E>
            //pour tout element e de c qui est de type CollectionI<E>
            if(!contient(e))
                return false;
        }
        return true;
    } 

    public boolean equals(Object o){
        if(o==null || !(o instanceof CollectionI)) return false;
        CollectionI<E> c = (CollectionI<E>)o;
        // à compléter
        return false;
    }

    public int hashCode(){
        int res = 0;

        // à compléter

        return res;
    }

    public int taille(){
        int res = 0;
        // à compléter
        return res;
    }

    public String toString(){
        String str = "[";
        // à compléter
        return str + "]";
    }

}
/**
 * Interface CollectionI<E>
 * 
 * Classe Abstract
 * IncompleteCollection<E>
 * ajouter(CollectionI E){
 * //parcour collection
 * Iterator<E> e = itr.tr();
 * //ajouter
 * }
 * Question 1
 * 
 * classe contrète
 * Sac<E>
 * iterator()
 * ajouter(E e)
 * question 2
 * 
 * Transparent 44, 45, 46, 47, 48 Collection(Template Iterator)
 * 46 > ajouter / addAll
 * 47 > removeAll
 */