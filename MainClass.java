import java.util.*;

public class MainClass{
	public static void main(String args[])
	{
		Method method=new Method();
		System.out.println("input your calculation");
		Scanner sc =new Scanner(System.in);
		String numbers=sc.nextLine();
		
		Double total=method.calculate(numbers);
		System.out.println(total);

		sc.close();
	}
}