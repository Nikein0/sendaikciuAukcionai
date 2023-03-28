package lt.viko.eif.neinoris.auctions.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pricing")
public class Pricing {

    public Pricing(){}
    public Pricing(int id, double startingPrice, double minimumBid, double currentPrice) {
        this.startingPrice = startingPrice;
        this.minimumBid = minimumBid;
        this.currentPrice = currentPrice;
        this.id = id;
    }
    public Pricing(double startingPrice, double minimumBid, double currentPrice) {
        this.startingPrice = startingPrice;
        this.minimumBid = minimumBid;
        this.currentPrice = currentPrice;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private double startingPrice;
    private double minimumBid;
    private double currentPrice = 0.0;

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getMinimumBid() {
        return minimumBid;
    }

    public void setMinimumBid(double minimumBid) {
        this.minimumBid = minimumBid;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
