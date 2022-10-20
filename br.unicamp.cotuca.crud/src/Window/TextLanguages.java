package Window;
import Window.memberWindows.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class TextLanguages {
    

    public String[] portugueseBox_Insert = {"Inserir novo Membro", 
                                     "Inserir valores",
                                     "Inserir novo Foguete",
                                     "Erro: O ID inserido já existe." + "<br>" +" O próximo ID deve ser de ",
                                     "Erro: O ID inserido é inválido." + "<br>" +" O próximo ID deve ser de ",
                                     "Status: Member inserido com sucesso!",
                                     "Status: Rocket inserido com sucesso!" }; 
    String[] portugueseBox_Alter = {};
    String[] portugueseBox_Delete = {};
    String[] portugueseBox_Select = {};

    public String[] englishBox_Insert = {"Insert new Member", 
                                     "Insert values",
                                     "Insert new Rocket",
                                     "Error: The inserted ID already exists" + "<br>" +" Next ID must be ",
                                     "Error: ID inserted is not valid." + "<br>" +" Next ID must be ",
                                     "Status: Member inserted successfully!",
                                     "Status: Rocket inserted successfully!" }; 
    String[] englishBox_Alter = {};
    String[] englishBox_Delete = {};
    String[] englishBox_Select = {};
    
    public String[] languageBox_Insert = new String[20];
    

    public static void main (String[] args) {
        TextLanguages lt = new TextLanguages();

        for (int i = 0; i<lt.portugueseBox_Insert.length; i++)
            lt.languageBox_Insert[i] = lt.portugueseBox_Insert[i];

        for (int c = 0; c< lt.languageBox_Insert.length; c++)
            System.out.println(lt.languageBox_Insert[c]);
    }

    // RUNNING 
    public void getLanguageSelected(String languageSelected) {
        if (languageSelected == "Portugues") {
            for (int i = 0; i < portugueseBox_Insert.length; i++) {
                languageBox_Insert[i] = portugueseBox_Insert[i];
                System.out.println(languageBox_Insert[i]);

            }
            System.out.println("Got in the method");
        }
        
        else if (languageSelected == "English") {
            for (int i = 0; i < englishBox_Insert.length; i++) {
                languageBox_Insert[i] = englishBox_Insert[i];
                System.out.println(languageBox_Insert[i]);
            }
            System.out.println("-----------> Has entered English");

        }
        else if (languageSelected == "Francais") {
            System.out.println("Has entered French ");

        }

    }
}
