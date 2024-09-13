package solvd.laba.paymentmethods;


import solvd.laba.interfaces.CanPayPurchase;
import solvd.laba.siteutilities.Cart;

/**
 * Class associated with the payment method that an user will need
 * to pay for a product in the E-Commerce store.
 * Declared as an abstract, to further separate in two classes:
 *      -Bank Account
 *      -Credit Card
 */
public abstract class PaymentMethod implements CanPayPurchase {

    //Attributes:
    protected long identifier;        // The numeric identifier of this payment method.
    protected int validationCode;     //
    protected double balance;

    public PaymentMethod(long identifier, int validationCode, int balance){
        this.identifier = identifier;
        this.validationCode = validationCode;
        this.balance = balance;
    }

    // Implement methods later.

    //  Getters:

    public double getBalance(){
        return this.balance;
    }

    public long getIdentifier(){
        return this.identifier;
    }

    public int getValidationCode(){
        return this.validationCode;
    }

    //  Setters:

    public void setIdentifier(int identifier){
        this.identifier = identifier;
    }

    public void setValidationCode(int validationCode){
        this.validationCode = validationCode;
    }

    public boolean payPurchase(Cart cart){

        boolean ret = false;
        if (cart.totalCost()<this.balance){
            this.balance = this.balance - cart.totalCost();
            cart.stateOfPurchase = true;
            ret = true;
        }

        return ret;
    }

}
