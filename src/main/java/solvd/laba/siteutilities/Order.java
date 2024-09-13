package solvd.laba.siteutilities;

import solvd.laba.users.Client;

import java.time.LocalDate;

import static java.lang.String.format;

/**
 * Class that represents an order. This corresponds to a shopping cart
 * that has already been purchased.
 * It has an identifier attribute, and a String determining what was purchased.
 */
public class Order {

    //  Attributes
    public final LocalDate orderDate;
    public final Client buyer;
    public final String orderDescription;


    /**
     * Default constructor for an order. It requires a cart, to generate
     * the order's description.
     * @param client    , the client that purchased this order.
     * @param purchased , the cart from which the order was purchased.
     */
    public Order(Client client, Cart purchased){
        this.orderDate = LocalDate.now();
        this.buyer = client;
        this.orderDescription = purchased.toString();
    }


    @Override
    public String toString(){

        return format("Order at %s, purchased by %s\n", this.orderDate, this.buyer.toString()) +
                format("Order description: \n%s", this.orderDescription);
    }

}
