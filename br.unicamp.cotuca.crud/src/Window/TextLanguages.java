package Window;
import Window.memberWindows.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class TextLanguages {
    
    String[] portugueseBox_Insert = {"Inserir novo Membro", 
                                     "Inserir valores",
                                     "Inserir novo Foguete",
                                     "Erro: O ID inserido já existe." + "<br>" +" O próximo ID deve ser de ",
                                     "Erro: O valor inserido é inválido." + "<br>" +" O próximo ID deve ser de ",
                                     "Status: Member inserido com sucesso!",
                                     "Status: Rocket inserido com sucesso!" }; 
    String[] portugueseBox_Alter = {};
    String[] portugueseBox_Delete = {};
    String[] portugueseBox_Select = {};

    // String[] languageBox_Insert = {};
    ArrayList<String> languageBox_Insert = new ArrayList<String>(10);
    // this.teste();

    public static void main (String[] args) {
        TextLanguages lt = new TextLanguages();

        for (int i = 0; i<lt.portugueseBox_Insert.length; i++)
            lt.languageBox_Insert.add(lt.portugueseBox_Insert[i]);

        for (int c = 0; c< lt.languageBox_Insert.size(); c++)
            System.out.println(lt.languageBox_Insert.get(c));
    }
    public void teste() {
        TextLanguages lt = new TextLanguages();

        for (int i = 0; i<lt.portugueseBox_Insert.length; i++)
            lt.languageBox_Insert.add(lt.portugueseBox_Insert[i]);
    }
}
