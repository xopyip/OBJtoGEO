package tech.mateuszbaluch.objtogeo.geo;

import tech.mateuszbaluch.objtogeo.data.Line;
import tech.mateuszbaluch.objtogeo.model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeoExporter {
    public static void save(Model model, File s) {
        try(FileWriter writer = new FileWriter(s)) {
            for (Line line : model.getLines()) {
                writer.write(String.format("%f %f %f %f %f %f %d %d %d\r\n",
                        line.getStart().getX(), line.getStart().getY(), line.getStart().getZ(),
                        line.getEnd().getX(), line.getEnd().getY(), line.getEnd().getZ(),
                        255, 0, 0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
