package api.ramengo.model;

import api.ramengo.dto.ProteinDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="proteins")
public class Protein {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    private String description;
    private Integer price;
    @OneToMany(mappedBy = "protein", fetch = FetchType.LAZY)
    private List<Order> orders;
    public Protein() {
    }

    public Protein(ProteinDTO dto) {
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
