package solvd.laba.interfaces;


/**
 * Interface that will be used for users that can be authenticated into the system.
 */
public interface Authenticable {


    /**
     * Boolean method, to confirm if the password is correct.
     * @param attemptedPassword , the string that was attempted to use as a password.
     * @return                  'true' if the password was correct,
     *                          'false' otherwise.
     */
    public boolean validatePassword(String attemptedPassword);


    /**
     * Method used to change the password of a user.
     * I should use the previous method within this one to validate if the password change
     * should be executed or not.
     * @param validationPassword    , the attempted original password of the user.
     * @param newPassword           , the new password to store for the user.
     * @return                      'true' if the change in password was successful,
     *                              'false' if it was not.
     */
    public boolean modifyPassword(String validationPassword, String newPassword);


}
