public class Transition {
    private State state;
    private Edge edge;

    public Transition(final State state, final Edge edge) {
        this.state = state;
        this.edge = edge;
    }

    public State getState() {
        return this.state;
    }

    public Edge getEdge() {
        return this.edge;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Transition) {
            Transition t = (Transition) obj;
            return t.getEdge().equals(this.edge) && t.getState().equals(this.state);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hc = state != null ? state.hashCode() : 0;
        hc = 47 * hc + (edge != null ? edge.hashCode() : 0);
        return hc;
    }

    @Override
    public String toString() {
        return this.edge + "-->" + this.state.getName();
    }
}