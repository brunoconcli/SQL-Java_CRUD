# WORKING COMMAND FOR MEMBER.REGISTER 
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

# WORKING COMMAND FOR MEMBERS.INSERT
public static void incluir(Member member) throws Exception
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
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir member");
        }
    } 

# WORKING COMMAND FOR MEMBERS.DELETE 
public static void excluir (int idMember) throws Exception
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
            BDSQLServer.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir member");
        }
    }

# WORKING COMMAND FOR MEMBERS.ALTER
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
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados dos membros");
        }
    }

# WORKING COMMAND ROCKETS.INSERT 
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

# WORKING COMMAND ROCKETS.DELETE 
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

# WORKING COMMAND ROCKETS.ALTER 
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

# SAMPLE OF WORKING RESPONSE, INSERT BUTTON 2 
if (txtMemberName.getText().equals("bruno"))
                System.out.println("Bruno is now set for the master pilot of the spaceshift");
            
            System.out.println("Values archieved!\n" +
                               "IdMember: "  + txtIdMember.getText() + "\n" +
                               "IdRocket: " + txtIdRocket.getText() + "\n" + 
                               "MemberName: " + txtMemberName.getText());

# WORKING TABLE INSERCTION 
String[][] participantes = {
        {"Bruno", "22303", "17"},
        {"Gustavo", "22308", "18"},
        {"", "", ""}
        };
        
        String[] colunas = {"Nome", "RA", "Idade"};
        teste = new JTable(participantes, colunas);
        participantes[2] = colunas;
        JScrollPane sp2 = new JScrollPane(teste);
        frame.add(sp2);