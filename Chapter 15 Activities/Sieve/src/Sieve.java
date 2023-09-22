import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        Set<Integer> numbers =  new HashSet<>();

        for(int i = 1; i<=n; i++){
            numbers.add(i);

        }
        
        for(int j=3; j<=n;j++){
            for(int k=2; k<n; k++){
                if(j%k==0 && j!=k){
                    numbers.remove(j);
                }
            }
        }

        System.out.println(numbers);




    }
}