package solvd.laba.users;


/**
 * Class corresponding to a generic 'User' from the E-commerce site.
 * This will be the parent class for specific type of users,
 * specifically 'Admin' and 'Client' classes.
 */
public abstract class User {

    //  Attributes:
    protected final String userName;
    protected String password;

    /**
     * Public constructor for a User. requires a userName and
     * @param userName  , the username required for login.
     * @param password  , the password associated to this user.
     */
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    // Implement further methods here.

    //  Getters:

    public final String getPassword(){
        return this.password;
    }

    //  Setters:

    public final void setPassword(String password){
        this.password = password;
    }


}
