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
        GUITextValidator categoriaValidator = new GUITextValidator(new NonEmptyValidator());

        // GUITextValidator valorDaEntradaValidator = new GUITextValidator(new NonEmptyValidator());

        GUITextValidator redeSocialValidator = new GUITextValidator(new NonEmptyValidator());
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
        // boolean categoriaIsValid = categoriaValidator.validate(categoria);
        boolean valorDaEntradaIsValid = valorDaEntradaValidator.validate(valorDaEntrada);
        // boolean redeSocialIsValid = redeSocialValidator.validate(redeSocial);
        boolean telefoneIsValid = telefoneValidator.validate(telefone);
        boolean aniversarioIsValid = aniversarioValidator.validate(aniversario);

        if (nomeIsValid && sobrenomeIsValid && valorDaEntradaIsValid  && telefoneIsValid && aniversarioIsValid) {
            JOptionPane.showMessageDialog(nome.getParent(), "Contato adicionado com sucesso.");
            service.criar(nomeStr, sobrenomeStr, ligacao, chamadaVideo, categoriaStr, valorDaEntradaStr, redeSocialStr, telefoneStr, aniversarioStr);
        }
    }
}
