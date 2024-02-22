//Person class
//Evan Phillips

package assg9_phillipsev20;

class Person extends KeyedItem<String> {
    private String name;
    private String phoneNumber;
    
    /**
    Constructs a new Person object with the given name and phone number.
    @param name the name of the person
    @param phoneNumber the phone number of the person
    */
    public Person(String name, String phoneNumber) {
        super(name);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    /**
    Returns the name of the person.
    @return the name of the person
    */
    public String getName() {
        return name;
    }
    
    /**
    Returns the phone number of the person.
    @return the phone number of the person
    */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
    Sets the phone number of the person.
    @param phoneNumber the new phone number of the person
    */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
    Returns a string representation of the person in the format "name\tphoneNumber".
    @return a string representation of the person
    */
    public String toString() {
        return name + "\t" + phoneNumber;
    }
}