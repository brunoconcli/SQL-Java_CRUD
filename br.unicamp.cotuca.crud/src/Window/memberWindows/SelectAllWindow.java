package Window.memberWindows;
// import BancoDeDados.daos.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class SelectAllWindow implements ActionListener{
    JFrame frame = new JFrame();

    JLabel title_All_M = new JLabel("Selecionar Tabela Member");
    JLabel title_All_R= new JLabel("Selecionar Tabela Rocket");

    JButton btnSelectAll_M = new JButton("Tabela Membros");
    JButton btnSelectAll_R = new JButton("Tabela Foguete");

    JLabel status_M = new JLabel("Status: ");
    JLabel status_R = new JLabel("Status: ");
    public SelectAllWindow() {
        /*FIRST ROW: MEMBER*/
        title_All_M.setBounds(10, 5, 350, 30);
        title_All_M.setFont(new Font("Serif", Font.BOLD, 22));
        
        btnSelectAll_M.setBounds(10,40,150, 25);
        btnSelectAll_M.setFont(new Font("Serif", Font.BOLD,12));
        btnSelectAll_M.setFocusable(false);
        btnSelectAll_M.addActionListener(this);

        
        frame.add(title_All_M);
        frame.add(btnSelectAll_M);
        
        /*SECOND ROW: ROCKET*/
        title_All_R.setBounds(10, 80, 350, 30);
        title_All_R.setFont(new Font("Serif", Font.BOLD, 22));

        btnSelectAll_R.setBounds(10, 115,150, 25);
        btnSelectAll_R.setFont(new Font("Serif", Font.BOLD,12));
        btnSelectAll_R.setFocusable(false);
        btnSelectAll_R.addActionListener(this);

        frame.add(title_All_R);
        frame.add(btnSelectAll_R);

        frame.setSize(420, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        handleLocation();
    }
    private void handleLocation(){
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
        frame.setLocation(((d.width - frame.getWidth())/2), ((d.height - frame.getHeight())/3));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelectAll_M){
            try {
                new TableMember();
                //status_M = Members.getMembers();
            }
            catch (Exception erro) {
                
            }
        }
        else if(e.getSource() == btnSelectAll_R){
            try {
                new TableRocket();
            } catch (Exception erro) {
                
            }
        }
        
    }
}