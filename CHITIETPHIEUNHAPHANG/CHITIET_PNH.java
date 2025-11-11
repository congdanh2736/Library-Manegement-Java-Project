package CHITIETPHIEUNHAPHANG;

import java.util.Scanner;

public class CHITIET_PNH {
    private String MaPNH; // copy từ PNH qua
    private String MaSach; // nhập (ràng buộc)
    private int SL; //nhập (ràng buộc)
    private int DG; // copy từ sách qua
    private long ThanhTien; // tt = sl * dg

    public CHITIET_PNH(){}
    public CHITIET_PNH(String MaPNH, String MaSach, int SL, int DG, long tt){
        this.MaPNH = MaPNH;
        this.MaSach = MaSach;
        this.SL = SL;
        this.DG = DG;
        this.ThanhTien = SL * DG;
    }
    public CHITIET_PNH(CHITIET_PNH ct){
        this.MaPNH = ct.MaPNH;
        this.MaSach = ct.MaSach;
        this.SL = ct.SL;
        this.DG = ct.DG;
        ThanhTien = ct.ThanhTien;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap(){
        System.out.println("=== Nhap thong tin chi tiet phieu nhap hang ===");
        System.out.print("Nhap ma phieu nhap hang: ");
        this.MaPNH = sc.nextLine();
        System.out.print("Nhap ma sach: ");
        this.MaSach = sc.nextLine();
        System.out.print("Nhap so luong: ");
        this.SL = sc.nextInt();
        System.out.print("Nhap don gia: ");
        this.DG = sc.nextInt();
        this.ThanhTien = this.SL * this.DG;
    }

    public void xuat()
    {
        System.out.print("\n");
        System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12s|", MaPNH, MaSach, SL, DG, ThanhTien);
    }

    public String getMPNH(){
        return MaPNH;
    }
    public String getMS(){
        return MaSach;
    }
    public int getS(){
        return SL;
    }
    public int getD(){
        return DG;
    }
    public long getT(){
        return ThanhTien;
    }

    public void setMPHN(String mpnh){
        this.MaPNH = mpnh;
    }
    public void setMS(String ms){
        this.MaSach = ms;
    }
    public void setS(int s){
        this.SL = s;
    }
    public void setD(int d){
        this.DG = d;
    }
    public void setT(long t){
        this.ThanhTien = t;
    }
}
