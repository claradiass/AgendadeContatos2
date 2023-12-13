// package main.java.br.edu.ifpb.commands;

// import javax.swing.*;

// import main.java.br.edu.ifpb.repository.ContatoRepository;
// import main.java.br.edu.ifpb.service.ContatoService;
// import main.java.br.edu.ifpb.validators.AniversarioValidator;
// import main.java.br.edu.ifpb.validators.EmailValidator;
// import main.java.br.edu.ifpb.validators.GUITextValidator;
// import main.java.br.edu.ifpb.validators.NonEmptyValidator;
// import main.java.br.edu.ifpb.validators.TelefoneValidator;
// import main.java.br.edu.ifpb.validators.UserValidator;


// public class AdicionarContatoGUICommand implements Command {
//     private final JTextField nome;
//     private final JTextField sobrenome;
//     private final Boolean ligacao;
//     private final Boolean chamadaVideo;
//     private final String categoria;
//     private final JTextField valorDaEntrada;
//     private final String redeSocial;
//     private final JTextField telefone;
//     private final JTextField aniversario;

//     private final ContatoService service = new ContatoService(ContatoRepository.getInstance());

//     public AdicionarContatoGUICommand(JTextField nome, JTextField sobrenome, Boolean ligacao,
//                                     Boolean chamadaVideo, String categoria, JTextField valorDaEntrada,
//                                     String redeSocial, JTextField telefone, JTextField aniversario) {
//         this.nome = nome;
//         this.sobrenome = sobrenome;
//         this.ligacao = ligacao;
//         this.chamadaVideo = chamadaVideo;
//         this.categoria = categoria;
//         this.valorDaEntrada = valorDaEntrada;
//         this.redeSocial = redeSocial;
//         this.telefone = telefone;
//         this.aniversario = aniversario;
//     }

//     @Override
//     public void execute() {
//         String nomeStr = nome.getText();
//         String sobrenomeStr = sobrenome.getText();
//         boolean ligacaoValor = ligacao != null && ligacao; // Se ligacao for null, assume false
//         boolean chamadaVideoValor = chamadaVideo != null && chamadaVideo; // Se chamadaVideo for null, assume false
//         String categoriaStr = categoria;
//         String valorDaEntradaStr = valorDaEntrada.getText();
//         String redeSocialStr = redeSocial;
//         String telefoneStr = telefone.getText();
//         String aniversarioStr = aniversario.getText();

//         GUITextValidator nomeValidator = new GUITextValidator(new NonEmptyValidator());
//         GUITextValidator sobrenomeValidator = new GUITextValidator(new NonEmptyValidator());
//         // GUITextValidator categoriaValidator = new GUITextValidator(new NonEmptyValidator());
//         // GUITextValidator redeSocialValidator = new GUITextValidator(new NonEmptyValidator());
        
//         GUITextValidator telefoneValidator = new GUITextValidator(new TelefoneValidator(false));
//         GUITextValidator aniversarioValidator = new GUITextValidator(new AniversarioValidator());

//         GUITextValidator valorDaEntradaValidator = null;
//         if ("Email".equalsIgnoreCase(redeSocialStr)) {
//             valorDaEntradaValidator = new GUITextValidator(new EmailValidator(false));
//         } else if ("Instagram".equalsIgnoreCase(redeSocialStr)) {
//             valorDaEntradaValidator = new GUITextValidator(new UserValidator(false));
//         }

//         boolean nomeIsValid = nomeValidator.validate(nome);
//         boolean sobrenomeIsValid = sobrenomeValidator.validate(sobrenome);
//         boolean telefoneIsValid = telefoneValidator.validate(telefone);
//         boolean aniversarioIsValid = aniversarioValidator.validate(aniversario);
//         // boolean categoriaIsValid = categoriaValidator.validate(categoria);
//         boolean valorDaEntradaIsValid = valorDaEntradaValidator.validate(valorDaEntrada);
//         // boolean redeSocialIsValid = redeSocialValidator.validate(redeSocial);
        
//         // Verificação adicional para campos em branco
//         if (nomeStr.isEmpty() || sobrenomeStr.isEmpty() || valorDaEntradaStr.isEmpty() || telefoneStr.isEmpty() || aniversarioStr.isEmpty()) {
//             JOptionPane.showMessageDialog(nome.getParent(), "Preencha todos os campos antes de continuar.");
//             return;  // Retorna se algum campo estiver em branco
//         }
//         // Verificação para pelo menos um RadioButton de rede social e um RadioButton de categoria selecionados
//         // if (redeSocialGroup.getSelection() == null || (!radioCategoria1.isSelected() && !radioCategoria2.isSelected())) {
//         //     JOptionPane.showMessageDialog(nome.getParent(), "Selecione pelo menos um RadioButton de rede social e um RadioButton de categoria.");
//         //     return;  // Retorna se as condições não forem atendidas
//         // }

//         if (nomeIsValid && sobrenomeIsValid && valorDaEntradaIsValid  && telefoneIsValid && aniversarioIsValid) {
//             JOptionPane.showMessageDialog(nome.getParent(), "Contato adicionado com sucesso.");
//             service.criar(nomeStr, sobrenomeStr, ligacao, chamadaVideo, categoriaStr, valorDaEntradaStr, redeSocialStr, telefoneStr, aniversarioStr);
//         }

//         // try {
//         //     if (nomeIsValid && sobrenomeIsValid && valorDaEntradaIsValid && telefoneIsValid && aniversarioIsValid) {
//         //         // Se o código dentro deste bloco lançar uma exceção, ela será capturada pelos blocos catch abaixo.
//         //         JOptionPane.showMessageDialog(nome.getParent(), "Contato adicionado com sucesso.");
//         //         service.criar(nomeStr, sobrenomeStr, ligacao, chamadaVideo, categoriaStr, valorDaEntradaStr, redeSocialStr, telefoneStr, aniversarioStr);
//         //     } else {
//         //         // Adicione aqui qualquer código que você queira executar em caso de falha nas validações acima.
//         //     }
//         // } catch (Exception e) {
//         //     // Esta parte será executada se ocorrer qualquer exceção dentro do bloco try.
//         //     e.printStackTrace(); // Isso imprime o rastreamento da pilha, o que é útil para depuração.
//         //     JOptionPane.showMessageDialog(nome.getParent(), "Ocorreu um erro ao adicionar o contato. Consulte o console para obter mais detalhes.");
//         // }
//     }
// }





package main.java.br.edu.ifpb.commands;

import javax.swing.*;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.AniversarioValidator;
import main.java.br.edu.ifpb.validators.EmailValidator;
import main.java.br.edu.ifpb.validators.GUITextValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;
import main.java.br.edu.ifpb.validators.TelefoneValidator;
import main.java.br.edu.ifpb.validators.UserValidator;


public class AdicionarContatoGUICommand implements Command {
    private final JTextField nome;
    private final JTextField sobrenome;
    private final Boolean ligacao;
    private final Boolean chamadaVideo;
    private final String categoria;
    private final JTextField valorDaEntrada;
    private final String redeSocial;
    private final JTextField telefone;
    private final JTextField aniversario;

    private final ContatoService service = new ContatoService(ContatoRepository.getInstance());

    public AdicionarContatoGUICommand(JTextField nome, JTextField sobrenome, Boolean ligacao,
                                    Boolean chamadaVideo, String categoria, JTextField valorDaEntrada,
                                    String redeSocial, JTextField telefone, JTextField aniversario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ligacao = ligacao;
        this.chamadaVideo = chamadaVideo;
        this.categoria = categoria;
        this.valorDaEntrada = valorDaEntrada;
        this.redeSocial = redeSocial;
        this.telefone = telefone;
        this.aniversario = aniversario;
    }

    @Override
    public void execute() {
        String nomeStr = nome.getText();
        String sobrenomeStr = sobrenome.getText();
        boolean ligacaoValor = ligacao != null && ligacao; // Se ligacao for null, assume false
        boolean chamadaVideoValor = chamadaVideo != null && chamadaVideo; // Se chamadaVideo for null, assume false
        String categoriaStr = categoria;
        String valorDaEntradaStr = valorDaEntrada.getText();
        String redeSocialStr = redeSocial;
        String telefoneStr = telefone.getText();
        String aniversarioStr = aniversario.getText();

        GUITextValidator nomeValidator = new GUITextValidator(new NonEmptyValidator());
        GUITextValidator sobrenomeValidator = new GUITextValidator(new NonEmptyValidator());
        // GUITextValidator categoriaValidator = new GUITextValidator(new NonEmptyValidator());
        // GUITextValidator redeSocialValidator = new GUITextValidator(new NonEmptyValidator());
        
        GUITextValidator telefoneValidator = new GUITextValidator(new TelefoneValidator(false));
        GUITextValidator aniversarioValidator = new GUITextValidator(new AniversarioValidator());

        GUITextValidator valorDaEntradaValidator = null;
        if ("Email".equalsIgnoreCase(redeSocialStr)) {
            valorDaEntradaValidator = new GUITextValidator(new EmailValidator(false));
        } else if ("Instagram".equalsIgnoreCase(redeSocialStr)) {
            valorDaEntradaValidator = new GUITextValidator(new UserValidator(false));
        }

        boolean nomeIsValid = nomeValidator.validate(nome);
        boolean sobrenomeIsValid = sobrenomeValidator.validate(sobrenome);
        boolean telefoneIsValid = telefoneValidator.validate(telefone);
        boolean aniversarioIsValid = aniversarioValidator.validate(aniversario);
        // boolean categoriaIsValid = categoriaValidator.validate(categoria);
        boolean valorDaEntradaIsValid = valorDaEntradaValidator.validate(valorDaEntrada);
        // boolean redeSocialIsValid = redeSocialValidator.validate(redeSocial);
        
        // Verificação adicional para campos em branco
        if (nomeStr.isEmpty() || sobrenomeStr.isEmpty() || valorDaEntradaStr.isEmpty() || telefoneStr.isEmpty() || aniversarioStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar.");
              // Retorna se algum campo estiver em branco
        }
        // Verificação para pelo menos um RadioButton de rede social e um RadioButton de categoria selecionados
        // if (redeSocialGroup.getSelection() == null || (!radioCategoria1.isSelected() && !radioCategoria2.isSelected())) {
        //     JOptionPane.showMessageDialog(nome.getParent(), "Selecione pelo menos um RadioButton de rede social e um RadioButton de categoria.");
        //     return;  // Retorna se as condições não forem atendidas
        // }

        if (nomeIsValid && sobrenomeIsValid && valorDaEntradaIsValid  && telefoneIsValid && aniversarioIsValid) {
            JOptionPane.showMessageDialog(nome.getParent(), "Contato adicionado com sucesso.");
            service.criar(nomeStr, sobrenomeStr, ligacao, chamadaVideo, categoriaStr, valorDaEntradaStr, redeSocialStr, telefoneStr, aniversarioStr);
        }
    }
}
