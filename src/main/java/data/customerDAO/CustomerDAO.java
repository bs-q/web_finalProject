package data.customerDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import data.util.DButil;
import models.Customer;

/**
 * This class support insert, update, select, validating customer
 */
public class CustomerDAO {

    /**
     * Insert customer entity to database by using EntityManager
     * 
     * @param customer
     */
    public static void insertCustomer(Customer customer) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    /**
     * Update customer entity
     * 
     * @param customer
     */
    public static void updateCustomer(Customer customer) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            trans.begin();
            em.merge(customer);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Select customer from database using criteria API
     * 
     * @param email
     * @return return null if customer entity is not stored in database, or an customer entity
     */
    public static Customer selectCustomer(String email) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        CriteriaQuery<Customer> cq = em.getCriteriaBuilder().createQuery(Customer.class);
        Root<Customer> customer = cq.from(Customer.class);
        try {
            cq.select(customer).where(em.getCriteriaBuilder().equal(customer.get("customerEmail"), email));
            return DButil.getEntityManagerFactory().createEntityManager().createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Check customer input 
     * @param email
     * @return true if the email is registered, else false
     */
    public static boolean emailExist(String email) {
        Customer customer = selectCustomer(email);
        return customer != null;
    }

    /**
     * Check validity of customer
     * @param email
     * @param password
     * @return true if customer is valid, or false
     */
    public static boolean validCustomer(String email, String password) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        CriteriaQuery<Customer> q = em.getCriteriaBuilder().createQuery(Customer.class);
        Root<Customer> customer = q.from(Customer.class);
        q.select(customer).where(em.getCriteriaBuilder().equal(customer.get("customerEmail"), email),
                em.getCriteriaBuilder().equal(customer.get("customerPassword"), password));

        try {
            em.createQuery(q).getSingleResult().equals(null);
            return true;
        } catch (PersistenceException exception) {
            return false;
        } finally {
            em.close();
        }

    }

}
