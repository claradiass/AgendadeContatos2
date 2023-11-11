package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.domain.Contato;
import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.IntervalValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;
import main.java.br.edu.ifpb.validators.ValidationContext;

import java.util.List;

public class ExcluirContatoCommand implements Command {

  @Override
  public void execute() {
    ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n-----------------------------------");
        System.out.println("Excluir contato\nBusque um contato para excluir");
        System.out.println("\n-----------------------------------");

        ValidationContext<String> strValidationContext = new ValidationContext<>(new NonEmptyValidator());
        String termo = strValidationContext.getValidValue("Digite parte do nome para buscar: ", "O termo de busca não pode ser vazio", String.class);

        List<Contato> resultado = contatoService.buscar(termo);

        System.out.println("\nResultados:\n");

        int indice = 0;

        for(Contato c: resultado){
          System.out.println(++indice + " - " + c);
        }

        ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, indice));
        int indiceDigitado = intValidationContext.getValidValue("Digite o índice do Contato que você deseja remover: ", String.format("O índice deve ser um valor entre 1 e %d (inclusive)%n", indice), Integer.class);

        contatoService.remover(resultado.get(indiceDigitado - 1));
        System.out.println("\nO contato de " + resultado.get(indiceDigitado - 1).getNome() +  " " + resultado.get(indiceDigitado - 1).getSobrenome() + " foi removido");

  }
  
}
