package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Color implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3856935856850484939L;
    @Id
    @OneToOne(fetch = FetchType.EAGER)
    // @MapsId("id")
    private Shoes shoes;

    private String color;
    private String image;

    public Color() {
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
