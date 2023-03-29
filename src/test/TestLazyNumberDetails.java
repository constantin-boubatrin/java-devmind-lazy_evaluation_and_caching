package test;

import main.LazyNumberDetails;

public class TestLazyNumberDetails {

    public void run() {
        LazyNumberDetails lnd;
        lnd = new LazyNumberDetails(23); // (1) **none (lazy eval.)** -> no user action

        // User instruction        |    What happens?            |  Explanation
        lnd.updateNumber(10); // (2)  **none (lazy eval.)**    -> no user action
        lnd.updateNumber(17); // (3)  **none (lazy eval.)**    -> no user action
        lnd.isPrime();        // (4)  !!intensiveComputation!! -> prime algorithm for 17
        lnd.isPrime();        // (5)  **cached**               -> saved result from prime alg
        lnd.updateNumber(28); // (6)  **none (lazy eval.)**    -> no user action
        lnd.isPerfect();      // (7)  !!intensiveComputation!! -> perfect algorithm for 28
        lnd.isPrime();        // (8)  !!intensiveComputation!! -> prime algorithm for 28
        lnd.isPerfect();      // (9)  **cached**               -> saved result from perfect alg
        lnd.isMagic();        // (10) !!intensiveComputation!! -> magic algorithm for 28
        lnd.isPrime();        // (11) **cached**               -> saved result from prime alg
        lnd.updateNumber(12); // (12) **none (lazy eval.)**    -> no user action
        lnd.isMagic();        // (13) !!intensiveComputation!! -> magic algorithm for 12
        lnd.isMagic();        // (14) **cached**               -> saved result from magic alg
    }

    /** DRIVER CODE */
    public static void main(String[] args) {
        System.out.println("<<< Lazy Evaluation And Caching >>>");

        // create and run an instance (for test purpose)
        new TestLazyNumberDetails().run();
    }
}