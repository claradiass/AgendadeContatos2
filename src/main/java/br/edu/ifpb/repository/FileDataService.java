package main.java.br.edu.ifpb.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.br.edu.ifpb.domain.Contato;

public class FileDataService extends InMemoryDataService {
    private static final String CSV_FILE = "data.csv";

    public FileDataService() {
        read();
    }

    @Override
    public void add(Contato c) {
        super.add(c);
        write();
    }
    @Override
    public void update(Contato c) {
        super.update(c);
        write();
    }

    @Override
    public void remove(Contato c) {
        super.remove(c);
        write();
    }

    private void read() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 9) { // Verifica se há 9 campos
                    Contato contato = new Contato(data[0], data[1], Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[3]), data[4], data[5], data[6], data[7], data[8]);
                    super.add(contato);
                } else {
                    System.err.println("Dados incorretos no arquivo CSV: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

            private void write() {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
                    if ((CSV_FILE).length() == 0) {
                        bw.write("Nome,Sobrenome,Ligacao,ChamadaVideo,Categoria,ValorDaEntrada,RedeSocial,Telefone,Aniversario");
                        bw.newLine();
                    }


                    for (Contato contato : getAll()) {
                        String line = contato.getNome() + "," + contato.getSobrenome() + "," +
                                contato.isLigacao() + "," + contato.isChamadaVideo() + "," +
                                contato.getCategoria() + "," + contato.getValorDaEntrada() + "," +
                                contato.getRedeSocial() + "," + contato.getTelefone() + "," +
                                contato.getAniversario();
            
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
}




