import java.util.ArrayList;
import java.util.Scanner;

public class TestForMyOwnShit {

    public static void main(String[] args) {

        ArrayList <Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input index");
        int index = sc.nextInt();
        System.out.println("Input number");
        int number = sc.nextInt();

        for (int i =0; i < 50; i ++)
        {
            array.add((int) ( Math.random()*100 +1 ));
        }
        for(Integer f: array)
        {
            System.out.println(f);
        }
        int[] arrayToTest = new int[51];
        System.arraycopy(array,index,arrayToTest, index +1,array.size() - index);
        array.set(index, number);
    }
}
