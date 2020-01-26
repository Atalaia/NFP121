package container;



public class FactoryTest extends junit.framework.TestCase{
 
    
    public void testFactory(){
       ApplicationContext ctx = Factory.createApplicationContext("./proxy/README.TXT");
       // pour le moment ...
       assertEquals(FileSystemPropsApplicationContext.class,ctx.getClass());
    }
}
