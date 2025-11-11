package QuanLyThuVien;

import PHIEUMUON.PHIEUMUON;
import CHITIETPHIEUMUON.CHITIET_PM;

public class QuanLyPM extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        boolean running = true;
        while (running) {
            System.out.println("+-----------------------------------------+");
            System.out.println("|         MENU QUẢN LÝ PHIẾU MƯỢN         |");
            System.out.println("+-----------------------------------------+");
            System.out.println("| 1. Xem danh sach phieu muon             |");
            System.out.println("| 2. Them phieu muon                      |");
            System.out.println("| 3. Tim kiem theo ma phieu muon          |");
            System.out.println("| 4. Tim kiem theo ngay muon              |");
            System.out.println("| 5. Xoa phieu muon                       |");
            System.out.println("| 6. Sua phieu muon                       |");
            System.out.println("| 7. Thống kê theo tình trạng sách.       |");
            System.out.println("| 8. Thống kê số lần mượn theo độc giả.   |");
            System.out.println("| 0. Thoat                                |");
            System.out.println("+-----------------------------------------+");
            System.out.print("Lua chon: ");
            
            int choosen;
            choosen = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(choosen) {
                case 1: 
                    dspm.xuat(); 
                    break;

                case 2: 
                    menu_them(); 
                    dspm.ghiFile("PHIEUMUON\\phieumuon.txt");
                    dsctpm.ghiFile("CHITIETPHIEUMUON\\chitietpm.txt");
                    dss.writeToFile("Book\\Books.txt");
                    break;

                case 3: 
                    dspm.timkiem(); 
                    break;

                case 4: 
                    dspm.timkiemTheoNgayMuon(); 
                    break;

                case 5: 
                    dspm.xoa();
                    dspm.ghiFile("PHIEUMUON\\phieumuon.txt"); 
                    break;
                    
                case 6: 
                    dspm.sua(); 
                    dspm.ghiFile("PHIEUMUON\\phieumuon.txt"); 
                    break;
                    
                case 7: 
                    dspm.thongkeTheoTinhTrangSach(); 
                    break;

                case 8: 
                    dspm.thongkeSoLanMuonTheoDocGia(); 
                    break;

                case 0: 
                    running = false; 
                    break;

                default: System.out.println("\nLua chon khong hop le!"); break;
            }

            if (!running) {
                System.out.println();
                System.out.println("# Bạn đã thoát MENU quản lý danh sách phiếu mượn!");
                break;
            }
            
            System.out.println();
            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý danh sách phiếu mượn không (y/n): ");
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

    public void menu_them() {
        System.out.println("=== Nhap thong tin phieu muon ===");
        
        String MaPM;
        do {
            double val = Math.random() * 10000;
            int n = (int)val;
            MaPM = "PM" + n;
        } while (dspm.timkiemMa(MaPM) != null);

        System.out.print("# Nhap ma doc gia: ");
        String MaDG = sc.nextLine();

        while (dsdg.timKiem_TTDG(MaDG) == null) {
            System.out.println("! Mã độc giả không tồn tại !");
            System.out.print("# Vui lòng nhập lại: ");
            MaDG = sc.nextLine();
        }

        System.out.print("# Nhap ma nhan vien: ");
        String MaNV = sc.nextLine();

        while (dsnv.timKiem_TTNV(MaNV) == null) {
            System.out.println("! Mã nhân viên không tồn tại !");
            System.out.print("# Vui lòng nhập lại: ");
            MaNV = sc.nextLine();
        }

        System.out.print("# Nhap ngay muon: ");
        String NgayMuon = sc.nextLine();

        while (!isValidDay(NgayMuon)) {
            System.out.println("# Ngày mượn không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            NgayMuon = sc.nextLine();
        }

        System.out.print("# Nhap ngay tra: ");
        String NgayTra = sc.nextLine();

        while (!isValidDay(NgayTra)) {
            System.out.println("# Ngày trả không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            NgayTra = sc.nextLine();
        }

        System.out.print("# Nhap ngay thuc tra: ");
        String NgayThucTra = sc.nextLine();

        while (!isValidDay(NgayThucTra)) {
            System.out.println("# Ngày thực trả không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            NgayThucTra = sc.nextLine();
        }

        System.out.print("# Nhập vào số lượng chi tiết phiếu mượn cần thêm: ");
        int k = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < k; ++i) {
            String maPM = MaPM;
            
            System.out.println();
            System.out.println("# Nhập vào chi tiết phiếu mượn thứ " + (i + 1) + ": ");

            System.out.print("# Nhập vào mã sách: ");
            String maSach = sc.nextLine();

            // Kiểm tra mã sách
            while (dss.timKiem(maSach) == null) {
                System.out.println("! Mã sách không tồn tại !");
                System.out.print("# Vui lòng nhập lại: ");
                maSach = sc.nextLine();
            }

            System.out.print("# Nhập vào số lượng sách mượn: ");
            int SL = sc.nextInt();
            sc.nextLine();
            
            CHITIET_PM ctpm = new CHITIET_PM(maPM, maSach, SL);
            dsctpm.them(ctpm);

            // Cap nhat so luong
            dss.setSoLuong(maSach, SL);

        }

        PHIEUMUON pm = new PHIEUMUON(MaPM, MaDG, MaNV, NgayMuon, NgayTra, NgayThucTra);
        dspm.them(pm);
    }
}
