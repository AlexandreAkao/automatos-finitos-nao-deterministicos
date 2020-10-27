public class Edge {
    private Character c;

    public Edge(Character c) {
        this.c = c;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge) {
            Edge e = (Edge) o;
            return Util.testAB(this.c, e.getC());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hc = c != null ? c.hashCode() : 0;
        return hc;
    }

    @Override
    public String toString() {
        return "edge{c=" + c + "}";
    }
}