package main.java.br.edu.ifpb.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;

public class TelefoneValidator implements Validator<String>{
  private final ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());
  private final boolean checkIfExists;

  public TelefoneValidator(boolean checkIfExists){
    this.checkIfExists = checkIfExists;
  }

  @Override
  public boolean validate(String data) {
    String telefonePattern = "\\(\\d{2}\\)\\d{5}-\\d{4}";
    Pattern pattern = Pattern.compile(telefonePattern);
    Matcher matcher = pattern.matcher(data);

    return matcher.matches() && (!checkIfExists || !contatoService.existe(data));
  }
}
