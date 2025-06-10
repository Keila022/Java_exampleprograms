/**
 * The Customer class represents a customer with personal and credit card information.
 * It provides methods to get and set these attributes securely.
 */
public class Customer {

    // Private fields to store customer information
    private String SSN = "", firstName = "", middleInitial = "", lastName = "", 
                   street = "", city = "", state = "", zipcode = "", 
                   birthdate = " ", creditCardType = "",
                   creditCardNumber = "", creditCardExpiration = "";
    private char gender = '\0';

    /**
     * Constructs a new Customer with the specified details.
     *
     * @param SSN the social security number of the customer
     * @param gender the gender of the customer
     * @param firstName the first name of the customer
     * @param middleInitial the middle initial of the customer
     * @param lastName the last name of the customer
     * @param street the street address of the customer
     * @param city the city of the customer
     * @param state the state of the customer
     * @param zipcode the zipcode of the customer
     * @param birthdate the birthdate of the customer
     * @param creditCardType the type of credit card the customer has
     * @param creditCardNumber the credit card number of the customer
     * @param creditCardExpiration the expiration date of the credit card
     */
    public Customer(String SSN, char gender, String firstName, String middleInitial,
                    String lastName, String street, String city, String state, 
                    String zipcode, String birthdate, String creditCardType, 
                    String creditCardNumber, String creditCardExpiration) {
        this.SSN = validateSSN(SSN);
        this.gender = gender;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.birthdate = birthdate;
        this.creditCardType = creditCardType;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiration = creditCardExpiration;
    }

    /**
     * Validates the SSN format.
     * @param SSN the social security number to validate
     * @return the validated SSN
     * @throws IllegalArgumentException if the SSN format is invalid
     */
    
   private String validateSSN(String SSN) {
    if (SSN.matches("\\d{9}")) { // Matches 9 digits
        return SSN;
    } else {
        throw new IllegalArgumentException("Invalid SSN format");
    }
}


    /**
     * Returns the social security number of the customer, masked for security.
     * @return the masked SSN
     */
    public String getSSN() {
        return "XXX-XX-" + SSN.substring(7);
    }

    /**
     * Sets the social security number of the customer after validation.
     * @param SSN the new SSN
     */
    public void setSSN(String SSN) {
        this.SSN = validateSSN(SSN);
    }

    // Getter and setter methods with Javadoc comments

    /**
     * Returns the gender of the customer.
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets the gender of the customer.
     * @param gender the new gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Returns the first name of the customer.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer.
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the middle initial of the customer.
     * @return the middle initial
     */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * Sets the middle initial of the customer.
     * @param middleInitial the new middle initial
     */
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * Returns the last name of the customer.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer.
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the street address of the customer.
     * @return the street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address of the customer.
     * @param street the new street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns the city of the customer.
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the customer.
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state of the customer.
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of the customer.
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the zipcode of the customer.
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Sets the zipcode of the customer.
     * @param zipcode the new zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Returns the birthdate of the customer.
     * @return the birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the customer.
     * @param birthdate the new birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Returns the credit card type of the customer.
     * @return the credit card type
     */
    public String getCreditCardType() {
        return creditCardType;
    }

    /**
     * Sets the credit card type of the customer.
     * @param creditCardType the new credit card type
     */
    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    /**
     * Returns the credit card number of the customer.
     * @return the credit card number
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Sets the credit card number of the customer.
     * @param creditCardNumber the new credit card number
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Returns the credit card expiration date of the customer.
     * @return the credit card expiration date
     */
    public String getCreditCardExpiration() {
        return creditCardExpiration;
    }

    /**
     * Sets the credit card expiration date of the customer.
     * @param creditCardExpiration the new credit card expiration date
     */
    public void setCreditCardExpiration(String creditCardExpiration) {
        this.creditCardExpiration = creditCardExpiration;
    }

    /**
     * Returns the full name of the customer.
     * @return the full name
     */
    public String getFullName() {
        return firstName + " " + middleInitial + ". " + lastName;
    }

    /**
     * Returns a string representation of the customer.
     * @return the string representation
     */
    @Override
    public String toString() {
        return firstName + " " + middleInitial + " " + lastName;
    }
}
