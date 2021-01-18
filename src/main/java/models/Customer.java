package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5999543277828065178L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerPassword;
    private String customerPhone;
    private String customerRole;
    private String customerAddress;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<WishList> wishList;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> cart;

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerRole() {
        return customerRole;
    }

    public void setCustomerRole(String customerRole) {
        this.customerRole = customerRole;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Customer(String customerFirstName, String customerLastName, String customerEmail, String customerPassword,
            String customerPhone, String customerRole, String customerAddress) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerPhone = customerPhone;
        this.customerRole = customerRole;
        this.customerAddress = customerAddress;
    }

    public List<WishList> getWishList() {
        return wishList;
    }

    public void setWishList(List<WishList> wishList) {
        this.wishList = wishList;
    }
}
