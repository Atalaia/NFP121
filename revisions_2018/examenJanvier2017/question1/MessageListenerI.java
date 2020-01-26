package examenJanvier2017.question1;




public interface MessageListenerI{
  /** Méthode déclenchée à chaque réception d'un message.
   * @param source l'émetteur du message
   * @param message le message reçu.
   * @throws Exception si le destinataire est injoignable
   */
  public void onMessage(Message message) throws Exception;
}
