package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.TelefoneValidator;
import main.java.br.edu.ifpb.validators.UserValidator;
import main.java.br.edu.ifpb.validators.AniversarioValidator;
import main.java.br.edu.ifpb.validators.EmailValidator;
import main.java.br.edu.ifpb.validators.GUITextValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditarContatoGUICommand implements Command {
    private final JFrame parent;
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

    public EditarContatoGUICommand(JFrame parent, JTextField nome, JTextField sobrenome, Boolean ligacao,
    Boolean chamadaVideo, String categoria, JTextField valorDaEntrada,
    String redeSocial, JTextField telefone, JTextField aniversario) {
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
    
    }
    @Override
    public void execute() {
        String nomeStr = nome.getText();
        String sobrenomeStr = sobrenome.getText();        
        String telefoneStr = telefone.getText();
        String aniversarioStr = aniversario.getText();
        String valorDaEntradaStr = valorDaEntrada.getText();
        String redeSocialStr = redeSocial;
        String categoriaStr = categoria;
        
        

        GUITextValidator nomeValidator = new GUITextValidator(new NonEmptyValidator());        
        GUITextValidator sobrenomeValidator = new GUITextValidator(new NonEmptyValidator());

        GUITextValidator telefoneValidator = new GUITextValidator(new TelefoneValidator(false));
        GUITextValidator aniversarioValidator = new GUITextValidator(new AniversarioValidator());
        GUITextValidator redeSocialValidator = new GUITextValidator(new NonEmptyValidator());        
        GUITextValidator categoriaValidator = new GUITextValidator(new NonEmptyValidator());

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
        boolean valorDaEntradaIsValid = valorDaEntradaValidator.validate(valorDaEntrada);

        if (nomeIsValid && sobrenomeIsValid && telefoneIsValid && aniversarioIsValid && valorDaEntradaIsValid) {
            service.editar(nomeStr, sobrenomeStr, false, false, categoriaStr, valorDaEntradaStr, redeSocialStr, telefoneStr, aniversarioStr);
            JOptionPane.showMessageDialog(nome.getParent(), "Contato editado com sucesso.");
            nome.setText("");
            sobrenome.setText("");
            telefone.setText("");
            parent.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Corrija os campos inválidos antes de continuar.");
        }
    }        
}
