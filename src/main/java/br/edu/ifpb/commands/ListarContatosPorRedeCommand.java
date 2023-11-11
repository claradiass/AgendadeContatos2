// package main.java.br.edu.ifpb.commands;

// import main.java.br.edu.ifpb.repository.ContatoRepository;
// import main.java.br.edu.ifpb.service.ContatoService;
// import main.java.br.edu.ifpb.validators.IntervalValidator;
// import main.java.br.edu.ifpb.validators.ValidationContext;
// import main.java.br.edu.ifpb.domain.Contato;

// public class ListarContatosPorRedeCommand implements Command {
//     @Override
//     public void execute() {
//         ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

//         System.out.println("\n-------------------------------");
//         System.out.println("Listar contatos por Rede Social\n");
//         System.out.println("\n-------------------------------");
//         System.out.println(" [1] - Email \n[2] - WhatsApp \n[3] - Instagram \n[4] - Telegram ");

//         ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, 4));
//         int escolhaRedeSocial = intValidationContext.getValidValue("Escolha a opção desejada: ",
//                 "Escolha inválida, escolha entre 1 e 4 (inclusivo)", Integer.class);

//         if (escolhaRedeSocial == 1) {
//             List<Contato> contatosFiltrados = contatos.stream()
//                 .filter(c -> c.getRedeSocial().equalsIgnoreCase(categoria))
//                 .collect(Collectors.toList());
//         System.out.println(contatosFiltrados);
//         } else {
            
//         }

        

//         for (Contato c : contatoService.getContatos()) {
//             if (c.getRedeSocial() != null && c.getRedeSocial().equals(atributoRedeSocial)) {
//                 System.out.println("Nome: " + c.getNome());
//                 System.out.println("Rede Social: " + c.getRedeSocial());
//                 // Adicione outros atributos relevantes aqui
//                 System.out.println("====================");
//             }
//         }
//     }
// }




package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.IntervalValidator;
import main.java.br.edu.ifpb.validators.ValidationContext;
import main.java.br.edu.ifpb.domain.Contato;

import java.util.List;
import java.util.stream.Collectors;

public class ListarContatosPorRedeCommand implements Command {
    @Override
    public void execute() {
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());
        List<Contato> contatos = contatoService.getContatos();

        System.out.println("\n-------------------------------");
        System.out.println("Listar contatos por Rede Social\n");
        System.out.println("\n-------------------------------");
        System.out.println("[1] - Email \n[2] - WhatsApp \n[3] - Instagram \n[4] - Telegram ");

        ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, 4));
        int escolhaRedeSocial = intValidationContext.getValidValue("Escolha a opção desejada: ",
                "Escolha inválida, escolha entre 1 e 4 (inclusivo)", Integer.class);

        List<Contato> contatosFiltrados = contatos.stream()
                .filter(c -> c.getRedeSocial().equalsIgnoreCase(getRedeSocialFromChoice(escolhaRedeSocial)))
                .collect(Collectors.toList());

        System.out.println(contatosFiltrados);
    }

    private String getRedeSocialFromChoice(int escolhaRedeSocial) {
        switch (escolhaRedeSocial) {
            case 1:
                return "Email";
            case 2:
                return "WhatsApp";
            case 3:
                return "Instagram";
            case 4:
                return "Telegram";
            default:
                throw new IllegalArgumentException("Escolha de Rede Social inválida: " + escolhaRedeSocial);
        }
    }
}
