package src;

import java.util.Random;

public class Matrix {

    private int height;
    private int width;
    private int maximum;
    private int[][] values;

    Random random = new Random();

    // Default constructor
    private Matrix() {
        // TODO : maximum = 0 ?
        height = 0;
        width = 0;
        values = new int[0][0];
    }

    // Constructor with random numbers
    public Matrix(int width, int height, int maximum) {
        checkParams(width, height, maximum, null);

        this.height = height;
        this.width = width;
        this.maximum = maximum;
        values = new int[height][width];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                values[i][j] = random.nextInt(maximum);
            }
        }
    }

    // Constructor with chosen numbers
    public Matrix(int width, int height, int maximum, int[][] values) {
        checkParams(width, height, maximum, values);

        this.height = height;
        this.width = width;
        this.maximum = maximum;
        this.values = new int[height][width];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                this.values[i][j] = values[i][j];
            }
        }
    }

    private void checkParams(int width, int height, int maximum, int[][] values) {
        // Matrix dimensions must be positive and modulus must be greater than 0
        if (width < 0 || height < 0 || maximum < 1) {
            throw new RuntimeException("Invalid parameters");
        }

        // Passed values array must be the same size as the matrix and all values must be less than the modulus
        if (values != null) {
            if (values.length != height || values[0].length != width) {
                throw new RuntimeException("Invalid matrix dimensions");
            } else {
                for (int i = 0; i < height; ++i) {
                    for (int j = 0; j < width; ++j) {
                        if (values[i][j] >= maximum) {
                            throw new RuntimeException("Invalid matrix values");
                        }
                    }
                }
            }
        }
    }

    // So that we can simply "print" the matrix
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.height; ++i) {
            result.append("[");
            for (int j = 0; j < this.width; ++j) {
                result.append(values[i][j]);
                if (j != this.width - 1) {
                    result.append(", ");
                }
            }
            result.append("]\n");
        }

        return result.toString();
    }

    // Checks whether the matrices are the same size
    private boolean isCompatible(Matrix other) {
        return (this.height == other.height && this.width == other.width);
    }
}