package NhanVien;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class NhanVien {
    Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    private String maNV;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private String soDienThoai;
    private String diaChi;
    private int luong;

    public NhanVien() {
        maNV="";
        ho="";
        ten="";
        ngaySinh="";
        gioiTinh="";
        soDienThoai="";
        diaChi="";
        luong=0;
    }

    public NhanVien(String ma, String h, String t, String ns, String gt, String sdt, String dc, int l) {
        this.maNV = ma;
        this.ho = h;
        this.ten = t;
        this.ngaySinh = ns;
        this.gioiTinh = gt;
        this.soDienThoai = sdt;
        this.diaChi = dc;
        this.luong = l;
    }

    public NhanVien(NhanVien nv) {
        this.maNV = nv.maNV;
        this.ho = nv.ho;
        this.ten = nv.ten;
        this.ngaySinh = nv.ngaySinh;
        this.gioiTinh = nv.gioiTinh;
        this.soDienThoai = nv.soDienThoai;
        this.diaChi = nv.diaChi;
        this.luong = nv.luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getNS() {
        return ngaySinh;
    }

    public String getGT() {
        return gioiTinh;
    }

    public String getSDT() {
        return soDienThoai;
    }

    public String getDC() {
        return diaChi;
    }

    public int getLuong() {
        return luong;
    }

    public void setMaNV(String ma) {
        this.maNV = ma;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNS(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGT(String gt) {
        this.gioiTinh = gt;
    }

    public void setSDT(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setDC(String dc) {
        this.diaChi = dc;
    }

    public void setLuong(int l) {
        this.luong = l;
    }

    public void nhap() {
        
        System.out.print("# Nhập vào mã nhân viên: ");
        maNV = sc.nextLine();

        System.out.print("# Nhập vào họ: ");
        ho = sc.nextLine();

        System.out.print("# Nhập vào tên: ");
        ten = sc.nextLine();

        System.out.print("# Nhập vào ngày sinh: ");
        ngaySinh = sc.nextLine();

        while (!isValidDay(ngaySinh)) {
            System.out.println("# Ngày sinh không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            ngaySinh = sc.nextLine();
        }

        System.out.print("# Nhập vào giới tính: ");
        gioiTinh = sc.nextLine();

        System.out.print("# Nhập vào số điện thoại: ");
        soDienThoai = sc.nextLine();

        while (soDienThoai.length() != 10 || soDienThoai.charAt(0) != '0') {
            System.out.println("# Số điện thoại nhập không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            soDienThoai = sc.nextLine();
        }

        System.out.print("# Nhập vào địa chỉ: ");
        diaChi = sc.nextLine();

        System.out.print("# Nhập vào lương: ");
        luong = sc.nextInt();

        sc.nextLine();
    }

    public void xuat() {
        System.out.println("# Mã nhân viên: " + maNV);
        System.out.println("# Họ: " + ho);
        System.out.println("# Tên: " + ten);
        System.out.println("# Ngày sinh: " + ngaySinh);
        System.out.println("# Giới tính: " + gioiTinh);
        System.out.println("# Số điện thoại: " + soDienThoai);
        System.out.println("# Địa chỉ: " + diaChi);
        System.out.println("# Lương: " + luong);
    }

    public boolean isValidDay(String day) {
        String dateStr = day;

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("d/M/yyyy") // dùng d và M thay vì dd/MM
                .toFormatter();

        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
