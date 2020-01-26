

public class Client2{

    public static void main(String[] args) throws Exception{

      String nomDuFichier = args[0]; // pour les tests ...
      Subject s = Configuration.newProxyInstance(nomDuFichier);
      String res = s.requete("http://jfod.cnam.fr");
      System.out.println(" res : " + res);
      res = s.requete("http://www.google.fr");
      System.out.println(" res : " + res);
      
    }
}
