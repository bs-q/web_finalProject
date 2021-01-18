package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Image implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 9219679831719628806L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    // image can be fetch from other server or current connected database

    private String imageOut;

    private byte[] imageIn;

    @OneToOne(fetch = FetchType.LAZY)
    private Shoes shoes;

    public Image() {
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageOut() {
        return imageOut;
    }

    public void setImageOut(String imageOut) {
        this.imageOut = imageOut;
    }

    public byte[] getImageIn() {
        return imageIn;
    }

    public void setImageIn(byte[] imageIn) {
        this.imageIn = imageIn;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

}
