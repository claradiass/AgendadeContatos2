package main.java.br.edu.ifpb.repository;

import java.util.List;

import main.java.br.edu.ifpb.domain.Contato;

public class ContatoRepository {
    private DataService dataService;

    private static ContatoRepository instance;

    // O Singleton é um padrão de projeto criacional que permite a você garantir que uma classe tenha apenas uma 
    // instância, enquanto provê um ponto de acesso global para essa instância.

    private ContatoRepository (DataService dataService){
        this.dataService = dataService;
    }

    public static ContatoRepository getInstance() {
        if (instance == null) {
            instance = new ContatoRepository(new InMemoryDataService());
        }

        return instance;
    }

    public void setRepository(DataService dataService) {
        this.dataService = dataService;
    }

    public void add(Contato c) {
        dataService.add(c);
    }

    public List<Contato> getAll() {
        return dataService.getAll();
    }

    public void update(Contato c) {
        dataService.update(c);
    }

    public List<Contato> search(String termo) {
        return dataService.search(termo);
    }

    public boolean exists(String contato) {
        return dataService.exists(contato);
    }

    public void remove(Contato c) {
        dataService.remove(c);
    }

    public List<Contato> getContatosPorCategoria(String categoria) {
        return dataService.getContatosPorCategoria(categoria);
    }

    public List<Contato> getContatosPorChamada(boolean chamadaDeVideo) {
        return dataService.getContatosPorChamada(chamadaDeVideo);
    }

    public List<Contato> getContatosPorRedeSocial(String redeSocial) {
        return dataService.getContatosPorRedeSocial(redeSocial);
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

}
