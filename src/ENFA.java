import java.util.HashSet;
import java.util.Set;

public class ENFA {
    private State q;

    public ENFA(State q) {
        this.q = q;
    }

    public boolean run(String w) {
        Set<State> states = new HashSet<State>();//q.states(null);
        states.add(q);
        states = eclosure(states);

        for (int k = 0; k < w.length(); k++) { // varrer simbolos de w: w[0] w[1] ... w[k]
            char ch = w.charAt(k);

            Set<State> newStates = new HashSet<State>();
            for (State s : states) {
                //Só para visão não interfere na lógica
                System.out.print("[" + s.getName() + "]");
                Set<State> a = s.states(ch);
                a = eclosure(a);
                draw(w, k, a);
                //end

                newStates = merge(newStates, s.states(ch));
                newStates = eclosure(newStates);
            }
            states = newStates;
            if (states.size() == 0) break;
        }
        for (State s : states)
            System.out.print(s.getName() + " ");
        System.out.println();
        return valid(states);// verificar se existe algum estado final em states
    }

    private static Set<State> merge(Set<State> a, Set<State> b) {
        Set<State> r = new HashSet<State>();
        for (State s : a) if (!r.contains(s)) r.add(s);
        for (State s : b) if (!r.contains(s)) r.add(s);
        return r;
    }

    public static Set<State> eclosure(Set<State> qs) {
        Set<State> r = merge(new HashSet<State>(), qs);
        for (State s : qs) {
            Set<State> a = s.states(null);
            Set<State> b = eclosure(a);
            r = merge(r, a);
            r = merge(r, b);
        }
        return r;
    }

    public boolean valid(Set<State> qs) {
        if (qs == null || qs.size() == 0) return false;
        for (State s : qs)
            if (s.isFinal())
                return true;

        return false;
    }

    private void draw(String w, int k, Set<State> qs) {
        System.out.print(w.substring(0, k) + "{");
        for (State s : qs) {
            System.out.print(s.getName() + " ");
        }
        System.out.println("}" + w.substring(k));
    }
}