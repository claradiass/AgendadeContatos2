package main.java.br.edu.ifpb.service;

import java.util.List;
import java.util.stream.Collectors;

import main.java.br.edu.ifpb.domain.Contato;
import main.java.br.edu.ifpb.repository.ContatoRepository;

public class ContatoService {
    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public void criar(String nome, String sobrenome, boolean ligacao, boolean chamadaVideo, String categoria, String valorDaEntrada, String redeSocial, String telefone, String aniversario){
        
        repository.add(new Contato(nome, sobrenome, ligacao, chamadaVideo, categoria, valorDaEntrada, redeSocial, telefone, aniversario));
    }

    public List<Contato> buscar(String termo) {
        return repository.search(termo);
    }

    public boolean existe(String contato) {
        return repository.exists(contato);
    }

    public List<Contato> getContatos() {
        return repository.getAll();
    }

    public void remover(Contato c){
        repository.remove(c);
    }

    public void editar(String nome, String sobrenome, boolean ligacao, boolean chamadaVideo, String categoria, String valorDaEntrada, String redeSocial, String telefone, String aniversario) {
        repository.update(new Contato(nome, sobrenome, ligacao, chamadaVideo, categoria, valorDaEntrada, redeSocial, telefone, aniversario));
    }

    public List<Contato> filtrarPorRedeSocial(String redeSocial) {
        return repository.getAll().stream()
                .filter(contato -> contato.getRedeSocial().equalsIgnoreCase(redeSocial))
                .collect(Collectors.toList())  ;
    }

    public List<Contato> filtrarPorCategoria(String categoria) {
        return repository.getAll().stream()
                .filter(contato -> contato.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList())  ;
    }

    

}
