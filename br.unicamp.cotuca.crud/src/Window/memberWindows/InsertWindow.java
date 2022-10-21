package Window.memberWindows;

import BancoDeDados.daos.*;
import BancoDeDados.dbos.*;
import Window.LaunchPage;
import Window.TextLanguages;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class InsertWindow implements ActionListener {
    JFrame frame = new JFrame();

    TextLanguages lt = new TextLanguages();
    
    JLabel title_M;
    JLabel status_M = new JLabel("Status: ");
    JLabel lbIdMember = new JLabel("IdMember: ");
    JLabel lbIdRocket_M = new JLabel("IdRocket: ");
    JLabel lbNameMember = new JLabel("Member Name: ");
    
    JTextField txtIdMember = new JTextField();
    JTextField txtIdRocket_M = new JTextField();
    JTextField txtMemberName = new JTextField();

    JButton btnGetInserted_M;

    JLabel title_R;
    JLabel status_R = new JLabel("Status: "); 
    JLabel lbIdRocket_R = new JLabel("IdRocket: ");
    JLabel lbRocketName = new JLabel("Rocket Name: ");

    JTextField txtIdRocket_R = new JTextField();
    JTextField txtRocketName = new JTextField();

    JButton btnGetInserted_R;

    String languageSelected = new LaunchPage().languageSelected;
    JButton changeLanguage = new JButton("Aqui ó");
    
    public InsertWindow() {

        System.out.println(new LaunchPage().switchSelected());
        System.out.println("Valor instanciado na classe InsertWindow: " + languageSelected + "\n");
        switchLanguage(languageSelected);


        /* TEXT DEFINITION */
        title_M = new JLabel(lt.languageBox_Insert[0]);
        btnGetInserted_M = new JButton(lt.languageBox_Insert[1]);
        title_R = new JLabel(lt.languageBox_Insert[2]);
        btnGetInserted_R = new JButton(lt.languageBox_Insert[1]);

        /* FIRST ROW: MEMBER*/
        title_M.setBounds(10, 5, 350, 30);
        title_M.setFont(new Font("Serif", Font.BOLD, 22));

        status_M.setBounds(170, 160, 300, 50);
        status_M.setFont(new Font("Serif", Font.PLAIN, 12));

        lbIdMember.setBounds(10, 40, 90, 25);
        lbIdMember.setFont(new Font("Serif", Font.BOLD, 12));

        lbIdRocket_M.setBounds(10, 70, 90, 25);
        lbIdRocket_M.setFont(new Font("Serif", Font.BOLD, 12));
        
        lbNameMember.setBounds(10, 105, 90, 25);
        lbNameMember.setFont(new Font("Serif", Font.BOLD, 12));


        txtIdMember.setBounds(110, 40, 50, 25);
        txtIdRocket_M.setBounds(110, 70, 50, 25);
        txtMemberName.setBounds(110, 105, 150, 25);

        btnGetInserted_M.setBounds(10, 160, 150, 25);
        btnGetInserted_M.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetInserted_M.setFocusable(false);
        btnGetInserted_M.addActionListener(this);

        changeLanguage.setBounds(200, 70, 50, 25);
        changeLanguage.setFocusable(false);
        changeLanguage.addActionListener(this);
        frame.add(changeLanguage);

        frame.add(lbIdMember);
        frame.add(lbIdRocket_M);
        frame.add(lbNameMember);

        frame.add(title_M);
        frame.add(status_M);

        frame.add(txtIdMember);
        frame.add(txtIdRocket_M);
        frame.add(txtMemberName);

        frame.add(btnGetInserted_M);

        
        /* SECOND ROW: ROCKET */
        title_R.setBounds(10, 220, 350, 30);
        title_R.setFont(new Font("Serif", Font.BOLD, 22));
        
        status_R.setBounds(170, 325, 300, 50);
        status_R.setFont(new Font("Serif", Font.PLAIN, 12));
        
        lbIdRocket_R.setBounds(10, 255, 90, 25);
        lbIdRocket_R.setFont(new Font("Serif", Font.BOLD, 12));
        
        lbRocketName.setBounds(10, 285, 90, 25);
        lbRocketName.setFont(new Font("Serif", Font.BOLD, 12));
        
        txtIdRocket_R.setBounds(110, 255, 50, 25);
        txtRocketName.setBounds(110, 285, 150, 25);
        
        btnGetInserted_R.setBounds(10, 325, 150, 25);
        btnGetInserted_R.setFont(new Font("Serif", Font.PLAIN, 12));
        btnGetInserted_R.setFocusable(false);
        btnGetInserted_R.addActionListener(this);
        
        frame.add(title_R);
        frame.add(status_R);
        
        frame.add(lbIdRocket_R);
        frame.add(lbRocketName);
        
        frame.add(txtIdRocket_R);
        frame.add(txtRocketName);
        
        frame.add(btnGetInserted_R);
        

        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        
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
        if (e.getSource() == btnGetInserted_M) {
            try {
                
                if (Integer.parseInt(txtIdMember.getText()) <= Members.getLength()) 
                    throw new Exception("<html>O ID inserido já existe." + "<br>" +" O próximo ID deve ser de "+(Members.getLength() + 1) + "</html>");
                    
                if (Integer.parseInt(txtIdMember.getText()) != Members.getLength() + 1) 
                    throw new Exception("<html>O valor inserido é inválido." + "<br>" +" O próximo ID deve ser de "+(Members.getLength() + 1) + "</html>");
                
                    
                Members.insertMember (new Member (Integer.parseInt(txtIdMember.getText()), 
                                                  Integer.parseInt(txtIdRocket_M.getText()), 
                                                  txtMemberName.getText()));
                status_M.setText("Status: Member inserido com sucesso!");
            }
            catch (Exception erro) {
                status_M.setText("<html>Erro: "+ erro.getMessage() + "</html>");

            }

        }
        else if (e.getSource() == btnGetInserted_R) {
            try {

                title_M.setText(lt.languageBox_Insert[0]);
                btnGetInserted_M.setText(lt.languageBox_Insert[1]);
                title_R.setText(lt.languageBox_Insert[2]);
                btnGetInserted_R.setText(lt.languageBox_Insert[1]);


                if(Integer.parseInt(txtIdRocket_R.getText()) <= Rockets.getLength())
                    throw new Exception("<html>O ID inserido já existe." + "<br>" +" O próximo ID deve ser de "+(Rockets.getLength() + 1) + "</html>");
                if(Integer.parseInt(txtIdRocket_R.getText())!= Rockets.getLength() + 1)
                    throw new Exception("<html>O valor inserido é inválido." + "<br>" +" O próximo ID deve ser de "+(Rockets.getLength() + 1) + "</html>");
                Rockets.insertRocket(new Rocket(Integer.parseInt(txtIdRocket_R.getText()), txtRocketName.getText()));
                status_R.setText("Status: Rocket inserido com sucesso!");

            } 
            catch (Exception erro) {
                status_R.setText("<html>Erro: "+ erro.getMessage() + "</html>");
            }
        }
        else if (e.getSource() == changeLanguage) {
            try {
                languageSelected = "English";
                switchLanguage(languageSelected);
                applyText();
            
            } catch (Exception erro) {
                System.out.println("Não pode!");
            }

        }
        
    }

    public void applyText() {

        title_M.setText(lt.languageBox_Insert[0]);
        btnGetInserted_M.setText(lt.languageBox_Insert[1]);
        title_R.setText(lt.languageBox_Insert[2]);
        btnGetInserted_R.setText(lt.languageBox_Insert[1]);

        // for (int i = 0; i < lt.languageBox_LaunchPage.length; i++)
        //     System.out.println(lt.languageBox_Insert[i]);
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
