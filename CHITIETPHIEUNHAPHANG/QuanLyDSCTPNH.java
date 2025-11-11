package CHITIETPHIEUNHAPHANG;

import java.util.*;

public class QuanLyDSCTPNH{

    Scanner sc = new Scanner(System.in);

    DSCHITIET_PNH ds = new DSCHITIET_PNH();

    public QuanLyDSCTPNH(String filename) {
        ds.docTuFile(filename);
    }

    public void setDuLieu(String filename) {
        ds.ghiFile(filename);
    }

    public void menu() {
        int choosen;
        boolean running = true;
        while(running) {
            System.out.println("\n-------------- MENU --------------");
            System.out.println("1. Xem danh sach chi tiet phieu nhap hang");
            System.out.println("2. Them chi tiet phieu nhap hang");
            System.out.println("3. Tim kiem chi tiet phieu nhap hang");
            System.out.println("4. Xoa chi tiet phieu nhap hang");
            System.out.println("5. Sua chi tiet phieu nhap hang");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");

            choosen = sc.nextInt();
            sc.nextLine();
            
            switch(choosen) {
                case 1: ds.xuat(); break;
                case 2: ds.them(); break;
                case 3: ds.timkiem(); break;
                case 4: ds.xoa(); break;
                case 5: ds.sua(); break;
                case 0: running = false; break;
                default: System.out.println("\nLua chon khong hop le!"); break;
            }

            if (!running) {
                System.out.println();
                System.out.println("# Bạn đã thoát MENU quản lý chi tiết phiếu nhập hàng!");
                break;
            }

            System.out.println();
            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý chi tiết phiếu nhập hàng không (y/n): ");
            String c = sc.nextLine();

            while (!c.equalsIgnoreCase("n") && !c.equalsIgnoreCase("y")) {
                System.out.println("# Chỉ được nhập y hoặc n!!!");
                System.out.print("# Nhập lại (y/n): ");
                c = sc.nextLine();
            }

            if (c.charAt(0) == 'n' || c.charAt(0) == 'N') {
                // System.out.println("Tạm biệt!");
                break;
            }

            System.out.println();
        } 
    }  
}
