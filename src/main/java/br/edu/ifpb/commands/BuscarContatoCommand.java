package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.domain.Contato;
import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;
import main.java.br.edu.ifpb.validators.ValidationContext;

import java.util.List;


public class BuscarContatoCommand implements Command{

    @Override
    public void execute(){
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());


        System.out.println("\n=================================");
        System.out.println("Buscar contatos\n");
        System.out.print("Digite parte do nome para buscar: ");
        ValidationContext<String> strValidationContext = new ValidationContext<>(new NonEmptyValidator());

        String nome = strValidationContext.getValidValue("Digite parte do nome para buscar: ", "Termo de busca não pode ser vazio", String.class);
        List<Contato> resultado = contatoService.buscar(nome);

        System.out.println("\nResultado:\n");

        for(Contato c: resultado){
            System.out.println(c);
        }

    }
    
}