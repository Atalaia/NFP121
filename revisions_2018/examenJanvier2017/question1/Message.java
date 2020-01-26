package examenJanvier2017.question1;


public class Message{
  //private long timeStamp;
  private String source;
  private String content;

  public Message(String source, String content){
    this.source = source;
    this.content = content;
  }

  public String getSource(){
    return source;
  }

  public String getContent(){
    return content;
  }
  
  public String toString(){
    return "<" + source + ", " + content + ">";
  }

}
