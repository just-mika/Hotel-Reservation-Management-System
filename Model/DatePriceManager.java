import java.util.ArrayList;

/**
 * Manages the date price rates of a hotel.
 */

public class DatePriceManager {
    private ArrayList<DatePriceRate> datePriceRateList; //attribute for list of date price rates

    public DatePriceManager(){
        this.datePriceRateList = new ArrayList<DatePriceRate>();

        //instantiate all dates.
        for(int i = 0; i < 31; i++){
            DatePriceRate datePriceRate = new DatePriceRate(i + 1);
            datePriceRateList.add(datePriceRate);
        }
    }


    /**
     * Finds the date price rate by a given date.
     *
     * @param date the given date to find in the list.
     * @return the date price rate of the given date; 'null' otherwise.
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
     * Changes the price rate of a given date.
     *
     * @param date the given date to change the rate of.
     * @param rate the new rate value.
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
