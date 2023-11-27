package main.java.br.edu.ifpb.commands;

import javax.swing.*;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.GUITextValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;


public class AdicionarContatoGUICommand implements Command{
    private final JTextField nome;
    private final JTextField sobrenome;
    private final JTextField ligacao;
    private final JTextField chamadaVideo;
    private final JTextField categoria;
    private final JTextField valorDaEntrada;
    private final JTextField redeSocial;
    private final JTextField telefone;
    private final JTextField aniversario;
    private final JFrame frame;

    private final ContatoService service = new ContatoService(ContatoRepository.getInstance());

    public AdicionarContatoGUICommand(JTextField nome, JTextField sobrenome, JTextField ligacao,
            JTextField chamadaVideo, JTextField categoria, JTextField valorDaEntrada, JTextField redeSocial,
            JTextField telefone, JTextField aniversario, JFrame frame) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ligacao = ligacao;
        this.chamadaVideo = chamadaVideo;
        this.categoria = categoria;
        this.valorDaEntrada = valorDaEntrada;
        this.redeSocial = redeSocial;
        this.telefone = telefone;
        this.aniversario = aniversario;
        this.frame = frame;
    }

    @Override
    public void execute(){
        String nomeStr = nome.getText();
        String sobrenomeStr = sobrenome.getText();
        // String ligacaoBoo = ligacao.getText();
        // String chamadaVideoBoo = chamadaVideo.getText();
        String categoriaStr = categoria.getText();
        String valorDaEntradaStr = valorDaEntrada.getText();
        String redeSocialStr = redeSocial.getText();
        String telefoneStr = telefone.getText();
        String aniversarioStr = aniversario.getText();


        GUITextValidator nomeValidator = new GUITextValidator(new NonEmptyValidator());

        boolean nomeIsValid = nomeValidator.validate(nome);

        if (nomeIsValid) {
            JOptionPane.showMessageDialog(nome.getParent(), "Paciente cadastrado com sucesso.");
            service.criar(nomeStr, sobrenomeStr, false, false, categoriaStr,  valorDaEntradaStr, redeSocialStr, telefoneStr, aniversarioStr);
            frame.setVisible(false);
        }


    }
}
