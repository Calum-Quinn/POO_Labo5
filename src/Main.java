package src;

import src.matrix.Matrix;
import src.matrix.operations.*;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public class Main {
    public static void main(String[] args) {
        // Arguments in args {N1,M1,N2,M2,mod}
        // NX: rows in matrix x
        // MX: columns in matrix x
        // mod: modulus for all numbers contained in the matrices
        if (args.length != 5) {
            throw new RuntimeException("Invalid number of arguments passed");
        }

        Matrix m1, m2;
        try {
            m1 = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[4]));
            m2 = new Matrix(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Arguments must be numbers");
        }

        System.out.println("The modulus is " + args[4]);
        System.out.println("one:");
        System.out.println(m1);

        System.out.println("two:");
        System.out.println(m2);

        Operation[] operations = new Operation[]{
                new Addition(),
                new Subtraction(),
                new Multiplication()
        };

        for (Operation operation : operations) {
            System.out.println("one " + operation + " two:");
            System.out.println(m1.calculate(m2, operation));
        }
    }
}