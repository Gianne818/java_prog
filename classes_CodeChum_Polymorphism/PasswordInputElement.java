package classes_CodeChum_Polymorphism;

public class PasswordInputElement extends InputElement {
    private char[] allowedCharacters;

    public PasswordInputElement(int maxLength, char[] allowedCharacters) {
        super(maxLength);
        this.allowedCharacters = allowedCharacters;
    }

    @Override
    public boolean validate() {
        // keep parent length and non-empty check
        if (!super.validate()) return false;

        String s = getValue();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean found = false;
            for (char a : allowedCharacters) {
                if (c == a) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}