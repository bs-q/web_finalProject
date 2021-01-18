package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5706300673441796274L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    private boolean status;

    private String note;

    private float total;

    private Date time;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CartItems> cartItems;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    private Shipment shipment;

    public Cart(boolean status, List<CartItems> cartItems) {
        this.status = status;
        this.cartItems = cartItems;
    }

    public Cart() {
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<CartItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItems> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getTotal() {
        float temp = 0;
        for (CartItems c : cartItems) {
            temp = temp + c.getShoes().getShoesPrice();
        }
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
