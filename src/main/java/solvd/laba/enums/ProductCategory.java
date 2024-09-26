package solvd.laba.enums;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public enum ProductCategory {
    FOOD("Basic food items",
            0.05, canExpire->true),
    DRINK("Beverages and drinks",
            0.1, canExpire->true),
    ELECTRONICS("Electronic gadgets and devices, for technicians or consumers",
            0.2, canExpire->false),
    TEXTILE("Clothing and fabric items, for people or for home",
            0.15, canExpire->false),
    BEAUTY_PRODUCT("Cosmetic and beauty products",
            0.18,canExpire->true),
    CLEANING_SUPPLY("Household cleaning supplies",
            0.12, canExpire->true),
    UNDEFINED("Items that do not currently match any other categories " +
            "in the shop.", 0.0, canExpire -> false);

    private final String descriptor;
    private final double taxRate;
    private final Predicate<ProductCategory> canExpirePredicate;

    ProductCategory(String descriptor, double taxRate, Predicate<ProductCategory> result){
        this.descriptor = descriptor;
        this.taxRate = taxRate;
        this.canExpirePredicate = result;
    }


    /**
     * Descriptor for this category.
     * @return  the descriptor of this enum.
     */
    public String descriptor(){
        return this.descriptor;
    }

    // Bifunction to calculate price after tax.
    public static final BiFunction<Double, ProductCategory, Double>
            calculatePriceWithTax = (price, category) -> price + (price * category.taxRate);






}
