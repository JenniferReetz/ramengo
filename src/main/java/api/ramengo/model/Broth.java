package api.ramengo.model;

import api.ramengo.dto.BrothDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="broths")
public class Broth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    private String description;
    private Integer price;
    @OneToMany(mappedBy = "broth")
    private List<Order> order;
    public Broth() {
    }

    public Broth(BrothDTO dto) {
        this.id = dto.id();
        this.image = dto.image();
        this.name = dto.name();
        this.description = dto.description();
        this.price = dto.price();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
