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
    /** La sortie en degr� Celsius. */
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
     * m�thode d�clench�e lorsque le bouton de conversion est appuy�. 
     * remarquer que le champs de droite (les degr�s Celsius) n'est pas �ditable.
     * @param ae l'�v�nement transmis
     */
    public void actionPerformed( ActionEvent ae ){
        try{
            int fahrenheit = 0; // valeur est une String et doit �tre convertie en entier, voir java.lang.Integer m�thode parseInt (--> try/catch)
            float celsius = 0F; // � compl�ter, en appelant la m�thode ad'hoc de la question2

            //r�cup�rer le contenu dans le JTextfield entree
            String f = entree.getText();
            //transformer le String en int
            fahrenheit = java.lang.Integer.parseInt(f);
            //passer le int en param�tre de la m�thode fahrenheitEnCelsius
            celsius = fahrenheitEnCelsius(fahrenheit);
            // un test ici pour le z�ro absolu (-273.1)
            if(celsius < -273.1F) celsius = -273.1F;
            //afficher le r�sultat en celsius dans le JTextField de sortie
            sortie.setText( Float.toString( celsius));
        }catch(NumberFormatException nfe){
            sortie.setText("error ! ");
        }
    }

    public static void main(String[] args){
        new IHMFahrenheit();
    }

    //Je reprend la m�thode de la question 2
    public static float fahrenheitEnCelsius( int f){
        float celsius = (float)5/9 * (f -32);

        return celsius; 
    }
}