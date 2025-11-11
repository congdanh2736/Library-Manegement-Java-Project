package NHACUNGCAP;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DSNHACUNGCAP {
    Scanner sc = new Scanner(System.in);

    NHACUNGCAP[] dsncc;
    private int n;

    public int getN() {
        return n;
    }

    public NHACUNGCAP[] getNCC() {
        return dsncc;
    }

    public DSNHACUNGCAP(){}
    public DSNHACUNGCAP(int ncc, NHACUNGCAP[] ds){
        this.n = ncc;
        this.dsncc = new NHACUNGCAP[n];
        for(int i = 0; i < n; i++){
            dsncc[i] = new NHACUNGCAP(ds[i]);
        }
    }
    public DSNHACUNGCAP(DSNHACUNGCAP d){
        this.n = d.n;
        this.dsncc = d.dsncc;
    }

    public void nhap(){
        System.out.print("Nhap so luong nha cung cap: ");
        this.n = sc.nextInt();
        sc.nextLine();

        this.dsncc = new NHACUNGCAP[n];
        for(int i = 0; i < n; i++){
            System.out.print("Nha cung cap thu " + (i + 1) + ": ");
            dsncc[i] = new NHACUNGCAP();
            dsncc[i].nhap();
            System.out.println();
        }
    }

    public void xuat(){
        if (n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("\n======================================== Danh sach nha cung cap ========================================");
        System.out.printf("| %-10s| %-40s| %-30s| %-15s|\n", "Ma NCC", "Ten NCC", "Dia chi", "So dien thoai");
        System.out.println("________________________________________________________________________________________________________");
        for(int i = 0; i < n; i++){
            dsncc[i].xuat();
        }
        System.out.println();
        System.out.println("________________________________________________________________________________________________________");
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
            dsncc = new NHACUNGCAP[0];

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue; 

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String ma = parts[0].trim();
                    String ten = parts[1].trim();
                    String dc = parts[2].trim();
                    String sdt = parts[3].trim();

                    dsncc = Arrays.copyOf(dsncc, n + 1);
                    dsncc[n] = new NHACUNGCAP(ma, ten, dc, sdt);
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
                NHACUNGCAP ncc = dsncc[i];
                writer.println(ncc.getM() + "," + ncc.getT() + "," + ncc.getD() + "," + ncc.getS());
            }
            // System.out.println("Ghi file thanh cong!");
        } 
        catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    public void them(){
        // System.out.print("Nhap so luong nha cung cap can them: ");
        // int k = sc.nextInt();
        // sc.nextLine();

        n += 1;
        dsncc = Arrays.copyOf(dsncc, n);

        // for(int i = n; i < n + k; i++){
            // System.out.println("Nhap thong tin nha cung cap thu " + (i + 1) + ": ");
            dsncc[n - 1] = new NHACUNGCAP();
            dsncc[n - 1].nhap();
        // }
        System.out.println("Da them thong tin nha cung cap thanh cong!");
    }
    
    public void them(NHACUNGCAP ncc){
        n = dsncc.length;
        dsncc = Arrays.copyOf(dsncc, n + 1);
        dsncc[n] = new NHACUNGCAP(ncc);
        n++;
    }

    public int timkiemTheoMa(String ma){
        for(int i = 0; i < n; i++){
            if(dsncc[i].getM().equalsIgnoreCase(ma)){
                return i;
            }
        }
        return -1;
    }
    public void timkiem(){
        System.out.print("Nhap ma nha cung cap can tim: ");
        String ma = sc.nextLine();

        int t = timkiemTheoMa(ma);
        if(t == -1){
            System.out.println("Khong tim thay nha cung cap co ma " + ma);
        }
        else{
            System.out.println("Thong tin nha cung cap");
            System.out.printf("| %-10s| %-40s| %-30s| %-15s|\n", "Ma NCC", "Ten NCC", "Dia chi", "So dien thoai");
            System.out.println("________________________________________________________________________________________________________");
            dsncc[t].xuat();
        }
    }
    public NHACUNGCAP timkiemMa(String ma){
        for(int i = 0; i < n; i++){
            if(dsncc[i].getM().equalsIgnoreCase(ma)){
                return dsncc[i];
            }
        }
        // System.out.println("Khong tim thay nha cung cap co ma " + ma);
        return null;    
    }

    public void timkiemTheoTen(){
        System.out.print("Nhap ten nha cung cap can tim: ");
        String ten = sc.nextLine();

        int count = 0;
        System.out.println("Danh sach cac nha cung cap co ten " + ten);
        System.out.printf("| %-10s| %-40s| %-30s| %-15s|\n", "", "Ma NCC", "Ten NCC", "Dia chi", "So dien thoai");
        System.out.println("________________________________________________________________________________________________________");

        for(int i = 0; i < n; i++){
            if(dsncc[i].getT().toLowerCase().indexOf(ten.toLowerCase()) != -1){
                dsncc[i].xuat();
                count++;
                //System.out.println();
            }
        }
        if(count == 0){
            System.out.println("Khong tim thay nha cung cap ten = " + ten);
        }
    }

    public NHACUNGCAP[] timkiemTheoTen(String ten){
        NHACUNGCAP[] kq = new NHACUNGCAP[0];
        System.out.println("Danh sach nha cung cap co ten " + ten);
        System.out.printf("| %-10s| %-40s| %-30s| %-15s|\n", "", "Ma NCC", "Ten NCC", "Dia chi", "So dien thoai");
        System.out.println("________________________________________________________________________________________________________");
        
        for(int i = 0; i < n; i++){
            if(dsncc[i].getT().toLowerCase().indexOf(ten.toLowerCase()) != -1){
                dsncc[i].xuat();
                System.out.println();
                
                kq = Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length - 1] = dsncc[i];
            }
        }
        return kq;
    }

    public void xoa(){
        System.out.print("Nhap ma nha cung cap can xoa: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay nha cung cap!");
            return;
        }
        for(int i = idx; i < n - 1; i++){
            dsncc[i] = dsncc[i + 1];
        }
        dsncc = Arrays.copyOf(dsncc, n - 1);
        n--;
        System.out.println("Da xoa thanh cong!");
    }

    public void xoa(String ma){
        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay nha cung cap!");
            return;
        }

        for(int i = idx; i < n - 1; i++){
            dsncc[i] = dsncc[i + 1];
        }
        dsncc = Arrays.copyOf(dsncc, n - 1);
        n--;
        System.out.println("Da xoa nha cung cap thanh cong!");
    }

    public void sua(){ 
        System.out.print("Nhap ma nha cung cap can sua: ");
        String ma = sc.nextLine();

        int idx = timkiemTheoMa(ma);
        if(idx == -1){
            System.out.println("Khong tim thay nha cung cap!");
            return;
        }

        int choose;
        do{
            System.out.println("--- MENU SUA THONG TIN NHA CUNG CAP ---");
            System.out.println("1. Sua ten nha cung cap");
            System.out.println("2. Sua dia chi nha cung cap");
            System.out.println("3. Sua so dien thoai nha cung cap");
            System.out.println("0. Thoat");

            System.out.print("Nhap lua chon: ");
            choose = sc.nextInt();
            sc.nextLine();

            switch(choose){
                case 1: {
                    System.out.print("Nhap ten can sua: ");
                    String ten = sc.nextLine();
                    dsncc[idx].setT(ten);
                    System.out.println("Doi ten thanh cong!");
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.print("Nhap dia chi can sua: ");
                    String dc = sc.nextLine();
                    dsncc[idx].setD(dc);
                    System.out.println("Doi dia chi thanh cong!");
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.print("Nhap so dien thoai can sua: ");
                    String sdt = sc.nextLine();
                    dsncc[idx].setS(sdt);
                    System.out.println("Doi so dien thoai thanh cong!");
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

    
    // thống kê số phiếu nhập hàng theo từng nhà cung câp
    // public void thongkeSoPhieuNhap(){
    //     System.out.println("=== Thong ke so phieu nhap theo nha cung cap ===");
    //     System.out.printf("| %-10s | %-30s | %-10s |\n", "Ma NCC", "Ten NCC", "So luong phieu nhap");
    //     System.out.println("\n_____________________________________________________________");
        
    //     for(int i = 0; i < n; i++){
    //         int count = 0;
    //         for(int j = 0; j < dspnh.getSL(); j++){
    //             if(dsncc[i].getM().equalsIgnoreCase(dspnh.get(j).getMNCC())){
    //                 count++;
    //             }
    //         }
    //         System.out.printf("| %-10s | %-30s | %-10s |\n", dsncc[i].getM(), dsncc[i].getT(), count);
    //     }
    // }

    // thống kê số tiền nhập từ từng nhà cung cấp
    // public void thongkeTongTienNhap(){
    //     System.out.println("=== Thong ke tong tien nhap theo nha cung cap");
    //     System.out.printf("| %-10s | %-30s | %-20s |\n", "Ma NCC", "Ten NCC", "So tien nhap");
    //     System.out.println("\n____________________________________________________________________");

    //     for(int i = 0; i < n; i++){
    //         long tongtien = 0;
    //         for(int j = 0; j < dspnh.getSL(); j++){
    //             if(dsncc[i].getM().equalsIgnoreCase(dspnh.get(j).getMNCC())){
    //                 tongtien += dspnh.get(j).getT();
    //             }
    //         }
    //         System.out.printf("| %-10s | %-30s | %-20s |\n", dsncc[i].getM(), dsncc[i].getT(), tongtien);
    //     }
    // }

}

