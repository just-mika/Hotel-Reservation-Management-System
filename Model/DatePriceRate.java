/**
 * Represents the rate for a specific date.
 */
public class DatePriceRate{
    private final int date; //attribute for the date
    private double rate; //attribute for the respective rate

    /**
     * Constructs the date's price rate with a given date. Sets the default rate to 1.0.
     *
     * @param date the date for which the rate is being set.
     */
    public DatePriceRate (int date) {
        if (date < 1 || date > 31)
            throw new IllegalArgumentException("Date must be between 1 and 31 inclusive.");
        this.date = date; //set date to given date
        this.rate = 1.0; //set default rate to 1.0
    }

    /**
     * Gets the respective date the price rate should be implemented in.
     *
     * @return the date.
     */
    public int getDate() {
        return date;
    }

    /**
     * Gets the rate that should be implemented on its respective date.
     *
     * @return the rate for the date.
     */
    public double getRate(){
        return rate;
    }

    /**
     * Sets the rate for the date.
     *
     * @param rate the new rate to be set.
     */
    public void setRate(double rate){
        this.rate = rate;
    }
}

