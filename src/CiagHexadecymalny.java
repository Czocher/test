
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CiagHexadecymalny {

    private String ciag;
    private int[] data = new int[256];

    void wczytaj() {
        Scanner s = new Scanner(System.in);
        ciag = s.nextLine();

        if (ciag.length() != 512) {
            System.out.println("Sorry ciag o niepoprawnej dlugosci");
            System.exit(1);
        }

        char[] dozwolone = {'A', 'B', 'C', 'D', 'E', 'F', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        label:
        for (int i = 0; i < ciag.length(); i++) {
            boolean przeszlo = false;
            for (int j = 0; j < dozwolone.length; j++) {
                if (ciag.charAt(i) != dozwolone[j]) {
                    przeszlo = true;
                }
            }

            if (!przeszlo) {
                System.out.println("Ciag ma niepoprawne znaki");
                System.exit(1);
            }
        }
    }

    void konwertuj() {
        int j = 0;
        for (int i = 0; i < ciag.length(); i = i + 2) {
            String a = "" + ciag.charAt(i) + ciag.charAt(i + 1);
            int hex = Integer.valueOf(a, 16);
            data[j] = hex;
            j++;
        }
    }

    void zapisz() throws FileNotFoundException, IOException {
        File f = new File("data.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
        for (int i = 0; i < data.length; i++) {
            writer.write(data[i] + "\n");
        }
        writer.close();
    }


}
