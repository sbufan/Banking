package banking;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class BankOperations {
    private BankOperations() { }

    public static void getAllCredits(List<Bank> banks, Credit.Type type) {
        List<Pair<Bank, Credit>> credits = new ArrayList<>();
        for (Bank bank : banks) {
            for (Credit credit : bank.getCredits()) {
                if (credit.getType().equals(type)) {
                    credits.add(new Pair<>(bank, credit));
                }
            }
        }

        printCredits(credits);
    }

    public static void selectCredits(List<Bank> banks, Double loanRateMin, Double loanRateMax,
                                     Integer termInDaysMin, Integer termInDaysMax) {
        List<Pair<Bank, Credit>> credits = new ArrayList<>();
        boolean isLoanRateNotSpecified = loanRateMin == null && loanRateMax == null;
        boolean isTermInDaysNotSpecified = termInDaysMin == null && termInDaysMax == null;
        for (Bank bank : banks) {
            for (Credit credit : bank.getCredits()) {
                if (selectTerms(termInDaysMin, termInDaysMax, credit, isLoanRateNotSpecified)
                        || selectLoanRange(loanRateMin, loanRateMax, credit, isTermInDaysNotSpecified)
                        || selectLoanRangeAndTerms(loanRateMin, loanRateMax, termInDaysMin, termInDaysMax, credit)) {
                    credits.add(new Pair<>(bank, credit));
                }
            }
        }

        printCredits(credits);
    }
    public static void selectCredits(List<Bank> banks, Double loanRateMin, Double loanRateMax) {
        selectCredits(banks, loanRateMin, loanRateMax, null, null);
    }

    public static void selectCredits(List<Bank> banks, Integer termInDaysMin, Integer termInDaysMax) {
        selectCredits(banks, null, null, termInDaysMin, termInDaysMax);
    }

    private static boolean selectLoanRange(Double loanRateMin, Double loanRateMax, Credit credit, boolean isTermInDaysNotSpecified) {
        return isTermInDaysNotSpecified && isLoanRateInRange(loanRateMin, loanRateMax, credit);
    }

    private static boolean selectTerms(Integer termInDaysMin, Integer termInDaysMax, Credit credit, boolean isLoanRateNotSpecified) {
        return isLoanRateNotSpecified && isTermInDaysInRange(termInDaysMin, termInDaysMax, credit);
    }

    private static boolean selectLoanRangeAndTerms(Double loanRateMin, Double loanRateMax, Integer termInDaysMin, Integer termInDaysMax, Credit credit) {
        return isLoanRateInRange(loanRateMin, loanRateMax, credit) && isTermInDaysInRange(termInDaysMin, termInDaysMax, credit);
    }

    private static boolean isLoanRateInRange(Double loanRateMin, Double loanRateMax, Credit credit) {
        return credit.getLoanRate() > loanRateMin && credit.getLoanRate() < loanRateMax;
    }

    private static boolean isTermInDaysInRange(Integer termInDaysMin, Integer termInDaysMax, Credit credit) {
        return credit.getTermInDays() > termInDaysMin && credit.getTermInDays() < termInDaysMax;
    }

    private static void printCredits(List<Pair<Bank, Credit>> credits) {
        System.out.println("Please find next propositions:");

        for (Pair<Bank, Credit> pair : credits) {
            System.out.print(String.format("Bank: '%s', Credit: name - '%s', term of credit in days - '%s', loan rate " +
                    "- '%s', currency - '%s';",
                    pair.getKey().getName(),
                    pair.getValue().getName(),
                    pair.getValue().getTermInDays(),
                    pair.getValue().getLoanRate(),
                    pair.getValue().getCurrency()));
            System.out.println();
        }
    }
}
