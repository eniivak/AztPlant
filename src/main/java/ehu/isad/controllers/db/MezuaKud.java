package ehu.isad.controllers.db;


import ehu.isad.controllers.db.DbKudSqlite;
import ehu.isad.model.Mezua;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MezuaKud {

 private DbKudSqlite dbkud= DbKudSqlite.getInstantzia();
    Mezua lortuInformazioa(int id) throws SQLException {
        String query="SELECT fromUser, toUser, message FROM DirectMessage WHERE id="+id ;
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

    List<Mezua> lortuMezuak() throws SQLException {
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
