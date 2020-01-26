package examenJanvier2017.question5;


import examenJanvier2017.question1.*;
import examenJanvier2017.question4.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.io.*;

public class IHM2 extends JFrame {

  private JTextArea         resultat = new JTextArea("", 7,60);
  private JButton           creerTheme = new JButton("cr�er ce th�me");
  private JTextField        theme = new JTextField("meteo",6);
  private JTextField        message = new JTextField("il pleut",8);
  private JButton           envoyerMessage = new JButton("envoyer ce message");
  private JTextField        souscripteur = new JTextField("s1",4);
  private JButton           ajouterSouscripteur = new JButton("ajouter ce souscripteur");
  private JButton           liste = new JButton("liste");
  private JButton           raz = new JButton("raz");
  private PublishSubscribeI pubsub;

  public class SubscriberIHM extends SimpleSubscriber{
    public SubscriberIHM(String name){
      super(name);
    }

    @Override
    public void onMessage(Message message){
      resultat.setText(resultat.getText() + "\n" + message + "\n");
    }
  }

  public IHM2() {
    this.setTitle("IHM de \"test\" class question4.PublishSubscribe");
    this.pubsub = new PublishSubscribeImpl();
    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());
    container.add(resultat, BorderLayout.NORTH);
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    panel.add(new JLabel("th�me:"));
    panel.add(theme);
    //panel.add(creerTheme);
    panel.add(new JLabel("message:"));
    panel.add(message);
    panel.add(envoyerMessage);
    panel.add(new JLabel("souscripteur:"));
    panel.add(souscripteur);
    panel.add(ajouterSouscripteur);
    panel.add(liste);
    panel.add(raz);
    container.add(panel, BorderLayout.SOUTH);

    this.ajouterSouscripteur.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            String topic = theme.getText();
            SubscriberI subscriber = new SubscriberIHM(souscripteur.getText());
            pubsub.subscribe(topic,subscriber);
            resultat.setText(subscribersList(topic));
           IHM.this.pack();
        } 
      });
      
      this.envoyerMessage.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          Message msg =new Message("ihm_test",message.getText());
          int n = pubsub.publish(theme.getText(),msg);
          resultat.setText(resultat.getText() + "\n au total " + n + " souscripteur(s)");
          IHM.this.pack();
        }
      });
      
      this.liste.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            String result = new String();
          for(String topic: pubsub){
            result = result + subscribersList(topic);
          }
          resultat.setText(result);
          IHM.this.pack();
        }            
      });
      
      this.raz.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            for(String topic: pubsub){
            Iterator<SubscriberI> it = pubsub.getSubscribers(topic).iterator();
            while(it.hasNext()){
              it.next();
              it.remove();
            }
          }
          IHM.this.pack();
        }            
      });
      
    }
    
    private String subscribersList(String topic){
    String result = "theme:" + topic + "\nSubscribers:\t"; 
    for(SubscriberI s : pubsub.getSubscribers(topic)){
      result = result + s.getName() + "\n\t";
    }
    return result +"\n";
  }
}
