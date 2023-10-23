package src.matrix;

import src.matrix.operations.Operation;

import java.util.Random;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public class Matrix {
    private final int height;
    private final int width;
    private final int modulus;
    private final int[][] values;

    Random random = new Random();

    // Default constructor
    private Matrix() {
        height = 0;
        width = 0;
        modulus = 1;
        values = new int[0][0];
    }

    // Constructor with random numbers
    public Matrix(int height, int width, int modulus) {
        checkConstructorParams(height, width, modulus, null);

        this.height = height;
        this.width = width;
        this.modulus = modulus;
        values = new int[height][width];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                values[i][j] = random.nextInt(modulus);
            }
        }
    }

    // Constructor with chosen numbers
    public Matrix(int height, int width, int modulus, int[][] values) {
        checkConstructorParams(height, width, modulus, values);

        this.height = height;
        this.width = width;
        this.modulus = modulus;
        this.values = new int[height][width];

        // We must copy the values array in order to not copy the reference
        for (int i = 0; i < height; ++i) {
            System.arraycopy(values[i], 0, this.values[i], 0, width);
        }
    }

    // Checks that we can create a matrix with the given parameters
    private void checkConstructorParams(int height, int width, int modulus, int[][] values) {
        // Matrix dimensions must be positive and modulus must be greater than 0
        if (height < 0 || width < 0 || modulus < 1) {
            throw new RuntimeException("Invalid parameters");
        }

        // Passed values array must be the same size as the matrix and all values must be less than the modulus
        if (values != null) {
            if (values.length != height || values[0].length != width) {
                throw new RuntimeException("Invalid matrix dimensions");
            } else {
                for (int i = 0; i < height; ++i) {
                    for (int j = 0; j < width; ++j) {
                        if (values[i][j] >= modulus) {
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
            for (int j = 0; j < this.width; ++j) {
                result.append(values[i][j]);

                if (j != this.width - 1) {
                    result.append(" ");
                }
            }

            result.append("\n");
        }

        return result.toString();
    }

    // Calculates the result of the operation between this matrix and another matrix
    public Matrix calculate(Matrix other, Operation operation) {
        if (this.modulus != other.modulus) {
            throw new RuntimeException("Matrices must have the same modulus");
        }

        int maxHeight = Math.max(this.height, other.height);
        int maxWidth = Math.max(this.width, other.width);
        int[][] newValues = new int[maxHeight][maxWidth];

        for (int i = 0; i < maxHeight; ++i) {
            for (int j = 0; j < maxWidth; ++j) {
                int op1 = 0, op2 = 0;

                // If the index is out of bounds, we use 0 as the operand
                if (i < this.height && j < this.width) {
                    op1 = this.values[i][j];
                }

                if (i < other.height && j < other.width) {
                    op2 = other.values[i][j];
                }

                int result = operation.calculate(op1, op2);
                newValues[i][j] = Math.floorMod(result, this.modulus);
            }
        }

        // Returns the new matrix with the same modulus
        return new Matrix(maxHeight, maxWidth, this.modulus, newValues);
    }
}