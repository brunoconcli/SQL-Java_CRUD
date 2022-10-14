package Window.memberWindows;
import BancoDeDados.daos.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DeleteWindow implements ActionListener{
    JFrame frame = new JFrame();
    JLabel title_M = new JLabel("Deletar Um Membro");
    JLabel status_M = new JLabel("Status: ");

    JLabel lbIdMember = new JLabel("IdMember: ");
    JTextField txtIdMember = new JTextField();

    JButton btnGetDeleted_M = new JButton("Delete values");

    JLabel title_R = new JLabel("Deletar Um Foguete");
    JLabel status_R = new JLabel("Status: ");

    JLabel lbIdRocket = new JLabel("IdRocket: ");
    JTextField txtIdRocket = new JTextField();

    JButton btnGetDeleted_R = new JButton("Delete values");

    public DeleteWindow() {

        /* FIRST ROW: MEMBER*/
        title_M.setBounds(10, 5, 350, 30);
        title_M.setFont(new Font("Serif", Font.BOLD, 22));

        status_M.setBounds(170, 70, 250, 50);
        status_M.setFont(new Font("Serif", Font.PLAIN, 12));

        lbIdMember.setBounds(10, 40, 90, 25);
        lbIdMember.setFont(new Font("Serif", Font.BOLD, 12));

        txtIdMember.setBounds(110, 40, 50, 25);

        btnGetDeleted_M.setBounds(10, 70, 150, 25);
        btnGetDeleted_M.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetDeleted_M.setFocusable(false);
        btnGetDeleted_M.addActionListener(this);

        frame.add(title_M);
        frame.add(status_M);

        frame.add(lbIdMember);
        frame.add(txtIdMember);
        frame.add(btnGetDeleted_M);

        /* SECOND ROW: ROCKET */
        title_R.setBounds(10, 115, 350, 30);
        title_R.setFont(new Font("Serif", Font.BOLD, 22));

        status_R.setBounds(170, 180, 250, 50);
        status_R.setFont(new Font("Serif", Font.PLAIN, 12));

        lbIdRocket.setBounds(10, 150, 90, 25);
        lbIdRocket.setFont(new Font("Serif", Font.BOLD, 12));

        txtIdRocket.setBounds(110, 150, 50, 25);

        btnGetDeleted_R.setBounds(10, 180, 150, 25);
        btnGetDeleted_R.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetDeleted_R.setFocusable(false);
        btnGetDeleted_R.addActionListener(this);

        frame.add(title_R);
        frame.add(status_R);

        frame.add(lbIdRocket);
        frame.add(txtIdRocket);
        frame.add(btnGetDeleted_R);

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
        if (e.getSource() == btnGetDeleted_M) {
            try {

                if (Integer.parseInt(txtIdMember.getText()) > Members.getLength())  
                    throw new Exception("<html>" + "O ID inserido não é válido." + "<br>" + 
                                        "O ID só poderá ser excluído abaixo de " + Members.getLength() +"</html>");


                Members.deleteMember(Integer.parseInt(txtIdMember.getText()));
                status_M.setText("Status: " + "" + "excluído com sucesso!");
            } catch (Exception erro) {

                status_M.setText("<html>Erro: "+ erro.getMessage() + "</html>");
            }
        }
        else if(e.getSource() == btnGetDeleted_R) {
            try {
                if(Integer.parseInt(txtIdRocket.getText()) > Rockets.getLength())
                    throw new Exception("<html>" + "O ID inserido não é válido." + "<br>" +
                                        "O  ID só poderá ser excluído abaixo de "+ (Rockets.getLength()) +"</html>");
                
                Rockets.deleteRocket(Integer.parseInt(txtIdRocket.getText()));
                status_R.setText("Status: Rocket excluído com sucesso!");
            } catch (Exception erro) {
                status_R.setText("<html>Erro: "+ erro.getMessage() + "</html>");
            }
        }
    }
}
