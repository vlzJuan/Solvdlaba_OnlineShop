package solvd.laba.users;


import solvd.laba.interfaces.CanPayPurchase;
import solvd.laba.paymentmethods.PaymentMethod;
import solvd.laba.siteutilities.Cart;
import solvd.laba.siteutilities.Order;

import java.util.ArrayList;

/**
 * Class corresponding to a regular user from the E-commerce site.
 * This class should have permissions to instantiate a product cart,
 * make purchases, and
 */
public final class Client extends User implements CanPayPurchase {

    //  Inherits the following attributes from its parent class:
    //      -String userName
    //      -String password
    //  Adds the following attributes:
    private PaymentMethod payment;  //  The payment method associated to this user

    // MODIFICAR para que use OrderID
    private ArrayList<Order> purchaseHistory;   //  Attribute that stores this user's
                                                //  purchases on the site so far.
    /**
     * Inherits its behaviour from the User parent class.
     * Public constructor for a User. requires a userName and
     * @param userName  , the username required for login.
     * @param password  , the password associated to this user.
     */
    public Client(String userName, String password, PaymentMethod paymentMethod){
        super(userName, password);
        this.payment = paymentMethod;
    }

    //  Metodo setter
    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }

    //  Metodo getter
    public PaymentMethod getPaymentMethod(){
        return this.payment;
        // WARNING: This does not respect object encapsulation,
        // but I'll fix this in a later commit.
    }

    /**
     * Overridden method: toString()
     *
     * @return A string representing the user.
     */
    @Override
    public String toString(){
        return "User: " + this.userName + "(Client)";
    }

    /**
     * Overriden method: equals.
     *
     * @param obj, an object.
     * @return          'true' if the other user matches this one,
     *                  'false' otherwise.
     */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;
        if (obj instanceof Client otherClient){
            if(otherClient.userName.equals(this.userName)
                    && otherClient.password.equals(this.password) ){
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Overriden method: hashCode()
     *
     * @return an integer based off this instance's attributes.
     */
    @Override
    public int hashCode(){
        return this.userName.hashCode() + this.password.hashCode();
    }

    @Override
    public boolean payPurchase(Cart cart) {
        return this.payment.payPurchase(cart);
    }

    public double balance(){
        return this.payment.getBalance();
    }

}
