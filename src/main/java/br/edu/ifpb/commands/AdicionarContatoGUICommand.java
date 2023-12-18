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
    private final JFrame parent;
    private final JRadioButton favoritosRadioButton;
    private final JRadioButton trabalhoRadioButton;
    private final JRadioButton pessoalRadioButton;
    private final JRadioButton whatsappRadioButton;
    private final JRadioButton emailRadioButton;
    private final JRadioButton instagramRadioButton;
    private final ContatoService service = new ContatoService(ContatoRepository.getInstance());

    public AdicionarContatoGUICommand(JFrame parent, JTextField nome, JTextField sobrenome,
            Boolean ligacao, Boolean chamadaVideo, String categoria, JTextField valorDaEntrada,
            String redeSocial, JTextField telefone, JTextField aniversario,
            JRadioButton favoritosRadioButton, JRadioButton trabalhoRadioButton, JRadioButton pessoalRadioButton,
            JRadioButton whatsappRadioButton, JRadioButton emailRadioButton, JRadioButton instagramRadioButton) {
        this.parent = parent;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ligacao = ligacao;
        this.chamadaVideo = chamadaVideo;
        this.categoria = categoria;
        this.valorDaEntrada = valorDaEntrada;
        this.redeSocial = redeSocial;
        this.telefone = telefone;
        this.aniversario = aniversario;
        this.favoritosRadioButton = favoritosRadioButton;
        this.trabalhoRadioButton = trabalhoRadioButton;
        this.pessoalRadioButton = pessoalRadioButton;
        this.whatsappRadioButton = whatsappRadioButton;
        this.emailRadioButton = emailRadioButton;
        this.instagramRadioButton = instagramRadioButton;
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
        GUITextValidator telefoneValidator = new GUITextValidator(new TelefoneValidator(true));
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
        boolean valorDaEntradaIsValid = valorDaEntradaValidator == null ? true : valorDaEntradaValidator.validate(valorDaEntrada);

        // Verificação adicional para campos em branco
        if (nomeStr.isEmpty() || sobrenomeStr.isEmpty() ||  telefoneStr.isEmpty() || aniversarioStr.isEmpty()  ) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar. Selecione pelo menos uma opção em Redes Sociais e Categoria.");
              // Retorna se algum campo estiver em branco
        } 

        if (nomeIsValid && sobrenomeIsValid  && telefoneIsValid && aniversarioIsValid) {
            JOptionPane.showMessageDialog(nome.getParent(), "Contato adicionado com sucesso.");
            service.criar(nomeStr, sobrenomeStr, ligacao, chamadaVideo, categoriaStr, valorDaEntradaStr, redeSocialStr, telefoneStr, aniversarioStr);
            parent.setVisible(false);
        }
    }
}
