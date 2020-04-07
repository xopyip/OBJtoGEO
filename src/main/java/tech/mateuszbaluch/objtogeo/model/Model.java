package tech.mateuszbaluch.objtogeo.model;

import tech.mateuszbaluch.objtogeo.data.Line;
import tech.mateuszbaluch.objtogeo.data.Vector3d;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {
    private List<Vector3d> vertices = new ArrayList<>();
    private Set<Line> lines = new HashSet<>();

    public void pushVert(double x, double y, double z) {
        vertices.add(new Vector3d(x,y,z));
    }

    public Line pushLine(int idx_start, int idx_end) {
        if(idx_end < idx_start){
            int temp = idx_end;
            idx_end = idx_start;
            idx_start = temp;
        }
        Line line = new Line(vertices.get(idx_start-1), vertices.get(idx_end-1));
        lines.add(line);
        return line;
    }

    public List<Vector3d> getVertices() {
        return vertices;
    }

    public Set<Line> getLines() {
        return lines;
    }
}
