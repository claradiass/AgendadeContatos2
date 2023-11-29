package main.java.br.edu.ifpb.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.java.br.edu.ifpb.commands.CommandExecutor;
import main.java.br.edu.ifpb.domain.Contato;

import java.awt.*;
import java.text.SimpleDateFormat;

public class ContatoWindow {
    private final JFrame frame;

    public ContatoWindow(MainWindow main, Contato contato){
        CommandExecutor commandExecutor = new CommandExecutor();

        frame = new JFrame("Adicionar Contato");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelData = new JLabel("Data de nascimento:");

    }

    public void show() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
