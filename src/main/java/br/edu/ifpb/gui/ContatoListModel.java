package main.java.br.edu.ifpb.gui;

import javax.swing.DefaultListModel;

import main.java.br.edu.ifpb.domain.Contato;

import javax.swing.*;
import java.util.List;

public class ContatoListModel extends DefaultListModel<Contato> {
    private List<Contato> contatos;
    private Icon iconePadrao;

    public ContatoListModel(List<Contato> contatos, Icon iconePadrao) {
        this.contatos = contatos;
        this.iconePadrao = iconePadrao;
        updateModel();
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
        updateModel();
    }

    private void updateModel() {
        clear();
        for (Contato contato : contatos) {
            addElement(contato);
        }
    }

    public ListCellRenderer<Contato> getRenderer() {
        return new ContatoListCellRenderer(iconePadrao);
    }
}




