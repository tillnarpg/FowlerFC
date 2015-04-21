
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector _rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        Enumeration enum_rentals = _rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
    
    public String htmlStatement(){
    	Enumeration rentals = _rentals.elements();	    
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1>\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for each rental
            result += each.getMovie().getTitle()+ ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }
    
    private double getTotalCharge() {
    	double result = 0;
    	Enumeration rentals = _rentals.elements();
    	while (rentals.hasMoreElements()) {
    		Rental each = (Rental) rentals.nextElement();
    		result += each.getCharge();
    	}
    	return result;
    }
    
    private double getTotalFrequentRenterPoints() {
    	double result = 0;
    	Enumeration rentals = _rentals.elements();
    	while (rentals.hasMoreElements()) {
    		Rental each = (Rental) rentals.nextElement();
    		result += each.getFrequentRenterPoints();
    	}
    	return result;
    }
}
    