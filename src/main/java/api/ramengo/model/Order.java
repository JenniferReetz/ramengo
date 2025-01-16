package api.ramengo.model;
import jakarta.persistence.*;
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Broth broth;
    @ManyToOne(fetch = FetchType.LAZY)
    private Protein protein;
    private Long externalId;

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public Order(){}
    public Order(Broth broth, Protein protein) {
        this.broth = broth;
        this.protein = protein;
    }

    public Long getId() {
        return id;
    }

    public Broth getBroth() {
        return broth;
    }

    public void setBroth(Broth broth) {
        this.broth = broth;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }
}
