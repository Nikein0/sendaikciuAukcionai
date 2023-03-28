package lt.viko.eif.neinoris.auctions.model;



import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.lang.annotation.Target;
import java.util.List;

@XmlRootElement
@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String surname;
    private String nickname;


    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    private List<Item> items;
    public Seller(){};
    public Seller(int id, String name, String surname, String nickname, Account account, List<Item> items){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.account = account;
        this.items = items;
    }
    public Seller(String name, String surname, String nickname, Account account, List<Item> items){
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.account = account;
        this.items = items;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return String.format("Seller:\n\tFirst name = %s\n\tLast name = %s\n\tNickname = %s\n\t" + "Account: \n\t\t%s\n\tItems:\n\t\t%s",
                this.name, this.surname, this.nickname, this.account, constructItemString());
    }
    private String constructItemString(){
        String result = "";
        for(Item item : this.items){
            result += item.toString();
        }
        return result;
    }
}
