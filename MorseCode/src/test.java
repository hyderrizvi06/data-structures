import java.util.Scanner;
public class test {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String var = scan.nextLine();
        scan.close();
        Scanner dissect = new Scanner(var);
        System.out.println("S:"+var+":E");
        int count = 0;
        while(dissect.hasNext()){
            count++;
            System.out.println(dissect.next()+" ITERATION "+count);
        }
    }
}
