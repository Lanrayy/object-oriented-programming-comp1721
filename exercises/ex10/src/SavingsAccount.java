//import java.lang.Math;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    //constructor

    public SavingsAccount(String num, int bal){
        this(num, bal, 0.05);
    }

    /**
     *Default three parameter constructor for the SavingsAccount Class
     * @param num
     * @param balance
     * @param rate
     */
    public SavingsAccount(String num, int bal, double rate){
        super(num, bal);
        setInterestRate(rate);
    }

    //getters
    public double getInterestRate(){
        return interestRate;
    }

    //setters
    public void setInterestRate(double rate){
        if(rate <= 0.0){
            throw new IllegalArgumentException("Interest rate should be greater than 0");
        }
        interestRate = rate;
    }


    /**
     * This method applys the interest to the account by multiplying interest rate by balance,
     * rounding down to the nearesrt integer and incrementing the balance by this amount
     *
     */
    public void applyInterest(){
        double interest = balance * interestRate;
        interest = Math.floor(interest);
        balance += interest;
    }

    @Override
    protected void checkWithdrawal(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("invalid amount");
        }

        if (amount > (this.balance-100)) {
            throw new IllegalArgumentException("insufficient funds for withdrawal");
        }
    }

}