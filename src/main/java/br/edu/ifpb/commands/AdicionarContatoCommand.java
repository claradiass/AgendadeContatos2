package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.AniversarioValidator;
import main.java.br.edu.ifpb.validators.EmailValidator;
import main.java.br.edu.ifpb.validators.IntervalValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;
import main.java.br.edu.ifpb.validators.UserValidator;
import main.java.br.edu.ifpb.validators.TelefoneValidator;
import main.java.br.edu.ifpb.validators.ValidationContext;

public class AdicionarContatoCommand implements Command {
    @Override
    public void execute() {
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n-----------------------------------");
        System.out.println("Adicionar um novo contato");
        System.out.println("-----------------------------------");

        ValidationContext<String> strValidationContext = new ValidationContext<>(new NonEmptyValidator());

        System.out.println("Escolha a Rede Social:");
        System.out.println("[1] - Email");
        System.out.println("[2] - WhatsApp");
        System.out.println("[3] - Instagram");
        System.out.println("[4] - Telegram");

        ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, 4));

        int escolhaRedeSocial = intValidationContext.getValidValue("Escolha a opção desejada: ",
                "Escolha inválida, escolha entre 1 e 4 (inclusivo)", Integer.class);
        String redeSocial = "";

        String nome = strValidationContext.getValidValue("Nome: ", "Nome não pode ser vazio", String.class);
        
        String sobrenome = strValidationContext.getValidValue("Sobrenome: ", "Sobrenome não pode ser vazio",
                String.class);

        strValidationContext.setValidator(new TelefoneValidator(true));
        String telefone = strValidationContext.getValidValue("Telefone: ",
                "Telefone inválido, digite neste formato (xx)xxxxx-xxxx", String.class);

        strValidationContext.setValidator(new AniversarioValidator());
        String aniversario = strValidationContext.getValidValue("Aniversário: ", "Aniversario não pode ser vazio",
                String.class);

        boolean ligacao = false;
        boolean chamadaVideo = false;
        String valorDaEntrada = "";

        if (escolhaRedeSocial == 1) {
            redeSocial = "Email";

            strValidationContext.setValidator(new EmailValidator(true));

            valorDaEntrada = strValidationContext.getValidValue("Email: ", "Email não pode ser vazio e não pode estar no formato errado, formato correto: (name@example.com)", String.class);
            
        } else if(escolhaRedeSocial == 2){

            redeSocial = "WhatsApp";
            ligacao = true;
            chamadaVideo = true;

        } else if (escolhaRedeSocial == 3) {
            redeSocial = "Instagram";

            strValidationContext.setValidator(new UserValidator(true));
            valorDaEntrada = strValidationContext.getValidValue("Usuário: ", "Usuário não pode ser vazio", String.class);

            chamadaVideo = true;

        } else if (escolhaRedeSocial == 4) {
            redeSocial = "Telegram";
            valorDaEntrada = strValidationContext.getValidValue("d: ", "Id não pode ser vazio", String.class);
            ligacao = true;
        }

        System.out.println("\nEscolha uma categoria:");
        System.out.println("[1] - Favoritos");
        System.out.println("[2] - Pessoal");
        System.out.println("[3] - Trabalho");

        int escolhaCategoria = intValidationContext.getValidValue("Escolha a opção desejada: ", "Escolha inválida, escolha entre 1 e 3 (inclusivo)", Integer.class);
        String categoria = "";
        
        if(escolhaCategoria == 1){
            categoria = "Favoritos";
        }else if(escolhaCategoria == 2){
            categoria = "Pessoal";
        }else if(escolhaCategoria == 3){
            categoria = "Trabalho";
        }

        contatoService.criar(nome, sobrenome, ligacao, chamadaVideo, categoria, valorDaEntrada, redeSocial, telefone, aniversario);
        System.out.println("Contato adicionado ao aplicativo " + redeSocial + " com sucesso!");

    }
}
