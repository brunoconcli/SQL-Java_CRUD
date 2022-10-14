package Window.memberWindows;
import BancoDeDados.daos.*;
import BancoDeDados.core.*;
import java.awt.*;
import javax.swing.*;

public class TableMember{
    JFrame frame = new JFrame();
    JTextArea txt = new JTextArea();
    JTable table;
    public TableMember() {

        String[][] newMaquiavelico;
        try {

            newMaquiavelico = new String[Members.getLength()][3]; //
            MeuResultSet resultado = Members.getMembers();
            String[] columnNames = {"IDMEMBER", "IDROCKET", "MEMBERNAME"};
            
            for (int i = 0 ; resultado.next(); i++){
                String[] maquiavelico = {""+resultado.getInt("IDMEMBER"), " "+resultado.getInt("idRocket"), " "+resultado.getString("MEMBERNAME")};
                newMaquiavelico[i] = maquiavelico;
                table = new JTable(newMaquiavelico, columnNames);
            }
                // data += ""+resultado.getInt("IDMEMBER")+" "+resultado.getInt("idRocket")+" "+resultado.getString("MEMBERNAME")+"\n";
        } 
            catch(Exception erro) {
                System.out.println(erro.getMessage());
                System.out.println("Erro detectado em Members");
            }

                
                

        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        frame.setSize(500, 420);
        frame.setVisible(true);
        handleLocation();
    }
    
    private void handleLocation(){
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
        frame.setLocation(((d.width - frame.getWidth())/2), ((d.height - frame.getHeight())/3));
    }
}
