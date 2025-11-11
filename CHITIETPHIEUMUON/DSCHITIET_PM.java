package CHITIETPHIEUMUON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner; 

public class DSCHITIET_PM {
    Scanner sc = new Scanner(System.in);

    CHITIET_PM[] dsct;
    private int n;

    public DSCHITIET_PM(){}
    public DSCHITIET_PM(int p, CHITIET_PM[] ds){
        this.n = p;
        this.dsct = new CHITIET_PM[n];
        for(int i = 0; i < n; i++){
            dsct[i] = new CHITIET_PM(ds[i]);
        }
    }
    public DSCHITIET_PM(DSCHITIET_PM ct){
        this.n = ct.n;
        this.dsct = ct.dsct;
    }

    public void nhap(){
        System.out.print("Nhap so luong chi tiet phieu muon: ");
        n = sc.nextInt();
        sc.nextLine();

        this.dsct = new CHITIET_PM[n];
        for(int i = 0; i < n; i++){
            System.out.print("Chi tiet phieu muon thu " + (i + 1) + ": ");
            dsct[i] = new CHITIET_PM();
            dsct[i].nhap();
            System.out.println();
        }
    }

    public void xuat(){
        if (n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("\n====== Danh sach chi tiet phieu muon ======");
        System.out.printf("| %-12s| %-12s| %-12s|\n", "Ma PM", "Ma Sach", "So Luong");
        System.out.println("___________________________________________");
        for(int i = 0; i < n; i++){
            dsct[i].xuat();
        }
        System.out.println();
        System.out.println("___________________________________________");
    }

    public void them(String maPM){
        // System.out.print("Nhap so luong chi tiet phieu muon can them: ");
        // int k = sc.nextInt();
        // sc.nextLine();
        n += 1;

        dsct = Arrays.copyOf(dsct, n);

        // for(int i = n; i < n + k; i++){
            // System.out.println("Nhap thong tin chi tiet phieu muon thu " + (i + 1) + ": ");
            dsct[n - 1] = new CHITIET_PM();
            dsct[n - 1].nhap();
        // }
        // n += k;
        System.out.println("Da them thong tin thanh cong!");
    }
    public void them(CHITIET_PM ctpm){
        n = dsct.length;
        dsct = Arrays.copyOf(dsct, n + 1);
        dsct[n] = new CHITIET_PM(ctpm);
        n++;
    }
    public int timkiemTheoMa(String ma){
        for(int i = 0; i < n; i++){
            if(dsct[i].getMPM().equalsIgnoreCase(ma) ){
                return i;
            }
        }
        return -1;
    }
    public void timkiem(){
        System.out.print("Nhap ma phieu muon can tim: ");
        String ma = sc.nextLine();

        int t = timkiemTheoMa(ma);
        if(t == -1){
            System.out.println("Khong tim thay phieu muon co ma " + ma);
        }
        else{
            System.out.println("Thong tin chi tiet phieu muon");
            System.out.printf("| %-12s| %-12s| %-12s|", "MaPM", "MaSach", "SL");
            System.out.println("___________________________________________");
            dsct[t].xuat();
        }
    }
    public CHITIET_PM timkiemMa(String ma){
        for(int i = 0; i < n; i++){
            if(dsct[i].getMPM().equalsIgnoreCase(ma)){
                dsct[i].xuat();
                return dsct[i];
            }
        }
        System.out.println("Khong tim thay chi tiet phieu muon!");
        return null;
    }

    public void timkiemTheoMaSach(){
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();

        int idx = -1;
        for(int i = 0; i < n; i++){
            if(dsct[i].getMS().equalsIgnoreCase(ma)){
                idx = i;
            }
        }
        if(idx == -1){
            System.out.println("Khong tim thay ma sach!");
            return;
        }
        else{
            System.out.println("Thong tin chi tiet phieu muon");
            System.out.printf("| %-12s| %-12s| %-12s|\n", "MaPM", "MaSach", "SL");
            System.out.println("___________________________________________");
            dsct[idx].xuat();
        }
    }
    public void timkiemTheoMaSach(String ma){
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(dsct[i].getMS().equalsIgnoreCase(ma)){
                idx = i;
            }
        }
        if(idx == -1){
            System.out.println("Khong tim thay ma sach!");
            return;
        }
        else{
            System.out.println("Thong tin chi tiet phieu muon");
            System.out.printf("| %-12s| %-12s| %-12s|\n", "MaPM", "MaSach", "SL");
            System.out.println("___________________________________________");
            dsct[idx].xuat();
        }
    }


    public void xoa(){
        System.out.print("Nhap ma phieu muon can xoa: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay chi tiet phieu muon!");
            return;
        }
        //Dich cac phan tu sau idx len 1 bac
        for(int i = idx; i < n-1; i++){
            dsct[i] = dsct[i+1];
        }
        dsct = Arrays.copyOf(dsct, n-1);
        n--;
        System.out.println("Da xoa thanh cong!");
    }
    public void xoa(String ma){
        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay chi tiet phieu muon!");
            return;
        }
        //Dich cac phan tu sau idx len 1 bac
        for(int i = idx; i < n-1; i++){
            dsct[i] = dsct[i+1];
        }
        dsct = Arrays.copyOf(dsct, n-1);
        n--;
        System.out.println("Da xoa thanh cong!");
    }

    public void sua(){ 
        System.out.print("Nhap ma phieu muon can sua: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay phieu muon!");
            return;
        }

        int choose;
        do{
            System.out.println("--- MENU SUA THONG TIN CHI TIET PHIEU MUON ---");
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
                    dsct[idx].setSL(sl);
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

    //thống kê số lần mượn theo mã sách 
    public void thongkeSoLanMuonTheoMaSach(){
        System.out.println("=== Thong ke so lan muon theo ma sach ===");
        System.out.printf("| %-10s | %-10s |\n", "Ma Sach", "So lan muon");
        System.out.println("------------------------------------");

        for (int i = 0; i < n; i++) {
            String maSach = dsct[i].getMS();
            boolean daDem = false;

            for (int j = 0; j < i; j++) {
                if (maSach.equals(dsct[j].getMS())){
                    daDem = true;
                    break;
                }
            }

            if (!daDem) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (maSach.equals(dsct[k].getMS())){
                        count++;
                    }
                }
                System.out.printf("| %-10s | %-10d |\n", maSach, count);
            }
        }
    }

    //thống kê tổng số lượng sách đã mượn theo mã sách 
    public void thongkeTongSoLuongTheoMaSach() {
        System.out.println("=== Thong ke tong so luong sach muon theo ma sach ===");
        System.out.printf("| %-10s | %-15s |\n", "Ma Sach", "Tong so luong");
        System.out.println("------------------------------------------");

        for (int i = 0; i < n; i++) {
            String maSach = dsct[i].getMS();
            boolean daDem = false;

            for (int j = 0; j < i; j++) {
                if (maSach.equals(dsct[j].getMS())) {
                    daDem = true;
                    break;
                }
            }

            if (!daDem) {
                int tongSL = 0;
                for (int k = 0; k < n; k++) {
                    if (maSach.equals(dsct[k].getMS())) {
                        tongSL += dsct[k].getS();
                    }
                }
                System.out.printf("| %-10s | %-15d |\n", maSach, tongSL);
            }
        }
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
            dsct = new CHITIET_PM[0];

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue; 

                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String mapm = parts[0].trim();
                    String mas = parts[1].trim();
                    int sl = Integer.parseInt(parts[2].trim());

                    dsct = Arrays.copyOf(dsct, n + 1);
                    dsct[n] = new CHITIET_PM(mapm, mas, sl);
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
                CHITIET_PM ct = dsct[i];
                writer.println(ct.getMPM() + ", " + ct.getMS() + ", " + ct.getS());
            }
            // System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }
}
