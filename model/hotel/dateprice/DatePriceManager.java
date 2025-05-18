package model.hotel.dateprice;

import java.util.ArrayList;
/**
 * Manages the date price rates of a hotel.
 */

public class DatePriceManager {
    private ArrayList<DatePriceRate> datePriceRateList; //attribute for list of date price rates

    /**
     * Constructs a DatePriceManager with default rates for all dates.
     */
    public DatePriceManager(){
        this.datePriceRateList = new ArrayList<DatePriceRate>();

        //instantiate all dates.
        for(int i = 0; i < 31; i++){
            DatePriceRate datePriceRate = new DatePriceRate(i + 1);
            datePriceRateList.add(datePriceRate);
        }
    }


    /**
     * Finds the date price rate for a given date.
     *
     * @param date the date to find the price rate for
     * @return the DatePriceRate for the given date; `null` if not found
     * @throws IllegalArgumentException if the date is not within the range of 1 to 31
     */
    public DatePriceRate findDate(int date) {
        for (DatePriceRate datePriceRate : datePriceRateList) {
            if (datePriceRate.getDate() == date) {
                return datePriceRate; //return the datePriceRate of the given date.
            }
        }
        return null;
    }

    /**
     * Changes the price rate for a given date.
     *
     * @param date the date for which the rate needs to be changed
     * @param rate the new rate value
     * @throws IllegalArgumentException if the date is not within the range of 1 to 31
     * @throws IllegalArgumentException if the rate is negative
     */
    public void changeDatePrice(int date, double rate){
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        if(rate < 0.0)
            throw new IllegalArgumentException("Rate cannot be negative!");
        if(this.findDate(date) != null) //if date is found, set rate.
            findDate(date).setRate(rate);
    }
}
