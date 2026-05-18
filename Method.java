interface Method2 {
	   double calculate( String numbers);
}
public class Method implements Method2{

 public double calculate(String numbers) {
       String[] tokens = numbers.split("(?<=\\d)(?=[+\\-*/])|(?<=[+\\-*/])(?=\\d)");

        double result = Double.parseDouble(tokens[0]);

        for (int j = 1; j < tokens.length - 1; j += 2) {
            double next = Double.parseDouble(tokens[j + 1]);

            if (tokens[j].equals("+")) {
                result =result+ next;
            } else if (tokens[j].equals("-")) {
                result =result- next;
            } else if (tokens[j].equals("*")) {
                result =result*  next;
            } else if (tokens[j].equals("/")) {
                result =result/ next;
            }
        }

        return result;
    }

}