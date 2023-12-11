package main.java.br.edu.ifpb.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.br.edu.ifpb.domain.Contato;

public class InMemoryDataService implements DataService {
    protected List<Contato> contatos = new ArrayList<>();

    @Override
    public void add(Contato c){
        contatos.add(c);
    }

    @Override
    public List<Contato> getAll(){
        return contatos;
    }

    // @Override
    // public void update(Contato c) {
    //     int index = contatos.indexOf(c);
    //     contatos.set(index, c);
    // }

    @Override
public void update(Contato c) {
    int index = contatos.indexOf(c);
    if (index != -1) {
        contatos.set(index, c);
    } else {
        throw new IllegalArgumentException("Contato não encontrado na lista");
    }
}

    @Override
    public List<Contato> search(String termo) {
        return contatos.stream()
                .filter(p -> (p.getNome() + " " + p.getSobrenome()).toLowerCase().contains(termo.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(String contato) {
        return contatos.stream().anyMatch(c -> c.getTelefone().equals(contato));
    }

    @Override
    public void remove(Contato c){
        contatos.remove(c);
    }

    @Override
    public List<Contato> getContatosPorCategoria(String categoria){
        return contatos.stream()
            .filter(contato -> contato.getCategoria().equals(categoria))
            .collect(Collectors.toList());
    }

    @Override
    public List<Contato> getContatosPorChamada(boolean chamadaDeVideo){
        return contatos.stream()
        .filter(contato -> contato.isChamadaVideo() == chamadaDeVideo)
        .collect(Collectors.toList());
    }

    @Override
    public List<Contato> getContatosPorRedeSocial(String redeSocial) {
        return contatos.stream()
            .filter(contato -> contato.getRedeSocial().equals(redeSocial))
            .collect(Collectors.toList());
    }
}
