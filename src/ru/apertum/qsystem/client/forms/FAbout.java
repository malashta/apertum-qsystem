/*
 *  Copyright (C) 2010 Apertum project. web: www.apertum.ru email: info@apertum.ru
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ru.apertum.qsystem.client.forms;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.swing.JFrame;
import org.jdesktop.application.Action;
import ru.apertum.qsystem.client.model.QPanel;
import ru.apertum.qsystem.common.Uses;

/**
 * Created on 3 Март 2009 г., 14:54
 * @author Evgeniy Egorov
 */
public class FAbout extends javax.swing.JDialog {

    /**
     * Используемая ссылка на диалоговое окно.
     */
    private static FAbout aboutForm;

    /** Creates new form FAbout */
    public FAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //setSize(500, 313);
        loadVersion();
    }

    /**
     * Показать информацию о сборке.
     * @param parent  относительно этого контрола модальность и позиционирование
     * @param modal режим модальности
     */
    public static void showAbout(JFrame parent, boolean modal) {
        getForm(parent, modal, "");
        aboutForm.setVisible(true);
    }

    /**
     * Показать информацию о сборке и о версии БД.
     * @param parent  относительно этого контрола модальность и позиционирование
     * @param modal режим модальности
     * @param verDB отображаемая версия БД.
     */
    public static void showAbout(JFrame parent, boolean modal, String verDB) {
        getForm(parent, modal, verDB);
        aboutForm.setVisible(true);
    }

    /**
     * Опредилить Singleton.
     * @param parent  относительно этого контрола модальность и позиционирование
     * @param modal режим модальности
     */
    private static void getForm(JFrame parent, boolean modal, String verDB) {
        Uses.log.logger.info("Демонстрация информации о программе.");
        if (aboutForm == null) {
            aboutForm = new FAbout(parent, modal);
        }
        if (aboutForm != null) {
            // Отцентирируем
            final Toolkit kit = Toolkit.getDefaultToolkit();
            aboutForm.setLocation((Math.round(kit.getScreenSize().width - aboutForm.getWidth()) / 2),
                    (Math.round(kit.getScreenSize().height - aboutForm.getHeight()) / 2));
        }
        aboutForm.labelDBVer.setText("".equals(verDB) ? "" : ("Версия базы данных : " + verDB));
    }

    /**
     * Загрузим параметры сборки билда из файла с версией.
     */
    private void loadVersion() {
        final Properties settings = new Properties();
        //"/ru/apertum/qsystem/reports/web/"
        final InputStream inStream = this.getClass().getResourceAsStream("/ru/apertum/qsystem/common/version.properties");

        try {
            settings.load(inStream);
        } catch (IOException ex) {
            throw new Uses.ClientException("Проблемы с чтением версии. " + ex);
        }
        labelDate.setText("Дата сборки : " + settings.getProperty(DATE));
        labelVersion.setText("Версия сборки : " + settings.getProperty(VERSION));
    }
    private final static String DATE = "date";
    private final static String VERSION = "version";

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new QPanel("/ru/apertum/qsystem/client/forms/resources/fon_about.jpg");
        labelRight = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelVersion = new javax.swing.JLabel();
        labelDBVer = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        jToggleButtonLic = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 313));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 313));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ru.apertum.qsystem.QSystem.class).getContext().getResourceMap(FAbout.class);
        labelRight.setFont(resourceMap.getFont("labelRight.font")); // NOI18N
        labelRight.setForeground(resourceMap.getColor("labelRight.foreground")); // NOI18N
        labelRight.setText(resourceMap.getString("labelRight.text")); // NOI18N
        labelRight.setToolTipText(resourceMap.getString("labelRight.toolTipText")); // NOI18N
        labelRight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRight.setName("labelRight"); // NOI18N
        labelRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRightMouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        labelVersion.setText(resourceMap.getString("labelVersion.text")); // NOI18N
        labelVersion.setName("labelVersion"); // NOI18N

        labelDBVer.setText(resourceMap.getString("labelDBVer.text")); // NOI18N
        labelDBVer.setName("labelDBVer"); // NOI18N

        labelDate.setText(resourceMap.getString("labelDate.text")); // NOI18N
        labelDate.setName("labelDate"); // NOI18N

        jToggleButtonLic.setText(resourceMap.getString("jToggleButtonLic.text")); // NOI18N
        jToggleButtonLic.setName("jToggleButtonLic"); // NOI18N
        jToggleButtonLic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonLicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDBVer)
                            .addComponent(labelVersion)
                            .addComponent(labelDate)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButtonLic)
                            .addComponent(labelRight))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(labelDate)
                .addGap(18, 18, 18)
                .addComponent(labelVersion)
                .addGap(18, 18, 18)
                .addComponent(labelDBVer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(labelRight)
                .addGap(18, 18, 18)
                .addComponent(jToggleButtonLic, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 313));

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(ru.apertum.qsystem.QSystem.class).getContext().getActionMap(FAbout.class, this);
        jButton1.setAction(actionMap.get("close")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(resourceMap.getFont("jTextArea1.font")); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(resourceMap.getString("jTextArea1.text")); // NOI18N
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jTextArea1.setMinimumSize(new java.awt.Dimension(102, 200));
        jTextArea1.setName("jTextArea1"); // NOI18N
        jTextArea1.setPreferredSize(new java.awt.Dimension(148, 220));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 311, 503, 285));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-500)/2, (screenSize.height-313)/2, 500, 313);
    }// </editor-fold>//GEN-END:initComponents

private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed

    setVisible(false);
}//GEN-LAST:event_jPanel1KeyPressed

private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    setVisible(false);
}//GEN-LAST:event_jPanel1MouseClicked

private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

    setVisible(false);
}//GEN-LAST:event_jButton1KeyPressed

private void labelRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRightMouseClicked
    try {
        Desktop.getDesktop().browse(new URI("http://www.apertum.ru"));
    } catch (URISyntaxException ex) {
        Uses.log.logger.error(ex);
    } catch (IOException ex) {
        Uses.log.logger.error(ex);
    }
}//GEN-LAST:event_labelRightMouseClicked

private void jToggleButtonLicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonLicActionPerformed
    final int delta = 280 * (jToggleButtonLic.isSelected() ? 1 : -1);
    aboutForm.setSize(aboutForm.getSize().width, aboutForm.getSize().height + delta);
}//GEN-LAST:event_jToggleButtonLicActionPerformed

    @Action
    public void close() {
        setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButtonLic;
    private javax.swing.JLabel labelDBVer;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelRight;
    private javax.swing.JLabel labelVersion;
    // End of variables declaration//GEN-END:variables
}