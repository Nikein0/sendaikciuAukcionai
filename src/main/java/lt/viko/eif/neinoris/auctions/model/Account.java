package lt.viko.eif.neinoris.auctions.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String username;

    public Account(){};
    public Account(int id, String username)
    {
        this.id = id;
        this.username = username;
    }
    public Account(String username)
    {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("Username: %s", this.username);
    }
}
