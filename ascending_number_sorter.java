import java.util.ArrayList;
import java.util.Scanner;

public class lab_3 {
	
	public static void main(String[] args) {
		
		Scanner user = new Scanner(System.in);
		int n = 7;
		ArrayList<Integer> sevenNumbers = new ArrayList<Integer>();
		System.out.println("Please enter seven numbers: ");
		
	    for (int i=0; i < n; i++) {
	    	sevenNumbers.add(user.nextInt());	
	    }
	    arrayListSort(sevenNumbers);
	    System.out.println(sevenNumbers);
	}
	
	public static void arrayListSort(ArrayList<Integer> list) {
	
		for (int i = 0; i < list.size(); i++) {
	        for (int j = 0; j < list.size() - i - 1; j++) {
	            if (list.get(j) > list.get(j + 1)) {
	               int temp = list.get(j);
	               list.set(j, list.get(j + 1));
	               list.set(j + 1, temp);
            }
        }
	}
	}
}

