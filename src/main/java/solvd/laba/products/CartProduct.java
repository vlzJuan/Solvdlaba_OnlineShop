package solvd.laba.products;

import solvd.laba.interfaces.IndexableByMenu;
import solvd.laba.interfaces.HasCost;

import static java.lang.String.format;

/**
 *  Class corresponding to a wrapper for a product from the inventory.
 *  ALL instances of this class must be instantiated with an existing product.
 */
public class CartProduct implements IndexableByMenu, HasCost {

    //  Attributes:
    public Product referenceProduct;    //  A product already in the inventory
    public int units;          //  The amount of this product in stock.

    /**
     * Constructor
     *
     * @param referenceProduct, the already-instantiated reference product
     * @param units ,           the amount of units a user wants.
     */
    public CartProduct(Product referenceProduct, int units){
        this.referenceProduct   =   referenceProduct;
        this.units = units;
    }


    //  Getters and Setters:

    /**
     * Setter for the amount of solicited units for this product in the cart.
     *
     * @param newUnits      , the new number of units of this product.
     */
    // FIX SO THAT IT CHECKS FOR THIS AND THE PRODUCT'S UNITS.
    public void setUnits(int newUnits){
        this.units = newUnits;
    }

    /**
     * Method used to determine the total cost of 'this.units' amount of products.
     *
     * @return  the total cost of this product.
     */
    public double getCost(){
        return (double) this.units * this.referenceProduct.getCost();
    }


    /**
     * Overriden method 'toString', to show the product as a string
     * in an amicable format
     * @return A descriptive String that shows the instance's characteristics.
     */
    @Override
    public String toString(){
        return format("Product name: %s, Units in cart: %d, Cost per unit: %.2f",
                this.referenceProduct.productName, this.units, this.getCost());
    }

    /**
     * Overriden method 'equals', that verifies whether an object can be considered
     * equal to this instance.
     *
     * @param obj   , the object to compare.
     * @return      'true', if the object is a product that matches the internal product
     *              in this CartProduct,
     *              'true' if the object is a CartProduct that matches the internal product
     *              and the unit count,
     *              'false' otherwise.
     *              ### MIGHT WANT TO ADD AN OWNER TO THIS CHECK.
     */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(obj instanceof Product product){
            if(this.referenceProduct.equals(product)){
                ret = true;
            }
        }
        else if(obj instanceof CartProduct product){
            if(this.units == product.units
                    && this.referenceProduct.equals(product.referenceProduct)){
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Overridden method, 'hashCode()'
     *
     * @return  an int based on the reference product and the amount of units solicited.
     */
    @Override
    public int hashCode(){
        return this.units + this.referenceProduct.hashCode();
    }



    @Override
    public String descriptorForMenu() {
        return format("%s (up to %d units), cost/u: $%.2f",
                this.referenceProduct.productName,
                this.referenceProduct.getStock(),
                this.referenceProduct.getCost());
    }


}
