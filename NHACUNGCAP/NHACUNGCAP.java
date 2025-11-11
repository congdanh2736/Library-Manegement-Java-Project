package NHACUNGCAP;

import java.util.Scanner;

public class NHACUNGCAP {
    private String MaNCC;
    private String TenNCC;
    private String DChi;
    private String sdt;
    
    public NHACUNGCAP(){}
    public NHACUNGCAP(String MaNCC, String TenNCC, String DChi, String sdt){
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DChi = DChi;
        this.sdt = sdt;
    }
    public NHACUNGCAP(NHACUNGCAP ncc){
        this.MaNCC = ncc.MaNCC;
        this.TenNCC = ncc.TenNCC;
        this.DChi = ncc.DChi;
        this.sdt = ncc.sdt;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap(){
        System.out.println("=== Nhap thong tin nha cung cap ===");
        System.out.print("Nhap ma: ");
        MaNCC = sc.nextLine();
        System.out.print("Nhap ten: ");
        TenNCC = sc.nextLine();
        System.out.print("Nhap dia chi");
        DChi = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt = sc.nextLine();
        
    }

    public void xuat()
    {
        System.out.print("\n");
        System.out.printf("| %-10s| %-40s| %-30s| %-15s|", MaNCC, TenNCC, DChi, sdt);
    }

    public String getM(){
        return MaNCC;
    } 
    public String getT(){
        return TenNCC;
    }
    public String getD(){
        return DChi;
    }
    public String getS(){
        return sdt;
    }

    public void setM(String m){
        this.MaNCC = m;
    }
    public void setT(String t){
        this.TenNCC = t;
    }
    public void setD(String d){
        this.DChi = d;
    }
    public void setS(String s){
        this.sdt = s;
    }
}

