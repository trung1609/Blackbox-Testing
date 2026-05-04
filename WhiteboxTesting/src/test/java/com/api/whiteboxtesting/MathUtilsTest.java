package com.api.whiteboxtesting;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("MathUtils – White-box Test Suite")
class MathUtilsTest {

    @Nested
    @DisplayName("1. perimeterRectangle")
    class PerimeterRectangleTests {

        @Test
        @DisplayName("Chu vi hợp lệ: 5 x 3 => 16")
        void validPerimeter() {
            assertEquals(16.0, MathUtils.perimeterRectangle(5, 3), 1e-9);
        }

        @Test
        @DisplayName("Chu vi hợp lệ: số thực 2.5 x 4.0 => 13.0")
        void validPerimeterDouble() {
            assertEquals(13.0, MathUtils.perimeterRectangle(2.5, 4.0), 1e-9);
        }

        @Test
        @DisplayName("Ngoại lệ: width = 0")
        void zeroWidth() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.perimeterRectangle(0, 5));
        }

        @Test
        @DisplayName("Ngoại lệ: height <= 0")
        void negativeHeight() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.perimeterRectangle(3, -1));
        }

        @Test
        @DisplayName("Ngoại lệ: cả hai đều âm")
        void bothNegative() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.perimeterRectangle(-2, -3));
        }
    }

    @Nested
    @DisplayName("2. areaRectangle")
    class AreaRectangleTests {

        @Test
        @DisplayName("Diện tích hợp lệ: 4 x 6 => 24")
        void validArea() {
            assertEquals(24.0, MathUtils.areaRectangle(4, 6), 1e-9);
        }

        @Test
        @DisplayName("Diện tích hợp lệ: 1.5 x 2.0 => 3.0")
        void validAreaDouble() {
            assertEquals(3.0, MathUtils.areaRectangle(1.5, 2.0), 1e-9);
        }

        @Test
        @DisplayName("Ngoại lệ: width <= 0")
        void invalidWidth() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.areaRectangle(-5, 3));
        }

        @Test
        @DisplayName("Ngoại lệ: height = 0")
        void invalidHeight() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.areaRectangle(3, 0));
        }
    }

    @Nested
    @DisplayName("3. solveQuadratic")
    class SolveQuadraticTests {

        @Test
        @DisplayName("Hai nghiệm phân biệt: x² - 5x + 6 = 0 => {2, 3}")
        void twoRoots() {
            double[] roots = MathUtils.solveQuadratic(1, -5, 6);
            assertEquals(2, roots.length);
            assertEquals(2.0, roots[0], 1e-9);
            assertEquals(3.0, roots[1], 1e-9);
        }

        @Test
        @DisplayName("Nghiệm kép: x² - 4x + 4 = 0 => {2}")
        void doubleRoot() {
            double[] roots = MathUtils.solveQuadratic(1, -4, 4);
            assertEquals(1, roots.length);
            assertEquals(2.0, roots[0], 1e-9);
        }

        @Test
        @DisplayName("Vô nghiệm: x² + x + 1 = 0 => []")
        void noRoots() {
            double[] roots = MathUtils.solveQuadratic(1, 1, 1);
            assertEquals(0, roots.length);
        }

        @Test
        @DisplayName("Ngoại lệ: a = 0")
        void aEqualsZero() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.solveQuadratic(0, 3, 2));
        }

        @Test
        @DisplayName("Hai nghiệm: 2x² - x - 1 = 0 => {-0.5, 1}")
        void twoRootsNegativeCoeff() {
            double[] roots = MathUtils.solveQuadratic(2, -1, -1);
            assertEquals(2, roots.length);
            assertEquals(-0.5, roots[0], 1e-9);
            assertEquals(1.0,  roots[1], 1e-9);
        }
    }

    @Nested
    @DisplayName("4. daysInMonth / isLeapYear")
    class DaysInMonthTests {

        @Test
        @DisplayName("Tháng 1 (31 ngày)")
        void january() { assertEquals(31, MathUtils.daysInMonth(1, 2023)); }

        @Test
        @DisplayName("Tháng 4 (30 ngày)")
        void april() { assertEquals(30, MathUtils.daysInMonth(4, 2023)); }

        @Test
        @DisplayName("Tháng 2 năm thường (28 ngày)")
        void februaryNonLeap() { assertEquals(28, MathUtils.daysInMonth(2, 2023)); }

        @Test
        @DisplayName("Tháng 2 năm nhuận chia hết 4 (29 ngày)")
        void februaryLeap() { assertEquals(29, MathUtils.daysInMonth(2, 2024)); }

        @Test
        @DisplayName("Tháng 2 năm chia hết 100 nhưng không 400 (28 ngày)")
        void februaryNotLeap100() { assertEquals(28, MathUtils.daysInMonth(2, 1900)); }

        @Test
        @DisplayName("Tháng 2 năm chia hết 400 (29 ngày)")
        void februaryLeap400() { assertEquals(29, MathUtils.daysInMonth(2, 2000)); }

        @Test
        @DisplayName("Tháng 12 (31 ngày)")
        void december() { assertEquals(31, MathUtils.daysInMonth(12, 2023)); }

        @Test
        @DisplayName("Ngoại lệ: tháng 0")
        void invalidMonthZero() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.daysInMonth(0, 2023));
        }

        @Test
        @DisplayName("Ngoại lệ: tháng 13")
        void invalidMonth13() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.daysInMonth(13, 2023));
        }

        @Test
        @DisplayName("Ngoại lệ: năm <= 0")
        void invalidYear() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.daysInMonth(5, 0));
        }

        @Test
        @DisplayName("isLeapYear: 2020 là năm nhuận")
        void leapYear2020() { assertTrue(MathUtils.isLeapYear(2020)); }

        @Test
        @DisplayName("isLeapYear: 2019 không phải năm nhuận")
        void notLeapYear2019() { assertFalse(MathUtils.isLeapYear(2019)); }
    }

    @Nested
    @DisplayName("5. isPrime")
    class IsPrimeTests {

        @Test
        @DisplayName("n < 2 => false")
        void lessThanTwo() {
            assertFalse(MathUtils.isPrime(1));
            assertFalse(MathUtils.isPrime(0));
            assertFalse(MathUtils.isPrime(-5));
        }

        @Test
        @DisplayName("n = 2 => true (số nguyên tố chẵn duy nhất)")
        void two() { assertTrue(MathUtils.isPrime(2)); }

        @Test
        @DisplayName("n = 4 (chẵn, không nguyên tố) => false")
        void four() { assertFalse(MathUtils.isPrime(4)); }

        @Test
        @DisplayName("n = 3 => true")
        void three() { assertTrue(MathUtils.isPrime(3)); }

        @Test
        @DisplayName("n = 9 = 3x3 => false")
        void nine() { assertFalse(MathUtils.isPrime(9)); }

        @Test
        @DisplayName("n = 97 => true")
        void ninetySeven() { assertTrue(MathUtils.isPrime(97)); }

        @Test
        @DisplayName("n = 100 => false")
        void hundred() { assertFalse(MathUtils.isPrime(100)); }
    }

    @Nested
    @DisplayName("6. alternatingSum")
    class AlternatingSumTests {

        @Test
        @DisplayName("n = 1 => 1")
        void n1() { assertEquals(1L, MathUtils.alternatingSum(1)); }

        @Test
        @DisplayName("n = 2 => 1-2 = -1")
        void n2() { assertEquals(-1L, MathUtils.alternatingSum(2)); }

        @Test
        @DisplayName("n = 3 => 1-2+3 = 2")
        void n3() { assertEquals(2L, MathUtils.alternatingSum(3)); }

        @Test
        @DisplayName("n = 4 => 1-2+3-4 = -2")
        void n4() { assertEquals(-2L, MathUtils.alternatingSum(4)); }

        @Test
        @DisplayName("n = 10 => -5")
        void n10() { assertEquals(-5L, MathUtils.alternatingSum(10)); }

        @Test
        @DisplayName("Ngoại lệ: n = 0")
        void nZero() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.alternatingSum(0));
        }

        @Test
        @DisplayName("Ngoại lệ: n âm")
        void nNegative() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.alternatingSum(-3));
        }
    }

    @Nested
    @DisplayName("7. gcd")
    class GcdTests {

        @Test
        @DisplayName("gcd(12, 8) = 4")
        void basic() { assertEquals(4, MathUtils.gcd(12, 8)); }

        @Test
        @DisplayName("gcd(7, 5) = 1 (nguyên tố cùng nhau)")
        void coprime() { assertEquals(1, MathUtils.gcd(7, 5)); }

        @Test
        @DisplayName("gcd(18, 6) = 6 (chia hết nhau)")
        void divisible() { assertEquals(6, MathUtils.gcd(18, 6)); }

        @Test
        @DisplayName("gcd(100, 75) = 25")
        void hundred() { assertEquals(25, MathUtils.gcd(100, 75)); }

        @Test
        @DisplayName("Ngoại lệ: a = 0")
        void aZero() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.gcd(0, 5));
        }

        @Test
        @DisplayName("Ngoại lệ: b âm")
        void bNegative() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.gcd(5, -3));
        }
    }

    @Nested
    @DisplayName("8. factorial & sumOfFactorials")
    class FactorialTests {

        // -- factorial --
        @Test
        @DisplayName("0! = 1")
        void factZero() { assertEquals(1L, MathUtils.factorial(0)); }

        @Test
        @DisplayName("1! = 1")
        void factOne() { assertEquals(1L, MathUtils.factorial(1)); }

        @Test
        @DisplayName("5! = 120")
        void factFive() { assertEquals(120L, MathUtils.factorial(5)); }

        @Test
        @DisplayName("10! = 3628800")
        void factTen() { assertEquals(3628800L, MathUtils.factorial(10)); }

        @Test
        @DisplayName("Ngoại lệ: n âm")
        void factNegative() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.factorial(-1));
        }

        @Test
        @DisplayName("n=1: 1! = 1")
        void sumN1() { assertEquals(1L, MathUtils.sumOfFactorials(1)); }

        @Test
        @DisplayName("n=3: 1!+2!+3! = 9")
        void sumN3() { assertEquals(9L, MathUtils.sumOfFactorials(3)); }

        @Test
        @DisplayName("n=5: 1!+2!+3!+4!+5! = 153")
        void sumN5() { assertEquals(153L, MathUtils.sumOfFactorials(5)); }

        @Test
        @DisplayName("Ngoại lệ: n = 0")
        void sumNZero() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.sumOfFactorials(0));
        }

        @Test
        @DisplayName("Ngoại lệ: n âm")
        void sumNNegative() {
            assertThrows(IllegalArgumentException.class,
                    () -> MathUtils.sumOfFactorials(-2));
        }
    }
}
