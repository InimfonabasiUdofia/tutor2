
import java.util.LinkedList;

public class Method {

    /**
     * @param console calculator that obeys rule of BODMAS
     *
     */
    public LinkedList<Double> calculate(String expression) {

        CalCompute calCompute = new CalCompute();

        LinkedList<Double> List_operand = new LinkedList<>();
        LinkedList<String> List_operator = new LinkedList<>();


        /* * 
        * Split the expression into operands and operators
        * then store them in a seperate array*
         */
        String[] operands = expression.replaceAll("[()]", "").split("[+\\-*/]");
        for (String operand : operands) {
            String trimmed = operand.trim();
            if (!trimmed.isEmpty()) {
                List_operand.add(Double.parseDouble(trimmed));
            }
        }

        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                List_operator.add(String.valueOf(c));
            }
        }

        /**
         * Resolve all division and multiplication operations from left to
         * right. Iterates through the operator list and finds / and *
         * operators, computes the result, and updates both lists accordingly .
         *
         */
        calCompute.bracket(List_operator, List_operand);
        calCompute.compute("/", "*", List_operator, List_operand);

        /**
         * Resolve all addition and subtraction operations first from left to
         * right. Iterates through the operator list and finds + and -
         * operators, computes the result, and updates both lists accordingly.
         */
        calCompute.compute("+", "-", List_operator, List_operand);

        /**
         * @return returns value of linkedlinked list in double
         */
        return List_operand;

    }
}
