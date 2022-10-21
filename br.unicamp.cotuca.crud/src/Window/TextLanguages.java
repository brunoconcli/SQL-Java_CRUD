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
    String[] portugueseBox_LaunchPage = {"Opções para Tabela", 
                                        "Inserir", 
                                        "Deletar", 
                                        "Alterar",
                                        "Selecionar ID", 
                                        "Selecionar *"};

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
    String[] englishBox_LaunchPage = {"Options for Table", 
                                    "Insert", 
                                    "Delete", 
                                    "Alter",
                                    "Select ID", 
                                    "Select *"};
    
    public String[] languageBox_Insert = new String[20];
    public String[] languageBox_Delete = new String[20];
    public String[] languageBox_Alter = new String[20];
    public String[] languageBox_Select = new String[20];
    public String[] languageBox_LaunchPage = new String[20];
    

    // public static void main (String[] args) {
    //     // TextLanguages lt = new TextLanguages();

    //     // for (int i = 0; i<lt.portugueseBox_Insert.length; i++)
    //     //     lt.languageBox_Insert[i] = lt.portugueseBox_Insert[i];


    //     // lt.languageBox_Insert = lt.portugueseBox_Insert;
    //     // for (int c = 0; c< lt.languageBox_Insert.length; c++)
    //     //     System.out.println(lt.languageBox_Insert[c]);
    // }

    public void switchToPortuguese() {
        languageBox_Insert = portugueseBox_Insert;
        languageBox_Delete = portugueseBox_Delete;
        languageBox_Alter = portugueseBox_Alter;
        languageBox_Select = portugueseBox_Select;
        languageBox_LaunchPage = portugueseBox_LaunchPage;

        System.out.println("IDIOMA SELECIONADO: PORTUGUES");
    }

    public void switchToEnglish() {
        languageBox_Insert = englishBox_Insert;
        languageBox_Delete = englishBox_Delete;
        languageBox_Alter = englishBox_Alter;
        languageBox_Select = englishBox_Select;
        languageBox_LaunchPage = englishBox_LaunchPage;
        System.out.println("LANGUAGE SELECTED: ENGLISH");

    }

    public void switchToFrancais() {
        System.out.println("LANGUE  SELECIONÉ: FRANÇAIS");
        
    }
    // RUNNING 
    
}
