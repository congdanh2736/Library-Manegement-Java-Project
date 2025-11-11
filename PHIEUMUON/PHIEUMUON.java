package PHIEUMUON;

import java.util.Scanner;

public class PHIEUMUON {
    private String MaPM;
    private String MaDG;
    private String MaNV;
    private String NgayMuon;
    private String NgayTra;
    private String NgayThucTra;

    public PHIEUMUON(){}
    public PHIEUMUON(String MaPM, String MaDG, String MaNV, String NgayMuon, String NgayTra, String NgayThucTra){
        this.MaPM = MaPM;
        this.MaDG = MaDG;
        this.MaNV = MaNV;
        this.NgayMuon = NgayMuon;
        this.NgayTra = NgayTra;
        this.NgayThucTra = NgayThucTra;
    }
    public PHIEUMUON(PHIEUMUON pm){
        this.MaPM = pm.MaPM;
        this.MaDG = pm.MaDG;
        this.MaNV = pm.MaNV;
        this.NgayMuon = pm.NgayMuon;
        this.NgayTra = pm.NgayTra;
        this.NgayThucTra = pm.NgayThucTra;
    }

    Scanner sc = new Scanner(System.in);

    public void nhap(){
        System.out.println("=== Nhap thong tin phieu muon ===");
        System.out.println("Nhap ma phieu muon: ");
        MaPM = sc.nextLine();
        System.out.print("Nhap ma doc gia: ");
        MaDG = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        MaNV = sc.nextLine();
        System.out.print("Nhap ngay muon: ");
        NgayMuon = sc.nextLine();
        System.out.print("Nhap ngay tra: ");
        NgayTra = sc.nextLine();
        System.out.print("Nhap ngay thuc tra: ");
        NgayThucTra = sc.nextLine();
    }
    public void xuat(){
        System.out.print("\n");
        System.out.printf("| %-12s| %-12s| %-12s| %-15s| %-15s| %-15s|", MaPM, MaDG, MaNV, NgayMuon, NgayTra, NgayThucTra);
    }

    public String getMPM(){return MaPM;}
    public String getMDG(){return MaDG;}
    public String getMNV(){return MaNV;}
    public String getNM(){return NgayMuon;}
    public String getNT(){return NgayTra;}
    public String getNTT(){return NgayThucTra;}

    public void setMPM(String mpm){
        this.MaPM = mpm;
    }
    public void setMDG(String mdg){
        this.MaDG = mdg;
    }
    public void setMNV(String mnv){
        this.MaNV = mnv;
    }
    public void setNM(String nm){
        this.NgayMuon = nm;
    }
    public void setNT(String nt){
        this.NgayTra = nt;
    }
    public void setNTT(String ntt){
        this.NgayThucTra = ntt;
    }
}
