package src;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> one = new ArrayList<>();
        ArrayList<ArrayList<Integer>> two = new ArrayList<>();

        for(int i = 0; i < 3; ++i) {
            one.add(new ArrayList<>());
            two.add(new ArrayList<>());
        }

        // Add numbers to first matrix
        one.get(0).add(1);
        one.get(0).add(3);
        one.get(0).add(1);
        one.get(0).add(1);

        one.get(1).add(3);
        one.get(1).add(2);
        one.get(1).add(4);
        one.get(1).add(2);

        one.get(2).add(1);
        one.get(2).add(0);
        one.get(2).add(1);
        one.get(2).add(0);

        // Add numbers to second matrix
        two.get(0).add(1);
        two.get(0).add(4);
        two.get(0).add(2);
        two.get(0).add(3);
        two.get(0).add(2);

        two.get(1).add(0);
        two.get(1).add(1);
        two.get(1).add(0);
        two.get(1).add(4);
        two.get(1).add(2);

        two.get(2).add(0);
        two.get(2).add(0);
        two.get(2).add(2);
        two.get(2).add(0);
        two.get(2).add(2);

        Matrix matrix1 = new Matrix(3, 3, 5, one);
        Matrix matrix2 = new Matrix(4, 3, 5, two);

        System.out.println(matrix1);
        System.out.println(matrix2);

        System.out.println(matrix1.add(matrix2));
        System.out.println(matrix1.subtract(matrix2));
        System.out.println(matrix1.multiply(matrix2));

    }
}