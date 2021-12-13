package people;

import java.io.Serializable;

public class addresss implements Serializable {
 private String provincname;
 private String townname;
 private String streetname;
 private int plaque;

    public addresss(String provincname, String townname, String streetname, int plaque) {
        this.provincname = provincname;
        this.townname = townname;
        this.streetname = streetname;
        this.plaque = plaque;
    }

    @Override
    public String toString() {
        return provincname+","+ townname+","+streetname+","+plaque+",";   }
}
