package com.api.whiteboxtesting;


public class MathUtils {

    public static double perimeterRectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Chiều rộng và chiều cao phải lớn hơn 0.");
        }
        return 2 * (width + height);
    }

    public static double areaRectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Chiều rộng và chiều cao phải lớn hơn 0.");
        }
        return width * height;
    }

    public static double[] solveQuadratic(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Hệ số a không được bằng 0.");
        }
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return new double[0]; // vô nghiệm
        } else if (delta == 0) {
            return new double[]{-b / (2 * a)}; // nghiệm kép
        } else {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            if (x1 > x2) { double tmp = x1; x1 = x2; x2 = tmp; }
            return new double[]{x1, x2};
        }
    }

    public static int daysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Tháng phải trong khoảng 1 – 12.");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Năm phải lớn hơn 0.");
        }
        switch (month) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Tháng không hợp lệ.");
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static long alternatingSum(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n phải >= 1.");
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;
    }

    public static int gcd(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("a và b phải lớn hơn 0.");
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n phải >= 0.");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long sumOfFactorials(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n phải >= 1.");
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += factorial(i);
        }
        return sum;
    }
}
