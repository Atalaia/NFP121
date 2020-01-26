package question3;

import question1.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import question2.*;

public class IHMFahrenheit extends JFrame implements ActionListener{
    private JTextField entree = new JTextField( 6 );
    /** Le bouton de conversion. */
    private JButton  boutonDeConversion = new JButton( "convertir" );
    /** La sortie en degré Celsius. */
    private JTextField sortie = new JTextField( 6 );

    public IHMFahrenheit(){
        super("IHM Fahrenheit");

        setLayout(new FlowLayout());
        add( entree ); add( boutonDeConversion ); add( sortie );
        sortie.setEditable( false );
        getContentPane().setBackground( Color.pink );
        setLocation(100,100);
        pack();setVisible(true);

        boutonDeConversion.addActionListener( this );
    }

    /** 
     * méthode déclenchée lorsque le bouton de conversion est appuyé. 
     * remarquer que le champs de droite (les degrés Celsius) n'est pas éditable.
     * @param ae l'événement transmis
     */
    public void actionPerformed( ActionEvent ae ){
        try{
            int fahrenheit = 0; // valeur est une String et doit être convertie en entier, voir java.lang.Integer méthode parseInt (--> try/catch)
            float celsius = 0F; // à compléter, en appelant la méthode ad'hoc de la question2

            //récupérer le contenu dans le JTextfield entree
            String f = entree.getText();
            //transformer le String en int
            fahrenheit = java.lang.Integer.parseInt(f);
            //passer le int en paramètre de la méthode fahrenheitEnCelsius
            celsius = fahrenheitEnCelsius(fahrenheit);
            // un test ici pour le zéro absolu (-273.1)
            if(celsius < -273.1F) celsius = -273.1F;
            //afficher le résultat en celsius dans le JTextField de sortie
            sortie.setText( Float.toString( celsius));
        }catch(NumberFormatException nfe){
            sortie.setText("error ! ");
        }
    }

    public static void main(String[] args){
        new IHMFahrenheit();
    }

    //Je reprend la méthode de la question 2
    public static float fahrenheitEnCelsius( int f){
        float celsius = (float)5/9 * (f -32);

        return celsius; 
    }
}
