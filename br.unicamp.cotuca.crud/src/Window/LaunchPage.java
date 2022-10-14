package Window;
import Window.memberWindows.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class LaunchPage implements ActionListener{
    JFrame frame = new JFrame();

    JLabel title = new JLabel("Opções para Tabela");

    JButton btnInsert = new JButton("Insert");
    JButton btnDelete = new JButton("Delete");
    JButton btnAlter = new JButton("Alter");

    JButton btnShowMember = new JButton("Select ID");
    JButton btnShowAll = new JButton("Select * ");


    LaunchPage() {
        

        title.setBounds(30, 5, 350, 30);
        title.setFont(new Font("Serif", Font.BOLD, 22));

        btnInsert.setBounds(50, 40, 100, 40);
        btnInsert.setFocusable(false);
        btnInsert.addActionListener(this);

        btnDelete.setBounds(155, 40, 100, 40);
        btnDelete.setFocusable(false);
        btnDelete.addActionListener(this);

        btnAlter.setBounds(260, 40, 100, 40);
        btnAlter.setFocusable(false);
        btnAlter.addActionListener(this);
        
        btnShowMember.setBounds(85, 85, 120, 40);
        btnShowMember.setFocusable(false);
        btnShowMember.addActionListener(this);
        
        btnShowAll.setBounds(210, 85, 100, 40);
        btnShowAll.setFocusable(false);
        btnShowAll.addActionListener(this);

        frame.add(title);

        frame.add(btnInsert);
        frame.add(btnDelete);
        frame.add(btnAlter);
        frame.add(btnShowMember);
        frame.add(btnShowAll);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        handleLocation();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsert) {
            new InsertWindow();
        }
        else if(e.getSource() == btnDelete) {
            new DeleteWindow();
        }
        else if(e.getSource() == btnAlter) {
            new AlterWindow();
        }
        else if(e.getSource() == btnShowMember) {
            new SelectWindow();
        }
        else if(e.getSource() == btnShowAll) {
            new SelectAllWindow();
        }
    }
    private void handleLocation() { 
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
        frame.setLocation(((d.width - frame.getWidth())/2), ((d.height - frame.getHeight())/3)); 
    }

}
