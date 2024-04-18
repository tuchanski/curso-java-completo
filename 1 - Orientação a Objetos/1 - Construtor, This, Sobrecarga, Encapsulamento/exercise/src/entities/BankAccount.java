package entities;

public class BankAccount {

    private final int accountID;
    private String ownerName;
    private double cash;

    public BankAccount(int accountID, String ownerName, double cash){

        this.accountID = accountID;
        this.ownerName = ownerName;
        this.cash = cash;

    }

    public BankAccount(int accountID, String ownerName){
        this.accountID = accountID;
        this.ownerName = ownerName;
    }

    public void setOwnerName(String ownerName) {

        this.ownerName = ownerName;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public int getAccountID(){
        return accountID;
    }


    public double getCash(){
        return cash;
    }


    public void deposit(double value){
        cash += value;
    }

    public void withdraw(double value){
        cash -= value + 5;
    }

    @Override
    public String toString() {
        return "Account "
                + accountID
                + ", Holder: "
                + ownerName
                + ", Balance: $ "
                + cash;
    }
}
