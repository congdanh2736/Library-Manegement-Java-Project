package QuyDinhPhat;

import java.util.Scanner;

public class QuyDinhPhat {
    Scanner sc = new Scanner(System.in);

    private String maLD;
    private String tenLD;
    private String cachThuc;
    private int soTien;
    
    public QuyDinhPhat() {
        maLD = "";
        tenLD = "";
        cachThuc = "";
        soTien = 0;
    }

    public QuyDinhPhat(String ma, String ten, String ct, int t) {
        this.maLD = ma;
        this.tenLD = ten;
        this.cachThuc = ct;
        this.soTien = t;
    }

    public QuyDinhPhat(QuyDinhPhat qd) {
        this.maLD = qd.maLD;        
        this.tenLD = qd.tenLD;        
        this.cachThuc = qd.cachThuc;        
        this.soTien = qd.soTien;        
    }

    public String getMaLD() {
        return maLD;
    }

    public String getTenLD() {
        return tenLD;
    }

    public String getCachThuc() {
        return cachThuc;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setMaLD(String ld) {
        this.maLD = ld;
    }

    public void setTenLD(String ten) {
        this.tenLD = ten;
    }

    public void setCachThuc(String ct) {
        this.cachThuc = ct;
    }

    public void setSoTien(int t) {
        this.soTien = t;
    }

    public void nhap() {
        
        System.out.print("# Nhập vào mã lý do: ");
        maLD = sc.nextLine();

        System.out.print("# Nhập vào tên lý do: ");
        tenLD = sc.nextLine();

        System.out.print("# Nhập vào cách thức: ");
        cachThuc = sc.nextLine();

        System.out.print("# Nhập vào số tiền phạt: ");
        soTien = sc.nextInt();

        sc.nextLine();
    }

    public void xuat() {
        System.out.println("# Mã lý do: " + maLD);
        System.out.println("# Tên lý do: " + tenLD);
        System.out.println("# Cách thức: " + cachThuc);
        System.out.println("# Số tiền phạt: " + soTien);
    }
}
