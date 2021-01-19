/*
 * File Created: Friday, 15th January 2021 10:19:15 am
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 * Last Modified: Friday, 15th January 2021 10:19:48 am
 */

package data.cartDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import data.util.DButil;
import models.Cart;
import models.CartItems;

public class CartDao {

    public static Cart selectCartById(Integer id) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        return em.find(Cart.class, id);
    }

    public static List<CartItems> retrieveAllItemsInCart(Integer id) {
        return selectCartById(id).getCartItems();
    }

    public static void addCartItems(Cart c, CartItems i) {

        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        i.setCart(c);
        trans.begin();
        try {
            em.merge(i);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static boolean insertCart(Cart cart) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        em.close();
        return true;
    }

    public static boolean updateCart(Cart cart) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(cart);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
            return false;
        }
        em.close();
        return true;
    }

    public static Cart selectCartByEmailAndStatus(String email,boolean status) {
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        String qString = "select u from Cart u where u.customer.customerEmail=:email and u.status=:status";
        TypedQuery<Cart> q = em.createQuery(qString, Cart.class);
        q.setParameter("email", email);
        q.setParameter("status", status);
        Cart cart = null;
        try {
            cart = q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return cart;
    }
    public static List<CartItems> retrieveAllItemInCart(String email,boolean status) { 
        return selectCartByEmailAndStatus(email, status).getCartItems();
    }
}
