package classes_CodeChum_Polymorphism;

public class PasswordField {

    public void validate(String password, PasswordInputElement passwordInputElement) {
        // clear previous value
        while (passwordInputElement.getValue().length() > 0) {
            passwordInputElement.setValue('/');
        }

        boolean anyRejected = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int beforeLen = passwordInputElement.getValue().length();
            passwordInputElement.setValue(c);
            int afterLen = passwordInputElement.getValue().length();

            // if we tried to add a regular char (not backspace) and length didn't increase,
            // the set attempt was rejected (either invalid char or too long)
            if (c != '/' && afterLen == beforeLen) {
                anyRejected = true;
            }
        }

        boolean res = passwordInputElement.validate() && !anyRejected;
        System.out.println("Password validation result: " + res);
    }
}