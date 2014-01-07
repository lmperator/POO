package po.pkg666;

public class UserValidator {
    private static final String name = "Artur";
    private static final String password = "maslo";
 
    public static boolean authenticate(String name, String password) {
        if(UserValidator.name.equals(name) & UserValidator.password.equals(password))
            return true;
        else
            return false;
    }
}