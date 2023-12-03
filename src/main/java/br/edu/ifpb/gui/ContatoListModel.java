package main.java.br.edu.ifpb.gui;

import javax.swing.DefaultListModel;

import main.java.br.edu.ifpb.domain.Contato;


public class ContatoListModel extends DefaultListModel<Contato> {
    @Override
    public String getElementAt(int index) {
        Contato contato = getElementAt(index);
        // Edite esta linha conforme necessário para personalizar a exibição do Contato
        return contato.getNome() + " - " + contato.getTelefone();
    }
}

