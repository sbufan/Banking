package banking;

import java.util.Set;

public class Bank {
    private String name;
    private String address;
    private Set<Credit> credits;


    public Bank(String name, String address, Set<Credit> credits) {
        this.name = name;
        this.address = address;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Credit> getCredits() {
        return credits;
    }

    public void setCredits(Set<Credit> credits) {
        this.credits = credits;
    }
}
