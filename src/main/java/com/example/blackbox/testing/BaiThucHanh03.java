package com.example.blackbox.testing;

public class BaiThucHanh03 {

    // BÀI 1: Tính chu vi hình chữ nhật
    public static double chuViHCN(double a, double b) {
        if (a <= 0 || b <= 0) return -1;
        return 2 * (a + b);
    }

    // BÀI 2: Tính diện tích hình chữ nhật
    public static double dienTichHCN(double a, double b) {
        if (a <= 0 || b <= 0) return -1;
        return a * b;
    }

    // BÀI 3: Giải phương trình bậc 2
    public static String giaiphuongtrinhibac2(double a, double b, double c) {
        if (a == 0) return "Không phải phương trình bậc 2 (a = 0)";
        double delta = b * b - 4 * a * c;
        if (delta < 0) return "Phương trình vô nghiệm";
        if (delta == 0) {
            double x = -b / (2 * a);
            return "Nghiệm kép: x = " + x;
        }
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        return "Hai nghiệm: x1 = " + x1 + ", x2 = " + x2;
    }

    // BÀI 4: Tính số ngày của một tháng
    public static int soDayTrongThang(int thang, int nam) {
        if (thang < 1 || thang > 12 || nam <= 0) return -1;
        switch (thang) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                boolean nhuan = (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
                return nhuan ? 29 : 28;
            default:
                return -1;
        }
    }

    // BÀI 5: Kiểm tra số nguyên tố
    public static boolean laSoNguyenTo(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // BÀI 6: Tính tổng S = 1 - 2 + 3 - 4 + ... + n
    public static long tinhTongXenKe(int n) {
        if (n < 1) return Long.MIN_VALUE;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) sum -= i;
            else sum += i;
        }
        return sum;
    }

    // BÀI 7: Tìm UCLN của a và b
    public static int ucln(int a, int b) {
        if (a <= 0 || b <= 0) return -1;
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // BÀI 8: Hàm tính giai thừa
    public static long giaiThua(int n) {
        if (n < 0) return -1;
        if (n == 0) return 1;
        long result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

    // BÀI 8: Tính tổng S = 1! + 2! + ... + n!
    public static long tongGiaiThua(int n) {
        if (n < 1) return Long.MIN_VALUE;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += giaiThua(i);
        }
        return sum;
    }
}

