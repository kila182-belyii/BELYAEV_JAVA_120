package Classwork_4;

public class Program {
    public static double f(double x) {
        
        return Math.sin(x);
    }

    public static double calcIntegralByRectangles(int a, double b, int N) {
    
        double h = (b - a) / N;
        double result = 0;
    
        for (double x = a; x <= b; x += h) {
            result = result + f(x) * h;
        }
        return result;
}

    public static double integralBySimpson(int a, double b, int n) {

        double h = (b - a) / n;

        double result = 0;

        for (double x = a + h; x <= b; x = x + 2 * h) {
            double currentValue = f(x - h) + 4 * f(x) + f(x + h);
            result = result + currentValue;
        }

        return (h / 3) * result;
    }
    public static void main(String[] args) {
        double integral = calcIntegralByRectangles(0, Math.PI, 1000000);
        double integral2 = integralBySimpson(0, Math.PI, 5000);
        System.out.println(integral);
        System.out.println(integral2);
    }
}