
import java.util.LinkedList;

public class CalCompute {

    public void bracket(LinkedList<String> List_operator, LinkedList<Double> List_operand) {

        while (List_operator.contains("(")) {
            int closeIndex = -1;
            int openIndex = -1;

            for (int i = 0; i < List_operator.size(); i++) {
                if (List_operator.get(i).equals(")")) {
                    closeIndex = i;
                    break;
                }
            }

            for (int i = closeIndex; i >= 0; i--) {
                if (List_operator.get(i).equals("(")) {
                    openIndex = i;
                    break;
                }
            }

           

            LinkedList<String> subOperators = new LinkedList<>(List_operator.subList(openIndex + 1, closeIndex));

            LinkedList<Double> subOperands = new LinkedList<>(
                    List_operand.subList(openIndex, closeIndex)
            );

            compute("/", "*", subOperators, subOperands);
            compute("+", "-", subOperators, subOperands);

            double subResult = subOperands.get(0);

            for (int i = closeIndex; i >= openIndex; i--) {
                List_operator.remove(i);
            }

            for (int i = closeIndex - 1; i >= openIndex; i--) {
                List_operand.remove(i);
            }

            List_operand.add(openIndex, subResult);
        }
    }

    public void compute(String operator1, String operator2, LinkedList<String> List_operator, LinkedList<Double> List_operand) {
        for (int i = 0; i < List_operator.size(); i++) {
            if (List_operator.get(i).equals(operator1) || List_operator.get(i).equals(operator2)) {
                double left = List_operand.get(i);
                double right = List_operand.get(i + 1);
                double result = calculate(left, right, List_operator.get(i));

                List_operand.remove(i + 1);
                List_operand.remove(i);
                List_operand.add(i, result);
                List_operator.remove(i);
                i--;
            }
        }
    }

    private double calculate(double left, double right, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
