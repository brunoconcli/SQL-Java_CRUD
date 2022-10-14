package Window.memberWindows;
import BancoDeDados.daos.*;
import BancoDeDados.core.*;
import java.awt.*;
import javax.swing.*;

public class TableRocket{
    JFrame frame = new JFrame();
    JTextArea txt = new JTextArea();
    JTable table;
    public TableRocket() {

        String[][] newMaquiavelico;
        try {

            newMaquiavelico = new String[Rockets.getLength()][3]; //
            MeuResultSet resultado = Rockets.getRockets();
            String[] columnNames = {"IDRocket", "Rocket Name"};
            
            for (int i = 0 ; resultado.next(); i++){
                String[] maquiavelico = {""+resultado.getInt("idRocket"), " "+resultado.getString("rocketName")};
                newMaquiavelico[i] = maquiavelico;
                table = new JTable(newMaquiavelico, columnNames);
            }
        } 
        catch(Exception erro) {
            System.out.println(erro.getMessage());
            System.out.println("Erro detectado em Rockets");
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
