package Window;
import Window.memberWindows.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class LaunchPage implements ActionListener{
    TextLanguages lt = new TextLanguages();
    JFrame frame = new JFrame();

    String[] languages = {"Portugues", "English", "Francais"}; // Primeiro idioma: por padrão em português
    
    public JComboBox languageBox = new JComboBox(languages);

    // public String languageSelected = "English";
    public String languageSelected = this.getLanguageSelected();
    JLabel title;

    JButton btnInsert;
    JButton btnDelete;
    JButton btnAlter;
    
    JButton btnShowMember;
    JButton btnShowAll;
    
    
    public void startWindow() {
        this.switchLanguage(languageSelected);
        
        title = new JLabel(lt.languageBox_LaunchPage[0]);

        btnInsert = new JButton(lt.languageBox_LaunchPage[1]);
        btnDelete = new JButton(lt.languageBox_LaunchPage[2]);
        btnAlter = new JButton(lt.languageBox_LaunchPage[3]);
        
        btnShowMember = new JButton(lt.languageBox_LaunchPage[4]);
        btnShowAll = new JButton(lt.languageBox_LaunchPage[5]);

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
    
        
        languageBox.setBounds(50, 150, 110, 25);
        languageBox.addActionListener(this);
    
        frame.add(title);
    
        frame.add(btnInsert);
        frame.add(btnDelete);
        frame.add(btnAlter);
        frame.add(btnShowMember);
        frame.add(btnShowAll);
        frame.add(languageBox);
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        handleLocation();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsert) {
            languageSelected = (String)languageBox.getSelectedItem();
            System.out.println("\n" + "Valor recebido da classe LaunchPage: " + languageSelected);
            new InsertWindow(languageSelected);
            
        }
        else if(e.getSource() == btnDelete) {
            new DeleteWindow(languageSelected);
        }
        else if(e.getSource() == btnAlter) {
            new AlterWindow(languageSelected);
        }
        else if(e.getSource() == btnShowMember) {
            new SelectWindow(languageSelected);
        }
        else if(e.getSource() == btnShowAll) {
            new SelectAllWindow(languageSelected);
        }
        else if (e.getSource() == languageBox) {
            languageSelected = (String)languageBox.getSelectedItem();
            switchLanguage(languageSelected);

            title.setText(lt.languageBox_LaunchPage[0]);

            btnInsert.setText(lt.languageBox_LaunchPage[1]);
            btnDelete.setText(lt.languageBox_LaunchPage[2]);
            btnAlter.setText(lt.languageBox_LaunchPage[3]);
            
            btnShowMember.setText(lt.languageBox_LaunchPage[4]);
            btnShowAll.setText(lt.languageBox_LaunchPage[5]);
        }
    }
    private void handleLocation() { 
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
        frame.setLocation(((d.width - frame.getWidth())/2), ((d.height - frame.getHeight())/3)); 
    }

    public String getLanguageSelected() {
        return ((String)languageBox.getSelectedItem());
    }

    public void switchLanguage(String languageSelected) {

        if (languageSelected == "Portugues") 
            lt.switchToPortuguese();

        if(languageSelected == "English") 
            lt.switchToEnglish();
        
        if(languageSelected == "Francais") 
            lt.switchToFrancais();
        
    }
    // USELESS
    public String switchSelected () {
        if (languageBox.getSelectedItem() == "Portugues") 
            languageSelected = "Portugues";

        if(languageBox.getSelectedItem() == "English") 
            languageSelected = "English";
            
        if(languageBox.getSelectedItem() == "Francais") 
            languageSelected = "Francais";
        return languageSelected;
    }
}
