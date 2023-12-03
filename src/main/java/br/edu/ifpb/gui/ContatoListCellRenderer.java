package main.java.br.edu.ifpb.gui;

import javax.swing.*;

import main.java.br.edu.ifpb.domain.Contato;

import java.awt.*;
import java.util.List;

public class ContatoListCellRenderer extends JLabel implements ListCellRenderer<Contato> {
    private Icon iconePadrao;

    public ContatoListCellRenderer(Icon iconePadrao) {
        this.iconePadrao = iconePadrao;
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Contato> list, Contato value, int index, boolean isSelected, boolean cellHasFocus) {
        setIcon(iconePadrao);
        setText(value != null ? value.getNome() + " " + value.getSobrenome() : "");
        setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());

        return this;
    }
}

