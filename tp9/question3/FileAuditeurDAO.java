package question3;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

public class FileAuditeurDAO implements DAO<Auditeur, Integer>{
    private String fileName;

    public FileAuditeurDAO(final String path, final String fileName) throws Exception{

        File dir = new File(path);
        if (!dir.exists()){ // si le répertoire n'existe pas (1 seul niveau)
            dir.mkdir();
        }
        this.fileName = path+fileName;
        File f = new File(this.fileName);
        if(!(f.isFile())){ // si le fichier n'existe pas
            f.createNewFile();
        }
    }

    public FileAuditeurDAO(final String fileName) throws Exception{
        this("."+File.separator, fileName);
    }

    public void create(Auditeur a) throws Exception{
        List<Auditeur> auditeurs = findAll();
        OptionalInt id = auditeurs.stream().mapToInt(Auditeur::getId).max();
        if (id.isPresent()) {
            a.setId(id.getAsInt() + 1);
        }
        auditeurs.add(a);
        save(auditeurs);
    }

    public Auditeur retrieve(Integer id) throws Exception{
        return findAll().stream().filter(t -> t.getId() == id).findFirst().get(); 
    }

    public List<Auditeur> findAll() throws Exception{
        return Files.lines(Paths.get(fileName)).map(t -> {
                try {
                    return Auditeur.parseAuditeur(t);
                } catch(Exception ex) {}
                return null;
            }).collect(Collectors.toList());
    }

    public void update(Auditeur a) throws Exception{
        List<Auditeur> auditeurs = findAll();
        auditeurs.removeIf(ad -> ad.getId() == a.getId());
        auditeurs.add(a);
        save(auditeurs);
    }

    public void delete(Integer id) throws Exception{
        List<Auditeur> auditeurs = findAll();
        auditeurs.removeIf(t -> t.getId() == id);
        save(auditeurs);
    }

    public List<Auditeur> filter(Criteria<Auditeur> criteria) throws Exception{
        return DAO.DAOUtils.filter(this,criteria);
    }

    private void save(List<Auditeur> auditeurs) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        try(Stream<Auditeur> st = auditeurs.stream()) {
            st.forEach(a -> {
                    try {
                        String csv = a.toString();
                        writer.write(csv);
                        writer.newLine();
                    } catch(Exception ex) {}
                });
        }  
        writer.close();
    }
}