package CHITIETPHIEUMUON;

import java.util.Scanner; 

public class CHITIET_PM {
    private String MaPM; // copy từ PM qua
    private String MaSach; // nhập
    private int SL; // nhập

    public CHITIET_PM(){}
    public CHITIET_PM(String MaPM, String MaSach, int SL){
        this.MaPM = MaPM;
        this.MaSach = MaSach;
        this.SL = SL;
    }
    public CHITIET_PM(CHITIET_PM ct){
        this.MaPM = ct.MaPM;
        this.MaSach = ct.MaSach;
        this.SL = ct.SL;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap(){
        System.out.println("=== Nhap thong tin chi tiet phieu muon ===");
        System.out.print("Nhap ma phieu muon: ");
        MaPM = sc.nextLine();
        System.out.print("Nhap ma sach: ");
        MaSach = sc.nextLine();
        System.out.print("Nhap so luong: ");
        SL = sc.nextInt();
    }
    public void xuat()
    {
        System.out.print("\n");
        System.out.printf("| %-12s| %-12s| %-12s|", MaPM, MaSach, SL);
    }

    public String getMPM(){
        return MaPM;
    }
    public String getMS(){
        return MaSach;
    }
    public int getS(){
        return SL;
    }
    public void setMPM(String mpm){
        this.MaPM = mpm;
    }
    public void setMS(String ms){
        this.MaSach = ms;
    }
    public void setSL(int s){
        this.SL = s;
    }
}
