package classes_CodeChum_Polymorphism;

public class InputElement {
    private int maxLength;
    private String value;

    public InputElement(int maxLength) {
        this.maxLength = maxLength;
        this.value = "";
    }

    public boolean validate() {
        return value.length() >= 1 && value.length() <= maxLength;
    }

    public String getValue() {
        return value;
    }

    public void setValue(char c) {
        // backspace char is '/'
        if (c == '/') {
            int len = value.length();
            if (len > 0) value = value.substring(0, len - 1);
            return;
        }
        // only enforce max length here; do not reject based on allowed characters
        if (value.length() < maxLength) {
            value = value + c;
        }
    }

    public int getMaxLength() {
        return maxLength;
    }
}