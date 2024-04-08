import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    //Part of Example 3
    private int operate(int a, int b, FuncInter1 fobj)
    {
        return fobj.operation(a, b);
    }

    public static void main(String[] args) {

        //Example 1
        FuncInterface funcInterface =(int x)->System.out.println(2*x);
        funcInterface.abstractFun(5);


        //Example 2
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);

        arrL.forEach(n -> System.out.println(n));
        List<Integer> even =arrL.stream().filter(n->n%2==0)
                .collect(Collectors.toList());
        even.forEach(n->System.out.println("Even Number"+n));
        Runnable zeroParameterLambda =
                () -> System.out.println("Zero parameter lambda");


        //Example 3


        FuncInter1 add = (int x, int y) -> x + y;
        FuncInter1 multiply = (int x, int y) -> x * y;
        Main test = new Main();
        System.out.println("Addition is "
                + test.operate(6, 3, add));

        System.out.println("Multiplication "+ test.operate(10,4, multiply));

        FuncInter2 funcInter2 = message -> System.out.println("Welcome "+message);
        funcInter2.sayMessage("Asheesh Kumar");

    }
}