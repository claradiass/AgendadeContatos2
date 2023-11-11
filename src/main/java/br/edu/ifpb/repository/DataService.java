package main.java.br.edu.ifpb.repository;

import java.util.List;
import main.java.br.edu.ifpb.domain.Contato;

public interface DataService {

    void add(Contato c);

    List<Contato> getAll();

    void update(Contato c);

    List<Contato> search(String termo);

    boolean exists(String c);

    void remove(Contato c);

    List<Contato> getContatosPorRedeSocial(String redeSocial);

    List<Contato> getContatosPorCategoria(String categoria);

    List<Contato> getContatosPorChamada(boolean chamadaDeVideo);
}
