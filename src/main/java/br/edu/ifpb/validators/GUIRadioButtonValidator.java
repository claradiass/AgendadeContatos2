package main.java.br.edu.ifpb.validators;

import javax.swing.*;
import java.awt.*;

public class GUIRadioButtonValidator implements GUIValidator<Boolean> {
    private final Validator<Boolean> validator;

    public GUIRadioButtonValidator(Validator<Boolean> validator) {
        this.validator = validator;
    }

    @Override
    public boolean validate(JComponent component) {
        if (!(component instanceof JRadioButton)) {
            throw new IllegalArgumentException("Invalid component type. Expected JRadioButton.");
        }

        JRadioButton radioButton = (JRadioButton) component;
        boolean radioIsValid = getValidator().validate(radioButton.isSelected());

        if (!radioIsValid) {
            radioButton.setForeground(new Color(255, 155, 163));  // Use setForeground for radio button text color
        } else {
            radioButton.setForeground(Color.BLACK);
        }

        return radioIsValid;
    }

    @Override
    public Validator<Boolean> getValidator() {
        return validator;
    }
}
