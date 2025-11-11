package QuanLyThuVien;

import CHITIETPHIEUNHAPHANG.CHITIET_PNH;
import PHIEUNHAPHANG.PHIEUNHAPHANG;

public class QuanLyPNH extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        int choosen;
        boolean running = true;

        while(running) {
            System.out.println("+------------------------------------------------+");
            System.out.println("|           MENU QUẢN LÝ PHIẾU NHẬP HÀNG         |");
            System.out.println("+------------------------------------------------+");
            System.out.println("| 1. Xem danh sach phieu nhap hang               |");
            System.out.println("| 2. Them phieu nhap hang                        |");
            System.out.println("| 3. Tim kiem theo phieu nhap hang               |");
            System.out.println("| 4. Tim kiem theo ngay muon                     |");
            System.out.println("| 5. Xoa phieu nhap hang                         |");
            System.out.println("| 6. Sua phieu nhap hang                         |");
            System.out.println("| 7. Thong ke tong tien theo khoang ngay         |");
            System.out.println("| 8. Thong ke tong tien theo nha cung cap va nam |");
            System.out.println("| 0. Thoat                                       |");
            System.out.println("+------------------------------------------------+");

            System.out.print("Lua chon: ");

            choosen = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(choosen) {
                case 1: 
                    dspnh.xuat(); 
                    break;
                case 2: 
                    menu_them(); 
                    dspnh.ghiFile("PHIEUNHAPHANG\\phieunhaphang.txt");
                    dsctpnh.ghiFile("CHITIETPHIEUNHAPHANG\\chitietpnh.txt");
                    dss.writeToFile("Book\\Books.txt");
                    break;
                case 3: dspnh.timkiem(); break;
                case 4: dspnh.timkiemTheoNgayMuon(); break;
                case 5: 
                    dspnh.xoa(); 
                    dspnh.ghiFile("PHIEUNHAPHANG\\phieunhaphang.txt");
                    break;
                case 6: 
                    dspnh.sua(); 
                    dspnh.ghiFile("PHIEUNHAPHANG\\phieunhaphang.txt");
                    break;
                case 7: dspnh.thongKeTheoKhoangNgay(); break;
                case 8: dspnh.thongKeTheoNCCVaNam(); break;
                case 0: running = false; break;
                default: System.out.println("\nLua chon khong hop le!"); break;
            }

            if (!running) {
                System.out.println();
                System.out.println("# Bạn đã thoát MENU quản lý danh sách phiếu nhập hàng!");
                break;
            }

            System.out.println();
            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý danh sách phiếu nhập hàng không (y/n): ");
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
        };
    }

    public void menu_them() {
        System.out.println("=== Nhap thong tin phieu nhap hang ===");

        String MaPNH;
        do {
            double val = Math.random() * 10000;
            int n = (int) val;
            MaPNH = "PNH" + n;
        } while (dspnh.timkiemMa(MaPNH) != null);

        System.out.print("# Nhap ma nha cung cap: ");
        String MaNCC = sc.nextLine();

        while (dsncc.timkiemMa(MaNCC) == null) {
            System.out.println("! Mã nhà cung cấp không tồn tại !");
            System.out.print("# Vui lòng nhập lại: ");
            MaNCC = sc.nextLine();
        }

        System.out.print("# Nhap ngay nhap hang: ");
        String NgayNhap = sc.nextLine();

        while (!isValidDay(NgayNhap)) {
            System.out.println("# Ngày nhập không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            NgayNhap = sc.nextLine();
        }

        int tongTien = 0;

        System.out.print("# Nhập vào số lượng chi tiết phiếu nhập hàng: ");
        int k = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < k; ++i) {
            System.out.println("# Nhập vào thông tin chi tiết phiếu nhập hàng thứ " + (i + 1) + ": ");


            System.out.print("# Nhap ma sach: ");
            String ms = sc.nextLine();

            while (dss.timKiem(ms) == null) {
                System.out.println("! Mã sách không tồn tại !");
                System.out.print("# Vui lòng nhập lại: ");
                ms = sc.nextLine();
            }

            System.out.print("# Nhap so luong: ");
            int sl = sc.nextInt();
            sc.nextLine();

            int dg = dss.timKiem(ms).getDonGia();

            int thanhtien = sl * dg;

            CHITIET_PNH ctpnh = new CHITIET_PNH(MaPNH, ms, sl, dg, thanhtien);
            dsctpnh.them(ctpnh);

            tongTien += thanhtien;

            dss.setSoLuongNhapHang(ms, sl);
        }

        PHIEUNHAPHANG pnh = new PHIEUNHAPHANG(MaPNH, MaNCC, NgayNhap, tongTien);
        dspnh.them(pnh);
    }
}
