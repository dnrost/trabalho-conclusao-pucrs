package desview.util;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTextField;

/**
 * Class that provides a customized IP address.
 * @author Luiz Mello.
 * @author Diones Rossetto.
 * @since 16/04/2010.
 * @version 1.0
 */
public class IPAddress extends JXPanel {

    private static final long serialVersionUID = -973557441l;
    private JXTextField[] campos;
    private List<IPInterface> listeners;
    private int RIGHT_ARROW = 39;
    private int LEFT_ARROW = 37;
    private int BACKSPACE = 8;
    private int END = 35;
    private int HOME = 36;
    private char PONTO = '.';

    /**
     * Constructor of the class.
     */
    public IPAddress() {
        initComponents();
        listeners = new ArrayList<IPInterface>();
        campos = new JXTextField[]{
                    ip1,
                    ip2,
                    ip3,
                    ip4
                };
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ip1 = new org.jdesktop.swingx.JXTextField();
        ponto1 = new org.jdesktop.swingx.JXLabel();
        ip2 = new org.jdesktop.swingx.JXTextField();
        ponto2 = new org.jdesktop.swingx.JXLabel();
        ip3 = new org.jdesktop.swingx.JXTextField();
        ponto3 = new org.jdesktop.swingx.JXLabel();
        ip4 = new org.jdesktop.swingx.JXTextField();

        setBackground(new java.awt.Color(208, 208, 208));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new java.awt.GridBagLayout());

        ip1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ip1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ip1.setMinimumSize(new java.awt.Dimension(25, 18));
        ip1.setPreferredSize(new java.awt.Dimension(25, 18));
        ip1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ip1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ip1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ip1KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 8;
        add(ip1, gridBagConstraints);

        ponto1.setText(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(ponto1, gridBagConstraints);

        ip2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ip2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ip2.setMinimumSize(new java.awt.Dimension(25, 18));
        ip2.setPreferredSize(new java.awt.Dimension(25, 18));
        ip2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ip2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ip2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ip2KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 8;
        add(ip2, gridBagConstraints);

        ponto2.setText(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        add(ponto2, gridBagConstraints);

        ip3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ip3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ip3.setMinimumSize(new java.awt.Dimension(25, 18));
        ip3.setPreferredSize(new java.awt.Dimension(25, 18));
        ip3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ip3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ip3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ip3KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 8;
        add(ip3, gridBagConstraints);

        ponto3.setText(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        add(ponto3, gridBagConstraints);

        ip4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ip4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ip4.setMinimumSize(new java.awt.Dimension(25, 18));
        ip4.setPreferredSize(new java.awt.Dimension(25, 18));
        ip4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ip4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ip4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ip4KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 8;
        add(ip4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void ip4KeyReleased(KeyEvent evt) {//GEN-FIRST:event_ip4KeyReleased
        this.verificaTeclaLiberada(evt, 3);
    }//GEN-LAST:event_ip4KeyReleased

    private void ip3KeyReleased(KeyEvent evt) {//GEN-FIRST:event_ip3KeyReleased
        this.verificaTeclaLiberada(evt, 2);
    }//GEN-LAST:event_ip3KeyReleased

    private void ip2KeyReleased(KeyEvent evt) {//GEN-FIRST:event_ip2KeyReleased
        this.verificaTeclaLiberada(evt, 1);
    }//GEN-LAST:event_ip2KeyReleased

    private void ip1KeyReleased(KeyEvent evt) {//GEN-FIRST:event_ip1KeyReleased
        this.verificaTeclaLiberada(evt, 0);
    }//GEN-LAST:event_ip1KeyReleased

    private void ip4KeyTyped(KeyEvent evt) {//GEN-FIRST:event_ip4KeyTyped
        this.verificaTeclaDigitada(evt, 3);
    }//GEN-LAST:event_ip4KeyTyped

    private void ip3KeyTyped(KeyEvent evt) {//GEN-FIRST:event_ip3KeyTyped
        this.verificaTeclaDigitada(evt, 2);
    }//GEN-LAST:event_ip3KeyTyped

    private void ip2KeyTyped(KeyEvent evt) {//GEN-FIRST:event_ip2KeyTyped
        this.verificaTeclaDigitada(evt, 1);
    }//GEN-LAST:event_ip2KeyTyped

    private void ip1KeyTyped(KeyEvent evt) {//GEN-FIRST:event_ip1KeyTyped
        this.verificaTeclaDigitada(evt, 0);
    }//GEN-LAST:event_ip1KeyTyped

    private void ip4KeyPressed(KeyEvent evt) {//GEN-FIRST:event_ip4KeyPressed
        this.verificaTeclaPressionada(evt, 3);
    }//GEN-LAST:event_ip4KeyPressed

    private void ip3KeyPressed(KeyEvent evt) {//GEN-FIRST:event_ip3KeyPressed
        this.verificaTeclaPressionada(evt, 2);
    }//GEN-LAST:event_ip3KeyPressed

    private void ip2KeyPressed(KeyEvent evt) {//GEN-FIRST:event_ip2KeyPressed
        this.verificaTeclaPressionada(evt, 1);
    }//GEN-LAST:event_ip2KeyPressed

    private void ip1KeyPressed(KeyEvent evt) {//GEN-FIRST:event_ip1KeyPressed
        this.verificaTeclaPressionada(evt, 0);
    }//GEN-LAST:event_ip1KeyPressed

    private void verificaTeclaDigitada(KeyEvent evento, int indece) {
        if (!Character.isDigit(evento.getKeyChar()) || (indece == 3 && campos[indece].getText().length() == 3)) {
            evento.consume();
        }
    }

    private void verificaTeclaPressionada(KeyEvent evento, int index) {
        // Digitou ponto "." e campo nao vazio
        if (evento.getKeyChar() == PONTO && !campos[index].getText().equals("")) {
            this.focoProximoCampo(index);
        }
        // Pressionou seta direita "->"
        if (evento.getKeyCode() == RIGHT_ARROW) {
            this.focoProximoCampo(index);
        }
        // Pressionou seta esquerda "<-"
        if (evento.getKeyCode() == LEFT_ARROW) {
            this.focoCampoAnterior(index);
        }
        // Pressionou backspace "<----"
        if (evento.getKeyCode() == BACKSPACE && campos[index].getText().equals("")) {
            this.focoCampoAnterior(index);
        }
        // Pressionou "home"
        if (evento.getKeyCode() == HOME) {
            ip1.grabFocus();
        }
        // Pressionou "end"
        if (evento.getKeyCode() == END) {
            ip4.grabFocus();
        }
        // Preencheu todos os campos
        if (evento.getKeyCode() == 10 && ipPreenchido()) {
            this.notificaListeners();
        }
    }

    private boolean ipPreenchido() {
        boolean retorno = true;
        for (JXTextField texto : campos) {
            if (texto.getText().equals("")) {
                retorno = false;
                break;
            }
        }
        return retorno;
    }

    private void verificaTeclaLiberada(KeyEvent evento, int index) {
        if (campos[index].getText().length() >= 3
                && evento.getKeyCode() != BACKSPACE
                && evento.getKeyCode() != 16
                && evento.getKeyCode() != LEFT_ARROW) {
            this.focoProximoCampo(index);
        }

        if (evento.getKeyCode() == BACKSPACE
                && evento.getKeyCode() == 16
                && evento.getKeyCode() == 37
                && evento.getKeyCode() == 9) {
            if ((!(campos[0].getText().equals(""))) && Integer.parseInt(campos[0].getText()) == 0) {
                campos[0].setText("1");
            }
        }

        int limite;
        if (index == 0) {
            limite = 224;
        } else {
            limite = 256;
            if ((!(campos[0].getText().equals(""))) && Integer.parseInt(campos[0].getText()) == 0) {
                campos[0].setText("1");
            }
        }
        if ((!(campos[index].getText().equals(""))) && Integer.parseInt(campos[index].getText()) >= limite) {
            campos[index].setText(String.valueOf(limite - 1));
        }
    }

    private void focoProximoCampo(int index) {
        if (index < 3) {
            campos[index + 1].requestFocus();
        }
    }

    private void focoCampoAnterior(int indece) {
        if (indece > 0) {
            campos[indece - 1].requestFocus();
        }
    }

    /**
     * Returns the IP Address in format xxx.xxx.xxx.xxx ("dot format").
     * @return the IP Address.
     */
    public String getIp() {
        StringBuilder sb = new StringBuilder();
        sb.append(ip1.getText());
        sb.append(".");
        sb.append(ip2.getText());
        sb.append(".");
        sb.append(ip3.getText());
        sb.append(".");
        sb.append(ip4.getText());
        return sb.toString();
    }

    /**
     * This method returns an octect of the IP address.
     * <table cellspacing="10" cellpadding="10" border="3">
     * <tr>
     * <td align="center">
     * <table cellspacing="2" cellpadding="2" border="1">
     * <tr>
     * <td><b>Value</b></td>
     * <td><b>Returned octect</b></td>
     * </tr>
     * <tr>
     * <td>1</td>
     * <td>Octet 1</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>Octet 2</td>
     * </tr>
     * <tr>
     * <td>3</td>
     * <td>Octet 3</td>
     * </tr>
     * <tr>
     * <td>4</td>
     * <td>Octet 4</td>
     * </tr>
     * </table>
     * </td>
     * </tr>
     * </table>
     * @param value the value.
     * @return the octect.
     */
    public String getOctetIP(int value) {
        String retorno = "";
        switch (value) {
            case 1:
                retorno = ip1.getText();
                break;
            case 2:
                retorno = ip2.getText();
                break;
            case 3:
                retorno = ip3.getText();
                break;
            case 4:
                retorno = ip4.getText();
                break;
        }
        return retorno;
    }

    /**
     * Clear the IP fields, setting fields with empty string.
     */
    public void cleanIP() {
        for (int i = 0; i < campos.length; i++) {
            campos[i].setText("");
        }
    }

    /**
     * Sets an IP Adrress
     * @param ip a new IP address in "dot format".
     */
    public void setIp(String ip) {
        if (ip.length() >= 7 && ip.length() <= 15) {
            String[] octetos = ip.split("\\.");

            if (octetos.length >= 4) {
                for (int i = 0; i < campos.length; i++) {
                    if (octetos[i].length() >= 1 && octetos[i].length() <= 3) {
                        campos[i].setText(octetos[i]);
                    }
                }
            }
        }
    }

    private void notificaListeners() {
        for (IPInterface listener : listeners) {
            listener.IPIsFilled();
        }
    }

    @Override
    public void grabFocus() {
        ip1.grabFocus();
    }

    public void setEditable(boolean editable) {
        ip1.setEditable(editable);
        ip2.setEditable(editable);
        ip3.setEditable(editable);
        ip4.setEditable(editable);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTextField ip1;
    private org.jdesktop.swingx.JXTextField ip2;
    private org.jdesktop.swingx.JXTextField ip3;
    private org.jdesktop.swingx.JXTextField ip4;
    private org.jdesktop.swingx.JXLabel ponto1;
    private org.jdesktop.swingx.JXLabel ponto2;
    private org.jdesktop.swingx.JXLabel ponto3;
    // End of variables declaration//GEN-END:variables
}
