package main.java.br.edu.ifpb.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OpcionalDateValidator implements Validator<String> {

    @Override
    public boolean validate(String data) {
        if(data.equals("")) return true;
        
        try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.parse(data);

        return true;

        } catch (ParseException e) {
        return false;
        }
    }
}