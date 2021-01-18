/*
 * File Created: Saturday, 16th January 2021 7:08:09 pm Author: Bui Si Quan
 * (18110041@student.hcmute.edu.vn) -----
 */
package data.shoesDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import data.util.DButil;
import models.Shoes;

public class ShoesDAO {
    
    public static List<Shoes> retrieveAllShoes(){
        EntityManager em = DButil.getEntityManagerFactory().createEntityManager();
        CriteriaQuery<Shoes> cq = em.getCriteriaBuilder().createQuery(Shoes.class);
        Root<Shoes> customer = cq.from(Shoes.class);
        try {
            cq.select(customer);
            return DButil.getEntityManagerFactory().createEntityManager().createQuery(cq).getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
