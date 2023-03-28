package lt.viko.eif.neinoris.auctions.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String surname;
    private String nickname;

    @OneToMany(targetEntity = WonItem.class, cascade = CascadeType.ALL)
    private List<WonItem> wonitems;
    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    private Account account;

    public Customer(){}

    public Customer(int id, String name, String surname, String nickname, List<WonItem> wonitems, Account account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.wonitems = wonitems;
        this.account = account;
    }
    public Customer(String name, String surname, String nickname, List<WonItem> wonitems, Account account) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.wonitems = wonitems;
        this.account = account;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public List<WonItem> getWonitems() {
        return wonitems;
    }

    public void setWonitems(List<WonItem> wonitems) {
        this.wonitems = wonitems;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
