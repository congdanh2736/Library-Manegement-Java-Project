package QuanLyThuVien;

import NHACUNGCAP.NHACUNGCAP;

public class QuanLyNCC extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        int choosen;
        boolean running = true;

        while(running) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|           MENU QUẢN LÝ NHÀ CUNG CẤP              |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| 1. Xem danh sach nha cung cap                    |");
            System.out.println("| 2. Them nha cung cap                             |");
            System.out.println("| 3. Tim kiem nha cung cap theo ma                 |");
            System.out.println("| 4. Tim kiem nha cung cap theo ten                |");
            System.out.println("| 5. Xoa nha cung cap                              |");
            System.out.println("| 6. Sua nha cung cap                              |");
            System.out.println("| 7. Thong ke so phieu nhap hang theo nha cung cap |");
            System.out.println("| 8. Thong ke so tien nhap theo tung nha cung cap  |");
            System.out.println("| 0. Thoat                                         |");
            System.out.println("+--------------------------------------------------+");
            System.out.print("Lua chon: ");

            choosen = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(choosen) {
                case 1: 
                    dsncc.xuat(); 
                    break;
                case 2: 
                    // dsncc.them(); 
                    menu_them();
                    dsncc.ghiFile("NHACUNGCAP\\nhacungcap.txt");
                    break;
                case 3: 
                    dsncc.timkiem(); 
                    break;
                case 4: 
                    dsncc.timkiemTheoTen();
                    break;
                case 5: 
                    dsncc.xoa(); 
                    dsncc.ghiFile("NHACUNGCAP\\nhacungcap.txt");
                    break;
                case 6: 
                    dsncc.sua(); 
                    dsncc.ghiFile("NHACUNGCAP\\nhacungcap.txt");
                    break;
                case 7:
                    menuThongKeSoPhieuNhap();
                    break;
                case 8: 
                    menuThongKeTongTienNhap();
                    break;
                case 0: running = false; break;
                default: System.out.println("\nLua chon khong hop le!"); break;
            }

            if (!running) {
                System.out.println();
                System.out.println("# Bạn đã thoát MENU quản lý nhà cung cấp!");
                break;
            }

            System.out.println();
            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý nhà cung cấp không (y/n): ");
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
        } ;
    }

    public void menu_them() {
        String maNCC;
        do {
            double val = Math.random() * 10000;
            int n = (int) val;
            maNCC = "NCC" + n;
        } while (dsncc.timkiemMa(maNCC) != null);

        System.out.print("# Nhap ten nha cung cap: ");
        String TenNCC = sc.nextLine();

        System.out.print("# Nhap dia chi nha cung cap: ");
        String DChi = sc.nextLine();

        System.out.print("# Nhap so dien thoai nha cung cap: ");
        String sdt = sc.nextLine();

        NHACUNGCAP ncc = new NHACUNGCAP(maNCC, TenNCC, DChi, sdt);
        dsncc.them(ncc);
    }

    public void menuThongKeSoPhieuNhap() {
        System.out.println("=== Thong ke so phieu nhap theo nha cung cap ===");
        System.out.printf("| %-10s | %-30s | %-10s |\n", "Ma NCC", "Ten NCC", "So luong phieu nhap");
        System.out.println("\n_____________________________________________________________");
        
        for(int i = 0; i < dsncc.getN(); i++){
            int count = 0;
            for(int j = 0; j < dspnh.getSL(); j++){
                if(dsncc.getNCC()[i].getM().equalsIgnoreCase(dspnh.get(j).getMNCC())){
                    count++;
                }
            }
            System.out.printf("| %-10s | %-30s | %-10s |\n", dsncc.getNCC()[i].getM(), dsncc.getNCC()[i].getT(), count);
        }
    
    }

    public void menuThongKeTongTienNhap() {
        System.out.println("=== Thong ke tong tien nhap theo nha cung cap");
        System.out.printf("| %-10s | %-30s | %-20s |\n", "Ma NCC", "Ten NCC", "So tien nhap");
        System.out.println("\n____________________________________________________________________");

        for(int i = 0; i < dsncc.getN(); i++){
            long tongtien = 0;
            for(int j = 0; j < dspnh.getSL(); j++){
                if(dsncc.getNCC()[i].getM().equalsIgnoreCase(dspnh.get(j).getMNCC())){
                    tongtien += dspnh.get(j).getT();
                }
            }
            System.out.printf("| %-10s | %-30s | %-20s |\n", dsncc.getNCC()[i].getM(), dsncc.getNCC()[i].getT(), tongtien);
        }
    }
}