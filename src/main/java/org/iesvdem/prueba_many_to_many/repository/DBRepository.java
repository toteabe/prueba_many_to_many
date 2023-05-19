package org.iesvdem.prueba_many_to_many.repository;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DBRepository {

    @Autowired
    private EntityManager em;

    @Transactional
    public int truncateAllTablesInDatabase() {

       List<String> tables= em.createNativeQuery("SHOW TABLES").getResultList();
       em.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
       int eliminatedRecords = 0;
       for (String table: tables) {
           eliminatedRecords = em.createNativeQuery("TRUNCATE " + table).executeUpdate();
       }
       em.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();

       return eliminatedRecords;
    }
}
