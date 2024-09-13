package solvd.laba.siteutilities;


import solvd.laba.interfaces.Purchasable;
import solvd.laba.interfaces.SearchableStorage;
import solvd.laba.products.CartProduct;
import solvd.laba.products.Product;
import solvd.laba.users.Client;

import java.util.ArrayList;

/**
 * Class associated with a Shopping cart for the E-commerce site.
 */
public class Cart extends Container<CartProduct>
        implements Purchasable, SearchableStorage<CartProduct> {

    public boolean stateOfPurchase;
    public boolean stateOfDelivery; //

    /**
     * Constructor with parameters for this
     */
    public Cart(){
        //  Create a copy of the list (to avoid issues with references).
        this.inventory = new ArrayList<>();
        this.stateOfPurchase = false;
        stateOfDelivery = false;
    }


    /**
     * Overridden method, toString()
     * @return  A descriptive string representing the cart
     */
    @Override
    public String toString(){
        return super.toString("Cart products:\n");
    }
    // Implement methods



    /**
     * Overridden method: equals.
     * @param obj   , an object to compare to this instance of a cart.
     * @return      'true' if this object matches the cart,
     *              'false' otherwise.
     */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(obj instanceof Cart otherCart){
            if(this.inventory.equals(otherCart.inventory)
                    && this.stateOfDelivery == otherCart.stateOfDelivery
                    && this.stateOfPurchase == otherCart.stateOfPurchase){
                ret = true;
            }
        }

        return ret;
    }


    /**
     * Overridden method: hashCode()
     * @return  An int representing the products within the cart.
     */
    @Override
    public int hashCode(){
        int ret = 0;
        for(CartProduct prod:this.inventory){
            ret = ret + prod.hashCode();
        }
        return ret;
    }



    public void addProduct(Product prod, int amount){
        CartProduct aux = new CartProduct(prod, amount);
        this.inventory.add(aux);
    }


    public double totalCost(){
        double cost = 0.0;
        for(CartProduct prod:this.inventory){
            cost = cost + prod.totalCost();
        }
        return cost;
    }


    @Override
    public String menuDescriptor() {
        return super.menuDescriptor("Select the object to choose:\n");
    }


    @Override
    public void buy(Client buyer) {
        buyer.payPurchase(this);
    }





}




