package main.java.br.edu.ifpb.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.java.br.edu.ifpb.commands.CommandExecutor;
import main.java.br.edu.ifpb.domain.Contato;

import java.awt.*;
import java.text.SimpleDateFormat;

public class ContatoWindow {
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

    public ContatoWindow(MainWindow main, Contato contato){
        CommandExecutor commandExecutor = new CommandExecutor();

        frame = new JFrame("Adicionar Contato");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelData = new JLabel("Data de nascimento:");

        txtNome = new JTextField();
        txtData = new JTextField();
    }
}
