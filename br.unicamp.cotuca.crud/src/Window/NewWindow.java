package Window;
import BancoDeDados.daos.*;
import BancoDeDados.dbos.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class NewWindow implements ActionListener {
    
    JFrame frame = new JFrame();
    
    JLabel lbIdMember = new JLabel("IdMember: ");
    JLabel lbIdRocket = new JLabel("IdRocket: ");
    JLabel lbNameMember = new JLabel("NameMember: ");
    JLabel title = new JLabel("Inserir Novo Membro");
    JLabel status = new JLabel("Status: ");
    
    JTextField txtIdMember = new JTextField();
    JTextField txtIdRocket = new JTextField();
    JTextField txtMemberName = new JTextField();

    JButton btnGetInserted = new JButton("Insert values");
    
    NewWindow() {
        lbIdMember.setBounds(10, 40, 90, 25);
        lbIdMember.setFont(new Font("Serif", Font.BOLD, 12));

        lbIdRocket.setBounds(10, 70, 90, 25);
        lbIdRocket.setFont(new Font("Serif", Font.BOLD, 12));
        
        lbNameMember.setBounds(10, 105, 90, 25);
        lbNameMember.setFont(new Font("Serif", Font.BOLD, 12));

        title.setBounds(10, 5, 350, 30);
        title.setFont(new Font("Serif", Font.BOLD, 22));

        status.setBounds(170, 160, 250, 25);
        status.setFont(new Font("Serif", Font.PLAIN, 12));

        txtIdMember.setBounds(110, 40, 50, 25);
        txtIdRocket.setBounds(110, 70, 50, 25);
        txtMemberName.setBounds(110, 105, 150, 25);

        btnGetInserted.setBounds(10, 160, 150, 25);
        btnGetInserted.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetInserted.setFocusable(false);
        btnGetInserted.addActionListener(this);

        // <additions> Additions to the frame 
        frame.add(lbIdMember);
        frame.add(lbIdRocket);
        frame.add(lbNameMember);

        frame.add(title);
        frame.add(status);

        frame.add(txtIdMember);
        frame.add(txtIdRocket);
        frame.add(txtMemberName);

        frame.add(btnGetInserted);

        frame.setSize(420, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        // </additions>

        handleLocation();
    }
    private void handleLocation() { 
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
        frame.setLocation(((d.width - frame.getWidth())/2), ((d.height - frame.getHeight())/3)); 
    }
    public void verifyInputs() {
        if (txtMemberName.getText() == "Bruno") {
            System.out.println("Bruno is now set for the master pilot of the spaceshift");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGetInserted) {
            try {
                Members.insertMember (new Member (Integer.parseInt(txtIdMember.getText()), 
                                                  Integer.parseInt(txtIdRocket.getText()), 
                                                  txtMemberName.getText()));
                status.setText("Status: Member inserido com sucesso!");
            }
            catch (Exception erro) {
                System.err.println("Something went wrong: " + erro.getMessage());
                erro.printStackTrace();

                status.setText("[ERROR] Os campos devem ser preenchidos!");

            }

        }
        
    }
}
