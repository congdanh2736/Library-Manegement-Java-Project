package PHIEUNHAPHANG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import CHITIETPHIEUNHAPHANG.DSCHITIET_PNH;

public class DSPHIEUNHAPHANG {
    Scanner sc = new Scanner(System.in);

    PHIEUNHAPHANG[] dspnh;
    private int n;

    public int getSL(){
        return n;
    }
    
    public PHIEUNHAPHANG get(int i){
        return dspnh[i];
    }

    public DSPHIEUNHAPHANG(){}
    public DSPHIEUNHAPHANG(int p, PHIEUNHAPHANG[] ds){
        n = p;
        dspnh = new PHIEUNHAPHANG[n];
        for(int i = 0; i < n; i++){
            dspnh[i] = new PHIEUNHAPHANG(ds[i]);
        }
    }
    public DSPHIEUNHAPHANG(DSPHIEUNHAPHANG d){
        this.n = d.n;
        this.dspnh = d.dspnh;
    }

    public void capNhatTongTien(DSCHITIET_PNH dsct){
        for(int i = 0; i < n; i++){
            String maPNH = dspnh[i].getM();
            long tong = dsct.tinhTongTienTheoMaPNH(maPNH);
            dspnh[i].setT(tong);
        }
    }
    public void nhap(){
        System.out.print("Nhap so luong phieu nhap hang: ");
        n = sc.nextInt();
        sc.nextLine();

        this.dspnh = new PHIEUNHAPHANG[n];
        for(int i = 0; i < n; i++){
            System.out.print("Phieu nhap hang thu " + (i + 1) + ": ");
            dspnh[i] = new PHIEUNHAPHANG();
            dspnh[i].nhap();
            System.out.println();
        }
    }

    public void xuat(){
        if (n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("\n================== Danh sach phieu nhap hang ==================");
        System.out.printf("| %-12s| %-12s| %-15s| %-15s|\n", "Ma PNH", "Ma NCC", "Ngay Nhap", "Tong Tien");
        System.out.println("_______________________________________________________________");
        for(int i = 0; i < n; i++){
            dspnh[i].xuat();
        }
        System.out.println();
        System.out.println("_______________________________________________________________");
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
            dspnh = new PHIEUNHAPHANG[0];

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String mapnh = parts[0].trim();
                    String mancc = parts[1].trim();
                    String nn = parts[2].trim();
                    long tt = Long.parseLong(parts[3].trim());
                    
                    dspnh = Arrays.copyOf(dspnh, n + 1);
                    dspnh[n] = new PHIEUNHAPHANG(mapnh, mancc, nn, tt);
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
                PHIEUNHAPHANG pnh = dspnh[i];
                writer.println(pnh.getM() + ", "  + pnh.getMNCC() + ", " + pnh.getN() + ", " + pnh.getT());
            }
            // System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public void them(){
        // System.out.print("Nhap so luong phieu nhap hang can them: ");
        // int k = sc.nextInt();
        // sc.nextLine();

        n += 1;
        dspnh = Arrays.copyOf(dspnh, n);

        // for(int i = n; i < n + k; i++){
            // System.out.println("Nhap thong tin phieu muon thu " + (i + 1) + ": ");
            dspnh[n - 1] = new PHIEUNHAPHANG();
            dspnh[n - 1].nhap();
        // }
        System.out.println("Da them thong tin thanh cong!");
    }
    public void them(PHIEUNHAPHANG pnh){
        n = dspnh.length;
        dspnh = Arrays.copyOf(dspnh, n + 1);
        dspnh[n] = new PHIEUNHAPHANG(pnh);
        n++;
    }
    
    public int timkiemTheoMa(String ma){
        for(int i = 0; i < n; i++){
            if(dspnh[i].getM().equalsIgnoreCase(ma)){
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
            System.out.println("Thong tin phieu muon");
            System.out.printf("| %-12s| %-12s| %-15s| %-15s|\n", "Ma PNH", "Ma NCC", "Ngay Nhap", "Tong Tien");
            System.out.println("_______________________________________________________________");
            dspnh[t].xuat();
        }
    }
    public PHIEUNHAPHANG timkiemMa(String ma){
        for(int i = 0; i < n; i++){
            if(dspnh[i].getM().equalsIgnoreCase(ma)){
                dspnh[i].xuat();
                return dspnh[i];
            }
        }
        return null;
    }

    public void timkiemTheoNgayMuon(){
        System.out.print("Nhap ngay muon can tim (dd/MM/yyyy): ");
        String nm = sc.nextLine();
        
        int count = 0;
        System.out.println("Danh sach cac phieu nhap hang co ngay muon la " + nm);
        System.out.printf("| %-12s| %-12s| %-15s| %-15s|\n", "Ma PNH", "Ma NCC", "Ngay Nhap", "Tong Tien");
            System.out.println("_______________________________________________________________");
        
        for(int i = 0; i < n; i++){
            if(dspnh[i].getN().trim().equalsIgnoreCase(nm.trim())){
                dspnh[i].xuat();
                count++;
                System.out.println();
            }
        }
        if(count == 0){
            System.out.println("Khong tim thay phieu muon co ngay muon la " + nm);
        }
    }
    public PHIEUNHAPHANG[] timkiemTheoNgayMuon(String nm){
        PHIEUNHAPHANG[] kq = new PHIEUNHAPHANG[0];
        System.out.println("Danh sach cac phieu nhap hang co ngay muon la " + nm);
        System.out.printf("| %-12s| %-12s| %-15s| %-15s|\n", "Ma PNH", "Ma NCC", "Ngay Nhap", "Tong Tien");
            System.out.println("_______________________________________________________________");
        
        for(int i = 0; i < n; i++){
            if(dspnh[i].getN().equals(nm)){
                dspnh[i].xuat();
                System.out.println();

                kq = Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length - 1] = dspnh[i];
            }
        }
        return kq;
    }

    public void xoa(){
        System.out.print("Nhap ma phieu nhap hang can xoa: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay phieu nhap hang!");
            return;
        }
        for(int i = idx; i < n-1; i++){
            dspnh[i] = dspnh[i + 1];
        }
        dspnh = Arrays.copyOf(dspnh, n-1);
        n--;
        System.out.println("Da xoa thanh cong!");
    }
    public void xoa(String ma){
        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay phieu nhap hang!");
            return;
        }
        for(int i = idx; i < n-1; i++){
            dspnh[i] = dspnh[i + 1];
        }
        dspnh = Arrays.copyOf(dspnh, n-1);
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
            System.out.println("--- MENU SUA THONG TIN PHIEU NHAP HANG ---");
            System.out.println("1. Sua ma nha cung cap");
            System.out.println("2. Sua ngay nhap");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon: ");

            choose = sc.nextInt();
            sc.nextLine();

            switch(choose){
                case 1: {
                    System.out.print("Nhap ma nha cung cap can sua: ");
                    String manv = sc.nextLine();
                    dspnh[idx].setMNCC(manv);
                    System.out.println("Doi ma nha cung cap thanh cong!");
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("Nhap ngay nhap can sua: ");
                    String nn = sc.nextLine();
                    dspnh[idx].setN(nn);
                    System.out.println("Doi ngay nhap thanh cong!");
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

    // thống kê tính tổng tiền hóa đơn từ ngày a (1/10/2025) đến ngày b (7/10/2025)

    public void thongKeTheoKhoangNgay() {
        System.out.print("Nhập tháng cần thống kê: ");
        int month = sc.nextInt();
        while(month <= 0 || month > 12){
            System.out.print("Nhập tháng cần thống kê (> 0 và <= 12): ");
            month = sc.nextInt();
        }

        long tong1 = 0, tong2 = 0, tong3 = 0;

        for (int i = 0; i < n; i++) {
            String[] tach = dspnh[i].getN().split("/"); 

            int ngay = Integer.parseInt(tach[0]);
            int thang = Integer.parseInt(tach[1]);
            int nam = Integer.parseInt(tach[2]);

            if (nam == 2025 && thang == month) {
                if (ngay >= 1 && ngay <= 10)
                    tong1 += dspnh[i].getT();
                else if (ngay >= 11 && ngay <= 20)
                    tong2 += dspnh[i].getT();
                else if (ngay >= 21 && ngay <= 31)
                    tong3 += dspnh[i].getT();
            }
        }

        long tongCong = tong1 + tong2 + tong3;

        System.out.println("\n=== THONG KE TONG TIEN HOA ĐON THANG " + month +" NAM 2025 ===");
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-25s | %-12s |\n", "Khoang ngay", "Tong tien");
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-25s | %-12d |\n", "01/"+month+" - 10/"+month+"/2025", tong1);
        System.out.printf("| %-25s | %-12d |\n", "11/"+month+" - 20/"+month+"/2025", tong2);
        if((month <= 6 && month % 2 != 0) || (month == 7) || (month == 8) || (month >= 10 && month % 2 == 0)){
            System.out.printf("| %-25s | %-12d |\n", "21/"+month+" - 31/"+month+"/2025", tong3);
        }else{
            System.out.printf("| %-25s | %-12d |\n", "21/"+month+" - 30/"+month+"/2025", tong3);
        }
        System.out.println("_____________________________________________________________");
        System.out.printf("| %-25s | %-12d |\n", "Tong cong", tongCong);
        System.out.println("_____________________________________________________________");
    }

    // thống kê tổng tiền hóa đơn theo kh/nv/sp và theo quý/ năm 
    public void thongKeTheoNCCVaNam() {
        long ncc_2023 = 0, ncc_2024 = 0, ncc_2025 = 0;
        long sum_2023 = 0, sum_2024 = 0, sum_2025 = 0;

        System.out.println("\n=== THONG KE TONG TIEN NHAP HANG THEO NHA CUNG CAP VA NAM ===");
        System.out.println("_______________________________________________________________");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-12s |\n", "Ma NCC", "2023", "2024", "2025", "Tong cong");
        System.out.println("_______________________________________________________________");
        if(n == 0) System.out.println(">> Hiện không có nhà cung cấp nào");
        else {
            for (int i = 0; i < n; i++) {
                String[] tach = dspnh[i].getN().split("/");
                int nam = Integer.parseInt(tach[2]);
                long tien = dspnh[i].getT();

                if (nam == 2023) ncc_2023 += tien;
                else if (nam == 2024) ncc_2024 += tien;
                else if (nam == 2025) ncc_2025 += tien;
                long ncc_tong = ncc_2023 + ncc_2024 + ncc_2025;
                sum_2023 += ncc_2023;
                sum_2024 += ncc_2024;
                sum_2025 += ncc_2025;
                System.out.printf("| %-10s | %-10d | %-10d | %-10d | %-12d |\n", dspnh[i].getMNCC(), ncc_2023, ncc_2024, ncc_2025, ncc_tong);
            }
            System.out.println("_______________________________________________________________");
            System.out.printf("| %-10s | %-10d | %-10d | %-10d | %-12d |\n", "Tổng cộng", sum_2023, sum_2024, sum_2025, sum_2023 + sum_2024 + sum_2025);
            System.out.println("_______________________________________________________________");
        }
    }

}
