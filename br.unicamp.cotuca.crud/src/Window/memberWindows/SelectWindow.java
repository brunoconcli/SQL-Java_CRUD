package Window.memberWindows;
import BancoDeDados.daos.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class SelectWindow implements ActionListener{
    JFrame frame = new JFrame();
    JLabel title_M = new JLabel("Selecionar Um Membro");
    JLabel status_M = new JLabel("Status: ");

    JLabel lbIdMember = new JLabel("IdMember: ");
    JTextField txtIdMember = new JTextField();

    JButton btnGetSelected_M = new JButton("Mostrar");

    JLabel title_R = new JLabel("Selecionar Um Foguete");
    JLabel status_R = new JLabel("Status: ");

    JLabel lbIdRocket = new JLabel("IdRocket: ");
    JTextField txtIdRocket = new JTextField();

    JButton btnGetSelected_R = new JButton("Mostrar");

    public SelectWindow() {

        /* FIRST ROW: MEMBER*/
        title_M.setBounds(10, 5, 350, 30);
        title_M.setFont(new Font("Serif", Font.BOLD, 22));

        status_M.setBounds(200, 40, 400, 100);
        status_M.setFont(new Font("Serif", Font.PLAIN, 12));
        status_M.setVerticalAlignment(JLabel.TOP);

        lbIdMember.setBounds(10, 40, 90, 25);
        lbIdMember.setFont(new Font("Serif", Font.BOLD, 12));

        txtIdMember.setBounds(110, 40, 50, 25);

        btnGetSelected_M.setBounds(10, 70, 150, 25);
        btnGetSelected_M.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetSelected_M.setFocusable(false);
        btnGetSelected_M.addActionListener(this);

        frame.add(title_M);
        frame.add(status_M);

        frame.add(lbIdMember);
        frame.add(txtIdMember);
        frame.add(btnGetSelected_M);

        /* SECOND ROW: ROCKET */
        title_R.setBounds(10, 115, 350, 30);
        title_R.setFont(new Font("Serif", Font.BOLD, 22));

        status_R.setBounds(200, 150, 400, 100);
        status_R.setFont(new Font("Serif", Font.PLAIN, 12));
        status_R.setVerticalAlignment(JLabel.TOP);

        lbIdRocket.setBounds(10, 150, 90, 25);
        lbIdRocket.setFont(new Font("Serif", Font.BOLD, 12));

        txtIdRocket.setBounds(110, 150, 50, 25);

        btnGetSelected_R.setBounds(10, 180, 150, 25);
        btnGetSelected_R.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetSelected_R.setFocusable(false);
        btnGetSelected_R.addActionListener(this);

        frame.add(title_R);
        frame.add(status_R);

        frame.add(lbIdRocket);
        frame.add(txtIdRocket);
        frame.add(btnGetSelected_R);

        frame.setSize(420, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        handleLocation();
    }

    private void handleLocation() { 
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
        frame.setLocation(((d.width - frame.getWidth())/2), ((d.height - frame.getHeight())/3)); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGetSelected_M) {
            try {

                if (Integer.parseInt(txtIdMember.getText()) > Members.getLength())  
                    throw new Exception("<html>" + "O ID inserido não é válido." + "<br>" + 
                                        "O ID só poderá ser exibido abaixo de " + Members.getLength() +"</html>");

                status_M.setText("<html>Status: " + Members.getMember(Integer.parseInt(txtIdMember.getText())) + "</html>");
                
            } catch (Exception erro) {
                status_M.setText("<html>Erro: "+ erro.getMessage() + "</html>");
            }
        }
        else if(e.getSource() == btnGetSelected_R) {
            try {

                if (Integer.parseInt(txtIdRocket.getText()) > Rockets.getLength())  
                    throw new Exception("<html>" + "O ID inserido não é válido." + "<br>" + 
                                        "O ID só poderá ser exibido abaixo de " + Rockets.getLength() +"</html>");

                status_R.setText("<html> Status: " + Rockets.getRocket(Integer.parseInt(txtIdRocket.getText())) + "</html>");

            } catch (Exception erro) {
                status_R.setText("<html>Erro: "+ erro.getMessage() + "</html>");
                
            }
        }
    }
}
