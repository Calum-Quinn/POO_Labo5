package src.matrix;

import src.matrix.operations.Operation;

import java.util.Random;

public class Matrix {
    private int height;
    private int width;
    private int modulus;
    private int[][] values;

    Random random = new Random();

    // Default constructor
    private Matrix() {
        // TODO : modulus = 0 ?
        height = 0;
        width = 0;
        values = new int[0][0];
    }

    // Constructor with random numbers
    public Matrix(int height, int width, int modulus) {
        checkParams(height, width, modulus, null);

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
        checkParams(height, width, modulus, values);

        this.height = height;
        this.width = width;
        this.modulus = modulus;
        this.values = new int[height][width];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                this.values[i][j] = values[i][j];
            }
        }
    }

    private void checkParams(int height, int width, int modulus, int[][] values) {
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

    public Matrix calculate(Matrix other, Operation operation) {
        if (this.modulus != other.modulus) {
            throw new RuntimeException("Matrices must have the same modulus");
        }

        int maxHeight = Math.max(this.height, other.height);
        int maxWidth = Math.max(this.width, other.width);
        int newModulus = 1;
        int[][] newValues = new int[maxHeight][maxWidth];

        for (int i = 0; i < maxHeight; ++i) {
            for (int j = 0; j < maxWidth; ++j) {
                int op1 = 0;
                int op2 = 0;

                if (i < this.height && j < this.width) {
                    op1 = this.values[i][j];
                }

                if (i < other.height && j < other.width) {
                    op2 = other.values[i][j];
                }

                int result = operation.calculate(op1, op2);
                newValues[i][j] = Math.floorMod(result, this.modulus);

                if (result > newModulus) {
                    newModulus = result;
                }
            }
        }

        // Returns the new matrix. Note that the modulus is incremented by 1 because values are from 0 to modulus - 1
        return new Matrix(maxHeight, maxWidth, newModulus + 1, newValues);
    }
}