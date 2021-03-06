/*
 * File Created: Sunday, 17th January 2021 9:09:42 pm
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
package data.cartItemDao;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import data.cartDao.CartDao;
import data.util.DButil;
import models.Cart;
import models.CartItems;

public class CartItemsDAO {

    /**
     * insert cart item
     * 
     * @param item
     * @return return true if transaction if complete, else false
     */
    public static boolean insertCartItem(CartItems item) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(item);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static boolean updateCartItem(CartItems item) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(item);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static boolean deleteCartItem(CartItems item) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(item);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }
}
