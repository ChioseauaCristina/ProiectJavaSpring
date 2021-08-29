package com.Chioseaua.springbootsecondapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReplace {
    List<String> lines = new ArrayList<>();
    String line = null;

    public void updateFile(int i, String toBeUpdated, String withWhat) {
        try {
            File f = new File("src/Products.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains(toBeUpdated)) {
                    String data[] = line.split(",");
                    data[i] = withWhat;
                    line="";
                    for(int j=0; j<4; j++) {
                        line+=data[j];
                        if(j != 3)
                            line+=",";
                    }
                }
                lines.add(line);
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f,false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : lines) {
                bw.write(s);
                bw.write("\n");
            }
            bw.flush();
            fw.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateFile(String toBeUpdated) {
        try {
            File f = new File("src/Products.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.contains(toBeUpdated)) {
                    lines.add(line);
                }
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : lines) {
                bw.write(s);
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
