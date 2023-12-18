package main.java.br.edu.ifpb.gui;

import main.java.br.edu.ifpb.domain.Contato;
import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.repository.FileDataService;
import main.java.br.edu.ifpb.service.ContatoService;

import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends javax.swing.JFrame {
        private ImagePanel imagePanel;
        private ContatoService dataService;
        private JList<Contato> list;

    public MainWindow() {
        imagePanel = new ImagePanel("../Imagens/Blue wallpaper.png");
        setContentPane(imagePanel);
        initComponents();
        initContactListListener();
        
    }

    private void atualizarListaDeContatos() {
        String filtro = (String) jComboBox1.getSelectedItem();
        String termoBusca = jTextField1.getText().trim();
        
        List<Contato> contatosFiltrados;

        if (!termoBusca.isEmpty()) {
            contatosFiltrados = dataService.buscar(termoBusca);
        } else if ("Todos".equals(filtro)) {
            contatosFiltrados = dataService.getContatos();
        } else {
            if (Arrays.asList("Instagram", "WhatsApp", "Email").contains(filtro)) {
                contatosFiltrados = dataService.filtrarPorRedeSocial(filtro);
            } else {
                contatosFiltrados = dataService.filtrarPorCategoria(filtro);
            }
        }

        list.setListData(contatosFiltrados.toArray(new Contato[0]));

        if (contatosFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum contato encontrado.", "Lista Vazia", JOptionPane.INFORMATION_MESSAGE);
        } else {
            list.setListData(contatosFiltrados.toArray(new Contato[0]));
        }
    }

    private void initContactListListener() {
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Contato selectedContato = list.getSelectedValue();
                    updateContactDetails(selectedContato);
                }
            }
        });
    }

    public void updateContactList() {
        // Add logic to update the contact list in MainWindow
        // For example, if you have a method named refreshContactsList() in MainWindow:
        atualizarListaDeContatos();
    }
    

    private void updateContactDetails(Contato contato) {
        if (contato != null) {
            StringBuilder details = new StringBuilder("<html>");
            details.append("<b>Nome:</b> ").append(contato.getNome()).append("<br>");
            details.append("<b>Sobrenome:</b> ").append(contato.getSobrenome()).append("<br>");
            details.append("<b>Telefone:</b> ").append(contato.getTelefone()).append("<br>");
            details.append("<b>Aniversário:</b> ").append(contato.getAniversario()).append("<br>");
    
            // Condição para determinar a cor do texto com base na ligação e chamada de vídeo
            String ligacaoCor = contato.isLigacao() ? "green" : "red";
            String chamadaVideoCor = contato.isChamadaVideo() ? "green" : "red";
    
            details.append("<font color=\"").append(ligacaoCor).append("\"><b>Ligação</b></font><br>");
            details.append("<font color=\"").append(chamadaVideoCor).append("\"><b>Chamada de Vídeo</b></font><br>");
    
            details.append("<b>Categoria:</b> ").append(contato.getCategoria()).append("<br>");
    
            if ("Instagram".equalsIgnoreCase(contato.getRedeSocial())) {
                details.append("<b>Usuário:</b> ").append(contato.getValorDaEntrada()).append("<br>");
    
            } else if ("Email".equalsIgnoreCase(contato.getRedeSocial())) {
                details.append("<b>Email:</b> ").append(contato.getValorDaEntrada()).append("<br>");
            }
    
            details.append("<b>Rede Social:</b> ").append(contato.getRedeSocial()).append("<br>");
            details.append("</html>");
            jLabel4.setText(details.toString());
    
        } else {
            // Clear the text in jLabel4 when no contact is selected
            jLabel4.setText("");
            jLabel3.setText("Selecione um contato para ver suas informações");
            // Limpe outras informações, se necessário
        }
    }

    private void editarContatoSelecionado() {
        Contato selectedContato = list.getSelectedValue();
        if (selectedContato != null) {
            // Abra a janela de edição passando o contato selecionado
            new ContatoWindow(this, selectedContato).show();
        } else {
            JOptionPane.showMessageDialog(MainWindow.this, "Selecione um contato para editar.");
        }
    }
    
    

    private void excluirContatoSelecionado() {
        Contato selectedContato = list.getSelectedValue();
        if (selectedContato != null) {
            // Excluir o contato
            JOptionPane.showConfirmDialog(MainWindow.this, "Tem certeza que deseja excluir o contato selecionado?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
            dataService.remover(selectedContato);
            atualizarListaDeContatos();
            updateContactDetails(null); // Limpar os detalhes após a exclusão
            JOptionPane.showMessageDialog(MainWindow.this, "Contato excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(MainWindow.this, "Selecione um contato para excluir.");
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        // list = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        list = new JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();

        ContatoRepository repository = ContatoRepository.getInstance();
        repository.setRepository(new FileDataService());
        dataService = new ContatoService(repository);

        list.setListData(dataService.getContatos().toArray(new Contato[0]));
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaDeContatos();
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione um diálogo de confirmação
                // int option = JOptionPane.showConfirmDialog(MainWindow.this, "Tem certeza que deseja excluir o contato selecionado?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
                // if (option == JOptionPane.YES_OPTION) {
                    excluirContatoSelecionado();
                // }
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600,400));
        setTitle("Agenda de Contatos");

        jLabel1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 50, 78));
        jLabel1.setText("Agenda de Contatos");

        jTextField1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(33, 50, 78));
        jTextField1.setText(" ");
        jTextField1.setToolTipText("Pesquise um contato");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaDeContatos();
            }
        });

        list.setBackground(new java.awt.Color(170, 213, 248));
        list.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 14)); // NOI18N
        list.setForeground(new java.awt.Color(33, 50, 78));
        list.setListData(dataService.getContatos().toArray(new Contato[0]));
        jScrollPane1.setViewportView(list);

        jButton1.setBackground(new java.awt.Color(33, 50, 78));
        jButton1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Excluir");
        jButton1.setToolTipText("Exclua um contato selecionado");

        jButton2.setBackground(new java.awt.Color(33, 50, 78));
        jButton2.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Editar");
        jButton2.setToolTipText("Edite um contato selecionado");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarContatoSelecionado();
            }
        });
        
        

        // jButton3.setBackground(new java.awt.Color(170, 213, 248));
        // jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("whatsapp.png"))); // NOI18N
        jButton3.setBackground(new java.awt.Color(33, 50, 78));
        jButton3.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Adicionar contato");
        jButton3.setToolTipText("Adicione um novo contato");
        // jButton3.setBorder(null);
        // jButton3.setBorderPainted(false);
        jButton3.addActionListener(e -> {
            // PacienteWindow pode ser aberta para criação ou edição de um paciente
            // Se paciente for nulo, a janela funcionará para criar um novo
            // Caso contrário, carregará os dados para editar
            new ContatoWindow(this, null).show();
        });

        // jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("whatsapp.png"))); // NOI18N
        // jButton3.setBorder(null);
        // jButton3.setBorderPainted(false);

        jComboBox1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(33, 50, 78));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Instagram", "WhatsApp", "Email", "Pessoal", "Trabalho", "Favoritos" }));
        jComboBox1.setBackground(new java.awt.Color(170, 213, 248)); // Cor branca
        jComboBox1.setForeground(new java.awt.Color(33, 50, 78)); // Cor personalizada (RGB)
        jComboBox1.setFont(new java.awt.Font("Liberation Sans", java.awt.Font.BOLD, 15));
        // Defina a borda do JComboBox
        // jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 213, 248), 3)); // Cor e largura da borda
        // Defina a opacidade do JComboBox
        jComboBox1.setOpaque(true);
        jComboBox1.setToolTipText("Selecione um filtro");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });


        jLabel3.setBackground(new java.awt.Color(33, 50, 78));
        jLabel3.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 50, 78));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Informações do contato:");

        jLabel4.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 50, 78));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selecione algum contato!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2))
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }   
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
                mainWindow.setLocationRelativeTo(null); 
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    
    // End of variables declaration       
    
    
}
