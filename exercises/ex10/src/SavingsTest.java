public class SavingsTest{
    public static void main(String[] args){
        //Creating a savings account
        SavingsAccount s1 = new SavingsAccount("001", 50);
        System.out.println("Account number: " + s1.getAccountNumber());
        System.out.println("Balance: " + s1.getBalance());
        System.out.println("Interest rate: " + s1.getInterestRate());

        //Apply interest
        s1.applyInterest();
        System.out.println("The new balance is: " + s1.getBalance() + "\n");

        //Try to withdraw money - successful
        System.out.println("Balance is " +  s1.getBalance() +  ". Attempting to withdrawing 400...");
        try{
            s1.withdraw(400);
        }catch (IllegalArgumentException error){
            System.out.println(error);
        }
        System.out.println("The new balance is: "+ s1.getBalance() + "\n");


        //Try to withdraw money - unsuccessful
        System.out.println("Balance is " +  s1.getBalance() + ". Attempting to withdrawing 100...");
        try{
            s1.withdraw(100);
        }catch (IllegalArgumentException error){
            System.out.println(error);
        }

        System.out.println("The new balance is: " + s1.getBalance() + "\n");

    }
}