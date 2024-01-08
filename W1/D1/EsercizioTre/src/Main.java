//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(perimeter(10, 12.5));
        System.out.println(evenOdd(4));
        System.out.println(area(2.5, 4.2, 5.6));
    }

    public static double perimeter(double l1, double l2) {
        return l1 + l2 + l1 + l2;
    }

    public static int evenOdd(int input) {
        return input % 2 == 0 ? 0 : 1;
    }

    public static double area(double l1, double l2, double l3) {
        double semiPerimeter = (l1 + l2 + l3) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - l1) * (semiPerimeter - l2) * (semiPerimeter - l3));
    }
}