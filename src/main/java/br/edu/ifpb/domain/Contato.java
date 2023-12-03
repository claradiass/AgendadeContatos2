package main.java.br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.Objects;

// Em resumo, a importação import java.io.Serializable; não é usada diretamente no código, mas a implementação da interface Serializable na classe 
// Contato permite que os objetos dessa classe sejam serializados.

public class Contato implements Serializable {
    private String nome;
    private String sobrenome;
    private boolean ligacao;
    private boolean chamadaVideo;
    private String categoria;
    private String valorDaEntrada;
    private String redeSocial;
    private String telefone;
    private String aniversario;



    // construtor
    public Contato(String nome, String sobrenome, boolean ligacao, boolean chamadaVideo, String categoria, String valorDaEntrada, String redeSocial, String telefone, String aniversario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ligacao = ligacao;
        this.chamadaVideo = chamadaVideo;
        this.categoria = categoria;
        this.valorDaEntrada = valorDaEntrada;
        this.redeSocial = redeSocial;
        this.telefone = telefone;
        this.aniversario = aniversario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contato contato = (Contato) obj;
        return Objects.equals(this.valorDaEntrada, contato.valorDaEntrada);
            // compara se o contato tem o mesmo tipo de entrada e o mesmo valor da entrada
    }

    // public String toString() {
    //     return "Nome:" + getNome() + "\nSobrenome:" + getSobrenome() + "\nTelefone:" + getTelefone() + "\nRecebe Ligação?" + isLigacao() + "\nEssa ligação pode ser uma chamada de vídeo?" + 
    //     isChamadaVideo() + "\nRede social: " + getRedeSocial() + "\nDado específico: " + getValorDaEntrada() + "\nData de aniversário:" + getAniversario() + "\nCategoria: " + getCategoria() + "\n";
        
    // }

    public String toString() {
        return "Nome: " + getNome() + " " + getSobrenome() + "\n";
        
    }

    // sobrescrita

    @Override
    public int hashCode() {
        return Objects.hash(getValorDaEntrada());
    }

    // setters e getters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public boolean isLigacao() {
        return ligacao;
    }

    public void setLigacao(boolean ligacao) {
        this.ligacao = ligacao;
    }

    public boolean isChamadaVideo() {
        return chamadaVideo;
    }

    public void setChamadaVideo(boolean chamadaVideo) {
        this.chamadaVideo = chamadaVideo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValorDaEntrada() {
        return valorDaEntrada;
    }

    public void setValorDaEntrada(String valorDaEntrada) {
        this.valorDaEntrada = valorDaEntrada;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    // Este método está calculando o código hash (um valor numérico) com base apenas
    // no atributo número
    // do objeto Contato. Isso significa que, se dois Contatos tiverem o mesmo
    // número,
    // eles terão o mesmo código hash, o que é desejável para garantir que objetos
    // com o
    // mesmo número sejam considerados iguais ao serem inseridos em estruturas de
    // dados que dependem
    // do código hash, como HashSetouHashMap`.
}