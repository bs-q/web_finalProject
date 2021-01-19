package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItems implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7830256341344206044L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemsId;

    private Integer cartItemsSize;

    private Integer cartItemsQuantity;

    @OneToOne(fetch = FetchType.EAGER)
    private Shoes shoes;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;

    public CartItems(Integer cartItemsSize, Integer cartItemsQuantity, Shoes shoes) {
        this.cartItemsSize = cartItemsSize;
        this.cartItemsQuantity = cartItemsQuantity;
        this.shoes = shoes;
    }

    public CartItems() {
    }

    public Integer getCartItemsSize() {
        return cartItemsSize;
    }

    public void setCartItemsSize(Integer cartItemsSize) {
        this.cartItemsSize = cartItemsSize;
    }

    public Integer getCartItemsQuantity() {
        return cartItemsQuantity;
    }

    public void setCartItemsQuantity(Integer cartItemsQuantity) {
        this.cartItemsQuantity = cartItemsQuantity;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public Integer getCartItemsId() {
        return cartItemsId;
    }

    public void setCartItemsId(Integer cartItemsId) {
        this.cartItemsId = cartItemsId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
