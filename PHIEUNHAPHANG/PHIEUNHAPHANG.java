package PHIEUNHAPHANG;

import java.util.Scanner;

public class PHIEUNHAPHANG {
    private String MaPNH;
    private String MaNCC;
    private String NgayNhap;
    private long TongTien; // = tổng các thành tiền trong chi tiết pnh

    public PHIEUNHAPHANG(){}
    public PHIEUNHAPHANG(String MaPNH, String MaNCC, String NgayNhap, long TongTien){
        this.MaPNH = MaPNH;
        this.MaNCC = MaNCC;
        this.NgayNhap = NgayNhap;
        this.TongTien = TongTien;
    }
    public PHIEUNHAPHANG(PHIEUNHAPHANG pnh){
        this.MaPNH = pnh.MaPNH;
        this.MaNCC = pnh.MaNCC;
        this.NgayNhap = pnh.NgayNhap;
        this.TongTien = pnh.TongTien;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap(){
        System.out.println("=== Nhap thong tin phieu nhap hang ===");
        System.out.print("Nhap ma phieu nhap hang: ");
        MaPNH = sc.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
        MaNCC = sc.nextLine();
        System.out.print("Nhap ngay nhap: ");
        NgayNhap = sc.nextLine();
        TongTien = 0;
    }

    public void xuat()
    {
        System.out.print("\n");
        System.out.printf("| %-12s| %-12s| %-15s| %-15s|", MaPNH, MaNCC, NgayNhap, TongTien);
    }

    public String getM(){
        return MaPNH;
    } 
    public String getMNCC(){
        return MaNCC;
    }
    public String getN(){
        return NgayNhap;
    }
    public long getT(){
        return TongTien;
    }
    

    public void setM(String m){
        this.MaPNH = m;
    }
    public void setMNCC(String mncc){
        this.MaNCC = mncc;
    }
    public void setN(String n){
        this.NgayNhap = n;
    }
    public void setT(long t){
        this.TongTien = t;
    }
}
