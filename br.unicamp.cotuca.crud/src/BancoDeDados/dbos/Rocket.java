package BancoDeDados.dbos;
public class Rocket implements Cloneable{
    private int idRocket;
    private String nameRocket;

    public void setIdRocket(int idRocket)throws Exception{
        if(idRocket <= 0)
            throw new Exception("Ivalid idRocket");
        this.idRocket = idRocket;
    }
    public void setNameRocket(String nameRocket)throws Exception{
        if(nameRocket==null||nameRocket.equals(""))
            throw new Exception("Invalid name rocket");
        this.nameRocket = nameRocket;
    }
    public int getIdRocket(){
        return this.idRocket;
    }
    public String getNameRocket(){
        return this.nameRocket;
    }
    public Rocket(int idRocket, String nameRocket )throws Exception{
        this.setIdRocket(idRocket);
        this.setNameRocket(nameRocket);
    }
    public String toString(){
        String ret = "";
        ret+="IdRocket: "+this.idRocket+"\n";
        ret+="NameRocket: "+this.nameRocket+"\n";
        return ret;
    }
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null) return false;
        if(!(obj instanceof Rocket)) return false;
        Rocket rocket = (Rocket)obj;
        if(this.idRocket!= rocket.idRocket) return false;
        if(this.nameRocket.equals(rocket.nameRocket)) return false;
        
        return true;
    }
    public int hashCode(){
        int hash = 22;
        // hash = 17*hash + new Integer(this.idRocket).hashCode();
        hash = 17*hash + Integer.valueOf(this.idRocket).hashCode(); // não ultrapassado 
        hash = 17*hash + this.nameRocket.hashCode();
        if(hash < 0)
            hash *= -1;
        return hash;
    }
    public Rocket(Rocket modelo)throws Exception{
        this.idRocket=modelo.idRocket;
        this.nameRocket=modelo.nameRocket;
    }
    public Object clone(){
        Rocket rock=null;
        try{
            rock = new Rocket(this);
        }
        catch(Exception erro){}
        return rock;
    }
}