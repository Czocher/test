
import java.io.IOException;

public class Main {

    public static void main(String[] arg) throws IOException {
        CiagHexadecymalny c = new CiagHexadecymalny();
        c.wczytaj();
        c.konwertuj();
        c.zapisz();
    }

}
