package main.java.br.edu.ifpb;

import java.util.Scanner;

import main.java.br.edu.ifpb.commands.AdicionarContatoCommand;
import main.java.br.edu.ifpb.commands.BuscarContatoCommand;
import main.java.br.edu.ifpb.commands.CommandExecutor;
import main.java.br.edu.ifpb.commands.EditarContatoCommand;
import main.java.br.edu.ifpb.commands.ExcluirContatoCommand;
import main.java.br.edu.ifpb.commands.ListarContatosCommand;
import main.java.br.edu.ifpb.commands.ListarContatosPorRedeCommand;
import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.repository.FileDataService;

public class AgendaDeContatosConsoleApplication {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static void main(String[] args) {
        ContatoRepository dataService = ContatoRepository.getInstance();
        dataService.setRepository(new FileDataService());
        CommandExecutor executor = new CommandExecutor();

        Scanner leitor = new Scanner(System.in);

        int op = -1;

        while (op != 7) {
            System.out.println("\n=================================");
            System.out.println(YELLOW +  "MENU" + RESET);
            System.out.println("=================================");

            System.out.println("[1] - Adicionar contato");
            System.out.println("[2] - Listar contatos");
            System.out.println("[3] - Listar contatos por categoria");
            System.out.println("[4] - Buscar contatos");
            System.out.println("[5] - Excluir contato");
            System.out.println("[6] - Editar contato");
            System.out.println("[7] - Sair");

            System.out.print("Digite a opção -> ");
            op = leitor.nextInt();
            leitor.nextLine();

            switch (op) {
                case 1 -> executor.executeCommand(new AdicionarContatoCommand());
                case 2 -> executor.executeCommand(new ListarContatosCommand());
                case 3 -> executor.executeCommand(new ListarContatosPorRedeCommand());
                case 4 -> executor.executeCommand(new BuscarContatoCommand());
                case 5 -> executor.executeCommand(new ExcluirContatoCommand());
                case 6 -> executor.executeCommand(new EditarContatoCommand());
                case 7 -> System.out.println("Tchau");
                default -> System.out.println("Opção inválida");
                
            }

        }
    }
}
