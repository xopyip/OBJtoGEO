package tech.mateuszbaluch.objtogeo.obj;

import tech.mateuszbaluch.objtogeo.model.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ObjLoader {
    public static Model load(File path) {
        Model model = new Model();
        try(Scanner scanner = new Scanner(new FileInputStream(path))) {
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.startsWith("#")) {
                    continue;
                }
                while(line.contains("  ")) line = line.replace("  ", " ");
                String[] s = line.split(" ");
                if(line.startsWith("v ")){ //vert
                    double x = Double.parseDouble(s[1]);
                    double y = Double.parseDouble(s[2]);
                    double z = Double.parseDouble(s[3]);
                    model.pushVert(x,y,z);
                    continue;
                }
                if(line.startsWith("f ")){ //face
                    for (int i = 1; i < s.length; i++) {
                        int idx_start = Integer.parseInt(s[i].split("/")[0]);
                        int idx_end = Integer.parseInt(s[Math.max(1, (i+1)%s.length)].split("/")[0]);
                        model.pushLine(idx_start, idx_end);
                    }
                    continue;
                }
                if(line.startsWith("l ")){ //line
                    for (int i = 1; i < s.length; i++) {
                        int idx_start = Integer.parseInt(s[i]);
                        int idx_end = Integer.parseInt(s[Math.max(1, (i+1)%s.length)]);
                        model.pushLine(idx_start, idx_end);
                    }
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }
}
