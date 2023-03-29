package main;

public class LazyNumberDetails {
    /** FIELDS */
    private int number;
    private int previousNumberPrime;
    private int previousNumberPerfect;
    private int previousNumberMagic;
    private boolean saveResultPrime;
    private boolean saveResultPerfect;
    private boolean saveResultMagic;

    /** METHODS */
    public LazyNumberDetails(int number) {
        System.out.println("**none (lazy eval.)**    -> no user action");
        this.number = number;
    }

    public void updateNumber(int number) {
        System.out.println("**none (lazy eval.)**    -> no user action");
        this.number = number;
    }

    public boolean isPrime() {
        if (this.number == this.previousNumberPrime) {
            System.out.println("**cached** -> saved result from prime alg");
            return this.saveResultPrime;
        } else {
            this.previousNumberPrime = this.number;
            return this.saveResultPrime = isPrime(this.number);
        }
    }

    public boolean isPerfect() {
        if (this.number == this.previousNumberPerfect) {
            System.out.print("**cached** -> saved result from perfect alg");
            System.out.println(" --->>> " + this.number + " is"
                    + (this.saveResultPerfect ? "" : " not") + " a perfect number.");

            return this.saveResultPerfect;

        } else {
            this.previousNumberPerfect = this.number;
            return this.saveResultPerfect = isPerfect(this.number);
        }
    }

    public boolean isMagic() {
        if (this.number == this.previousNumberMagic) {
            System.out.print("**cached** -> saved result from magic alg");
            System.out.println(" --->>> " + this.number + " is"
                    + (this.saveResultMagic ? "" : " not") + " a perfect number.");
            return this.saveResultMagic;
        } else {
            this.previousNumberMagic = this.number;
            return isMagic(this.number);
        }
    }

    private boolean isPrime (int number) {
        for (int i = 2; i < number; i++ ) {
            if (number % i == 0) {
                System.out.print("!!intensiveComputation!! -> prime algorithm for " + this.number);
                System.out.println(" --->>> " + number + " is not a prime number.");
                return this.saveResultPrime = false;
            }
        }
        System.out.print("!!intensiveComputation!! -> prime algorithm for " + this.number);
        System.out.println(" --->>> " + number + " is a prime number.");
        return this.saveResultPrime = true;
    }

    private boolean isPerfect (int number) {
        int sumDiv = 0;
        for (int div = 1; div <= number/2; div++) {
            if (number % div == 0) {
                sumDiv += div;
            }
        }
        System.out.print("!!intensiveComputation!! -> perfect algorithm for " + this.number);
        System.out.println(" --->>> " + number + " is" + ((sumDiv == number)? "" : " not") + " a perfect number.");
        return sumDiv == number;
    }

    private static int sumNumbers(int number) {
        int sum = 0, num;
        while (number > 0) {
            num = number % 10;
            sum += num;
            number /= 10;
        }
        return sum;
    }

    private boolean isMagic(int number) {
        int reduceNumber = sumNumbers(number);
        System.out.print("!!intensiveComputation!! -> magic algorithm for " + this.number);
        System.out.println(" --->>> " + number + " is"
                + ((reduceNumber == 3 || reduceNumber == 7 || reduceNumber == 9)? "" : " not")
                + " a magic number.");
        return this.saveResultMagic = (reduceNumber == 3 || reduceNumber == 7 || reduceNumber == 9);
    }
}