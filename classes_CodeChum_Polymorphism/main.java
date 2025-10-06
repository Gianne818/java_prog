package classes_CodeChum_Polymorphism;

public class main {
    public static void main(String[] args) {
        // --------------------------------------------------
        // Testcase 1
        System.out.println();
        System.out.println();
        System.out.println("action: Invoking getValue(), setValue(char value), and validate() methods for PasswordInputElement created with PasswordInputElement(3, new char[] {'a', 'b', 'c', '1', '2', '3'}).");
        PasswordInputElement pie = new PasswordInputElement(3, new char[] {'a','b','c','1','2','3'});

        System.out.println("Output:");
        System.out.println("Valid: " + pie.validate());

        pie.setValue('a');
        System.out.println(pie.getValue());
        pie.setValue('1');
        System.out.println(pie.getValue());
        pie.setValue('2');
        System.out.println(pie.getValue());
        pie.setValue('3');  // should be rejected because maxLength = 3
        System.out.println(pie.getValue());

        System.out.println("Valid: " + pie.validate());
        pie.setValue('/');
        System.out.println(pie.getValue());
        pie.setValue('/');
        System.out.println(pie.getValue());
        pie.setValue('4');  // '4' is NOT in allowedCharacters so this will be rejected
        System.out.println(pie.getValue());

        // --------------------------------------------------
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("action: Invoking getValue(), setValue(char value), and validate() methods for CustomPasswordInputElement created with CustomPasswordInputElement(4).");
        CustomPasswordInputElement cpie = new CustomPasswordInputElement(4);

        System.out.println("Output:");
        System.out.println("Valid: " + cpie.validate());
        cpie.setValue('J');
        System.out.println(cpie.getValue());
        cpie.setValue('r');
        System.out.println(cpie.getValue());
        cpie.setValue('v');
        System.out.println(cpie.getValue());
        cpie.setValue('D');
        System.out.println(cpie.getValue());

        System.out.println("Valid: " + cpie.validate());
        System.out.println(cpie.getValue());
        cpie.setValue('/');
        System.out.println("Valid: " + cpie.validate());
        System.out.println(cpie.getValue());
        cpie.setValue('/');
        System.out.println("Valid: " + cpie.validate());
        System.out.println(cpie.getValue());
        cpie.setValue('x'); // not allowed, will be rejected
        System.out.println("Valid: " + cpie.validate());
        System.out.println(cpie.getValue());

        // --------------------------------------------------
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("action: Invoking validate(String, PasswordInputElement) method for PasswordField created with PasswordField().");

        PasswordField pf = new PasswordField();
        PasswordInputElement pie2 = new PasswordInputElement(6, new char[] {'a','b','c','1','2','3'});

        System.out.println("Output:Validating abc123");
        pf.validate("abc123", pie2);

        System.out.println("Validating abcxxx234");
        pf.validate("abcxxx234", pie2);

        System.out.println("Validating abc1xx23/aa");
        pf.validate("abc1xx23/aa", pie2);
    }
}