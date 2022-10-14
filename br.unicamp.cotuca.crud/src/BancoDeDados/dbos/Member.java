package BancoDeDados.dbos;

public class Member implements Cloneable 
{
    private int idMember, idRocket;
    private String memberName;

    public void setIdMember (int idMember) throws Exception 
    {
        if (idMember <= 0)
            throw new Exception ("ID Member inválido");
        this.idMember = idMember;
    }

    public void setIdRocket(int idRocket) throws Exception 
    {
        if (idRocket <= 0)
            throw new Exception ("ID Foguete inválido");
        this.idRocket = idRocket;
    }

    public void setMemberName(String memberName) throws Exception 
    {
        if(memberName == null || memberName.equals(""))
            throw new Exception("Member name has not been set");
        this.memberName = memberName;
    }

    public int getIdMember ()
    {
        return this.idMember;
    }

    public int getIdRocket ()
    {
        return this.idRocket;
    }

    public String getMemberName ()
    {
        return this.memberName;
    }

    public Member (int idMember, int idRocket, String memberName) throws Exception
    {
        this.setIdMember(idMember);
        this.setIdRocket(idRocket);
        this.setMemberName(memberName);
    }

    public String toString ()
    {
        String ret="";

        ret+="idMember: "+this.idMember+"\n";
        ret+="idRocket..: "+this.idRocket  +"\n";
        ret+="member Name.: "+this.memberName;

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Member))
            return false;

        Member mem = (Member)obj;

        if (this.idMember!=mem.idMember)
            return false;

        if (this.idRocket!=mem.idRocket)
            return false;

        if (this.memberName.equals(mem.memberName))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=22;

        ret = 17*ret + Integer.valueOf(this.idMember).hashCode();
        ret = 17*ret + Integer.valueOf(this.idRocket).hashCode();
        ret = 17*ret + this.memberName.hashCode();

        return ret;
    }

    public Member (Member model) throws Exception
    {
        this.idMember = model.idMember; // nao clono, pq nao eh objeto
        this.idRocket   = model.idRocket;   // nao clono, pq nao eh clonavel
        this.memberName  = model.memberName;  // nao clono, pq nao eh objeto
    }

    public Object clone ()
    {
        Member ret=null;

        try
        {
            ret = new Member (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca � null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }

}