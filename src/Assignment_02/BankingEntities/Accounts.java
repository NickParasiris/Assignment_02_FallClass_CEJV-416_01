package Assignment_02.BankingEntities;

import java.math.BigDecimal;

public abstract class Accounts {

    //The account id.
    private int accountID;
    //Starting balance at the beginning of the month
    private BigDecimal SMBalance;
    //Current balance.
    private BigDecimal CBalance;
    //The total amount of money deposited this month.
    private BigDecimal TMDeposit;
    //The number of times there was a deposit this month.
    private int NOfDeposits;
    //The total amount of money withdrew this month.
    private BigDecimal TMWithdrew;
    //The number of times there was a withdrawal this month.
    private int NOfWithdrawals;
    //The annual interest rate.
    private double AInterestRate;
    //The service charge for the month.
    private BigDecimal serviceCharge;
    //Account Status
    private char status;


    public Accounts(BigDecimal CBalance, double AInterestRate) {
        this.CBalance = CBalance;
        this.AInterestRate = AInterestRate;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getSMBalance() {
        return SMBalance;
    }

    public void setSMBalance(BigDecimal SMBalance) {
        this.SMBalance = SMBalance;
    }

    public BigDecimal getCMBalance() {
        return CBalance;
    }

    public void setCMBalance(BigDecimal CMBalance) {
        this.CBalance = CMBalance;
    }

    public BigDecimal getTMDeposit() {
        return TMDeposit;
    }

    public void setTMDeposit(BigDecimal TMDeposit) {
        this.TMDeposit = TMDeposit;
    }

    public int getNOfDeposits() {
        return NOfDeposits;
    }

    public void setNOfDeposits(int NOfDeposits) {
        this.NOfDeposits = NOfDeposits;
    }

    public BigDecimal getTMWithdrew() {
        return TMWithdrew;
    }

    public void setTMWithdrew(BigDecimal TMWithdrew) {
        this.TMWithdrew = TMWithdrew;
    }

    public int getNOfWithdrawals() {
        return NOfWithdrawals;
    }

    public void setNOfWithdrawals(int NOfWithdrawals) {
        this.NOfWithdrawals = NOfWithdrawals;
    }

    public double getAInterestRate() {
        return AInterestRate;
    }

    public void setAInterestRate(double AInterestRate) {
        this.AInterestRate = AInterestRate;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public abstract BigDecimal deposit();

    /**
     * The Account becomes active if the balance is above $25, this is represented as (A)
     * The Account becomes inactive if the balance drops bellow $25, this is represented as (I).
     * @param
     */

    protected void activeInactive()
    {
        if (CBalance.compareTo(new BigDecimal("25.00")) > 0)
        {
            this.status = 'A';
        }
        else
            this.status = 'I';
    }

    protected BigDecimal withdrawal(BigDecimal amount)
    {
        this.CBalance = this.CBalance.subtract(amount);
        this.NOfWithdrawals += 1;
        return this.CBalance;
    }

    public BigDecimal calculateInterest(BigDecimal amount)
    {
        double MInterestRate = this.AInterestRate / 12.00;

        BigDecimal monthlyInterest = this.CBalance.multiply(BigDecimal.valueOf(MInterestRate));

        this.CBalance = this.CBalance.add(monthlyInterest);

        return this.CBalance;
    }


    public abstract void generateMonthlyReport();




}



