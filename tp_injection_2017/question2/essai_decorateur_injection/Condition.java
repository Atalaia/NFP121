package question2.essai_decorateur_injection;

public interface Condition<C,E>{
    public boolean estSatisfaite(C contexte, E entite);
}
