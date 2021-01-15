package data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import business.Customer;

public class DBconnection {


    public static void main(String[] args) throws InterruptedException {
        EntityManager entityManager =DButil.getEntityManagerFactory().createEntityManager();
        DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction trans= entityManager.getTransaction();
        trans.begin();
        // Customer cus= entityManager.find(Customer.class, 1);
        // if(cus==null){
        // System.out.print("error");
        // }
        // System.out.println(cus.getPassword().getPassword());
        trans.commit();
        entityManager.close();

        DButil.shutdown();
        // TimeUnit.MINUTES.sleep(2);
        /////////////////
        
    }


    public static void newConnection() {
        try {

            String url = "jdbc:postgresql://ec2-54-196-89-124.compute-1.amazonaws.com/d8060b5cb9ocl0?user=ioyigtkwnmarkp&password=3a7c34cabfe6f7775d6c1ac2cd46f336ef219eeb285e534c72b0a793a88b93cd";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("ok");

        } catch (Exception e) {

            System.out.print(e);
        }

    }
}
