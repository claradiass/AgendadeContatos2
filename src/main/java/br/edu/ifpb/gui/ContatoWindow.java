package main.java.br.edu.ifpb.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import main.java.br.edu.ifpb.commands.AdicionarContatoGUICommand;
import main.java.br.edu.ifpb.commands.CommandExecutor;
import main.java.br.edu.ifpb.commands.EditarContatoGUICommand;
import main.java.br.edu.ifpb.domain.Contato;

public class ContatoWindow extends javax.swing.JFrame {
    private ImagePanel imagePanel;
    private ButtonGroup buttonGroup;
    private Contato contato;
    private CommandExecutor commandExecutor;
    private MainWindow mainWindow;
    private ButtonGroup redeSocialGroup;

    public ContatoWindow(MainWindow main, Contato contato) {
        this.contato = contato;
        this.commandExecutor = new CommandExecutor();
        this.mainWindow = main;
        redeSocialGroup = new ButtonGroup();

        CommandExecutor commandExecutor = new CommandExecutor();
        imagePanel = new ImagePanel("../Imagens/Blue wallpaper.png");
        setContentPane(imagePanel);
        initComponents();
        setLocationRelativeTo(null);
        JScrollPane scrollPane = new JScrollPane(getContentPane());

        // Definir o JScrollPane como o conteúdo da janela
        setContentPane(scrollPane);

        setLocationRelativeTo(null);

        if (contato != null) {
            jTextField1.setText(contato.getNome());
            jTextField3.setText(contato.getSobrenome());
            jTextField4.setText(contato.getTelefone());
            jTextField6.setText(contato.getAniversario());

            // Lógica para determinar a rede social do contato
            if (contato.getCategoria().equals("Favoritos")) {
                jRadioButton1.setSelected(true);
            } else if (contato.getCategoria().equals("Trabalho")) {
                jRadioButton2.setSelected(true);
            } else if (contato.getCategoria().equals("Pessoal")) {
                jRadioButton3.setSelected(true);
            }

            if (contato.getRedeSocial().equals("WhatsApp")) {
                jRadioButton6.setSelected(true);
                jTextField7.setVisible(false);
            } else if (contato.getRedeSocial().equals("Email")) {
                jRadioButton4.setSelected(true);
                jTextField7.setText(contato.getValorDaEntrada());
                jTextField7.setVisible(true);
            } else if (contato.getRedeSocial().equals("Instagram")) {
                jRadioButton5.setSelected(true);
                jTextField7.setText(contato.getValorDaEntrada());
                jTextField7.setVisible(true);
            }
        } 
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton4);
        buttonGroup.add(jRadioButton5);
        buttonGroup.add(jRadioButton6);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 520));
        setMinimumSize(new java.awt.Dimension(400, 520));
        setPreferredSize(new java.awt.Dimension(400, 520));

        if (contato != null) {
            setTitle("Editar Contato");
            jLabel1.setText("Editar Contato");
            jButton1.setText("Editar"); // Altera o texto do botão conforme a ação desejada
        } else {
            setTitle("Adicionar Contato");
            jLabel1.setText("Adicionar Contato");
            jButton1.setText("Adicionar");
        }
        

        jLabel1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 50, 78));
        
        jLabel2.setText("Nome");
        jLabel2.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 50, 78));

        jTextField1.setText("");
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Sobrenome");
        jLabel3.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 50, 78));

        jLabel4.setText("Telefone");
        jLabel4.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 50, 78));

        jTextField3.setText("");
        jTextField3.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria");
        jLabel5.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 50, 78));

        jTextField4.setText("");
        jTextField4.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Favoritos");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Trabalho");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Pessoal");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        JFrame thisWindow = this;
        // jButton1.setText(contato == null ? "Adicionar" : "Editar");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Valores de teste para os campos específicos
                boolean ligacao = false;
                boolean chamadaVideo = false;

                String categoriaSelecionada = "";
                if (jRadioButton1.isSelected()) {
                    categoriaSelecionada = "Favoritos";
                } else if (jRadioButton2.isSelected()) {
                    categoriaSelecionada = "Trabalho";
                } else if (jRadioButton3.isSelected()) {
                    categoriaSelecionada = "Pessoal";
                }

                String redeSocial = "";
                if (jRadioButton6.isSelected()) {
                    redeSocial = "WhatsApp";
                    ligacao = true;
                    chamadaVideo = true;
                } else if (jRadioButton4.isSelected()) {
                    redeSocial = "Email";
                    ligacao = false;
                    chamadaVideo = false;
                } else if (jRadioButton5.isSelected()) {
                    redeSocial = "Instagram";
                    ligacao = false;
                    chamadaVideo = true;
                }

                if (contato == null) {
                    commandExecutor.executeCommand(new AdicionarContatoGUICommand(thisWindow,
                    jTextField1, jTextField3, ligacao, chamadaVideo, categoriaSelecionada,
                    jTextField7, redeSocial, jTextField4, jTextField6,
                    jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton6, jRadioButton4, jRadioButton5
                    ));
                    
                    mainWindow.updateContactList();
                } else if (contato != null) {
                    commandExecutor.executeCommand(new EditarContatoGUICommand(thisWindow,
                            jTextField1, jTextField3, ligacao, chamadaVideo, categoriaSelecionada,
                            jTextField7, redeSocial, jTextField4, jTextField6
                    ));
                    mainWindow.updateContactList();
                }
            }
        });


        jButton1.setBackground(new java.awt.Color(170, 213, 248));
        jButton1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(33, 50, 78));
        // jButton1.addActionListener(new ActionListener() {
        //             @Override
        //             public void actionPerformed(ActionEvent e) {
        //                 // Valores de teste para os campos específicos
        //                 boolean ligacao = false;
        //                 boolean chamadaVideo = false;
                        
        //                 String categoriaSelecionada = "";
        //                 if (jRadioButton1.isSelected()) {
        //                     categoriaSelecionada = "Favoritos";
        //                 } else if (jRadioButton2.isSelected()) {
        //                     categoriaSelecionada = "Trabalho";
        //                 } else if (jRadioButton3.isSelected()) {
        //                     categoriaSelecionada = "Pessoal";
        //                 }

        //                 String redeSocial = "";
        //                 if (jRadioButton6.isSelected()) {
        //                     redeSocial = "WhatsApp";
        //                     ligacao = true;
        //                     chamadaVideo = true;
        //                 } else if (jRadioButton4.isSelected()) {
        //                     redeSocial = "Email";
        //                     ligacao = false;
        //                     chamadaVideo = false;
        //                 } else if (jRadioButton5.isSelected()) {
        //                     redeSocial = "Instagram";
        //                     ligacao = false;
        //                     chamadaVideo = true;
        //                 }
                        
        //                 if(contato == null){
        //                 // Execute o comando para adicionar o contato
        //                     commandExecutor.executeCommand(
        //                         new AdicionarContatoGUICommand(
        //                         jTextField1, jTextField3, ligacao, chamadaVideo, categoriaSelecionada,
        //                         jTextField7, redeSocial, jTextField4, jTextField6
        //                         )
        //                     );
        //                     mainWindow.updateContactList();
        //                     setVisible(false);
        //                 }else if(contato != null){
        //                     commandExecutor.executeCommand(
        //                         new EditarContatoGUICommand(
        //                         jTextField1, jTextField3, ligacao, chamadaVideo, categoriaSelecionada,
        //                         jTextField7, redeSocial, jTextField4, jTextField6)
        //                     );
                            
        //                     mainWindow.updateContactList();
        //                     setVisible(false);
        //                 }  
                

        // // Close the ContatoWindow
        // //setVisible(false);
        //             }

                
        //         });


        jButton2.setText("Cancelar");
        jButton2.setBackground(new java.awt.Color(170, 213, 248));
        jButton2.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(33, 50, 78));
        jButton2.addActionListener(e -> this.setVisible(false));

        jLabel7.setText("Aniversário");
        jLabel7.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(33, 50, 78));

        jTextField6.setText("");
        jTextField6.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("Instagram");        
        jRadioButton4.setText("Email");
        jRadioButton6.setText("WhatsApp");

        jRadioButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton5.isSelected()) {
                    jLabel8.setVisible(true);
                    jLabel8.setText("Instagram");
                    jTextField7.setVisible(true);
                } 
            }
        });

        jRadioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton4.isSelected()) {
                    jLabel8.setVisible(true);
                    jLabel8.setText("Email");
                    jTextField7.setVisible(true);
                } 
            }
        });

        jRadioButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel8.setVisible(false);
                jTextField7.setVisible(false);
            }
        });


        jLabel8.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(33, 50, 78));

        jTextField7.setVisible(false);
        jTextField7.setText("");
        jTextField7.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel9.setText("Rede Social");
        jLabel9.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(33, 50, 78));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(14, 14, 14))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextField1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jTextField3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jTextField4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButton1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 78,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jRadioButton2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 78,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRadioButton3,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 78,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jTextField6,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel8)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jTextField7,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 250,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jRadioButton6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                78,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jRadioButton4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                78,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jRadioButton5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                78,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 106, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton6)
                                        .addComponent(jRadioButton4)
                                        .addComponent(jRadioButton5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap()));

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContatoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContatoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContatoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContatoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContatoWindow(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration
}
