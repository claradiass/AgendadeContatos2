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
    private final JFrame frame;
    private final ContatoService service = new ContatoService(ContatoRepository.getInstance());

    public EditarContatoGUICommand(JFrame frame, JTextField nome, JTextField sobrenome, JTextField telefone, JTextField aniversario) {
        this.frame = frame;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.aniversario = aniversario;
    }
    @Override
    public void execute() {
        String nomeStr = nome.getText();
        String sobrenomeStr = sobrenome.getText();        
        String telefoneStr = telefone.getText();
        String aniversarioStr = aniversario.getText();

        GUITextValidator nomeValidator = new GUITextValidator(new NonEmptyValidator());        
        GUITextValidator sobrenomeValidator = new GUITextValidator(new NonEmptyValidator());

        GUITextValidator telefoneValidator = new GUITextValidator(new TelefoneValidator(false));
        GUITextValidator aniversarioValidator = new GUITextValidator(new AniversarioValidator());

        boolean nomeIsValid = nomeValidator.validate(nome);
        boolean sobrenomeIsValid = sobrenomeValidator.validate(sobrenome);
        boolean telefoneIsValid = telefoneValidator.validate(telefone);        
        boolean aniversarioIsValid = aniversarioValidator.validate(aniversario);

        if (nomeIsValid && sobrenomeIsValid && telefoneIsValid && aniversarioIsValid) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String telefonePattern = "\\(\\d{2}\\)\\d{5}-\\d{4}";
            Pattern pattern = Pattern.compile(telefonePattern);
            Matcher matcher = pattern.matcher(telefoneStr);

            try {
                service.editar(nomeStr, df.parse(aniversarioStr), telefonePattern);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            JOptionPane.showMessageDialog(nome.getParent(), "Contato editado com sucesso.");
            nome.setText("");
            dataDeNascimento.setText("");
            cpf.setText("");
            frame.setVisible(false);
        }
    }
}