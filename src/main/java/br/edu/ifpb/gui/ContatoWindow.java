package main.java.br.edu.ifpb.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import main.java.br.edu.ifpb.commands.AdicionarContatoGUICommand;
import main.java.br.edu.ifpb.commands.CommandExecutor;
import main.java.br.edu.ifpb.domain.Contato;

public class ContatoWindow extends javax.swing.JFrame {
    private ImagePanel imagePanel;
    private ButtonGroup buttonGroup;



    public ContatoWindow(MainWindow main, Contato contato) {
        CommandExecutor commandExecutor = new CommandExecutor();
        imagePanel = new ImagePanel("Blue wallpaper.png");
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

            // Lógica para determinar a rede social do contato
            if (contato.getRedeSocial().equals("WhatsApp")) {
                jRadioButton1.setSelected(true);
                jTextFieldWhatsApp.setText(contato.getRedeSocial());
            } else if (contato.getRedeSocial().equals("Email")) {
                jRadioButton2.setSelected(true);
                jTextFieldEmail.setText(contato.getRedeSocial());
            } else if (contato.getRedeSocial().equals("Instagram")) {
                jRadioButton3.setSelected(true);
                jTextFieldInstagram.setText(contato.getRedeSocial());
            }
        }

        
    
    }

    // TESTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE

    // private void adicionarOuEditarContato(MainWindow main, Contato contato) {
    //     // Obtenha os valores dos campos
    //     String nome = jTextField1.getText();
    //     String sobrenome = jTextField3.getText();
    //     String telefone = jTextField4.getText();
    //     String categoria = "";  // Defina a categoria conforme necessário
    //     String valorDaEntrada = "";  // Defina o valor da entrada conforme necessário
    //     String redeSocial = "";
    //     String aniversario = "";  // Defina o aniversário conforme necessário
    //     Boolean ligacao = null;
    //     Boolean chamadaVideo = null;
        


    //     // Lógica para obter valores de outros campos

    //     // Crie um novo objeto Contato
    //     Contato novoContato = new Contato(nome, sobrenome, false, false,
    //             categoria, valorDaEntrada, redeSocial, telefone, aniversario);

    //     // Lógica para adicionar ou editar o contato no seu sistema
    //     if (contato == null) {
    //         // Adicionar novo contato
    //         commandExecutor.executeCommand(new AdicionarContatoGUICommand( nome,  sobrenome,  ligacao, chamadaVideo,  categoria,  valorDaEntrada,  redeSocial,
    //          telefone,  aniversario ));
    //     } else {
    //         // Editar contato existente
    //         // main.editarContato(contato, novoContato);
    //     }

    //     // Atualize a interface principal
    //     // main.update();

    //     // Feche a janela de ContatoWindow
    //     setVisible(false);
    // }


    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);

        jLabel6 = new javax.swing.JLabel();
        jTextFieldWhatsApp = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldInstagram = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500,300));
        setTitle("Adicionar novo Contato");

        

        


        jLabel1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 50, 78));
        jLabel1.setText("Adicionar Contato");

        jLabel2.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 50, 78));
        jLabel2.setText("Nome");

        jTextField1.setText("");
        jTextField1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(33, 50, 78));
        jTextField1.setText(" ");
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 50, 78));
        jLabel3.setText("Sobrenome");

        jLabel4.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 50, 78));
        jLabel4.setText("Telefone");

        jTextField3.setText("");
        jTextField3.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(33, 50, 78));
        jLabel5.setText("Rede Social");

        jTextField4.setText("");
        jTextField4.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jRadioButton1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 11)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(33, 50, 78));
        jRadioButton1.setLabel("WhatsApp");

        jRadioButton2.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(33, 50, 78));
        jRadioButton2.setLabel("Email");
    
        jRadioButton3.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 11)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(33, 50, 78));
        jRadioButton3.setLabel("Instagram");

        jLabel6.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 50, 78));
        jLabel6.setVisible(false);

        jTextFieldWhatsApp.setVisible(false);
        jTextFieldWhatsApp.setText("");
        jTextFieldWhatsApp.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextFieldWhatsApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWhatsAppActionPerformed(evt);
            }
        });

        // jTextFieldEmail.setVisible(false);
        // jTextFieldEmail.setText("");
        // jTextFieldEmail.setPreferredSize(new java.awt.Dimension(150, 50));
        // jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         jTextFieldEmailActionPerformed(evt);
        //     }
        // });

        jTextFieldEmail.setVisible(false);
        jTextFieldEmail.setText("");
        jTextFieldEmail.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jTextFieldInstagram.setVisible(false);
        jTextFieldInstagram.setText("");
        jTextFieldInstagram.setPreferredSize(new java.awt.Dimension(150, 50));
        jTextFieldInstagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInstagramActionPerformed(evt);
            }
        });

        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton1.isSelected()) {
                    jLabel6.setVisible(true);
                    jLabel6.setText("WhatsApp");
                    jTextFieldWhatsApp.setVisible(true);
                } else if(!jRadioButton1.isSelected()) {
                    jLabel6.setVisible(false);
                    jTextFieldWhatsApp.setVisible(false);
                }
            }
        });

        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton2.isSelected()) {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Email");
                    jTextFieldEmail.setVisible(true);
                } else if(!jRadioButton2.isSelected()) {
                    jLabel6.setVisible(false);
                    jTextFieldEmail.setVisible(false);
                }
            }
        });

        jRadioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButton3.isSelected()) {
                    jLabel6.setVisible(true);
                    jLabel6.setText("Instagram");
                    jTextFieldInstagram.setVisible(true);
                } else if(!jRadioButton3.isSelected()) {
                    jLabel6.setVisible(false);
                    jTextFieldInstagram.setVisible(false);
                }
            }
        });

        jButton1.setText("Adicionar");
        jButton1.setBackground(new java.awt.Color(33, 50, 78));
        jButton1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextFieldWhatsAppActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    } 
    
    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    } 

    private void jTextFieldInstagramActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContatoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContatoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContatoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContatoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContatoWindow(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldWhatsApp;    
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldInstagram;


    // End of variables declaration                   


    
    
    /*public void show() {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Chame setVisible(true) após adicionar os componentes
        frame.setVisible(true);
    } */

}

