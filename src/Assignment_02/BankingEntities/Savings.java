package Assignment_02.BankingEntities;

import java.math.BigDecimal;

public class Savings extends Accounts{

    public Savings(BigDecimal CBalance, double AInterestRate) {
        super(CBalance, AInterestRate);
    }

    @Override
    public BigDecimal withdrawal(BigDecimal amount)
    {
        activeInactive();
        if (getStatus() == 'A')
            return super.withdrawal(amount);

        else
            return new BigDecimal("0.00");

    }



    @Override
    public BigDecimal deposit() {
        return null;
    }

    @Override
    public void generateMonthlyReport() {

    }
}
