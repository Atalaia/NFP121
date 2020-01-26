package singleton;


public class TableSingletonTest extends junit.framework.TestCase{

    public void testSingleton(){
      TableSingleton table1 =  TableSingleton.getInstance();
      assertNotNull(table1);
      TableSingleton table2 =  TableSingleton.getInstance();
      assertNotNull(table2);
      assertSame(table1,table2);
      //TableSingleton t = new TableSingleton();
    }
    
  // Doc junit:
    // assertEquals: Asserts that two objects are equal.
    // assertSame: Asserts that two objects refer to the same object.

    public void testContenuSingleton(){
      TableSingleton table1 =  TableSingleton.getInstance();
      assertNotNull(table1);
      TableSingleton table2 =  TableSingleton.getInstance();
      assertNotNull(table2);

      table1.setContenu(new int[]{1,2,3,4});
      assertEquals(table1.getContenu(),table2.getContenu());
      
      table2.setContenu(new int[]{5,4,3,2});
      assertEquals(table1.getContenu(),table2.getContenu());
    }
    

    

}

