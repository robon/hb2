package eu.onak.hb2;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ItemService {
    @PersistenceContext
    private EntityManager em;


    public void readData() throws SQLException {
        System.out.println("readData");
        List<Item> items = em.createQuery("select i from Item i").getResultList();
        for (Item i: items) {
            System.out.println(i.toString());
        }

        List<Person> persons = em.createQuery("select i from Person i").getResultList();
        for (Person p: persons) {
            System.out.println(p.toString());
        }

        em.close();
    }

    public void addItems() {

        Item item1 = new Item();
        item1.setName("Karol");
        em.persist(item1);

        Item item2 = new Item();
        item2.setName("Wojtek");
        em.persist(item2);

        Item item3 = new Item();
        item3.setName("Wiola");
        em.persist(item3);

        String sql = "select i from Item i where i.id = :id";
        Item item4 = (Item) em.createQuery(sql).setParameter("id", 258L).getSingleResult();
        item4.setName("Aktualizacja danych: " + item4.getName());
        em.persist(item4);

        em.close();

    }

    public void setPerson() {
        Address address = new Address();
        address.setStreet("Leśna");
        address.setNumber("12A");
        address.setCode("22-198");

        Person person = new Person();
        person.setName("Kowalski");
        person.setAddress(address);

        em.persist(person);
    }
}
