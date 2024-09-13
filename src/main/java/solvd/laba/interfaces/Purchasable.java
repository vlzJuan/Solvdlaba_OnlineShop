package solvd.laba.interfaces;


import solvd.laba.users.Client;

/**
 * Interface for all classes that I can 'purchase'.
 *
 * This will be applied to Product and Cart.
 */

public interface Purchasable {



    /**
     * Method to buy this Purchaasable.
     */
    public void buy(Client buyer);



}
