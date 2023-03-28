package lt.viko.eif.neinoris.auctions.model;

import jakarta.persistence.*;


@Entity
@Table(name = "item")
public class Item {


    public Item(){};
    public Item(int id, String name, Category category, Pricing pricing)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.pricing = pricing;
    }
    public Item(String name, Category category, Pricing pricing)
    {
        this.name = name;
        this.category = category;
        this.pricing = pricing;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;

    @OneToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
    private Category category;

    @OneToOne(targetEntity = Pricing.class, cascade = CascadeType.ALL)
    private Pricing pricing;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing auctionDetails) {
        this.pricing = auctionDetails;
    }

    @Override
    public String toString() {
        return String.format("Item name = %s\n\t\tCategory = %s\n\t\tPricing: Cur.Price = %f, min.Bid = %f, startPrice = %f"
        , this.name, this.category, this.pricing.getCurrentPrice(), this.pricing.getMinimumBid(), this.pricing.getStartingPrice());
    }
}
