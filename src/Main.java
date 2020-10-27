public class Main {
    public static void main(String[] args) {
        State q0 = new State("q0");
        State x = new State("x");
        State y = new State("y");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");

        q1.setFinal();
        q3.setFinal();

        q0.addTransition(x, 'a');
        x.addTransition(q1, 'a');
        q1.addTransition(x, 'a');

        q0.addTransition(y, 'a');
        y.addTransition(q2, 'a');
        q2.addTransition(q3, 'a');
        q3.addTransition(y, 'a');

        String w = "a";
        NFA nfa = new NFA(q0);
        checkout(nfa.run(w), w);
    }

    public static void checkout(boolean b, String w) {
        if (b) System.out.println("Aceitou " + w);
        else System.out.println("Rejeitou " + w);
    }
}
