package Window.memberWindows;
import BancoDeDados.daos.*;
import Window.LaunchPage;
import Window.TextLanguages;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
// import javax.swing.event.InternalFrameEvent;

public class AlterWindow implements ActionListener {
    JFrame frame = new JFrame();

    TextLanguages lt = new TextLanguages(); //aaaaa sim desce aqui ó  

    JLabel title_M;
    JLabel status_M = new JLabel("Status: ");

    JLabel lbIdMember;
    JTextField txtIdMember = new JTextField();

    JLabel lbIdRocket_M;
    JTextField txtIdRocket_M = new JTextField();

    JLabel lbMemberName;
    JTextField txtMemberName = new JTextField();

    JButton btnGetAltered_M;
    
    JLabel title_R;
    JLabel status_R = new JLabel("Status: ");

    JLabel lbIdRocket_R;
    JTextField txtIdRocket_R = new JTextField();

    JLabel lbRocketName;
    JTextField txtRocketName = new JTextField();

    JButton btnGetAltered_R;

    String languageSelected = new LaunchPage().languageSelected;
    // é até qu epouco valor pra passar que ve
    public AlterWindow(String languageSelected) {

        switchLanguage(languageSelected);
        title_M = new JLabel(lt.languageBox_Alter[0]);
        btnGetAltered_M = new JButton(lt.languageBox_Alter[1]);

        lbIdMember = new JLabel(lt.languageBox_Alter[3]);
        lbIdRocket_M = new JLabel(lt.languageBox_Alter[4]);
        lbMemberName = new JLabel(lt.languageBox_Alter[5]);

        title_R = new JLabel(lt.languageBox_Alter[2]);
        btnGetAltered_R = new JButton(lt.languageBox_Alter[1]);

        lbIdRocket_R = new JLabel(lt.languageBox_Alter[10]);
        lbRocketName = new JLabel(lt.languageBox_Alter[11]);
        
        title_M.setBounds(10, 5, 350, 30);
        title_M.setFont(new Font("Serif", Font.BOLD, 22));

        status_M.setBounds(170, 160, 250, 50);
        status_M.setFont(new Font("Serif", Font.PLAIN, 12));

        lbIdMember.setBounds(10, 40, 100, 25);
        lbIdMember.setFont(new Font("Serif", Font.BOLD, 12));
        
        lbIdRocket_M.setBounds(10, 70, 100, 25);
        lbIdRocket_M.setFont(new Font("Serif", Font.BOLD, 12));
        
        lbMemberName.setBounds(10, 105, 120, 25);
        lbMemberName.setFont(new Font("Serif", Font.BOLD, 12));

        txtIdMember.setBounds(125, 40, 50, 25);
        txtIdRocket_M.setBounds(125, 70, 50, 25);
        txtMemberName.setBounds(125, 105, 150, 25);

         
        btnGetAltered_M.setBounds(10, 160, 150, 25);
        btnGetAltered_M.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetAltered_M.setFocusable(false);
        btnGetAltered_M.addActionListener(this);

        frame.add(title_M);
        frame.add(status_M);

        frame.add(lbIdMember);
        frame.add(lbIdRocket_M);
        frame.add(lbMemberName);
        
        frame.add(txtIdMember);
        frame.add(txtIdRocket_M);
        frame.add(txtMemberName);

        frame.add(btnGetAltered_M);

        /* SECOND ROW: ROCKET */
        title_R.setBounds(10, 220, 350, 30);
        title_R.setFont(new Font("Serif", Font.BOLD, 22));
        
        status_R.setBounds(170, 325, 250, 50);
        status_R.setFont(new Font("Serif", Font.PLAIN, 12));
        
        lbIdRocket_R.setBounds(10, 255, 110, 25);
        lbIdRocket_R.setFont(new Font("Serif", Font.BOLD, 12));
        
        lbRocketName.setBounds(10, 285, 110, 25);
        lbRocketName.setFont(new Font("Serif", Font.BOLD, 12));
        
        txtIdRocket_R.setBounds(120, 255, 50, 25);
        txtRocketName.setBounds(120, 285, 150, 25);
        
        btnGetAltered_R.setBounds(10, 325, 150, 25);
        btnGetAltered_R.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetAltered_R.setFocusable(false);
        btnGetAltered_R.addActionListener(this);

        frame.add(title_R);
        frame.add(status_R);
        
        frame.add(lbIdRocket_R);
        frame.add(lbRocketName);
        
        frame.add(txtIdRocket_R);
        frame.add(txtRocketName);
        
        frame.add(btnGetAltered_R);
        
        frame.setSize(420, 420);
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
		if (e.getSource() == btnGetAltered_M) {
            try {

                if (Integer.parseInt(txtIdMember.getText()) > Members.getLength())  
                    throw new Exception("<html>" + lt.languageBox_Alter[9] + Members.getLength() +"</html>");
                                        
                Members.alterMember(Integer.parseInt(txtIdRocket_M.getText()), 
                                    txtMemberName.getText(),
                                    Integer.parseInt(txtIdMember.getText())); 
                
                status_M.setText(lt.languageBox_Alter[7]);
                txtIdMember.setText("");
                txtIdRocket_M.setText("");
                txtMemberName.setText("");
                
            } catch (Exception erro) {
                status_M.setText("<html>Erro: "+ erro.getMessage() + "</html>");
            }
        }
        else if(e.getSource() == btnGetAltered_R){
            try{
                if(Integer.parseInt(txtIdRocket_R.getText()) > Rockets.getLength())
                    throw new Exception("<html>" + lt.languageBox_Alter[9] + (Rockets.getLength()) +"</html>");

                Rockets.alterRocket(txtRocketName.getText(),Integer.parseInt(txtIdRocket_R.getText()));
                status_R.setText(lt.languageBox_Alter[8]);
                txtIdRocket_R.setText("");
                txtIdRocket_R.setText("");
            }
            catch(Exception erro){
                status_R.setText("<html>Erro: "+ erro.getMessage() + "</html>");
            }
        }
	}
    public void switchLanguage(String languageSelected) {
    
        if (languageSelected == "Portugues") 
            lt.switchToPortuguese();

        else if(languageSelected == "English") 
            lt.switchToEnglish();
        
        else if(languageSelected == "Francais") 
            lt.switchToFrancais();
        
        for (int i = 0; i < lt.languageBox_Insert.length; i++)
            System.out.println(lt.languageBox_Insert[i]);
        System.out.println("\n");
    }
}
