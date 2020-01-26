package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");

    private Pile p;

    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("empiler")){
            try{
            //on empile l'objet introduit dans le champ JTextField donnee
            p.empiler(donnee.getText());
            //on affiche le contenu de la pile en bas dans le JLabel contenu
            contenu.setText(p.toString());
            
            }catch(PilePleineException ppe){
                //quand l'exception PilePleineException est levée, on affiche un message
                //avec le contenu de la pile + "estPleine !"
                contenu.setText(p.toString() + " estPleine !");
            }
        }else{
            try{
            //on depile et on affiche le sommet qu'on vient de depiler dans le champ JTextField sommet
            sommet.setText(p.depiler().toString());
            //on affiche le contenu de la pile en bas dans le JLabel contenu
            contenu.setText(p.toString());
            
            }catch(PileVideException pve){
                //quand l'exception PileVideException est levée, on affiche un message
                //avec le contenu de la pile + "estVide !"
                contenu.setText(p.toString() + " estVide !");
            }
        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
