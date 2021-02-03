package readwritend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteND {

    public static void main(String[] args) {
        // vieta kur saugau visus triju failu zodzius
        List<String> list = new ArrayList();
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
            String str;
            String str2;
            String str3;
            String[] parts;
            // perskaitau pirma faila po viena eilute
            while ((str = br.readLine()) != null) {
                System.out.print(str);
                // kiekviena eilute skaldau žodžiais ir pridedu i bendra list'a                        
                System.out.println(" ");
                for (String s : str.split(" ")) {
                    list.add(s);
                }
            }
            System.out.println(" ");

            // perskaitau antra faila po viena eilute
            while ((str2 = br2.readLine()) != null) {
                System.out.print(str2);
                // kiekviena eilute skaldau žodžiais ir pridedu i bendra list'a                        
                System.out.println(" ");
                for (String s2 : str2.split(" ")) {
                    list.add(s2);
                }
            }
            System.out.println(" ");

            // perskaitau trecia faila po viena eilute
            while ((str3 = br3.readLine()) != null) {
                System.out.print(str3);
                // kiekviena eilute skaldau žodžiais ir pridedu i bendra list'a                        
                System.out.println(" ");
                for (String s3 : str3.split(" ")) {
                    list.add(s3);
                }
            }
            System.out.println(" ");
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
        System.out.println("-----1-----");
        System.out.print(list);
        System.out.println("-----2-----");

//         saraso rusiavimas nuo ilgiausio iki trumpiausio
        list.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println("-----3-----");
        System.out.println(list);

//         pradedu irasyma i nauja faila
        try (
                FileOutputStream fos = new FileOutputStream("d.txt");
                Writer fw = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bw = new BufferedWriter(fw);) {

            System.out.println("-----4-----");
            // irasau i nauja faila
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i));
                // atskiriam zodzius
                if (i < list.size() - 1) {
                    bw.write(", ");
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
}
