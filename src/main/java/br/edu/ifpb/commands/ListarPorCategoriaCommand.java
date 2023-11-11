package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.IntervalValidator;
import main.java.br.edu.ifpb.validators.ValidationContext;
import main.java.br.edu.ifpb.domain.Contato;

import java.util.List;
import java.util.stream.Collectors;

public class ListarPorCategoriaCommand implements Command {
    @Override
    public void execute() {
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());
        List<Contato> contatos = contatoService.getContatos();

        System.out.println("\n-------------------------------");
        System.out.println("Listar contatos por Categoria\n");
        System.out.println("\n-------------------------------");
        System.out.println("[1] - Favoritos \n[2] - Pessoal \n[3] - Trabalho");

        ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, 3));
        int escolhaCategoria = intValidationContext.getValidValue("Escolha a opção desejada: ",
                "Escolha inválida, escolha entre 1 e 3 (inclusivo)", Integer.class);

        List<Contato> contatosFiltrados = contatos.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(getCategoriaFromChoice(escolhaCategoria)))
                .collect(Collectors.toList());

        System.out.println(contatosFiltrados);
    }

    private String getCategoriaFromChoice(int escolhaCategoria) {
        switch (escolhaCategoria) {
            case 1:
                return "Favoritos";
            case 2:
                return "Pessoal";
            case 3:
                return "Trabalho";
            default:
                throw new IllegalArgumentException("Escolha de Categoria inválida: " + escolhaCategoria);
        }
    }
}
