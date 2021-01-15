package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Color implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 3856935856850484939L;
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    // @MapsId("id")
    private Shoes shoes;

    private String color;

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
}
