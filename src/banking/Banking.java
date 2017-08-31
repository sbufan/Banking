package banking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Banking {
    public static void main(String[] args) {
        List<Bank> banks = initialize();

        BankOperations.getAllCredits(banks, Credit.Type.HOUSE);
        BankOperations.selectCredits(banks, 2.9, 11.5);
        BankOperations.selectCredits(banks, 2.9, 11.5, 60, 90);

    }

    public static List<Bank> initialize() {
        List<Bank> banks = new ArrayList<>();
        banks.add(new Bank("bank1", "Lviv", new HashSet<>(
                Arrays.asList(
                new Credit("credit11", Credit.Type.HOUSE, Credit.Currency.UAH, 12, false, 50),
                new Credit("credit12", Credit.Type.CAR, Credit.Currency.USD, 3, true, 60),
                new Credit("credit13", Credit.Type.HOUSE, Credit.Currency.UAH, 10, false, 70))
        )));

        banks.add(new Bank("bank2", "Lviv", new HashSet<>(
                Arrays.asList(
                new Credit("credit21", Credit.Type.REGULAD, Credit.Currency.UAH, 11, true, 80),
                new Credit("credit22", Credit.Type.CAR, Credit.Currency.USD, 3, false, 90),
                new Credit("credit23", Credit.Type.HOUSE, Credit.Currency.EUR, 2, true, 100))
        )));
        return banks;
    }
}
