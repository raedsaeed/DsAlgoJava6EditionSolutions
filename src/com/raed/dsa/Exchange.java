package com.raed.dsa;

import com.raed.dsa.chapter7list.ArrayList;

/**
 * Created by Raed Saeed on 03/10/2021
 **/
public class Exchange {
    public static void main(String[] args) {
        Object[][] items = {{"IPhone 12", 100f, "EUR"}, {"Computer", 3100f, "EGP"}, {"T-Shirt", 150f, "USD"}};
        Object[][] exchangeRate = {{"EGP", 1f}, {"USD", .5f}};
        Object[][] symbols = {{"EGP", "#"}, {"USD", "$"}, {"EUR", "U"}};

        System.out.println(getTotal(items, exchangeRate, symbols));
    }

    private static String getTotal(Object[][] items, Object[][] exchangeRates, Object[][] symbols) {
        StringBuilder messageBuilder = new StringBuilder();

        ArrayList<Item> newItems = new ArrayList<>();
        for (Object[] item : items) {
            newItems.add(new Item((String) item[0], (float) item[1], (String) item[2]));
        }

        ArrayList<Conversion> conversions = new ArrayList<>();
        for (Object[] rateObject : exchangeRates) {
            conversions.add(new Conversion((String) rateObject[0], (float) rateObject[1]));
        }

        ArrayList<CurrencySymbol> curSymbols = new ArrayList<>();
        for (Object[] curr : symbols) {
            curSymbols.add(new CurrencySymbol((String) curr[0], (String) curr[1]));
        }

        CurrencySymbol newCurrencySymbol = getCurrencySmybol(curSymbols, "EUR");
        float totalPrice = 0f;

        for (Item newItem : newItems) {
            float price;
            CurrencySymbol oldSymbol = null;

            if (newItem.currency.equals("EUR")) {
                price = newItem.price;
            } else {
                Conversion conversion = getConversion(conversions, newItem.currency);
                price = newItem.convert(conversion == null ? new Conversion("", 1f) : conversion);
                oldSymbol = getCurrencySmybol(curSymbols, newItem.currency);
            }

            totalPrice += price;

            messageBuilder
                    .append("*  ")
                    .append(newItem.name)
                    .append(" ")
                    .append(oldSymbol == null ? "" : " (" + oldSymbol.symbol + "" + newItem.price + ") ")
                    .append(newCurrencySymbol != null ? newCurrencySymbol.symbol : "")
                    .append(price)
                    .append("\n");
        }

        return messageBuilder
                .append("Total price : ")
                .append(totalPrice)
                .toString();
    }


    private static CurrencySymbol getCurrencySmybol(ArrayList<CurrencySymbol> symbols, String symbol) {
        for (CurrencySymbol currencySymbol : symbols) {
            if (currencySymbol.currency.equalsIgnoreCase(symbol)) return currencySymbol;
        }
        return null;
    }

    private static Conversion getConversion(ArrayList<Conversion> prices, String symbol) {
        for (Conversion conversion : prices) {
            if (conversion.currency.equals(symbol)) return conversion;
        }
        return null;
    }

    private static class Item {
        public String name;
        public float price;
        public String currency;

        public Item(String name, float price, String currency) {
            this.name = name;
            this.price = price;
            this.currency = currency;
        }

        public float convert(Conversion rate) {
            return price * rate.factor;
        }
    }

    private static class Conversion {
        String currency;
        float factor;

        public Conversion(String currency, float factor) {
            this.currency = currency;
            this.factor = factor;
        }
    }

    private static class CurrencySymbol {
        String currency;
        String symbol;

        public CurrencySymbol(String currency, String symbol) {
            this.currency = currency;
            this.symbol = symbol;
        }
    }
}
