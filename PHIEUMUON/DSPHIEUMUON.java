package PHIEUMUON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSPHIEUMUON {
    Scanner sc = new Scanner(System.in);

    PHIEUMUON[] dspm;
    private int n;

    public DSPHIEUMUON(){}
    public DSPHIEUMUON(int p, PHIEUMUON[] ds){
        this.n = p;
        this.dspm = new PHIEUMUON[n];
        for(int i = 0; i < n; i++){
            dspm[i] = new PHIEUMUON(ds[i]);
        }
    }
    public DSPHIEUMUON (DSPHIEUMUON p){
        this.n = p.n;
        this.dspm = p.dspm;
    }

    public void nhap(){
        System.out.print("Nhap so luong phieu muon: ");
        this.n = sc.nextInt();
        sc.nextLine();

        this.dspm = new PHIEUMUON[n];
        for(int i = 0; i < n; i++){
            System.out.print("Phieu muon thu " + (i + 1) + ": ");
            dspm[i] = new PHIEUMUON();
            dspm[i].nhap();
            System.out.println();
        }
    }

    public void xuat(){
        System.out.println("\n==================================== Danh sach phieu muon ====================================");
        System.out.printf("| %-12s| %-12s| %-12s| %-15s| %-15s| %-15s|\n", "Ma PM", "Ma DG", "Ma NV", "Ngay Muon", "Ngay Tra", "Ngay Thuc Tra");
        System.out.println("______________________________________________________________________________________________");
        for(int i = 0; i < n; i++){
            dspm[i].xuat();
        }
        System.out.println();
        System.out.println("______________________________________________________________________________________________");
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
            dspm = new PHIEUMUON[0];

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue; 

                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String mapm = parts[0].trim();
                    String madg = parts[1].trim();
                    String manv = parts[2].trim();
                    String nm = parts[3].trim();
                    String nt = parts[4].trim();
                    String ntt = parts[5].trim();

                    dspm = Arrays.copyOf(dspm, n + 1);
                    dspm[n] = new PHIEUMUON(mapm, madg, manv, nm, nt, ntt);
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
                PHIEUMUON pm = dspm[i];
                writer.println(pm.getMPM() + "," + pm.getMDG() + "," + pm.getMNV() + "," + pm.getNM() + "," + pm.getNT() + "," + pm.getNTT());
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public void them(){
        // System.out.print("Nhap so luong phieu muon can them: ");
        // int k = sc.nextInt();
        // sc.nextLine();

        n += 1;
        dspm = Arrays.copyOf(dspm, n);

        // for(int i = n; i < n + k; i++){
            // System.out.println("Nhap thong tin phieu muon thu " + (i + 1) + ": ");
            dspm[n] = new PHIEUMUON();
            dspm[n].nhap();
        // }
        System.out.println("Da them thong tin thanh cong!");
    }
    public void them(PHIEUMUON pm){
        n = dspm.length;
        dspm = Arrays.copyOf(dspm, n + 1);
        dspm[n] = new PHIEUMUON(pm);
        n++;
    }

    public int timkiemTheoMa(String ma){
        for(int i = 0; i < n; i++){
            if(dspm[i].getMPM().equalsIgnoreCase(ma)){
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
            System.out.println("Thong tin phieu muon");
            System.out.printf("| %-12s| %-12s| %-12s| %-15s| %-15s| %-15s|\n", "Ma PM", "Ma DG", "Ma NV", "Ngay Muon", "Ngay Tra", "Ngay Thuc Tra");
            System.out.println("______________________________________________________________________________________________");
            dspm[t].xuat();
        }
    }
    public PHIEUMUON timkiemMa(String ma){
        for(int i = 0; i < n; i++){
            if(dspm[i].getMPM().equalsIgnoreCase(ma)){
                return dspm[i];
            }
        }
        return null;
    }

    public void timkiemTheoNgayMuon(){
        System.out.print("Nhap ngay muon can tim (dd/MM/yyyy): ");
        String nm = sc.nextLine();
        
        int count = 0;
        System.out.println("Danh sach cac phieu muon co ngay muon la " + nm);
        System.out.printf("| %-12s| %-12s| %-12s| %-15s| %-15s| %-15s|\n", "Ma PM", "Ma DG", "Ma NV", "Ngay Muon", "Ngay Tra", "Ngay Thuc Tra");
        System.out.println("______________________________________________________________________________________________");
        
        for(int i = 0; i < n; i++){
            if(dspm[i].getNM().trim().equalsIgnoreCase(nm.trim())){
                dspm[i].xuat();
                count++;
                System.out.println();
            }
        }
        if(count == 0){
            System.out.println("Khong tim thay phieu muon co ngay muon la " + nm);
        }
    }
    public PHIEUMUON[] timkiemTheoNgayMuon(String nm){
        PHIEUMUON[] kq = new PHIEUMUON[0];
        System.out.println("Danh sach cac phieu muon co ngay muon la " + nm);
        System.out.printf("| %-12s| %-12s| %-12s| %-15s| %-15s| %-15s|\n", "Ma PM", "Ma DG", "Ma NV", "Ngay Muon", "Ngay Tra", "Ngay Thuc Tra");
        System.out.println("______________________________________________________________________________________________");
        
        for(int i = 0; i < n; i++){
            if(dspm[i].getNM().equals(nm)){
                dspm[i].xuat();
                System.out.println();

                kq = Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length - 1] = dspm[i];
            }
        }
        return kq;
    }

    public void xoa(){
        System.out.print("Nhap ma phieu muon can xoa: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay phieu muon!");
            return;
        }
        for(int i = idx; i < n-1; i++){
            dspm[i] = dspm[i+1];
        }
        dspm = Arrays.copyOf(dspm, n-1);
        n--;
        System.out.println("Da xoa thanh cong!");
    }
    public void xoa(String ma){
        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay phieu muon!");
            return;
        }
        for(int i = idx; i < n-1; i++){
            dspm[i] = dspm[i + 1];
        }
        dspm = Arrays.copyOf(dspm, n - 1);
        n--;
        System.out.println("Da xoa thanh cong!");
    }

    public void sua(){ 
        System.out.print("Nhap ma nha cung cap can sua: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay phieu muon!");
            return;
        }

        int choose;
        do{
            System.out.println("--- MENU SUA THONG TIN PHIEU MUON ---");
            System.out.println("1. Sua ma doc gia");
            System.out.println("2. Sua ma nhan vien");
            System.out.println("3. Sua ngay muon");
            System.out.println("4. Sua ngay tra");
            System.out.println("5. Sua ngay thuc tra");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon: ");
            choose = sc.nextInt();
            sc.nextLine();

            switch(choose){
                case 1: {
                    System.out.print("Nhap ma doc gia can sua: ");
                    String madg = sc.nextLine();
                    dspm[idx].setMDG(madg);
                    System.out.println("Doi ma doc gia thanh cong!");
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("Nhap ma nhan vien can sua: ");
                    String manv = sc.nextLine();
                    dspm[idx].setMNV(manv);
                    System.out.println("Doi ma nhan vien thanh cong!");
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.print("Nhap ngay muon can sua: ");
                    String nm = sc.nextLine();
                    dspm[idx].setNM(nm);
                    System.out.println("Doi ngay muon thanh cong!");
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.print("Nhap ngay tra can sua: ");
                    String ns = sc.nextLine();
                    dspm[idx].setNM(ns);
                    System.out.println("Doi ngay tra thanh cong!");
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.print("Nhap ngay thuc tra can sua: ");
                    String ntt = sc.nextLine();
                    dspm[idx].setNTT(ntt);
                    System.out.println("Doi ngay thuc tra thanh cong!");
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

    public int[] thongkeTheoTinhTrangSach() {
        int datradunghan = 0, datratrehan = 0, chuatra = 0;

        for(int i = 0; i < n; i++){
            String ngayTra = dspm[i].getNT();
            String ngayThucTra = dspm[i].getNTT();

            if(ngayThucTra == null || ngayThucTra.trim().isEmpty() || ngayThucTra.equals("0")){
                chuatra++;
                continue; // bỏ qua phần so sánh
            }

            String tra = ngayTra.substring(6, 10) + ngayTra.substring(3, 5)+ ngayTra.substring(0, 2);
            String thuctra = ngayThucTra.substring(6, 10) + ngayThucTra.substring(3, 5) + ngayThucTra.substring(0, 2);

            int t1 = Integer.parseInt(tra);
            int t2 = Integer.parseInt(thuctra);

            if(t1 < t2){
                datratrehan++;
            }
            else{
                datradunghan++;
            }
        }
        System.out.println("=== Thong ke tinh trang sach ===");
        System.out.println("Da tra dung han: " + datradunghan);
        System.out.println("Da tra tre han: " + datratrehan);
        System.out.println("Chua tra: " + chuatra);

        return new int[]{datradunghan, datratrehan, chuatra};
    }
    // thống kê theo số lần mượn của độc giả, số phiếu do từng nv lập, số phiếu theo tháng, trả đúng/trễ hạn theo tháng

    //thống kê theo số lần mượn của độc giả
    public void thongkeSoLanMuonTheoDocGia(){
        System.out.println("=== Thong ke so lan muon cua tung doc gia ===");
        System.out.printf("| %-10s| %-15s|\n", "Ma DG", "So lan muon");
        System.out.println("______________________________");

        for(int i = 0; i < n; i++){
            String madg = dspm[i].getMDG();

            boolean dathongke = false;
            for(int j = 0; j < i; j++){
                if(dspm[j].getMDG().equalsIgnoreCase(madg)){
                    dathongke = true;
                    break;
                }
            }
            if(dathongke) continue;

            int count = 0;
            for(int k = 0; k < n; k++){
                if(dspm[k].getMDG().equalsIgnoreCase(madg)){
                    count++;
                }
            }
            System.out.printf("| %-10s| %-15s|\n", madg, count);
        }
        System.out.println();
    }
    
}
