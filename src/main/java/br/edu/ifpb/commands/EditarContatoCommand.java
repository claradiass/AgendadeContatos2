package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.domain.Contato;
import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.IntervalValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;
import main.java.br.edu.ifpb.validators.ValidationContext;

import java.util.List;
import java.util.Scanner;

public class EditarContatoCommand implements Command {

    @Override
    public void execute() {
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n=================================");
        System.out.println("Editar contato");
        System.out.println("\n=================================");
        System.out.println("Busque um contato para editar");

        ValidationContext<String> strValidationContext = new ValidationContext<>(new NonEmptyValidator());
        String termo = strValidationContext.getValidValue("Digite parte do nome para buscar: ", "Termo de busca não pode ser vazio", String.class);

        List<Contato> resultado = contatoService.buscar(termo);

        System.out.println("\nResultado:\n");
        int indice = 0;
        for (Contato c : resultado) {
            System.out.println(++indice + " - " + c);
        }

        ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, indice));
        int indiceDigitado = intValidationContext.getValidValue("Digite o índice do Contato que você deseja editar: ", String.format("O índice deve ser um valor entre 1 e %d (inclusive)%n", indice), Integer.class);

        Contato toEdit = resultado.get(indiceDigitado - 1);

        String nome = readInput("Digite um novo nome (ou deixe vazio para não mudar): ");
        String sobrenome = readInput("Digite um novo sobrenome (ou deixe vazio para não mudar): ");
        String telefone = readInput("Digite um novo telefone (ou deixe vazio para não mudar): ");
        String redeSocial = readInput("Digite uma nova rede social (ou deixe vazio para não mudar): ");
        String valorDaEntrada = readInput("Digite um novo dado específico (ou deixe vazio para não mudar): ");
        String dataStr = readInput("Digite uma nova data de nascimento (ou deixe vazio para não mudar): ");
        String categoria = readInput("Digite uma nova categoria (ou deixe vazio para não mudar): ");

        if (!nome.isEmpty()) {
            toEdit.setNome(nome);
        }

        if (!sobrenome.isEmpty()) {
            toEdit.setSobrenome(sobrenome);
        }

        if (!telefone.isEmpty()) {
            toEdit.setTelefone(telefone);
        }

        if (!redeSocial.isEmpty()) {
            toEdit.setRedeSocial(redeSocial);
        }

        if (!valorDaEntrada.isEmpty()) {
            toEdit.setValorDaEntrada(valorDaEntrada);
        }

        if (!dataStr.isEmpty()) {
            toEdit.setAniversario(dataStr);
        }

        if (!categoria.isEmpty()) {
            toEdit.setCategoria(categoria);
        }

        contatoService.editar(toEdit.getNome(), toEdit.getSobrenome(), toEdit.isLigacao(), toEdit.isChamadaVideo(), toEdit.getCategoria(), toEdit.getValorDaEntrada(), toEdit.getRedeSocial(), toEdit.getTelefone(), toEdit.getAniversario());
        System.out.println("\nContato editado");
    }

    private String readInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextLine();
    }
}
