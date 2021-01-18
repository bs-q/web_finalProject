package models;

import java.io.Serializable;
import java.util.List;

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
public class Shoes implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7793415300483082194L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shoesId;
    private String shoesName;
    private Float shoesPrice;

    @OneToOne(mappedBy = "shoes",fetch = FetchType.LAZY)
    private WishList wishList;

    @OneToOne(mappedBy = "shoes",fetch = FetchType.LAZY)
    private CartItems cartItems;

    @OneToOne(mappedBy = "shoes",fetch = FetchType.LAZY)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;


    @OneToMany(mappedBy = "shoes",fetch = FetchType.LAZY)
    private List<Size> size;

    public Shoes() {
    }

    public Integer getShoesId() {
        return shoesId;
    }

    public void setShoesId(Integer shoesId) {
        this.shoesId = shoesId;
    }

    public String getShoesName() {
        return shoesName;
    }

    public void setShoesName(String shoesName) {
        this.shoesName = shoesName;
    }

    public Float getShoesPrice() {
        return shoesPrice;
    }

    public void setShoesPrice(Float shoesPrice) {
        this.shoesPrice = shoesPrice;
    }

    public Shoes(String shoesName, Float shoesPrice, CartItems cartItems) {
        this.shoesName = shoesName;
        this.shoesPrice = shoesPrice;
        this.cartItems = cartItems;
    }

    public CartItems getCartItems() {
        return cartItems;
    }

    public void setCartItems(CartItems cartItems) {
        this.cartItems = cartItems;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Size> getSize() {
        return size;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }

}
