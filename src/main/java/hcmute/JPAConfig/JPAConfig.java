package hcmute.JPAConfig;

import javax.persistence.*;

public class JPAConfig {

public static EntityManager getEntityManager() {

EntityManagerFactory factory = Persistence.createEntityManagerFactory("banhang");

return factory.createEntityManager();

}

}
