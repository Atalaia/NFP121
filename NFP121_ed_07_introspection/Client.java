

public class Client{

    public static void main(String[] args) throws Exception{
      Prise priseC = new Adaptateur(new PlugRCA());
      // priseC C comme à la compilation
      // la prise est décidée à la compilation
      priseC.peritel();
      // ou bien
      //Prise prise = new Adaptateur(new RCANew());
      // ou ...
      
      // Nous voulons generer la prise à partir
      // d'un fichier de configuration, dont le contenu pourrait être
      // classe_a_adapter=PlugRCA
      //String nomDuFichier = "config.props";
      String nomDuFichier = "README.TXT"; // pour les tests ...
      Prise prise = (Prise)Configuration.genererAdaptateur(nomDuFichier);
      prise.peritel();
      
    }
}
