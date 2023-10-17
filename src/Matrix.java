package src;

import java.util.Random;
import java.util.ArrayList;

public class Matrix {

    private final int height;
    private final int width;
    private int maximum;
    private ArrayList<ArrayList<Integer>> values;

    Random random = new Random();

    // Default constructor
    private Matrix() {
        height = 0;
        width = 0;
    }

    // Constructor with random numbers
    public Matrix(int width, int height, int maximum) {
        this.height = height;
        this.width = width;
        this.maximum = maximum;
        for (int i = 0; i < height; ++i) {
            ArrayList<Integer> row = new ArrayList<>(width);
            for (int j = 0; j < width; ++j) {
                row.add(random.nextInt(maximum));
            }
            values.add(row);
        }
    }

    // Constructor with chosen numbers
    public Matrix(int width, int height, int maximum, ArrayList<ArrayList<Integer>> values) {
        this.height = height;
        this.width = width;
        this.maximum = maximum;
        this.values.addAll(values);
    }

    // So that we can simply "print" the Matrix
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (ArrayList<Integer> row : values) {
            result.append("[");
                for (int i = 0; i < row.size(); ++i) {

                // PAS SUR DE CA, PEUT PEUT-ETRE AJOUTER UN CHAR DE VALEUR I
                result.append(row.get(i));

                if (i != row.size() - 1) {
                    result.append(", ");
                }
            }
            result.append("]");
        }

        return result.toString();
    }



//    public Matrix addition(Matrix other) {
//        return this + other;
//    }
}