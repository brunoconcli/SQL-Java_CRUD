package BancoDeDados.daos;
import java.sql.*;
import BancoDeDados.*;
import BancoDeDados.core.*;
import BancoDeDados.dbos.*;

public class Rockets implements Cloneable{
    public static boolean register(int idRocket) throws Exception{
        boolean retorno = false;
        try{
            String sql;
            sql = "SELECT * " + "FROM ROCKET" + "WHERE IDROCKET = ?";
            
            BDSQLServer.COMANDO.prepareStatement(sql);
            
            BDSQLServer.COMANDO.setInt(1, idRocket);
            
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first();

        }
        catch (SQLException erro)
        {
            throw new Exception ("Error to find Rocket of Protocol");
        }
        return retorno;
    }
    //incluir
    public static void insertRocket(Rocket rocket) throws Exception
    {
        if (rocket == null) 
            throw new Exception ("Foguete não fornecido");
        try{
            String sql;

            sql = "INSERT INTO LAUNCH.ROCKET " +
                  "(IDROCKET,ROCKETNAME) " +
                  "VALUES " +
                  "(?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, rocket.getIdRocket ());
            BDSQLServer.COMANDO.setString(2, rocket.getNameRocket ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();

            System.out.println("Rocket inserido com sucesso!");
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir rocket");
        }
    } 

    public static void deleteRocket (int idRocket) throws Exception
    {
        if (idRocket <= 0) 
            throw new Exception ("Rocket ID inválido");
        try
        {
            String sql;

            sql = "DELETE FROM LAUNCH.ROCKET " +
                  "WHERE IDROCKET=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idRocket);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
            
            System.out.println("Rocket excluído com sucesso!");
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir foguete");
        }
    }
    public static void alterRocket (String rocketName, int idRocket) throws Exception
    {
        if (rocketName == "")
            throw new Exception ("RocketName inválido");

        try
        {
            String sql;

            sql = "UPDATE LAUNCH.ROCKET " +
                  "SET ROCKETNAME=? " +
                  "WHERE IDROCKET = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, rocketName);
            BDSQLServer.COMANDO.setInt (2, idRocket);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();

            System.out.println("Rocket alterado com sucesso!");
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados dos rockets");
        }
    }
    public static String getRocket (int idRocket) throws Exception
    {
        Rocket rocket = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LAUNCH.ROCKET " +
                  "WHERE IDROCKET = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idRocket);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            rocket = new Rocket (resultado.getInt("IDROCKET"),
                                 resultado.getString ("ROCKETNAME"));
                               
            return "<html><br>IdRocket: "+ rocket.getIdRocket() +
                    "<br> Name Rocket: " + rocket.getNameRocket() +"</html>";

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
            sql = "SELECT COUNT (*) AS QTD FROM LAUNCH.ROCKET"; 
            BDSQLServer.COMANDO.prepareStatement(sql);
            
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
            resultado.first();
            retorno = resultado.getInt("QTD");
            return retorno;
        }
        catch(Exception erro){
            throw new Exception("Erro ao contar foguetes");
        }
    }
    
    public static MeuResultSet getRockets () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LAUNCH.ROCKET";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar foguete");
        }
        return resultado;
    }
    
}