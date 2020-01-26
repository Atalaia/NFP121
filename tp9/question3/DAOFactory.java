package question3;

import java.io.File;
// http://best-practice-software-engineering.ifs.tuwien.ac.at/patterns/dao.html

public class DAOFactory{
   
  public static DAO<Auditeur,Integer> getAuditeurDAO(String type) throws Exception{
    if(type.equals("file"))
      return new FileAuditeurDAO("."+File.separator+"question3"+File.separator+"tests"+File.separator, "auditeurs.txt");
//     else if(type.equals("jdbc"))
//       // cf. http://hsqldb.org/
//       return new DBAuditeurDAO("org.hsqldb.jdbcDriver","jdbc:hsqldb:auditeurs");
    
    return null;
  }
  
//   public static DAO<Entity,Integer> getEntityDAO()throws Exception{
//     return new FileEntityDAO("entities.txt");
//   }
  
}
