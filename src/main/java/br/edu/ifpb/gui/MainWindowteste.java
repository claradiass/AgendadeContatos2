package main.java.br.edu.ifpb.gui;





import javax.swing.*;

import main.java.br.edu.ifpb.domain.Contato;
import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.repository.FileDataService;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.gui.ContatoWindow;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindowteste {
    private final JFrame frame;
    private final JList<Contato> list;
    private final JPopupMenu menu;
    private final ContatoService dataService;

    public MainWindowteste() {
        frame = new JFrame("Sistema médico");
        list = new JList<>();
        menu = new JPopupMenu();
        // JMenuItem editarItem = new JMenuItem("Editar");
        // editarItem.addActionListener(e -> editarPaciente(list.getSelectedIndex()));
        // JMenuItem excluirItem = new JMenuItem("Excluir");
        // excluirItem.addActionListener(e -> excluirPaciente(list.getSelectedIndex()));
        // menu.add(editarItem);
        // menu.add(excluirItem);

        ContatoRepository repository = ContatoRepository.getInstance();
        repository.setRepository(new FileDataService());
        dataService = new ContatoService(repository);

        // JButton jButton3 = new JButton("Criar");
        // jButton3.addActionListener(e -> {
        //     // PacienteWindow pode ser aberta para criação ou edição de um paciente
        //     // Se paciente for nulo, a janela funcionará para criar um novo
        //     // Caso contrário, carregará os dados para editar
        //     new ContatoWindow(this, null).show();
        // });
        // JButton editarBtn = new JButton("Editar");
        // editarBtn.addActionListener(e -> editarPaciente(list.getSelectedIndex()));
        // JButton excluirBtn = new JButton("Excluir");
        // excluirBtn.addActionListener(e -> excluirPaciente(list.getSelectedIndex()));

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.LEADING, 2, 2));
        panelButtons.setPreferredSize(new Dimension(400, 50));
        // panelButtons.add(jButton3);
        // panelButtons.add(editarBtn);
        // panelButtons.add(excluirBtn);

        list.setListData(dataService.getContatos().toArray(new Contato[0]));
        list.setPreferredSize(new Dimension(400, 200));

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList<Contato> list = (JList<Contato>)e.getSource(); // em que componente foi o clique? no JList

                // Se o botão esquerdo for clicado duas vezes
                // if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                //     editarPaciente(list.locationToIndex(e.getPoint()));
                // }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                showContextMenu(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showContextMenu(e);
            }
        });
        JScrollPane listScroller = new JScrollPane(list);

        frame.add(panelButtons, BorderLayout.PAGE_START);
        frame.add(listScroller, BorderLayout.CENTER);
    }

    private void showContextMenu(MouseEvent e) {
        if (e.isPopupTrigger()) {
            // Melhora a usabilidade selecionando uma linha com o botão direito
            // antes de abrir o menu de contexto. Assim fica claro sobre qual
            // linha o botão foi acionado
            int index = list.locationToIndex(e.getPoint());
            list.setSelectedIndex(index);

            menu.show(e.getComponent(),
                    e.getX(), e.getY());
        }
    }

    // private void editarPaciente(int listIndex) {
    //     Contato p = dataService.get(listIndex);
    //     // ContatoWindow pode ser aberta para criação ou edição de um paciente
    //     // Se paciente for nulo, a janela funcionará para criar um novo
    //     // Caso contrário, carregará os dados para editar
    //     ContatoWindow cadastroWindow = new ContatoWindow(this, p);
    //     cadastroWindow.show();
    // }

    // private void excluirPaciente(int listIndex) {
    //     Contato p = dataService.get(listIndex);
    //     int option = JOptionPane.showConfirmDialog(frame, String.format("Deseja excluir o paciente %s?", p.getNome()),
    //             "Excluir paciente", JOptionPane.YES_NO_OPTION);
    //     if (option == JOptionPane.YES_OPTION) {
    //         dataService.remover(p);
    //         JOptionPane.showMessageDialog(frame, "O paciente foi removido.");
    //         update();
    //     }
    // }

    // public void update() {
    //     list.setListData(dataService.getPacientes().toArray(new Paciente[0]));
    // }

    public void show() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
//        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainWindowteste main = new MainWindowteste();
        main.show();
    }
}

