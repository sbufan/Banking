package banking;

public class Credit {
    private String name;
    private Type type;
    private Currency currency;
    private float loanRate;
    private boolean canBeRepay;
    private int termInDays;

    public Credit(String name, Type type, Currency currency, float loanRate, boolean canBeRepay, int termInDays) {
        this.name = name;
        this.type = type;
        this.currency = currency;
        this.loanRate = loanRate;
        this.canBeRepay = canBeRepay;
        this.termInDays = termInDays;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Currency getCurrency() {
        return currency;
    }

    public float getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(float loanRate) {
        this.loanRate = loanRate;
    }

    public boolean isRepayed() {
        return canBeRepay;
    }

    public void setCanBeRepay(boolean canBeRepay) {
        this.canBeRepay = canBeRepay;
    }

    public int getTermInDays() {
        return termInDays;
    }

    public void setTermInDays(int termInDays) {
        this.termInDays = termInDays;
    }

    public enum Type {
        REGULAD,
        HOUSE,
        CAR,
        WEDDING
    }

    public enum Currency {
        UAH,
        USD,
        EUR
    }
}
