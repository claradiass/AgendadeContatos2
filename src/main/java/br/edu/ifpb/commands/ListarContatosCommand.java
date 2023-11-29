package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.domain.Contato;


public class ListarContatosCommand implements Command {
    @Override
    public void execute() {
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n-------------------------------");
        System.out.println("Listar contatos");
        System.out.println("-------------------------------\n");

        for(Contato c: contatoService.getContatos()){
            System.out.println(c);
        }
    }
}




