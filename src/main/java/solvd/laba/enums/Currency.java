package solvd.laba.enums;

import solvd.laba.interfaces.HasCost;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Currency Enum, to perform conversions of money between several types of currency
 */
public enum Currency {
    USD(1),
    ARS(986.5),
    CLP(912.05),
    EUR(0.9),
    YEN(144.71);

    //  This parameter is taken from "How much of this currency is needed to buy one dollar.
    //  Taxes not included. This is a basic implementation.
    private final double rate_from_usd;

    Currency(double rate_from_usd){
        this.rate_from_usd = rate_from_usd;
    }

    //  Method used to convert the currency to another currency.
    public double convertTo(double amount_in_this_currency, Currency foreignCurrency) {
        //  Lambda Function from java.util package: BiFunction<Double, Currency, Double>
        BiFunction<Double, Currency, Double> conversionFunction = (amount, targetCurrency) -> {
            double amount_in_usd = amount * this.rate_from_usd;  // Convert this currency to USD
            return amount_in_usd / targetCurrency.rate_from_usd;  // Convert USD to target currency
        };
        return conversionFunction.apply(amount_in_this_currency, foreignCurrency);
    }

    // Stream method to convert the product price to all currencies
    public static <T extends HasCost> Stream<String> streamConversions(T product) {
        return Arrays.stream(Currency.values())
                .map(currency ->
                        "Price in " + currency + ": "
                        + currency.convertTo(product.getCost(), currency));
    }



}
