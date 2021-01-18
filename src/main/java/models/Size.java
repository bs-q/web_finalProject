/*
 * File Created: Monday, 18th January 2021 8:31:38 am
 * Author: Bui Si Quan (18110041@student.hcmute.edu.vn)
 * -----
 */
package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Size implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3706679396779032653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sizeId;

    private Integer size;

    @ManyToOne
    private Shoes shoes;

    private Integer available;

    public Size() {
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
    

}
