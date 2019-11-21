import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;
public class lab_7 {
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Main menu");
		System.out.println("1: Addition");
		System.out.println("2: Subtraction");
		System.out.println("3: Multiplication");
		System.out.println("4: Division");
		System.out.println("5: Exit");
		int userChoice = 0;
			
			
			
	do {	
	try {
		System.out.println("Enter a choice:");
		userChoice = input.nextInt();
				
				
			
			if (userChoice > 5) {
				System.out.println("Try again. (Incorrect input. Integer is greater than 5)\n");
				input.nextLine();
			}
			
			
			

				int firstNum = (int)(Math.random() * 10);
				int secondNum = (int)(Math.random() * 10);

				switch (userChoice) {
				case 1: 
					int adding = firstNum + secondNum;
					System.out.println(firstNum +" + "+secondNum+"?"); 
					int addingInput = input.nextInt();
					if (addingInput == adding)
						System.out.println("correct");
					else 
						System.out.println("Your answer is wrong. The correct answer is "+ adding);
					break;

				case 2:
					int sub = firstNum - secondNum;
					if (sub < 0) {
						System.out.println("Exception: answer is less than zero");
						System.out.println("Problem produced: " +firstNum +" - " +secondNum+"\n");
					break;}
					else
					System.out.println(firstNum +" - "+secondNum+"?"); 
					int subInput = input.nextInt();
					if (subInput == sub)
						System.out.println("correct");
					else 
						System.out.println("Your answer is wrong. The correct answer is "+ sub);
					break;

				case 3:
					int mult = firstNum * secondNum;
					System.out.println(firstNum +" * "+secondNum+"?"); 
					int multInput = input.nextInt();
					if (multInput == mult)
						System.out.println("correct");
					else 
						System.out.println("Your answer is wrong. The correct answer is "+ mult);
					break;

				case 4:
					try {
					double div = firstNum / secondNum;
					System.out.println(firstNum +" / "+secondNum+"?"); 
					double divInput = input.nextDouble();

					if (divInput == div)
						System.out.println("correct");
					else 
						System.out.println("Your answer is wrong. The correct answer is "+ div);
					break;
					}
					catch (ArithmeticException ex1 ) {
						System.out.println("Exception: an integer cannot be divided by zero");
						System.out.println("Problem produced: " +firstNum +"/" +secondNum+"\n");
					break;}

				case 5:
					System.out.println("Thank you for using the Math Tutor Program. Have a Great Day!");
					System.exit(0); break;
				}	

				
		}
		catch (InputMismatchException ex) {
			System.out.println("Try again. (Incorrect input. An integer is required)\n");
			input.nextLine();
		}
		
	}while (userChoice != 5);
	
				
	}
}



