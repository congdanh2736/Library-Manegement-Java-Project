package DocGia;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DocGia {
    Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    private String maDocGia;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String sdt;
    private String ngayLapThe;

    public DocGia() {
        maDocGia = "";
        ho = "";
        ten = "";
        ngaySinh = "";
        gioiTinh = "";
        diaChi = "";
        sdt = "";
        ngayLapThe = "";
    }

    public DocGia(String m, String h, String t, String ns, String gt, String dc, String sdt, String ng) {
        this.maDocGia = m;
        this.ho = h;
        this.ten = t;
        this.ngaySinh = ns;
        this.gioiTinh = gt;
        this.diaChi = dc;
        this.sdt = sdt;
        this.ngayLapThe = ng;
    }

    public DocGia(DocGia dg) {
        this.maDocGia = dg.maDocGia;
        this.ho = dg.ho;
        this.ten = dg.ten;
        this.ngaySinh = dg.ngaySinh;
        this.gioiTinh = dg.gioiTinh;
        this.diaChi = dg.diaChi;
        this.sdt = dg.sdt;
        this.ngayLapThe = dg.ngayLapThe;
    }

    public String getMaDocGia(){ return maDocGia; }
    public String getHo(){ return ho; }
    public String getTen(){ return ten; }
    public String getNS(){ return ngaySinh; }
    public String getGT(){ return gioiTinh; }
    public String getDC(){ return diaChi; }
    public String getSDT(){ return sdt; }
    public String getNLT() {return ngayLapThe; }

    public void setMaDocGia(String ma) {
        this.maDocGia = ma;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNS(String ns) {
        this.ngaySinh = ns;
    }

    public void setGT(String gt) {
        this.gioiTinh = gt;
    }

    public void setDC(String dc) {
        this.diaChi = dc;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public void setNLT(String ma) {
        this.ngayLapThe = ma;
    }

    public void nhap() {
        
        // System.out.print("# Nhập vào mã độc giả: ");
        // maDocGia = sc.nextLine();

        double val = Math.random() * 100000;
        int ran = (int)val;
        maDocGia = "DG" + ran;

        System.out.print("# Nhập vào họ: ");
        ho = sc.nextLine();

        System.out.print("# Nhập vào tên: ");
        ten = sc.nextLine();

        System.out.print("# Nhập vào ngày sinh (DD/MM/YYYY): ");
        ngaySinh = sc.nextLine();

        while (ngaySinh.length() != 10) {
            System.out.println("# Cú pháp nhập ngày không hợp lệ!");
            System.out.print("# Nhập lại theo cú pháp sau --> (ngày sinh)/(tháng sinh)/(năm sinh) : ");
            ngaySinh = sc.nextLine();
        }

        System.out.print("# Nhập vào giới tính: ");
        gioiTinh =  sc.nextLine();

        System.out.print("# Nhập vào địa chỉ: ");
        diaChi = sc.nextLine();

        System.out.print("# Nhập vào số điện thoại: ");
        sdt = sc.nextLine();

        while (sdt.length() != 10 || sdt.charAt(0) != '0') {
            System.out.println("# Số điện thoại nhập không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            sdt = sc.nextLine();
        }

        System.out.print("# Nhập vào ngày lập thẻ: ");
        ngayLapThe = sc.nextLine();
        
        while (ngayLapThe.length() != 10) {
            System.out.println("# Cú pháp nhập ngày không hợp lệ!");
            System.out.print("# Nhập lại theo cú pháp sau --> (ngày sinh)/(tháng sinh)/(năm sinh) : ");
            ngayLapThe = sc.nextLine();
        }
    }

    public void xuat() {
        System.out.println("# Mã độc giả: " + maDocGia);
        System.out.println("# Họ tên: " + ho + " " + ten);
        System.out.println("# Ngày sinh: " + ngaySinh);
        System.out.println("# Giới tính: " + gioiTinh);
        System.out.println("# Địa chỉ: " + diaChi);
        System.out.println("# Số điện thoại: " + sdt);
        System.out.println("# Ngày lập thẻ: " + ngayLapThe);
    }
}
