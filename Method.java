
import java.util.LinkedList;

public class Method {

    /**
     * @param
     * console calculator that obeys rule of BODMAS
     * 
     */
    
    public LinkedList<Double> calculate(String expression) {

        LinkedList<Double> List_operand = new LinkedList<>();
        LinkedList<String> List_operator = new LinkedList<>();


        /* * 
        * Split the expression into operands and operators
        * then store them in a seperate array
        */
        String[] operands = expression.split("[+\\-*/^%]");
        String[] operator = expression.trim().replaceAll("^[0-9.]+", "").split("[0-9.\\s]+");


        /* *
        * use a for loop to store the array operands and operators
        * in a seperate linkedlist
        */
        for (int i = 0; i < operands.length; i++) {
            List_operand.add(Double.parseDouble(operands[i]));
        }
        for (int i = 0; i < operator.length; i++) {
            List_operator.add(operator[i]);
        }


        /**
         *  Resolve all division and multiplication  operations from left to right.
         * Iterates through the operator list and finds / and * operators,
         * computes the result, and updates both lists accordingly .
         */
        for (int i = 0; i < List_operator.size(); i++) {
            if (List_operator.get(i).equals("/") ||List_operator.get(i).equals("*")) {
                double left = List_operand.get(i);
                double right = List_operand.get(i + 1);
                double result;
                if (List_operator.get(i).equals("/")){
                     result = left / right;
                }else{
                     result = left * right;
                }

                List_operand.remove(i + 1);
                List_operand.remove(i);
                List_operand.add(i, result);

                List_operator.remove(i);
                i--;
                
            }
        }


        
      


        
        /**
         *  Resolve all addition and subtraction operations first from left to right.
         * Iterates through the operator list and finds + and - operators,
         * computes the result, and updates both lists accordingly.
         */
        for (int i = 0; i < List_operator.size(); i++) {
            if (List_operator.get(i).equals("+") || List_operator.get(i).equals("-")) {
                double left = List_operand.get(i);
                double right = List_operand.get(i + 1);
                double result ;
                if(List_operator.get(i).equals("+")){
                    result = left + right;
                }else{
                    result = left - right;
                }

                List_operand.remove(i + 1);
                List_operand.remove(i);
                List_operand.add(i, result);

                List_operator.remove(i);
                i--;
                
            }
        }


           
      

        /**
         * @return
         * returns value of linkedlinked list in double
         */
        return List_operand ;

    }
}
