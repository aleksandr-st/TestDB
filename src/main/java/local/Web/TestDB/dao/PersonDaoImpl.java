package local.Web.TestDB.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.Web.TestDB.model.Person;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO implementation for Person entity
 * 
 * @author DevCrumb.com
 */
@Transactional
public class PersonDaoImpl {
 
    @PersistenceContext
    private EntityManager em;
     
    public Long save(Person person) {
        em.persist(person);
        return person.getId();
    }
     
    public List<Person>getAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
