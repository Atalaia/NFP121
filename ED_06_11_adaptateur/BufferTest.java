import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BufferTest
{
         
    @Test
    public void testFileEmpty(){
        CollectionI file = new Buffer(6);
        assertTrue(file.empty());
    }
    
    public void testFilePut() throws FullException,EmptyException{
        CollectionI file = new Buffer(6);
        //ajout d'un élément avec la méthode put
        file.put(10);
        //tester si la taille a bien augmenter
        assertEquals(1,file.size());
        file.put(20);
        assertEquals(10,file.get());
        assertFalse(file.empty());
    }
    
    //méthode de test pour empty()
    //créer la file 
    //tester la méthode empty
    public void test_empty(){
        Buffer b = new Buffer(5);
        assertTrue("la file est vide ?",b.empty());
    }
    
    //méthode de test pour capacity()
    public void test_capacity(){
        Buffer b = new Buffer(5);
        assertEquals(5,b.capacity());
    }
    
    //méthode de test pour put(int i) /enfiler un element dans la file
    public void test_put(){
        Buffer b = new Buffer(6);
         int size = 0;
    for(int i = 1; i<=6; i++){
      try{
        b.put(i);
        size++;
        assertEquals(size, b.size());
        assertFalse(b.empty());
      }catch(Exception e){
        fail("aucune exception n'est attendue ici !!");
      }
    }
    }
    
    //methode de test pour get() /défiler
    public void test_get(){
        Buffer b = new Buffer(6);
        assertEquals(6,b.capacity());
        assertEquals(0,b.size());
        assertTrue(b.empty());
        assertFalse(b.full());
        try{
            b.put(1);
            b.put(2);
            b.put(3);
    }catch(Exception e){
      fail("aucune exception n'est attendue ici !!");
    }
    assertFalse(b.full());
    try{
      assertEquals(1, b.get());
      assertEquals(2, b.get());
      b.put(55);
      assertEquals(3, b.get());  
      assertEquals(55, b.get());
      assertTrue(b.empty());
    }catch(Exception e){
       fail("aucune exception n'est attendue ici !!");
    }
    }
    
    //méthode de test pour size()
    
    //méthode de test pour full()
    public void test_full(){
        Buffer b = new Buffer(5);
        assertFalse("la file est pleine ?",b.full());
    }
    
}
