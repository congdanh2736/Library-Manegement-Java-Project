package Book.Categogy;

import Book.Books;
import java.util.*;

public class Reference extends Books{
    Scanner sc = new Scanner(System.in);
    private String LinhVuc, NgonNgu;
    private int DoTuoi;
    private static int refBookCount = 0;

    public Reference() {
        refBookCount++;
    }
    public Reference(String ms, String ts, String tl, String mtg, String nxb, String mnxb, String tt, int dg, int sl, int slcl, String LinhVuc, String NgonNgu, int DoTuoi){
        super(ms, ts, tl, mtg, nxb, mnxb, tt, dg, sl, slcl);
        this.LinhVuc = LinhVuc;
        this.NgonNgu = NgonNgu;
        this.DoTuoi = DoTuoi;
        refBookCount++;
    }
    public Reference(Reference stk){
        super(stk);
        this.LinhVuc = stk.LinhVuc;
        this.NgonNgu = stk.NgonNgu;
        this.DoTuoi = stk.DoTuoi;
        refBookCount++;
    }

    public void nhap() {
        super.nhap();
        System.out.print(">> Nhập vào lĩnh vực tham khảo: ");
        this.LinhVuc = sc.nextLine();
        System.out.print(">> Nhập vào ngôn ngữ: ");
        this.NgonNgu = sc.nextLine();
        System.out.print(">> Nhập vào độ tuổi phù hợp: ");
        this.DoTuoi = Integer.parseInt(sc.nextLine());
    }

    public void xuat() {
        super.xuat();
        System.out.println("# Lĩnh vực: " + LinhVuc);
        System.out.println("# Ngôn ngữ: " + NgonNgu);
        System.out.println("# Độ tuổi phù hợp: " + DoTuoi);
    }


    public void setLinhVuc(String lv){this.LinhVuc = lv;}
    public void setNgonNgu(String nn){this.NgonNgu = nn;}
    public void setDoTuoi(int dt){this.DoTuoi = dt;}

    public String getLinhVuc(){return this.LinhVuc;}
    public String getNgonNgu(){return this.NgonNgu;}
    public int getDoTuoi(){return this.DoTuoi;}

    public String getChiTiet() {
        return this.LinhVuc + ", " + this.NgonNgu + ", " + this.DoTuoi;
    }

    public static int getRefBookCount() {
        return refBookCount;
    }
}

