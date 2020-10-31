public class Linguagens {
    public static void l0() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        q3.setFinal();

        q0.addTransition(q0, 'a');
        q0.addTransition(q0, 'b');
        q0.addTransition(q1, 'b');

        q1.addTransition(q2, 'a');
        q1.addTransition(q2, 'b');

        q2.addTransition(q3, 'a');
        q2.addTransition(q3, 'b');

        String w = "abaaabaabaa";
        ENFA nfa = new ENFA(q0);
        checkout(nfa.run(w), w);
    }

    public static void l1() {
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

        String w = "aaa";
        ENFA nfa = new ENFA(q0);

        checkout(nfa.run(w), w);
    }

    public static void l2() {
        /*
         * L = { a^n in Σ^* | n par
         * pode terminar com p, ou n divisivel por 3 e
         * pode terminar com i }
         */
        System.out.println("*****************************\nProcessamento de L2:");

        State qa = new State("qa");
        State qb = new State("qb");

        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        State qx = new State("qx");
        State qy = new State("qy");

        q0.addTransition(qa, 'a');
        q0.addTransition(qb, 'a');

        qa.addTransition(q1, 'a');
        q1.addTransition(qa, 'a');

        qb.addTransition(q2, 'a');
        q2.addTransition(q3, 'a');
        q3.addTransition(qb, 'a');

        q1.addTransition(qx, 'p');
        q3.addTransition(qy, 'i');

        q1.setFinal();
        q3.setFinal();
        qx.setFinal();
        qy.setFinal();

        String w = "aaa";
        ENFA nfa = new ENFA(q0);
        checkout(nfa.run(w), w);
        System.out.println("*****************************");
    }

    public static void l3() {
        /*
         * L = { a^n in Σ^* | n par pode terminar com p, ou n divisivel por 3 e pode terminar com i}
         */
        System.out.println("*****************************\nProcessamento de L1:");

        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        State q4 = new State("q4");
        State q5 = new State("q5");

        State q6 = new State("q6");
        State q7 = new State("q7");
        State q8 = new State("q8");

        q0.addTransition(q1, null);
        q0.addTransition(q2, null);
        q0.addTransition(q8, 'a');

        q1.addTransition(q3, 'a');
        q3.addTransition(q1, 'a');
        q2.addTransition(q4, 'a');
        q4.addTransition(q5, 'a');
        q5.addTransition(q2, 'a');

        q1.addTransition(q6, null);
        q2.addTransition(q7, null);

        q6.addTransition(q6, 'p');
        q7.addTransition(q7, 'i');

        q6.setFinal();
        q7.setFinal();
        /*
         * Def.: e-closure de um estado p, ECLOSURE(p):
         * - conjunto dos estados alcancados a partir de
         * p (incluindo p) por caminhos rotulados por 'e'.
         */
        String w = "aaaaaap";
        ENFA nfa = new ENFA(q0);
        checkout(nfa.run(w), w);
        System.out.println("*****************************");
    }

    public static void checkout(boolean b, String w) {
        if (b) System.out.println("Aceitou " + w);
        else System.out.println("Rejeitou " + w);
    }
}