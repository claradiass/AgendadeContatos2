// package main.java.br.edu.ifpb.validators;

// import javax.swing.text.JTextComponent;

// public interface GUIValidator {
//     Validator<String> getStringValidator();
//     boolean validate(JTextComponent field);
// }


package main.java.br.edu.ifpb.validators;

import javax.swing.*;

public interface GUIValidator<T> {
    boolean validate(JComponent component);
    Validator<T> getValidator();
}




