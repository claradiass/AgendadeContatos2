package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.TelefoneValidator;
import main.java.br.edu.ifpb.validators.AniversarioValidator;
import main.java.br.edu.ifpb.validators.GUITextValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditarContatoGUICommand implements Command {
    private final JTextField nome;
    private final JTextField sobrenome;
    private final JTextField telefone;        
    private final JTextField aniversario;
    private final JRadioButton redeSocial;
    private final JTextField valorDaEntrada;
    private final JRadioButton categoria;

    private final JFrame frame;
    private final ContatoService service = new ContatoService(ContatoRepository.getInstance());

    public EditarContatoGUICommand(JFrame frame, JTextField nome, JTextField sobrenome, JTextField telefone, JTextField aniversario, JRadioButton redeSocial, JRadioButton categoria, JTextField valorDaEntrada) {
        this.frame = frame;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.aniversario = aniversario;
        this.redeSocial = redeSocial;
        this.categoria = categoria;
        this.valorDaEntrada = valorDaEntrada;
    }
    @Override
    public void execute() {
        String nomeStr = nome.getText();
        String sobrenomeStr = sobrenome.getText();        
        String telefoneStr = telefone.getText();
        String aniversarioStr = aniversario.getText();
        String redeSocialStr = redeSocial.getText();
        String categoriaStr = categoria.getText();
        String valorDaEntradaStr = valorDaEntrada.getText();
        

        GUITextValidator nomeValidator = new GUITextValidator(new NonEmptyValidator());        GUITextValidator sobrenomeValidator = new GUITextValidator(new NonEmptyValidator());

        GUITextValidator telefoneValidator = new GUITextValidator(new TelefoneValidator(false));
        GUITextValidator aniversarioValidator = new GUITextValidator(new AniversarioValidator());
        GUITextValidator redeSocialValidator = new GUITextValidator(new NonEmptyValidator());        GUITextValidator valorDaEntradaValidator = new GUITextValidator(new NonEmptyValidator());       
        GUITextValidator categoriaValidator = new GUITextValidator(new NonEmptyValidator());


        boolean nomeIsValid = nomeValidator.validate(nome);
        boolean sobrenomeIsValid = sobrenomeValidator.validate(sobrenome);
        boolean telefoneIsValid = telefoneValidator.validate(telefone);        
        boolean aniversarioIsValid = aniversarioValidator.validate(aniversario);
        boolean valorDaEntradaIsValid = valorDaEntradaValidator.validate(valorDaEntrada);


        if (nomeIsValid && sobrenomeIsValid && telefoneIsValid && aniversarioIsValid && valorDaEntradaIsValid) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String telefonePattern = "\\(\\d{2}\\)\\d{5}-\\d{4}";
            Pattern pattern = Pattern.compile(telefonePattern);
            Matcher matcher = pattern.matcher(telefoneStr);
        
            nome.setText("");
            sobrenome.setText("");
            telefone.setText("");
            aniversario.setText("");
            valorDaEntrada.setText("");
            frame.setVisible(false);
        
            try {
                service.editar(nomeStr, sobrenomeStr, false, false, categoriaStr, valorDaEntradaStr, redeSocialStr, telefoneStr, aniversarioStr);
                JOptionPane.showMessageDialog(nome.getParent(), "Contato editado com sucesso.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Erro ao converter a data. Certifique-se de que a data esteja no formato dd/MM/yyyy.");
                e.printStackTrace();
                return;
                // Adicione um return ou outra lógica apropriada aqui se desejar interromper a execução após a exceção.
            }
        }
    }
}