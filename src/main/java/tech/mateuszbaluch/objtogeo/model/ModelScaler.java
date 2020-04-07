package tech.mateuszbaluch.objtogeo.model;

import tech.mateuszbaluch.objtogeo.data.Vector3d;

public class ModelScaler {
    public static void scale(Model model, double max) {
        double foundMax = 0;
        for (Vector3d vertex : model.getVertices()) {
            foundMax = Math.max(foundMax, vertex.getX());
            foundMax = Math.max(foundMax, vertex.getY());
            foundMax = Math.max(foundMax, vertex.getZ());
        }
        foundMax /= max;
        for (Vector3d vertex : model.getVertices()) {
            vertex.div(foundMax);
        }
    }
}
