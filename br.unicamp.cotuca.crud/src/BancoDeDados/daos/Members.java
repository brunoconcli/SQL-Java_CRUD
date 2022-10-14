package BancoDeDados.daos;

import java.sql.*;
import BancoDeDados.*;
import BancoDeDados.core.*;
import BancoDeDados.dbos.*;
// import javax.swing.*;
// import java.util.*;

public class Members{
    public static boolean register(int idMember) throws Exception{
        boolean retorno = false;
        try{
            String sql;
            sql = "SELECT * " + "FROM LAUNCH.MEMBER" + "WHERE IDMEMBER = ?";
            
            BDSQLServer.COMANDO.prepareStatement(sql);
            
            BDSQLServer.COMANDO.setInt(1, idMember);
            
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first();

        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro em Register");
        }
        return retorno;
    }
    public static void insertMember(Member member) throws Exception
    {
        if (member == null) 
            throw new Exception ("Membro não fornecido");
        try{
            String sql;

            sql = "INSERT INTO LAUNCH.MEMBER " + 
                  "(IDMEMBER,IDROCKET,MEMBERNAME) " +
                  "VALUES " +
                  "(?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt    (1, member.getIdMember ());
            BDSQLServer.COMANDO.setInt (2, member.getIdRocket ());
            BDSQLServer.COMANDO.setString  (3, member.getMemberName ());
            
            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();

            System.out.println("Member inserido com sucesso!");
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir member");
        }
    } 

    public static void deleteMember(int idMember) throws Exception
    {
        if (idMember <= 0) 
        throw new Exception ("Membro não fornecido");

        try
        {
            String sql;

            sql = "DELETE FROM LAUNCH.MEMBER " +
                  "WHERE IDMEMBER=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idMember);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();      

            System.out.println("Member excluído com sucesso!");
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir member");
        }
    }
    public static void alterMember (int idRocket, String memberName, int idMember) throws Exception
    {
        if (idMember <= 0)
            throw new Exception ("IDMember inválido");

        if (idRocket <= 0)
            throw new Exception ("IDRocket inválido");
        
        if (memberName == "")
            throw new Exception ("MemberName inválido");

        try
        {
            String sql;

            sql = "UPDATE LAUNCH.MEMBER " + 
                  "SET IDROCKET=?, " +
                  "MEMBERNAME=? " +
                  "WHERE IDMEMBER = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idRocket);
            BDSQLServer.COMANDO.setString (2, memberName);
            BDSQLServer.COMANDO.setInt (3, idMember);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();

            System.out.println("Member alterado com sucesso!");
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados dos membros");
        }
    }
    public static String getMember (int idMember) throws Exception
    {
        Member member = null;

        try
        {
            String sql;
            
            sql = "SELECT * " +
                  "FROM LAUNCH.MEMBER " +
                  "WHERE IDMEMBER = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idMember);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
            throw new Exception ("Nao cadastrado");

            member = new Member (resultado.getInt   ("IDMEMBER"),
                                 resultado.getInt("IDROCKET"),
                                 resultado.getString ("MEMBERNAME"));
            System.out.println(member.getIdMember());
            return "<html><br>IDMeber: " + member.getIdMember() +"<br>IDRocket: " + 
                    member.getIdRocket() + "<br>MemberName: " +
                    member.getMemberName() + "</html>";
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar membro");
        }
    }
    public static int getLength()throws Exception{
        int retorno = 0;
        
        try{
            String sql;
            sql = "SELECT COUNT (*) AS QTD FROM LAUNCH.MEMBER"; 
            BDSQLServer.COMANDO.prepareStatement(sql);
            
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
            resultado.first();
            retorno = resultado.getInt("QTD");;
            return retorno;
        }
        catch(Exception erro){
            throw new Exception("Erro ao contar membros");
        }
    }
    
    public static MeuResultSet getMembers () throws Exception
    {
        try
        {
            String sql;
            
            sql = "SELECT * " +
                  "FROM LAUNCH.MEMBER ";
            
            BDSQLServer.COMANDO.prepareStatement (sql);
            
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
            return resultado;
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar membros");
        }
    }
}