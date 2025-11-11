package PhieuPhat;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PhieuPhat {
    Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    private String maPP;
    private String maPM;
    private String maLD;
    private int soTienPhat;
    
    public PhieuPhat() {
        maPP = "";
        maPM = "";
        maLD = "";
        soTienPhat = 0;
    }
    
    public PhieuPhat(String pp, String pm, String ld, int tien) {
        maPP = pp;
        maPM = pm;
        maLD = ld;
        soTienPhat = tien;
    }

    public PhieuPhat(PhieuPhat pp) {
        this.maPP = pp.maPP;
        this.maPM = pp.maPM;
        this.maLD = pp.maLD;
        this.soTienPhat = pp.soTienPhat;
    }

    public String getMaPP(){return maPP;}
    public String getMaPM(){return maPM;}
    public String getMaLD(){return maLD;}
    public int getSoTienPhat(){return soTienPhat;}

    public void setMaPP(String ma) {
        this.maPP = ma;
    } 

    public void setMaPM(String ma) {
        this.maPM = ma;
    } 

    public void setMaLD(String ma) {
        this.maLD = ma;
    } 

    public void setSoTienPhat(int tien) {
        this.soTienPhat = tien;
    } 

    public void nhap() {

        System.out.print("# Nhập vào mã phiếu phạt: ");
        maPP = sc.nextLine();

        System.out.print("# Nhập vào mã phiếu mượn: ");
        maPM = sc.nextLine();

        System.out.print("# Nhập vào mã lý do: ");
        maLD = sc.nextLine();

        System.out.print("# Nhập vào số tiền phạt: ");
        soTienPhat = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.println("# Mã phiếu phạt: " + maPP);
        System.out.println("# Mã phiếu mượn: " + maPM);
        System.out.println("# Mã lý do: " + maLD);
        System.out.println("# Số tiền phạt: " + soTienPhat);
    }
}
