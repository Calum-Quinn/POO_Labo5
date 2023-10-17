package src;

import java.util.Random;
import java.util.ArrayList;

public class Matrix {

    private int height;
    private int width;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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

    // Checks whether the Matrices are the same size
    private boolean isCompatible(Matrix other) {
        return (this.height == other.height && this.width == other.width);
    }

    // Replace the excess numbers with zeros
    private Matrix replaceWithZeros(Matrix matrix) {

        Matrix result = new Matrix();

        return result;
    }

    private static Matrix newMatrix(Matrix first, Matrix second) {
        Matrix result = new Matrix();
        if(first.isCompatible(second)) {
            result.setHeight(first.getHeight());
            result.setWidth(first.getWidth());
        }
        else {
            // LA IL FAUDRA REMPLACER PAR DES ZEROS
            result.setHeight(Math.max(first.getHeight(), second.getHeight()));
            result.setWidth(Math.max(first.getWidth(),second.getWidth()));
        }
        return result;
    }

    // Add two Matrices together
    public Matrix add(Matrix other){

        Matrix result = newMatrix(this,other);

        // Add numbers and end of line zeros
        for (int i = 0; i < Math.min(this.getHeight(),other.getHeight()); ++i) {
            ArrayList<Integer> row = new ArrayList<>(Math.min(this.getWidth(), other.getWidth()));
            for (int j = 0; j < row.size(); ++j) {
                row.add((this.values.get(i).get(j) + other.values.get(i).get(j)) % maximum);
            }
            // Add the extra zeros to the end of the lines
            for (int k = row.size(); k < Math.max(this.getWidth(), other.getWidth()); ++k) {
                row.add(0);
            }
            result.values.add(row);
        }


        // IL FAUDRA FAIRE UNE FONCTION QUE POUR CA (ADD ZEROS COMME HAUT DESSUS)

        // Create a row of zeros
        ArrayList<Integer> zeros = new ArrayList<>(Math.min(this.getWidth(), other.getWidth()));
        for (int i = 0; i < zeros.size(); i++) {
            zeros.add(0);
        }
        // Add rows of zeros
        for (int l = 0; l < (result.getHeight() - Math.min(this.getHeight(),other.getHeight())); ++l) {
            result.values.add(zeros);
        }


        return result;
    }

    // Subtract a Matrix from another
    public Matrix subtract(Matrix other){

        Matrix result = new Matrix();

        return result;
    }

    // Multiply two Matrices together
    public Matrix multiply(Matrix other){

        Matrix result = new Matrix();

        return result;
    }
}