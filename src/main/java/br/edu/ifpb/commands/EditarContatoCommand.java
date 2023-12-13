package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.domain.Contato;
import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.IntervalValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;
import main.java.br.edu.ifpb.validators.ValidationContext;
import main.java.br.edu.ifpb.validators.OpcionalDateValidator;

import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class EditarContatoCommand implements Command{
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";


  @Override
  public void execute() {
    ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n-------------------------------");
        System.out.println("Editar contato");
        System.out.println("-------------------------------\n");

        ValidationContext<String> strValidationContext = new ValidationContext<>(new NonEmptyValidator());
        String termo = strValidationContext.getValidValue("Digite parte do nome para buscar: ", "Termo de busca não pode ser vazio", String.class);

        List<Contato> resultado = contatoService.buscar(termo);

        System.out.println("\nResultado:\n");
        int indice = 0;
        for (Contato c: resultado) {
            System.out.println(++indice + " - " + c);
        }

        if(resultado.isEmpty()){
            System.out.println(YELLOW + "Não existem contatos com esse termo para serem editados.\n" + RESET);
            termo = strValidationContext.getValidValue("Digite outra parte do nome para buscar: ", "Termo de busca não pode ser vazio", String.class);

            resultado = contatoService.buscar(termo);
            System.out.println("\nResultado:\n");

            indice = 0;
            for (Contato c: resultado) {
                System.out.println(++indice + " - " + c);
            }
        }

        ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, indice));
        int indiceDigitado = intValidationContext.getValidValue("Digite o índice do Contato que você deseja editar: ", String.format("O índice deve ser um valor entre 1 e %d (inclusive)%n", indice), Integer.class);

        Contato toEdit = resultado.get(indiceDigitado - 1);

        System.out.print("Digite um novo nome (ou deixe vazio para não mudar): ");
        String nome = new Scanner(System.in).nextLine();

        System.out.print("Digite um novo sobrenome (ou deixe vazio para não mudar): ");
        String sobrenome = new Scanner(System.in).nextLine();

        System.out.print("Digite um novo telefone (ou deixe vazio para não mudar): ");
        String telefone = new Scanner(System.in).nextLine();

        System.out.print("Digite uma nova rede social (ou deixe vazio para não mudar): ");
        String redeSocial = new Scanner(System.in).nextLine();

        System.out.print("Digite um novo dado específico (ou deixe vazio para não mudar): ");
        String valorDaEntrada = new Scanner(System.in).nextLine();

        //Temos que fazer essa validação
        strValidationContext.setValidator(new OpcionalDateValidator());
        String dataStr = strValidationContext.getValidValue("Digite uma nova data de nascimento (ou deixe vazio para não mudar): ", "Formato de data incorreto, use o formato 'dd/MM/yyyy'", String.class);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Digite uma nova categoria (ou deixe vazio para não mudar): ");
        String categoria = new Scanner(System.in).nextLine();


        if (!nome.equals("")) {
            toEdit.setNome(nome);
        }

        if (!sobrenome.equals("")) {
            toEdit.setSobrenome(sobrenome);
        }

        if (!telefone.equals("")) {
            toEdit.setTelefone(telefone);
        }

        if (!redeSocial.equals("")) {
            toEdit.setRedeSocial(redeSocial);
        }

        if (!valorDaEntrada.equals("")) {
            toEdit.setValorDaEntrada(valorDaEntrada);;
        }

        if (!dataStr.equals("")) {
            toEdit.setAniversario(dataStr);
        }


        if (!categoria.equals("")) {
            toEdit.setCategoria(categoria);
        }


        contatoService.editar(toEdit.getNome(), toEdit.getSobrenome(), toEdit.isLigacao(), toEdit.isChamadaVideo(), toEdit.getCategoria(), toEdit.getValorDaEntrada(), toEdit.getRedeSocial(), toEdit.getTelefone(), toEdit.getAniversario());
        System.out.println(GREEN + "\nContato editado" + RESET);
    }
}
