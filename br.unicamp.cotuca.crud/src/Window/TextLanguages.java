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
                                     "Status: Membro inserido com sucesso!",
                                     "Status: Foguete inserido com sucesso!" }; 
    
    String[] portugueseBox_Alter = {"Alterar Um Membro",
                                    "Alterar valores ",
                                    "Alterar Um Foguete ",
                                    "Onde idMember: ",
                                    "Novo IdRocket: ",
                                    "Novo MemberName: ",
                                    "Novo Nome do Foguete: ",
                                    "Status: Membro alterado com sucesso!",
                                    "Status: Foguete alterado com sucesso!",
                                    "Erro: O ID inserido não é válido." + "<br>" + 
                                        "O ID só poderá ser alterado abaixo de ",
                                        "Onde IdRocket: ",
                                        "Novo RocketName: "};

    String[] portugueseBox_Delete = {"Deletar Um Membro",
                                     "Deletar Um Foguete",
                                     "Delete os valores",
                                     "Status: membro excluído com sucesso!",
                                     "Status: foguete excluído com sucesso!",
                                     "Erro: O ID inserido não é válido." + "<br>" + 
                                        "O ID só poderá ser excluído abaixo de "};
                                        
    String[] portugueseBox_Select = {"Selecionar Um Membro",
                                     "Selecionar Um Foguete",
                                     "Mostrar",
                                     "O ID inserido não é válido." + "<br>" + 
                                        "O ID só poderá ser exibido abaixo de "};

    String[] portugueseBox_SelectAll = {"Selecionar Tabela Member",
                                        "Selecionar Tabela Rocket",
                                        "Tabela Membros",
                                        "Tabela Foguete"};
                                        
    String[] portugueseBox_LaunchPage = {"Opções para Tabela", 
                                        "Inserir", 
                                        "Deletar", 
                                        "Alterar",
                                        "Selecionar ID", 
                                        "Selecionar *"};


    //English
    public String[] englishBox_Insert = {"Insert new Member", 
                                     "Insert values",
                                     "Insert new Rocket",
                                     "Error: The inserted ID already exists" + "<br>" +" Next ID must be ",
                                     "Error: ID inserted is not valid." + "<br>" +" Next ID must be ",
                                     "Status: Member inserted successfully!",
                                     "Status: Rocket inserted successfully!" }; 

    String[] englishBox_Alter = {"Alter a Member",
                                "Alter values ",
                                "Alter a Rocket",
                                "Where idMember:",
                                "New IdRocket: ",
                                "New MemberName: ",
                                "New Rocket Name: ",
                                "Status: Member altered successfully!",
                                "Status: Rocket altered successfully!",
                                "Error: The insert ID is not valid" + "<br>" + 
                                    "ID can only be altered below "};

    String[] englishBox_Delete = {"Delete a Member",
                                "Delete a Rocket",
                                "Delete values",
                                "Status: Member deleted successfully!",
                                "Status: Rocket deleted successfully!",
                                "Error: The inserted ID is not valid." + "<br>" +
                                "The Id can only be deleted below "};

    String[] englishBox_Select = {"Select a Member",
                                "Select a Rocket",
                                "Select",
                                "The inserted ID is not valid." + "<br>" +
                                "The inserted ID can only be inserted below"};

    String[] englishBox_SelectAll = {"Select Table Members",
                                    "Select Table Rockets",
                                    "Members Table",
                                    "Rockets Table"};

    String[] englishBox_LaunchPage = {"Options for Table", 
                                    "Insert", 
                                    "Delete", 
                                    "Alter",
                                    "Select ID", 
                                    "Select *"};


    //Fraçais
    public String[] francaisBox_Insert = {"Insérer un nouveau membre",
                                            "Insérer des valeurs",
                                            "Insérer une nouvelle fusée",
                                            "Erreur : l'ID saisi existe déjà." + "<br>" +" Le prochain ID doit provenir de ",
                                            "Erreur : l'ID saisi n'est pas valide." + "<br>" +" Le prochain ID doit provenir de ",
                                            "Statut : Membre entré avec succès !",
                                            "Statut : Fusée insérée avec succès !"};

    String[] francaisBox_Alter = {"Modifier un membre",
                                    "Changer les valeurs",
                                    "Changer une fusée",
                                    "Où idMember : ",
                                    "Nouveau IdRocket : ",
                                    "Nouveau nom de membre : ",
                                    "Nom de la nouvelle fusée : ",
                                    "Statut : Le membre a été modifié avec succès !",
                                    "Statut : Fusée modifiée avec succès !",
                                    "Erreur : l'ID saisi n'est pas valide." + "<br>" +
                                        "L'ID ne peut être modifié qu'en dessous",
                                        "Où IdRocket : ",
                                        "N  'ouveau nom de fusée"};

    String[] francaisBox_Delete = {"Supprimer un membre",
                                     "Supprimer une fusée",
                                     "Supprimer les valeurs",
                                     "Statut : Membre supprimé avec succès !",
                                     "Statut : Rocket supprimé avec succès !",
                                     "Erreur : l'ID saisi n'est pas valide." + "<br>" +
                                        "L'identifiant ne peut être supprimé qu'en dessous"};

    String[] francaisBox_Select = {"Sélectionner un membre",
                                     "Sélectionnez une fusée",
                                     "Spectacle",
                                     "L'ID saisi n'est pas valide." + "<br>" +
                                        "L'ID ne peut être affiché qu'en dessous"};

    String[] francais_SelectAll = {"Sélectionner les membres du tableau",
                                        "Sélectionnez le tableau des fusées",
                                        "Tableau des membres",
                                        "Table Fusée"};

    String[] francaisBox_LaunchPage = {"Options de tableau",
                                        "Insérer",
                                        "Effacer",
                                        "Changer",
                                        "Sélectionner l'identifiant",
                                        "Sélectionner *"};
    
    public String[] languageBox_Insert = new String[20];
    public String[] languageBox_Delete = new String[20];
    public String[] languageBox_Alter = new String[20];
    public String[] languageBox_Select = new String[20];
    public String[] languageBox_SelectAll = new String[20];
    public String[] languageBox_LaunchPage = new String[20];

    public void switchToPortuguese() {
        languageBox_Insert = portugueseBox_Insert;
        languageBox_Delete = portugueseBox_Delete;
        languageBox_Alter = portugueseBox_Alter;
        languageBox_Select = portugueseBox_Select;
        languageBox_SelectAll = portugueseBox_SelectAll;
        languageBox_LaunchPage = portugueseBox_LaunchPage;

        System.out.println("IDIOMA SELECIONADO: PORTUGUES");
    }

    public void switchToEnglish() {
        languageBox_Insert = englishBox_Insert;
        languageBox_Delete = englishBox_Delete;
        languageBox_Alter = englishBox_Alter;
        languageBox_Select = englishBox_Select;
        languageBox_SelectAll = englishBox_SelectAll;
        languageBox_LaunchPage = englishBox_LaunchPage;
        System.out.println("LANGUAGE SELECTED: ENGLISH");

    }

    public void switchToFrancais() {
        languageBox_Insert = francaisBox_Insert;
        languageBox_Delete = francaisBox_Delete;
        languageBox_Alter = francaisBox_Alter;
        languageBox_Select = francaisBox_Select;
        languageBox_SelectAll = francais_SelectAll;
        languageBox_LaunchPage = francaisBox_LaunchPage;
        System.out.println("LANGUE  SELECIONÉ: FRANÇAIS");
        
    }
    // RUNNING 
    
}
