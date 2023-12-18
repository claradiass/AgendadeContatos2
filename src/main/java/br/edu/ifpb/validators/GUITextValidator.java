// package main.java.br.edu.ifpb.validators;

// import javax.swing.text.JTextComponent;
// import java.awt.*;

// public class GUITextValidator implements GUIValidator {
//     private final Validator<String> validator;

//     public GUITextValidator(Validator<String> validator) {
//         this.validator = validator;
//     }

    

//     @Override
//     public boolean validate(JTextComponent field) {
//         boolean textIsValid = getStringValidator().validate(field.getText());

//         if (!textIsValid) {
//             field.setBackground(new Color(255, 155, 163));
//         } else {
//             field.setBackground(Color.WHITE);
//         }

//         return textIsValid;
//     }

//     @Override
//     public Validator<String> getStringValidator() {
//         return validator;
//     }
// }







package main.java.br.edu.ifpb.validators;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class GUITextValidator implements GUIValidator<String> {
    private final Validator<String> validator;

    public GUITextValidator(Validator<String> validator) {
        this.validator = validator;
    }

    @Override
    public boolean validate(JComponent component) {
        if (!(component instanceof JTextComponent)) {
            throw new IllegalArgumentException("Invalid component type. Expected JTextComponent.");
        }

        JTextComponent textComponent = (JTextComponent) component;
        boolean textIsValid = getValidator().validate(textComponent.getText());

        if (!textIsValid) {
            textComponent.setBackground(new Color(255, 155, 163));
        } else {
            textComponent.setBackground(Color.WHITE);
        }

        return textIsValid;
    }

    @Override
    public Validator<String> getValidator() {
        return validator;
    }
}
