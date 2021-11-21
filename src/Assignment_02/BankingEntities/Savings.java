package Assignment_02.BankingEntities;

import java.math.BigDecimal;

public class Savings extends Accounts{

    public Savings(BigDecimal CBalance, double AInterestRate) {
        super(CBalance, AInterestRate);
    }

    /**
     * The Account becomes active if the balance is above $25, this is represented as (A)
     * The Account becomes inactive if the balance drops bellow $25, this is represented as (I).
     * @param
     */
    protected void activeInactive()
    {
        if (getCBalance().compareTo(new BigDecimal("24.99")) > 0)
        {
            setStatus('A');
        }
        else
            setStatus('I');
    }

    @Override
    public void withdrawal(BigDecimal amount)
    {
        activeInactive();
        if (getStatus() == 'A')
        {
            super.withdrawal(amount);
            activeInactive();
        }
        else
            super.withdrawal(new BigDecimal("0.00"));
    }



    @Override
    public void deposit(BigDecimal amount)
    {
        activeInactive();
        if (getStatus() == 'I')
        {
            super.deposit(amount);
            activeInactive();
        }
        else
            super.deposit(amount);
    }

    @Override
    public void generateMonthlyReport() {

    }
}
