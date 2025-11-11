package Book.Categogy;

import Book.Books;

import java.util.*;

public class Education extends Books{
    Scanner sc = new Scanner(System.in);

    private String TenMon, Lop;
    private static int educationBookCount = 0;

    public Education() {
        educationBookCount++;
    }
    public Education(String ms, String ts, String tl, String mtg, String nxb, String mnxb, String tt, int dg, int sl, int slcl, String TenMon, String Lop){
        super(ms, ts, tl, mtg, nxb, mnxb, tt, dg, sl, slcl);
        this.TenMon = TenMon;
        this.Lop = Lop;
        educationBookCount++;
    }

    public Education(Education sgk){
        super((Books)sgk);
        this.TenMon = sgk.TenMon;
        this.Lop = sgk.Lop;
        educationBookCount++;
    }

    public void nhap() {
        super.nhap(); // Nhập thông tin chung từ Books
        System.out.print(">> Tên môn học: ");
        this.TenMon = sc.nextLine();
        System.out.print(">> Lớp học: ");
        this.Lop = sc.nextLine();
    }

    public void xuat() {
        super.xuat();
        System.out.println("# Tên môn học: " + TenMon);
        System.out.println("# Lớp: " + Lop);
    }


    public void setTenMon(String tm){this.TenMon = tm;}
    public void setLop(String lop){this.Lop = lop;}

    public String getTenMon(){return this.TenMon;}
    public String getLop(){return this.Lop;}

    public String getChiTiet() {
        return this.TenMon + ", " + this.Lop;
    }

    public static int getEducationBookCount() {
        return educationBookCount;
    }
}