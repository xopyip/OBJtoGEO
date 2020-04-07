package tech.mateuszbaluch.objtogeo;

import tech.mateuszbaluch.objtogeo.geo.GeoExporter;
import tech.mateuszbaluch.objtogeo.model.Model;
import tech.mateuszbaluch.objtogeo.model.ModelScaler;
import tech.mateuszbaluch.objtogeo.obj.ObjLoader;

import java.io.File;

public class Converter {
    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("Usage java -jar app.jar <path to obj>");
            return;
        }
        File loadFile = new File(args[0]);
        if(!loadFile.isFile()){
            System.err.println("Usage java -jar app.jar <path to obj>");
            return;
        }
        Model model = ObjLoader.load(loadFile);
        ModelScaler.scale(model, 1);
        System.out.println("Loaded " + model.getLines().size() + " lines using " + model.getVertices().size() + " vertices.");
        GeoExporter.save(model, new File(args[0] + ".geo"));
    }
}
