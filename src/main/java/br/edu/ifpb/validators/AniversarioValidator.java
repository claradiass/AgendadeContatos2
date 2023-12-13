package main.java.br.edu.ifpb.validators;

import java.util.regex.*;

public class AniversarioValidator implements Validator<String> {

    @Override
    public boolean validate(String data) {
        try {
            String regex = "\\d{2}/\\d{2}/\\d{4}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(data);

            return matcher.matches();
        } catch (Exception e) {
            if (!data.matches("\\d+")) {
              System.out.println("Erro: A data de aniversário deve conter apenas números.");
            }
            e.printStackTrace();
            return false;
        }
    }
}


// import java.text.ParseException;
// import java.text.SimpleDateFormat;

// public class AniversarioValidator implements Validator<String>{

//   @Override
//   public boolean validate(String data) {
//     try{
//       //fazer com regex
//       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//       dateFormat.parse(data);

//       return true;
//     }catch(ParseException e){
//       return false;
//     }
//   }
  
  
// }


