package com.example.blackbox.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bài Thực Hành 03 - Kiểm thử hộp đen")
public class BaiThucHanh03Test {

    @Nested
    @DisplayName("Bài 1 - Chu vi hình chữ nhật")
    class ChuViHCNTest {

        @Test
        @DisplayName("TC01 - Dữ liệu hợp lệ thông thường (5, 3) → 16.0")
        void tc01_hopLe_thuongThuong() {
            assertEquals(16.0, BaiThucHanh03.chuViHCN(5, 3));
        }

        @Test
        @DisplayName("TC02 - Hình vuông (4, 4) → 16.0")
        void tc02_hinhVuong() {
            assertEquals(16.0, BaiThucHanh03.chuViHCN(4, 4));
        }

        @Test
        @DisplayName("TC03 - Số thực (2.5, 1.5) → 8.0")
        void tc03_soThuc() {
            assertEquals(8.0, BaiThucHanh03.chuViHCN(2.5, 1.5));
        }

        @Test
        @DisplayName("TC04 - [Biên] Giá trị nhỏ nhất hợp lệ (1, 1) → 4.0")
        void tc04_bienNhoNhat() {
            assertEquals(4.0, BaiThucHanh03.chuViHCN(1, 1));
        }

        @Test
        @DisplayName("TC05 - [Không hợp lệ] a = 0 → -1")
        void tc05_khongHopLe_aBang0() {
            assertEquals(-1.0, BaiThucHanh03.chuViHCN(0, 5));
        }

        @Test
        @DisplayName("TC06 - [Không hợp lệ] b âm → -1")
        void tc06_khongHopLe_bAm() {
            assertEquals(-1.0, BaiThucHanh03.chuViHCN(3, -2));
        }

        @Test
        @DisplayName("TC07 - [Không hợp lệ] cả hai âm → -1")
        void tc07_khongHopLe_caiHaiAm() {
            assertEquals(-1.0, BaiThucHanh03.chuViHCN(-1, -1));
        }
    }

    @Nested
    @DisplayName("Bài 2 - Diện tích hình chữ nhật")
    class DienTichHCNTest {

        @Test
        @DisplayName("TC01 - Dữ liệu hợp lệ (5, 3) → 15.0")
        void tc01_hopLe() {
            assertEquals(15.0, BaiThucHanh03.dienTichHCN(5, 3));
        }

        @Test
        @DisplayName("TC02 - Hình vuông (4, 4) → 16.0")
        void tc02_hinhVuong() {
            assertEquals(16.0, BaiThucHanh03.dienTichHCN(4, 4));
        }

        @Test
        @DisplayName("TC03 - Số thực (2.5, 4.0) → 10.0")
        void tc03_soThuc() {
            assertEquals(10.0, BaiThucHanh03.dienTichHCN(2.5, 4.0));
        }

        @Test
        @DisplayName("TC04 - [Biên] (1, 1) → 1.0")
        void tc04_bienNhoNhat() {
            assertEquals(1.0, BaiThucHanh03.dienTichHCN(1, 1));
        }

        @Test
        @DisplayName("TC05 - [Không hợp lệ] a = 0 → -1")
        void tc05_khongHopLe_aBang0() {
            assertEquals(-1.0, BaiThucHanh03.dienTichHCN(0, 5));
        }

        @Test
        @DisplayName("TC06 - [Không hợp lệ] b âm → -1")
        void tc06_khongHopLe_bAm() {
            assertEquals(-1.0, BaiThucHanh03.dienTichHCN(3, -1));
        }
    }

    @Nested
    @DisplayName("Bài 3 - Giải phương trình bậc 2")
    class GiaiPTBac2Test {

        @Test
        @DisplayName("TC01 - Delta > 0: x²-5x+6=0 → 2 nghiệm x1=3, x2=2")
        void tc01_haiNghiem() {
            String result = BaiThucHanh03.giaiphuongtrinhibac2(1, -5, 6);
            assertTrue(result.contains("x1") && result.contains("x2"));
        }

        @Test
        @DisplayName("TC02 - Delta = 0: x²-2x+1=0 → nghiệm kép x=1")
        void tc02_nghiemKep() {
            String result = BaiThucHanh03.giaiphuongtrinhibac2(1, -2, 1);
            assertTrue(result.contains("Nghiệm kép"));
            assertTrue(result.contains("1.0"));
        }

        @Test
        @DisplayName("TC03 - Delta < 0: x²+1=0 → vô nghiệm")
        void tc03_voNghiem() {
            String result = BaiThucHanh03.giaiphuongtrinhibac2(1, 0, 1);
            assertTrue(result.contains("vô nghiệm"));
        }

        @Test
        @DisplayName("TC04 - [Không hợp lệ] a=0 → không phải bậc 2")
        void tc04_aBang0() {
            String result = BaiThucHanh03.giaiphuongtrinhibac2(0, 2, 1);
            assertTrue(result.contains("a = 0"));
        }

        @Test
        @DisplayName("TC05 - [Biên] a=1, b=0, c=0 → nghiệm kép x=0")
        void tc05_bienNghiemKep0() {
            String result = BaiThucHanh03.giaiphuongtrinhibac2(1, 0, 0);
            assertTrue(result.contains("Nghiệm kép"));
        }
    }

    @Nested
    @DisplayName("Bài 4 - Số ngày trong tháng")
    class SoNgayTrongThangTest {

        @Test
        @DisplayName("TC01 - Tháng 1 → 31 ngày")
        void tc01_thang1() {
            assertEquals(31, BaiThucHanh03.soDayTrongThang(1, 2024));
        }

        @Test
        @DisplayName("TC02 - Tháng 4 → 30 ngày")
        void tc02_thang4() {
            assertEquals(30, BaiThucHanh03.soDayTrongThang(4, 2024));
        }

        @Test
        @DisplayName("TC03 - Tháng 2 năm nhuận 2024 → 29 ngày")
        void tc03_thang2NamNhuan() {
            assertEquals(29, BaiThucHanh03.soDayTrongThang(2, 2024));
        }

        @Test
        @DisplayName("TC04 - Tháng 2 không nhuận 2023 → 28 ngày")
        void tc04_thang2KhongNhuan() {
            assertEquals(28, BaiThucHanh03.soDayTrongThang(2, 2023));
        }

        @Test
        @DisplayName("TC05 - [Biên] Tháng 12 → 31 ngày")
        void tc05_bienThang12() {
            assertEquals(31, BaiThucHanh03.soDayTrongThang(12, 2024));
        }

        @Test
        @DisplayName("TC06 - [Không hợp lệ] Tháng 0 → -1")
        void tc06_khongHopLe_thang0() {
            assertEquals(-1, BaiThucHanh03.soDayTrongThang(0, 2024));
        }

        @Test
        @DisplayName("TC07 - [Không hợp lệ] Tháng 13 → -1")
        void tc07_khongHopLe_thang13() {
            assertEquals(-1, BaiThucHanh03.soDayTrongThang(13, 2024));
        }

        @Test
        @DisplayName("TC08 - [Không hợp lệ] Năm âm → -1")
        void tc08_khongHopLe_namAm() {
            assertEquals(-1, BaiThucHanh03.soDayTrongThang(5, -1));
        }
    }

    @Nested
    @DisplayName("Bài 5 - Kiểm tra số nguyên tố")
    class SoNguyenToTest {

        @Test
        @DisplayName("TC01 - n=2 → true (số nguyên tố nhỏ nhất)")
        void tc01_n2() {
            assertTrue(BaiThucHanh03.laSoNguyenTo(2));
        }

        @Test
        @DisplayName("TC02 - n=7 → true")
        void tc02_n7() {
            assertTrue(BaiThucHanh03.laSoNguyenTo(7));
        }

        @Test
        @DisplayName("TC03 - n=13 → true")
        void tc03_n13() {
            assertTrue(BaiThucHanh03.laSoNguyenTo(13));
        }

        @Test
        @DisplayName("TC04 - n=1 → false")
        void tc04_n1() {
            assertFalse(BaiThucHanh03.laSoNguyenTo(1));
        }

        @Test
        @DisplayName("TC05 - n=4 → false (hợp số)")
        void tc05_n4() {
            assertFalse(BaiThucHanh03.laSoNguyenTo(4));
        }

        @Test
        @DisplayName("TC06 - n=9 → false (hợp số)")
        void tc06_n9() {
            assertFalse(BaiThucHanh03.laSoNguyenTo(9));
        }

        @Test
        @DisplayName("TC07 - [Không hợp lệ] n=0 → false")
        void tc07_n0() {
            assertFalse(BaiThucHanh03.laSoNguyenTo(0));
        }

        @Test
        @DisplayName("TC08 - [Không hợp lệ] n=-5 → false")
        void tc08_nAm() {
            assertFalse(BaiThucHanh03.laSoNguyenTo(-5));
        }
    }

    @Nested
    @DisplayName("Bài 6 - Tổng S = 1 - 2 + 3 - 4 + ... + n")
    class TongXenKeTest {

        @Test
        @DisplayName("TC01 - n=1 → 1")
        void tc01_n1() {
            assertEquals(1L, BaiThucHanh03.tinhTongXenKe(1));
        }

        @Test
        @DisplayName("TC02 - n=2 → -1")
        void tc02_n2() {
            assertEquals(-1L, BaiThucHanh03.tinhTongXenKe(2));
        }

        @Test
        @DisplayName("TC03 - n=3 → 2")
        void tc03_n3() {
            assertEquals(2L, BaiThucHanh03.tinhTongXenKe(3));
        }

        @Test
        @DisplayName("TC04 - n=4 → -2")
        void tc04_n4() {
            assertEquals(-2L, BaiThucHanh03.tinhTongXenKe(4));
        }

        @Test
        @DisplayName("TC05 - n=5 → 3")
        void tc05_n5() {
            assertEquals(3L, BaiThucHanh03.tinhTongXenKe(5));
        }

        @Test
        @DisplayName("TC06 - [Không hợp lệ] n=0 → Long.MIN_VALUE")
        void tc06_n0() {
            assertEquals(Long.MIN_VALUE, BaiThucHanh03.tinhTongXenKe(0));
        }

        @Test
        @DisplayName("TC07 - [Không hợp lệ] n=-3 → Long.MIN_VALUE")
        void tc07_nAm() {
            assertEquals(Long.MIN_VALUE, BaiThucHanh03.tinhTongXenKe(-3));
        }
    }

    @Nested
    @DisplayName("Bài 7 - Tìm UCLN của a và b")
    class UCLNTest {

        @Test
        @DisplayName("TC01 - ucln(12, 8) → 4")
        void tc01_ucln12_8() {
            assertEquals(4, BaiThucHanh03.ucln(12, 8));
        }

        @Test
        @DisplayName("TC02 - ucln(7, 5) → 1 (nguyên tố cùng nhau)")
        void tc02_ucln7_5() {
            assertEquals(1, BaiThucHanh03.ucln(7, 5));
        }

        @Test
        @DisplayName("TC03 - ucln(10, 10) → 10 (hai số bằng nhau)")
        void tc03_ucln10_10() {
            assertEquals(10, BaiThucHanh03.ucln(10, 10));
        }

        @Test
        @DisplayName("TC04 - [Biên] ucln(1, 1) → 1")
        void tc04_ucln1_1() {
            assertEquals(1, BaiThucHanh03.ucln(1, 1));
        }

        @Test
        @DisplayName("TC05 - ucln(100, 75) → 25")
        void tc05_ucln100_75() {
            assertEquals(25, BaiThucHanh03.ucln(100, 75));
        }

        @Test
        @DisplayName("TC06 - [Không hợp lệ] a=0 → -1")
        void tc06_aBang0() {
            assertEquals(-1, BaiThucHanh03.ucln(0, 5));
        }

        @Test
        @DisplayName("TC07 - [Không hợp lệ] b âm → -1")
        void tc07_bAm() {
            assertEquals(-1, BaiThucHanh03.ucln(5, -3));
        }
    }

    @Nested
    @DisplayName("Bài 8 - Tổng S = 1! + 2! + 3! + ... + n!")
    class TongGiaiThuaTest {

        @Test
        @DisplayName("TC01 - n=1 → 1")
        void tc01_n1() {
            assertEquals(1L, BaiThucHanh03.tongGiaiThua(1));
        }

        @Test
        @DisplayName("TC02 - n=2 → 3  (1!+2!=1+2)")
        void tc02_n2() {
            assertEquals(3L, BaiThucHanh03.tongGiaiThua(2));
        }

        @Test
        @DisplayName("TC03 - n=3 → 9  (1+2+6)")
        void tc03_n3() {
            assertEquals(9L, BaiThucHanh03.tongGiaiThua(3));
        }

        @Test
        @DisplayName("TC04 - n=4 → 33 (1+2+6+24)")
        void tc04_n4() {
            assertEquals(33L, BaiThucHanh03.tongGiaiThua(4));
        }

        @Test
        @DisplayName("TC05 - n=5 → 153 (1+2+6+24+120)")
        void tc05_n5() {
            assertEquals(153L, BaiThucHanh03.tongGiaiThua(5));
        }

        @Test
        @DisplayName("TC06 - [Không hợp lệ] n=0 → Long.MIN_VALUE")
        void tc06_n0() {
            assertEquals(Long.MIN_VALUE, BaiThucHanh03.tongGiaiThua(0));
        }

        @Test
        @DisplayName("TC07 - [Không hợp lệ] n=-1 → Long.MIN_VALUE")
        void tc07_nAm() {
            assertEquals(Long.MIN_VALUE, BaiThucHanh03.tongGiaiThua(-1));
        }
    }
}

