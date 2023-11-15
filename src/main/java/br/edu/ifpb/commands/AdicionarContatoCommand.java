package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.*;

public class AdicionarContatoCommand implements Command {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[91m";
    public static final String GREEN = "\u001B[32m";

    @Override
    public void execute() {
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n-----------------------------------");
        System.out.println("Adicionar um novo contato");
        System.out.println("-----------------------------------");

        ValidationContext<String> strValidationContext = new ValidationContext<>(new NonEmptyValidator());
        ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, 4));
        ValidationContext<Integer> intValidationContext2 = new ValidationContext<>(new IntervalValidator(1, 3));

        System.out.println("Escolha a Rede Social:");
        System.out.println("[1] - Email");
        System.out.println("[2] - WhatsApp");
        System.out.println("[3] - Instagram");
        System.out.println("[4] - Outra");

        int escolhaRedeSocial = intValidationContext.getValidValue("Escolha a opção desejada: ",
                RED + "Escolha inválida, escolha entre 1 e 4 (inclusivo)" + RESET, Integer.class);

        String redeSocial = "";

        String nome = strValidationContext.getValidValue("Nome: ", RED + "Nome não pode ser vazio" + RESET, String.class);
        String sobrenome = strValidationContext.getValidValue("Sobrenome: ", RED + "Sobrenome não pode ser vazio" + RESET, String.class);

        strValidationContext.setValidator(new TelefoneValidator(true));
        String telefone = strValidationContext.getValidValue("Telefone: ",
                RED + "Telefone não pode ser vazio e não pode estar no formato errado, formato correto: (xx)xxxxx-xxxx" + RESET, String.class);

        strValidationContext.setValidator(new AniversarioValidator());
        String aniversario = strValidationContext.getValidValue("Aniversário: ",
                RED + "Aniversário não pode ser vazio e não pode estar no formato errado, formato correto: DD/MM/YYYY" + RESET, String.class);

        boolean ligacao = false;
        boolean chamadaVideo = false;
        String valorDaEntrada = "";

        switch (escolhaRedeSocial) {
            case 1:
                redeSocial = "Email";
                strValidationContext.setValidator(new EmailValidator(true));
                valorDaEntrada = strValidationContext.getValidValue("Email: ", RED + "Email não pode ser vazio e não pode estar no formato errado, formato correto: name@example.com" + RESET, String.class);
                break;
            case 2:
                redeSocial = "WhatsApp";
                ligacao = true;
                chamadaVideo = true;
                break;
            case 3:
                redeSocial = "Instagram";
                strValidationContext.setValidator(new UserValidator(true));
                valorDaEntrada = strValidationContext.getValidValue("Usuário: ", RED + "Usuário não pode ser vazio e não pode estar no formato errado, formato correto: @examplename, podendo conter .-_1-9" + RESET, String.class);
                chamadaVideo = true;
                break;
            case 4:
                ValidationContext<String> nomeRedeSocialValidationContext = new ValidationContext<>(new NonEmptyValidator());
                redeSocial = nomeRedeSocialValidationContext.getValidValue("Escolha o nome: ", RED + "Nome não pode ser vazio" + RESET, String.class);
                System.out.println("Escolha um dado específico: [1] - Email, [2] - Usuário");

                int escolhaValorDaEntrada = intValidationContext2.getValidValue("Escolha a opção desejada: ",
                        RED + "Escolha inválida, escolha entre 1 e 2 (inclusivo)" + RESET, Integer.class);

                switch (escolhaValorDaEntrada) {
                    case 1:
                        strValidationContext.setValidator(new EmailValidator(true));
                        valorDaEntrada = strValidationContext.getValidValue("Email: ", RED + "Email não pode ser vazio e não pode estar no formato errado, formato correto: name@example.com" + RESET, String.class);
                        break;
                    case 2:
                        strValidationContext.setValidator(new UserValidator(true));
                        valorDaEntrada = strValidationContext.getValidValue("Usuário: ", RED + "Usuário não pode ser vazio e não pode estar no formato errado, formato correto: @examplename, podendo conter .-_1-9" + RESET, String.class);
                        break;
                    default:
                        System.out.println("Opção inválida");
                        return; // Encerra o método se a opção não for válida
                }
                break;
        }

        System.out.println("\nEscolha uma categoria:\n[1] - Favoritos\n[2] - Pessoal\n[3] - Trabalho");

        int escolhaCategoria = intValidationContext2.getValidValue("Escolha a opção desejada: ",
                RED + "Escolha inválida, escolha entre 1 e 3 (inclusivo)" + RESET, Integer.class);

        String categoria = switch (escolhaCategoria) {
            case 1 -> "Favoritos";
            case 2 -> "Pessoal";
            case 3 -> "Trabalho";
            default -> "";
        };

        contatoService.criar(nome, sobrenome, ligacao, chamadaVideo, categoria, valorDaEntrada, redeSocial, telefone, aniversario);
        System.out.println(GREEN + "\nContato adicionado ao aplicativo " + redeSocial + " com sucesso!" + RESET);
    }
}
