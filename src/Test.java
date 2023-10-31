package src;

import src.matrix.Matrix;
import src.matrix.operations.*;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public class Test {
    public static void main(String[] args) {
        int modulus = 5;
        Matrix m1 = new Matrix(3, 4, modulus, new int[][]{
                {1, 3, 1, 1},
                {3, 2, 4, 2},
                {1, 0, 1, 0}
        });
        Matrix m2 = new Matrix(3, 5, modulus, new int[][]{
                {1, 4, 2, 3, 2},
                {0, 1, 0, 4, 2},
                {0, 0, 2, 0, 2},
        });

        System.out.println("The modulus is " + modulus);
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
