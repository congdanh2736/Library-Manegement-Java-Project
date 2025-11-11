package CHITIETPHIEUNHAPHANG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSCHITIET_PNH {
    Scanner sc = new Scanner(System.in);

    CHITIET_PNH[] dsct;
    private int n;

    public DSCHITIET_PNH(){}
    public DSCHITIET_PNH(int p, CHITIET_PNH[] ds){
        this.n = p;
        this.dsct = new CHITIET_PNH[n];
        for(int i = 0; i < n; i++){
            dsct[i] = new CHITIET_PNH(ds[i]);
        }
    }
    public DSCHITIET_PNH(DSCHITIET_PNH d){
        this.n = d.n;
        this.dsct = d.dsct;
    }

    public long tinhTongTienTheoMaPNH(String maPNH) {
        long tong = 0;
        for (int i = 0; i < n; i++) {
            if (dsct[i].getMPNH().equalsIgnoreCase(maPNH)) {
                tong += dsct[i].getT();
            }
        }
        return tong;
    }

    public void nhap(){
        System.out.print("Nhap so luong chi tiet phieu nhap hang: ");
        this.n = sc.nextInt();
        sc.nextLine();

        dsct = new CHITIET_PNH[n];
        for(int i = 0; i < n; i++){
            System.out.print("Chi tiet phieu nhap hang thu " + (i + 1) + ": ");
            dsct[i] = new CHITIET_PNH();
            dsct[i].nhap();
            System.out.println();
        }
    }

    public void xuat(){
        if (n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("\n================== Danh sach chi tiet phieu nhap hang ==================");
        System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12s|\n", "Ma PNH", "Ma Sach", "So Luong", "Don Gia", "Thanh Tien");
        System.out.println("________________________________________________________________________");
        for(int i = 0; i < n; i++){
            dsct[i].xuat();
        }
        System.out.println();
        System.out.println("________________________________________________________________________");
    }

    public void docTuFile(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File khong ton tai!");
                return;
            }

            Scanner reader = new Scanner(file);
            n = 0; 
            dsct = new  CHITIET_PNH[0];

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    String mapnh = parts[0].trim();
                    String mas = parts[1].trim();
                    int sl = Integer.parseInt(parts[2].trim());
                    int dg = Integer.parseInt(parts[3].trim());
                    long tt = Long.parseLong(parts[4].trim());

                    dsct = Arrays.copyOf(dsct, n + 1);
                    dsct[n] = new CHITIET_PNH(mapnh, mas, sl, dg, tt);
                    n++;
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (Exception e) {
            System.out.println("Loi khi đoc file: " + e.getMessage());
        }
    }

     public void ghiFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            for (int i = 0; i < n; i++) {
                CHITIET_PNH ct = dsct[i];
                writer.println(ct.getMPNH() + ", " + ct.getMS() + ", " + ct.getS() + ", " + ct.getD() + ", " + (ct.getS() * ct.getD()));
            }
            // System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public void them(){
        // System.out.print("Nhap so luong chi tiet phieu nhap hang can them: ");
        // int k = sc.nextInt();
        // sc.nextLine();

        n += 1;
        dsct = Arrays.copyOf(dsct, n);

        // for(int i = n; i < n + k; i++){
            // System.out.println("Nhap thong tin chi tiet phieu nhap hang thu " + (i + 1) + ": ");
            dsct[n - 1] = new CHITIET_PNH();
            dsct[n - 1].nhap();
        // }
        System.out.println("Da them thong tin thanh cong!");
    }
    public void them(CHITIET_PNH ct){
        n = dsct.length;
        dsct = Arrays.copyOf(dsct, n + 1);
        dsct[n] = new CHITIET_PNH(ct);
        n++;
    }

    public int timkiemTheoMa(String ma){
        for(int i = 0; i < n; i++){
            if(dsct[i].getMPNH().equalsIgnoreCase(ma) ){
                return i;
            }
        }
        return -1;
    }
    public void timkiem(){
        System.out.print("Nhap ma phieu nhap hang can tim: ");
        String ma = sc.nextLine();

        int t = timkiemTheoMa(ma);
        if(t == -1){
            System.out.println("Khong tim thay phieu nhap hang co ma " + ma);
        }
        else{
            System.out.println("Thong tin chi tiet phieu nhap hang");
            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12s|\n", "MaPNH", "MaSach", "SL", "DG", "ThanhTien");
            System.out.println("________________________________________________________________________");
            dsct[t].xuat();
        }
    }
    public CHITIET_PNH timkiemMa(String ma){
        for(int i = 0; i < n; i++){
            if(dsct[i].getMPNH().equalsIgnoreCase(ma)){
                dsct[i].xuat();
                return dsct[i];
            }
        }
        System.out.println("Khong tim thay ma phieu nhap hang!");
        return null;
    }

    public void timkiemDonGia(){
        System.out.print("Nhap don gia can tim: ");
        int dongia = sc.nextInt();

        int count = 0;
        System.out.println("Thong tin chi tiet phieu nhap hang");
        System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12s|\n", "MaPNH", "MaSach", "SL", "DG", "ThanhTien");
        System.out.println("________________________________________________________________________");
        
        for(int i = 0; i < n; i++){
            if(dsct[i].getD() == dongia){
                dsct[i].xuat();
                count++;
            }
        }
        if(count == 0){
            System.out.println("Khong tim thay don gia!");
        }
    }
    public void timkiemDonGia(int dongia){
        int count = 0;
        System.out.println("Thong tin chi tiet phieu nhap hang");
        System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12s|\n", "MaPNH", "MaSach", "SL", "DG", "ThanhTien");
        System.out.println("________________________________________________________________________");
        
        for(int i = 0; i < n; i++){
            if(dsct[i].getD() == dongia){
                dsct[i].xuat();
                count++;
            }
        }
        if(count == 0){
            System.out.println("Khong tim thay don gia!");
        }
    }

    public void xoa(){
        System.out.print("Nhap ma phieu nhap hang can xoa: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay chi tiet phieu nhap hang!");
            return;
        }
        for(int i = idx; i < n - 1; i++){
            dsct[i] = dsct[i + 1];
        }
        dsct = Arrays.copyOf(dsct, n - 1);
        n--;
        System.out.println("Da xoa thanh cong!");
    }
    public void xoa(String ma){
        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay chi tiet phieu nhap hang!");
            return;
        }
        for(int i = idx; i < n - 1; i++){
            dsct[i] = dsct[i + 1];
        }
        dsct = Arrays.copyOf(dsct, n - 1);
        n--;
        System.out.println("Da xoa thanh cong!");
    }

    public void sua(){ 
        System.out.print("Nhap ma phieu nhap hang can sua: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay phieu nhap hang!");
            return;
        }

        int choose;
        do{
            System.out.println("--- MENU SUA THONG TIN CHI TIET PHIEU NHAP HANG ---");
            System.out.println("1. Sua ma sach");
            System.out.println("2. Sua so luong");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon: ");

            choose = sc.nextInt();
            sc.nextLine();

            switch(choose){
                case 1: {
                    System.out.print("Nhap ma sach can sua: ");
                    String ms = sc.nextLine();
                    dsct[idx].setMS(ms);
                    System.out.println("Doi ma sach thanh cong!");
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("Nhap so luong can sua: ");
                    int sl = sc.nextInt();
                    dsct[idx].setS(sl);
                    System.out.println("Doi so luong thanh cong!");
                    System.out.println();
                    break;
                }
                case 0: {
                    System.out.println("Da thoat sua thong tin");
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le!");
                    break;
                }
            } 
        } while(choose != 0);
    }

    // thống kê tổng số lượng, tổng tiền theo mã sách
    public void thongKeTheoMaSach() {
        long s1_sl = 0, s2_sl = 0, s3_sl = 0;
        long s1_tt = 0, s2_tt = 0, s3_tt = 0;

        for (int i = 0; i < n; i++) {
            if (dsct[i].getMS().equalsIgnoreCase("S1")) {
                s1_sl += dsct[i].getS();
                s1_tt += dsct[i].getT();
            } 
            else if (dsct[i].getMS().equalsIgnoreCase("S2")) {
                s2_sl += dsct[i].getS();
                s2_tt += dsct[i].getT();
            } 
            else if (dsct[i].getMS().equalsIgnoreCase("S3")) {
                s3_sl += dsct[i].getS();
                s3_tt += dsct[i].getT();
            }
        }

        long tong_sl = s1_sl + s2_sl + s3_sl;
        long tong_tt = s1_tt + s2_tt + s3_tt;

        System.out.println("\n=== THONG KE TONG THANH TIEN NHAP THEO MA SACH ===");
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-10s | %-15s | %-15s |\n", "Ma sach", "Tong SL", "Tong tien");
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-10s | %-15d | %-15d |\n", "S1", s1_sl, s1_tt);
        System.out.printf("| %-10s | %-15d | %-15d |\n", "S2", s2_sl, s2_tt);
        System.out.printf("| %-10s | %-15d | %-15d |\n", "S3", s3_sl, s3_tt);
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-10s | %-15d | %-15d |\n", "Tong cong", tong_sl, tong_tt);
        System.out.println("_____________________________________________________________");
    }

    public void thongKeTheoDonGia() {
        long duoi50_tt = 0, tu50_100_tt = 0, tren100_tt = 0;
        int duoi50_sl = 0, tu50_100_sl = 0, tren100_sl = 0;

        for (int i = 0; i < n; i++) {
            if (dsct[i].getD() < 50000) {
                duoi50_sl += dsct[i].getS();
                duoi50_tt += dsct[i].getT();
            } 
            else if (dsct[i].getD() <= 100000) {
                tu50_100_sl += dsct[i].getS();
                tu50_100_tt += dsct[i].getT();
            } 
            else {
                tren100_sl += dsct[i].getS();
                tren100_tt += dsct[i].getT();
            }
        }

        long tong_sl = duoi50_sl + tu50_100_sl + tren100_sl;
        long tong_tt = duoi50_tt + tu50_100_tt + tren100_tt;

        System.out.println("\n=== THONG KE THEO KHOANG ĐON GIA ===");
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-20s | %-15s | %-15s |\n", "Khoang đon gia", "So luong", "Tong tien");
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-20s | %-15d | %-15d |\n", "Duoi 50,000", duoi50_sl, duoi50_tt);
        System.out.printf("| %-20s | %-15d | %-15d |\n", "Tu 50,000 - 100,000", tu50_100_sl, tu50_100_tt);
        System.out.printf("| %-20s | %-15d | %-15d |\n", "Tren 100,000", tren100_sl, tren100_tt);
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-20s | %-15d | %-15d |\n", "Tong cong", tong_sl, tong_tt);
        System.out.println("_____________________________________________________________");
    }

}
