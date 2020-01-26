package container;

import java.io.*;
import java.util.*;
import javax.swing.JFrame;

public class FileSystemPropsApplicationContextTest extends junit.framework.TestCase{

  public void testLectureFichierProperties() throws Exception{
    InputStream inputStream = new FileInputStream(new File("./container/README.TXT"));
    FileSystemPropsApplicationContext ctx = new FileSystemPropsApplicationContext(inputStream);
    
    List<String> liste = new ArrayList<String>();
    for(String bean : ctx){
        liste.add(bean);
    }
    assertTrue(liste.contains("list"));
    assertTrue(liste.contains("set"));
    
    assertEquals(ArrayList.class, ctx.getType("list"));
    assertEquals(TreeSet.class, ctx.getType("set"));
    


    
    assertTrue(liste.contains("container"));
    assertEquals(FileSystemPropsApplicationContext.class, ctx.getType("container"));
    
    FileSystemPropsApplicationContext ctxExemples = ctx.getBean("container");
    
    liste.clear();
    for(String bean : ctxExemples){
        liste.add(bean);
    }
    
    assertTrue(liste.contains("movieLister"));
    martin_fowler.MovieLister lister = ctxExemples.getBean("movieLister");
    List<martin_fowler.Movie> movies = lister.moviesDirectedBy("Sergio Leone");
    assertEquals("Once Upon a Time in the West",movies.get(0).getTitle());

  }


}

