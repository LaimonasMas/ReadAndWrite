package readwritend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadWriteND {

    public static void main(String[] args) {
        // vieta kur saugau visus triju failu zodzius
        String list = "";
        try (
                // perskaitau tris failus
                FileInputStream fis = new FileInputStream("a.txt");
                FileInputStream fis2 = new FileInputStream("b.txt");
                FileInputStream fis3 = new FileInputStream("c.txt");
                Reader fr = new InputStreamReader(fis, "UTF-8");
                Reader fr2 = new InputStreamReader(fis2, "UTF-8");
                Reader fr3 = new InputStreamReader(fis3, "UTF-8");
                BufferedReader br = new BufferedReader(fr);
                BufferedReader br2 = new BufferedReader(fr2);
                BufferedReader br3 = new BufferedReader(fr3);) {
            
            // vieta kur saugau po viena eilute
            String s;
            String s2;
            String s3;
            // perskaitau pirma faila po viena eilute
            while ((s = br.readLine()) != null) {
                System.out.print(s);
                // kiekviena eilute pridedu i bendra list'a
                list += s;
            }
            System.out.println(" ");
            
            // perskaitau antra faila po viena eilute
            while ((s2 = br2.readLine()) != null) {
                System.out.print(s2);
                // kiekviena eilute pridedu i bendra list'a
                list += s2;
            }
            System.out.println(" ");
            
            // perskaitau trecia faila po viena eilute
            while ((s3 = br3.readLine()) != null) {
                System.out.print(s3);
                // kiekviena eilute pridedu i bendra list'a
                list += s3;
            }
            System.out.println(" ");
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
        System.out.println("-----1-----");
        System.out.print(list);

        // zodziu skaldymas su tarpais
        String[] parts = list.split(" ");
        System.out.println(" ");
        List<String> sarasas = new ArrayList();
        for (String part : parts) {
            sarasas.add(part);
        }

        System.out.println("-----2-----");
        System.out.println(sarasas);
        
        // saraso rusiavimas nuo ilgiausio iki trumpiausio
        sarasas.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println("-----3-----");
        System.out.println(sarasas);
        
        // pradedu irasyma i nauja faila
        try (
                FileOutputStream fos = new FileOutputStream("d.txt");
                Writer fw = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bw = new BufferedWriter(fw);) {
            // lista verciu i String, nes kazkodel List<String> nenori irasineti...
            String naujasSarasas = sarasas.toString();
            System.out.println("-----4-----");
            System.out.println(naujasSarasas);
            // irasau i nauja faila
            bw.write(naujasSarasas);
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }

    }
}
