package console;

import comporators.CreditOverpaymentComparator;
import credits.Credit;
import filters.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Credit> allCredits = CreditReader.creditReader();
        for (Credit credit : allCredits) {
            System.out.println(credit);
        }
        allCredits.sort(new CreditOverpaymentComparator());
        ArrayList<Credit> credits = new ArrayList<>(allCredits);
        int key;
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("""
                    Choose action:
                    1) Search for credit
                    2) Show optimal credits
                    3) Choose credit
                    0) Exit program""");
            try {
                key = scanner.nextInt();
                switch (key) {
                    case 0:
                        return;
                    case 1:
                        System.out.println("""
                                Choose filter:
                                1) Search by bank name
                                2) Filter by interest rate
                                3) Filter by overpayment
                                4) Filter by term
                                5) Filter by minimal loan value
                                6) Filter by maximum loan value
                                7) Filter by credit line availability
                                8) Filter by early repayment availability
                                9) Remove filters""");
                        key = scanner.nextInt();
                        switch (key) {
                            case 1:
                                String bankName = scanner.next();
                                credits = Searcher.search(new FilterByBank(bankName), credits);
                                break;
                            case 2:
                                double interestRate = scanner.nextDouble();
                                credits = Searcher.search(new FilterByInterestRate(interestRate), credits);
                                break;
                            case 3:
                                double overpayment = scanner.nextDouble();
                                credits = Searcher.search(new FilterByOverpayment(overpayment), credits);
                                break;
                            case 4:
                                int term = scanner.nextInt();
                                credits = Searcher.search(new FilterByTerm(term), credits);
                                break;
                            case 5:
                                int minValue = scanner.nextInt();
                                credits = Searcher.search(new FilterByMinValue(minValue), credits);
                                break;
                            case 6:
                                int maxValue = scanner.nextInt();
                                credits = Searcher.search(new FilterByMaxValue(maxValue), credits);
                                break;
                            case 7:
                                boolean creditLine = scanner.nextInt() == 1;
                                credits = Searcher.search(new FilterByCreditLine(creditLine), credits);
                                break;
                            case 8:
                                boolean earlyRepayment = scanner.nextInt() == 1;
                                credits = Searcher.search(new FilterByEarlyRepayment(earlyRepayment), credits);
                                break;
                            case 9:
                                credits.clear();
                                credits.addAll(allCredits);
                            default:
                                System.out.println("Incorrect input");
                                break;
                        }
                        if (credits.isEmpty()) {
                            System.out.println("No credits were found by these criteria.");
                            credits.addAll(allCredits);
                        }
                        for (Credit credit : credits) {
                            System.out.println(credit);
                        }
                        break;
                    case 2:
                        for (Credit credit : OptimalCredits.getOptimalCredits(allCredits)) {
                            System.out.println(credit);
                        }
                        break;
                    case 3:
                        for (int i = 0; i < credits.size(); i++) {
                            System.out.println((i + 1) + ") " + credits.get(i));
                        }
                        int num = scanner.nextInt();
                        if (num > 0 && num <= credits.size()) {
                            num--;
                            System.out.println("Enter desirable loan value");
                            double loanValue = scanner.nextDouble();
                            if (loanValue < credits.get(num).getMinValue() || loanValue > credits.get(num).getMaxValue()) {
                                System.out.println("This loan value is unacceptable for chosen credit");
                                break;
                            }
                            System.out.println("You chose credit from " + credits.get(num).getBank().getBankName() +
                                    " for " + credits.get(num).getTerm() + " month where your overall debt will be " +
                                    credits.get(num).countSum(loanValue));
                        } else {
                            System.out.println("Incorrect credit number");
                        }
                        break;
                    default:
                        System.out.println("Incorrect input, try again.");
                        break;
                }
            }
            catch (InputMismatchException inputMismatchException) {
                System.out.println("Incorrect input, try again.");
                scanner.nextLine();
            }
            System.out.println();
        }
    }
}
