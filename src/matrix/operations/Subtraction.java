package src.matrix.operations;

/**
 * @author Calum Quinn
 * @author Dylan Ramos
 */
public class Subtraction extends Operation {
    public int calculate(int op1, int op2) {
        return op1 - op2;
    }

    public String toString() {
        return "-";
    }
}
