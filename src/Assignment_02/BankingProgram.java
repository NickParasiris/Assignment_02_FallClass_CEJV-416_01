package Assignment_02;

import Assignment_02.BankingEntities.Accounts;
import Assignment_02.BankingEntities.Savings;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankingProgram {
    public static void main(String[] args) {

        Savings s = new Savings(new BigDecimal("26.00"), 0.01);
        Scanner sc = new Scanner(System.in);

        s.withdrawal(new BigDecimal("10.00"));

        System.out.println(s.getCBalance());




    }
}
