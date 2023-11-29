package main.java.br.edu.ifpb.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.java.br.edu.ifpb.commands.AdicionarContatoGUICommand;
import main.java.br.edu.ifpb.commands.CommandExecutor;
import main.java.br.edu.ifpb.commands.EditarContatoCommand;
import main.java.br.edu.ifpb.domain.Contato;

import java.awt.*;
import java.text.SimpleDateFormat;

public class ContatoWindow extends javax.swing.JFrame{
    private ImagePanel imagePanel;

    private final JFrame frame;    
    private final JTextField txtNome;    
    private final JTextField txtSobrenome;
    private final JTextField txtValorDaEntrada;
    private final JTextField txtRedeSocial;    
    private final JTextField txtTelefone;
    private final JTextField txtAniversario;

    public ContatoWindow(MainWindow main, Contato contato){
        imagePanel = new ImagePanel("Blue wallpaper.png");
        setContentPane(imagePanel);

        
        CommandExecutor commandExecutor = new CommandExecutor();
        
        frame = new JFrame("Adicionar Contato");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelSobrenome = new JLabel("Sobrenome:");
        JLabel labelRedeSocial = new JLabel("Rede Social:");
        JLabel labelValorDeEntrada = new JLabel("Dado específico:");
        JLabel labelTelefone = new JLabel("Telefone:");        
        JLabel labelAniversario = new JLabel("Aniversario:");

        txtNome = new JTextField();        
        txtSobrenome = new JTextField();
        txtRedeSocial = new JTextField();
        txtValorDaEntrada = new JTextField();
        txtTelefone = new JTextField();
        txtAniversario = new JTextField();

        if(contato != null){
            txtNome.setText(contato.getNome());            
            txtSobrenome.setText(contato.getSobrenome());
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            txtAniversario.setText(df.format(contato.getAniversario()));
        }

        JButton btnCriar = new JButton(contato == null ? "Criar" : "Editar");
        btnCriar.addActionListener(e -> {
            if(contato == null){
                commandExecutor.executeCommand(new AdicionarContatoGUICommand(txtNome, txtSobrenome, txtAniversario, txtSobrenome, txtNome, txtValorDaEntrada, txtRedeSocial, txtTelefone, txtAniversario, main));
            } 

            main.update(null);
        });

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> frame.setVisible(false));

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
        fieldsPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
        labelNome.setAlignmentX(Component.LEFT_ALIGNMENT);
        fieldsPanel.add(labelNome);
        txtNome.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtNome.setMaximumSize(new Dimension(400, 30));
        fieldsPanel.add(txtNome);

        labelAniversario.setAlignmentX(Component.LEFT_ALIGNMENT);
        fieldsPanel.add(labelAniversario);
        txtAniversario.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtAniversario.setMaximumSize(new Dimension(400, 30));
        fieldsPanel.add(txtAniversario);

        labelTelefone.setAlignmentX(Component.LEFT_ALIGNMENT);
        fieldsPanel.add(labelTelefone);
        txtTelefone.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtTelefone.setMaximumSize(new Dimension(400, 30));
        fieldsPanel.add(txtTelefone);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(btnCancelar);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonPanel.add(btnCriar);

        frame.add(fieldsPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.PAGE_END);
    }
    
    public void update() {

    }



    public void show() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

