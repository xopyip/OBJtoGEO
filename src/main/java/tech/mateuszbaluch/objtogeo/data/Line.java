package tech.mateuszbaluch.objtogeo.data;

import java.util.Objects;

public class Line {
    private Vector3d start, end;

    public Line(Vector3d start, Vector3d end) {
        this.start = start;
        this.end = end;
    }

    public Vector3d getStart() {
        return start;
    }

    public Vector3d getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) &&
                Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
