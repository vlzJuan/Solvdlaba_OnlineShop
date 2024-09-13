package solvd.laba.paymentmethods;



/**
 * Class associated with a bank account from a user.
 */
public class BankAccount extends PaymentMethod{

    //  Inherited attributes:
    //      - long identifier
    //      - int validationCode
    //      - int balance
    // Local Attributes:
    private int balance;        //  The balance in this account
    private String aliasName;   //  The alias for the bank account.


    public BankAccount(long identifier, int validationCode,
                       int balance, String aliasName){
        super(identifier, validationCode, balance);
        this.aliasName = aliasName;
    }


    //  getters


    public String getAliasName(){
        return this.aliasName;
    }

    //  Setters


    public void setAliasName(String aliasName){
        this.aliasName = aliasName;
    }

}
