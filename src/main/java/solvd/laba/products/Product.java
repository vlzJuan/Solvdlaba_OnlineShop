package solvd.laba.products;


import solvd.laba.enums.ProductCategory;
import solvd.laba.exceptions.NotEnoughStockException;
import solvd.laba.interfaces.IndexableByMenu;
import solvd.laba.interfaces.HasCost;

import static java.lang.String.format;

/**
 *  Class corresponding to a product from the E-commerce store.
 */
public class Product implements IndexableByMenu, HasCost {

    //  Attributes:
    public String productName;  //  The name of the product.
    private int stock;          //  The amount of this product in stock.
    private final double cost;        //  The cost of this product
    private final ProductCategory category;

    /**
     * Constructor for a Product. It requires its name, and the initial
     * stock of it available in inventory.
     *
     * @param productName   , the product's name
     * @param initialStock  , the starting stock of it in the inventory.
     * @param cost          , the basic cost of this product.
     */
    public Product(String productName, int initialStock,
                   double cost, ProductCategory category){
        this.productName = productName;
        this.stock = initialStock;
        this.cost = cost;
        this.category = category;
    }


    /**
     * Basic boolean method, used to determine if there is stock of this product
     * in inventory.
     *
     * @return  'true' if the stock is greater than zero, 'false' otherwise.
     */
    public boolean hasStock(){
        return this.stock>0;
    }

    /**
     * Overloaded boolean method, using an int as a parameter.
     * It is used to determine if there is enough stock of this product
     * in inventory to make a purchase of 'solicited amount' units.
     *
     * @param solicitedAmount , the amount of stock to pull from inventory
     *                        in the purchase that requests this method.
     * @return  'true' if the stock is enough for purchase, 'false' otherwise.
     */
    public boolean hasStock(int solicitedAmount){
        return this.stock>=solicitedAmount;
    }


    /**
     * Method used to add more stock to this item.
     *
     * @param extraStock, the amount to add to the stock of this product.
     * @return              'true' if the operation was performed,
     *                      'false' otherwise.
     */
    public boolean restock(int extraStock) {
        boolean ret = false;
        if (extraStock >= 0) {
            this.stock = this.stock + extraStock;
            ret = true;
        }
        return ret;
    }


    /**
     * Method used to remove stock from a Purchasable item.
     *
     * @param removedStock, the amount of stock to remove     */
    public void removeStock(int removedStock){

        if(hasStock(removedStock)){
            this.stock = this.stock - removedStock;
        }
        else{
            throw new NotEnoughStockException("Error: Not enough stock to perform the operation");
        }
    }



    //  Implement further methods.

    /**
     * Overriden method 'toString', to show the product as a string
     * in an amicable format
     * @return A descriptive String that shows the instance's characteristics.
     */
    @Override
    public String toString(){
        return format("{Product name: %s, Stock: %d, Cost per unit: %.2f}",
                this.productName, this.stock, this.cost);
    }

    /**
     * Overwrite of the 'equals' method
     *
     * @param obj   , an object to compare to this instance
     * @return      'true' if the object is an instance of a product,
     *              with the same stock and product name,
     *              'false' otherwise.
     */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(obj instanceof Product prod){
            if(prod.productName.equals(this.productName)
                    && prod.stock == this.stock){
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Overridden method: 'hashCode()'
     *
     * @return an int build from the productName, stock and cost attributes.
     */
    @Override
    public int hashCode(){
        return this.productName.hashCode() + this.stock + (int) cost;
    }



    @Override
    public String descriptorForMenu() {
        return format("%s (up to %d units), cost/u: $%.2f",this.productName, this.stock, this.cost);
    }
    public int getStock(){
        return this.stock;
    }
    public double getCost() {
        return this.cost;
    }
    public ProductCategory getCategory(){
        return this.category;
    }


}
