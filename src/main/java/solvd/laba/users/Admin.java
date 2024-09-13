package solvd.laba.users;


/**
 * Class corresponding to an admin user from the E-commerce site.
 * This class will have special privileges over a basic client, such as
 * modifying the stock of certain products in inventory.
 */
public final class Admin extends User {

    //  Inherits the following attributes from it's parent class:
    //      -String userName
    //      -String password
    //  Adds the following attributes:
    private final int employeeNumber; //  An unique identifier for the admin.
    // ADD ANOTHER PARAMETER.

    /**
     * Inherits its behaviour from the User parent class.
     * Public constructor for a User. requires a userName and
     * @param userName  , the username required for login.
     * @param password  , the password associated to this user.
     */
    public Admin(String userName, String password, int employeeNumber){
        super(userName, password);
        this.employeeNumber = employeeNumber;
    }


    /**
     * Overriden method: toString()
     *
     * @return A string representing the user.
     */
    @Override
    public String toString(){
        return "User: " + this.userName + "(Admin)";
    }

    /**
     * Overriden method: equals.
     *
     * @param obj, an object.
     * @return          'true' if the other user matches this one,
     *                  'false' otherwise.
     */
    @Override
    public boolean equals(Object obj){
        boolean ret = false;
        if (obj instanceof Admin otherAdmin){
            if(otherAdmin.userName.equals(this.userName)
                    && otherAdmin.password.equals(this.password)
                    &&  otherAdmin.employeeNumber == this.employeeNumber){
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Overriden method: hashCode()
     * The idea is that all users corresponding to the same employee should have
     * the same hashcode.
     *
     * @return  The employee number.
     */
    @Override
    public int hashCode(){
        return this.employeeNumber;
    }


}
