package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 6084206074721408964L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brandId;

    private String brandName;

    private String country;

    @OneToMany(mappedBy = "brand",fetch =FetchType.LAZY)
    private List<Shoes> shoes;

    public Brand() {
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoes> shoes) {
        this.shoes = shoes;
    }
    
}
