package lt.viko.eif.neinoris.auctions.model;

import jakarta.persistence.*;

@Entity
@Table(name = "wonItem")
public class WonItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @OneToOne
    private Item item;

    public WonItem(){}
    public WonItem(int id, Item item){
        this.id = id;
        this.item = item;
    }
    public WonItem(Item item){
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
