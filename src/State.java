import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class State {
    private String name;
    private boolean isFinal = false;
    private List<Transition> transitions = new LinkedList<>();

    public State(String name) {
        this.name = name;
    }

    public void setFinal() {
        this.isFinal = true;
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    public String getName() {
        return this.name;
    }

    public State addTransition(State state, Character c) {
        return addTransition(state, new Edge(c));
    }

    private State addTransition(State state, Edge... edges) {
        for (Edge e : edges) {
            Transition t = new Transition(state, e);
            if (transitions.contains(t))
                continue;
            transitions.add(t);
        }
        return this;
    }

    public Set<State> states(Character ch) {
        Set<State> r = new HashSet<>();

        for (Transition t : this.transitions) {
            Edge e = t.getEdge();
            if (e.getC() != null && e.getC().equals(ch)) {
                r.add(t.getState());
            } else {
                if (ch == null && e.getC() == null)
                    r.add(t.getState());
            }
        }
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof State) {
            State s = (State) obj;
            return s.getName().equals(this.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
        return this.name;//"[" + this.name + ":" + this.isFinal + "]";
    }
}