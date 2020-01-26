

public class Client{

    public static void main(String[] args) throws Exception{
      Prise priseC = new Adaptateur(new PlugRCA());
      // priseC C comme � la compilation
      // la prise est d�cid�e � la compilation
      priseC.peritel();
      // ou bien
      //Prise prise = new Adaptateur(new RCANew());
      // ou ...
      
      // Nous voulons generer la prise � partir
      // d'un fichier de configuration, dont le contenu pourrait �tre
      // classe_a_adapter=PlugRCA
      //String nomDuFichier = "config.props";
      String nomDuFichier = "README.TXT"; // pour les tests ...
      Prise prise = (Prise)Configuration.genererAdaptateur(nomDuFichier);
      prise.peritel();
      
    }
}
