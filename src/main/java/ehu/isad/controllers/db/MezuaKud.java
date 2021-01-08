package ehu.isad.controllers.db;


import ehu.isad.controllers.db.DbKudSqlite;
import ehu.isad.model.Mezua;

import java.awt.image.DataBuffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MezuaKud {
private static MezuaKud instantzia=null;
    private  MezuaKud() {}

    public static MezuaKud getInstantzia(){
        if(instantzia==null){
            instantzia= new MezuaKud();
        }
        return instantzia;
    }


   public  Mezua lortuInformazioa(int id) throws SQLException {
        String query="SELECT fromUser, toUser, message FROM DirectMessage WHERE id="+id ;
       DbKudSqlite dbkud= DbKudSqlite.getInstantzia();
        ResultSet rs;
        rs=dbkud.execSQL(query);
        Mezua mezuberria= new Mezua();
        while (rs.next()){
            String nondik= rs.getString("fromUser");
            String nora= rs.getString("toUser");
            String mezua= rs.getString("message");
            mezuberria.setId(id);
            mezuberria.setNondik(nondik);
            mezuberria.setNora(nora);
            mezuberria.setMezua(mezua);
        }
      return mezuberria;
    }

   public  List<Mezua> lortuMezuak() throws SQLException {
       DbKudSqlite dbkud= DbKudSqlite.getInstantzia();
        String query= "SELECT id from DirectMessage";
        ResultSet rs1,rs2;
        List<Mezua> emaitza = new ArrayList<Mezua>();
        rs1= dbkud.execSQL(query);
        while(rs1.next()){
          emaitza.add(lortuInformazioa(rs1.getInt("id")));
        }
        return emaitza;
    }

}
