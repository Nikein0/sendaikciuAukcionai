package lt.viko.eif.neinoris.auctions.model;


import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public Category(){}
    public Category(String name, int id){
        this.id = id;
        this.name = name;
    }
    public Category(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
