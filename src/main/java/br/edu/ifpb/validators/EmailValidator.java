package main.java.br.edu.ifpb.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;

public class EmailValidator implements Validator<String>{
    private final ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());
    private final boolean checkIfExists;

    public EmailValidator(boolean checkIfExists) {
        // Construtor da classe que permite definir se a validação deve verificar a existência do CPF.
        this.checkIfExists = checkIfExists;
    }

    @Override
    public boolean validate(String data) {
        String contatoPattern = "^[A-Za-z0-9+_.-]+@(.+)$"; 
        Pattern pattern = Pattern.compile(contatoPattern);
        Matcher matcher = pattern.matcher(data);

    return matcher.matches() && (!checkIfExists || !contatoService.existe(data));
    }

}





