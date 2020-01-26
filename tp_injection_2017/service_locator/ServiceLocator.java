package service_locator;

import java.util.*;
import container.*;

public class ServiceLocator implements ServiceLocatorI{
   
  private List<ApplicationContext> containers;
  private Map<String,Object> cache; 
  
  public ServiceLocator(){
    this.containers = new ArrayList<ApplicationContext>();
    this.cache = new HashMap<String,Object>();
  }
  
  public <T> T lookup(String serviceName) throws Exception{
    T t = (T) cache.get(serviceName);
    if(t==null){
      for(ApplicationContext container : containers){
        for( String bean : container){
          if(serviceName.equals(bean)){ // en cas de doublon, le premier de la liste
            Object service = container.getBean(bean);
            cache.put(serviceName, service);
            return (T)service;
          }
        }
      }
      throw new Exception(" service not found");
    }
    return (T)cache.get(serviceName);
  }
  
  
  public void setContainer(ApplicationContext container) throws Exception{
    try{
        containers.add(container);
    }catch(Exception e){
        throw e;
    }
  }
  
  private List<String> services(){
     List<String> services = new ArrayList<String>();
     for(ApplicationContext container : containers)
         for(String bean : container)
             services.add(bean);
 
     return services;
  }
     
  public Iterator<String> iterator(){
      return services().iterator();
  }
}
    
    


