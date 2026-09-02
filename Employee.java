
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

       
        int num1 = sc.nextInt();
        System.out.println(num1);
       
        int num2 = sc.nextInt();
        System.out.println(num2);

        int sum = num1 + num2;

        // Consume the leftover newline
        sc.nextLine();

        

        
        System.out.println( sum);

        sc.close();
        reader.close();
    }
}


