package QuanLyThuVien;

import Book.Books;
import Book.Categogy.Education;
import Book.Categogy.Reference;

public class QuanLyS extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        int chon;
        boolean running = true;
        while (running) {
            System.out.println("+--------------------------------------+");
            System.out.println("|   THÔNG TIN THƯ VIỆN - QUẢN LÝ SÁCH  |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1. Thêm sách                         |");
            System.out.println("| 2. Hiển thị sách                     |");
            System.out.println("| 3. Tìm kiếm sách                     |");
            System.out.println("| 4. Cập nhật thông tin sách           |");
            System.out.println("| 5. Thống kê                          |");
            System.out.println("| 6. Xóa sách                          |");
            System.out.println("| 0. Thoát                             |");
            System.out.println("+--------------------------------------+");

            System.out.print("Chọn: ");

            chon = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(chon){
                case 1:
                    menu_them();
                    dss.writeToFile("Book\\Books.txt");
                    break;
                case 2:
                    dss.showMenu();
                    break;
                case 3:
                    dss.findMenu();
                    break;
                case 4:
                    dss.changeInformation();
                    dss.writeToFile("Book\\Books.txt");
                    break;
                case 5:
                    dss.thongKe();
                    break;
                case 6:
                    dss.remove();
                    dss.writeToFile("Book\\Books.txt");
                    break;

                case 0: {
                    running = false;
                    break;
                }

                default: {
                    System.out.println("# Lựa chọn không hợp lệ!");
                    break;
                }
            }

            if (!running) {
                System.out.println();
                System.out.println("# Bạn đã thoát MENU quản lý sách!");
                break;
            }

            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý sách không (y/n): ");
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
        }
    }

    public void menu_them() {
        System.out.println("[ THƯ VIỆN ONLINE - THÊM SÁCH ]");
        System.out.println("1. Sách giáo dục");
        System.out.println("2. Sách tham khảo");
        System.out.print("Chọn loại sách: ");

        int loai = sc.nextInt();
        sc.nextLine();
        
        Books s;

        switch (loai) {
            case 1: {
                System.out.println("[ THƯ VIỆN ONLINE - NHẬP THÔNG TIN SÁCH");
                System.out.println("[!] Vui lòng nhập đúng các thông tin dưới đây.");

                String maSach;
                do {
                    double num = Math.random() * 10000;
                    int n = (int) num;
                    maSach = "S" + n;
                } while (dss.timKiem(maSach) != null);

                System.out.print(">> Tên sách: ");
                String TenSach = sc.nextLine();

                System.out.print(">> Thể loại: ");
                String TheLoai = sc.nextLine();

                System.out.print(">> Mã tác giả: ");
                String MaTG = sc.nextLine();

                while (dstg.timKiem_TTTG(MaTG) == null) {
                    System.out.println("! Mã tác giả không tồn tại !");
                    System.out.print("# Vui lòng nhập lại: ");
                    MaTG = sc.nextLine();
                }

                System.out.print(">> Trạng thái: ");
                String TrangThai = sc.nextLine();
                // while (!TrangThai.equalsIgnoreCase("còn") || !TrangThai.equalsIgnoreCase("hết")) {
                //     System.out.println("# Nhập sai trạng thái!");
                //     System.out.print("# Vui lòng nhập lại: ");
                //     TrangThai = sc.nextLine();
                // }

                System.out.print(">> Mã nhà xuất bản: ");
                String MaNXB = sc.nextLine();

                while (dsnxb.timKiem_TTNXB(MaNXB) == null) {
                    System.out.println("! Mã nhà xuất bản này không tồn tại !");
                    System.out.print("# Vui lòng nhập lại: ");
                    MaNXB = sc.nextLine();
                }

                System.out.print(">> Năm xuất bản: ");
                String NamXB = sc.nextLine();

                System.out.print(">> Đơn giá: ");
                int DonGia = sc.nextInt();

                while(DonGia < 0){
                    System.out.println("[!]. Đơn giá > 0");
                    System.out.print("# Vui lòng nhập lại: ");
                    DonGia = sc.nextInt();
                }

                System.out.print(">> Số lượng: ");
                int SoLuong = sc.nextInt();
                sc.nextLine();

                int SoLuongConLai = SoLuong;

                System.out.print(">> Nhập vào tên môn: ");
                String tenMon = sc.nextLine();

                System.out.print(">> Nhập vào lớp: ");
                String lop = sc.nextLine();

                s = new Education(maSach, TenSach, TheLoai, MaTG, NamXB, MaNXB, TrangThai, DonGia, SoLuong, SoLuongConLai, tenMon, lop);
                dss.them(s);
                break;
            }

            case 2: {
                System.out.println("[ THƯ VIỆN ONLINE - NHẬP THÔNG TIN SÁCH");
                System.out.println("[!] Vui lòng nhập đúng các thông tin dưới đây.");

                String ms;
                do {
                    double num = Math.random() * 10000;
                    int n = (int) num;
                    ms = "S" + n;
                } while (dss.timKiem(ms) != null);

                System.out.print(">> Tên sách: ");
                String ts = sc.nextLine();


                System.out.print(">> Thể loại: ");
                String tl = sc.nextLine();

                System.out.print(">> Mã tác giả: ");
                String mtg = sc.nextLine();

                while (dstg.timKiem_TTTG(mtg) == null) {
                    System.out.println("! Mã tác giả không tồn tại !");
                    System.out.print("# Vui lòng nhập lại: ");
                    mtg = sc.nextLine();
                }

                System.out.print(">> Trạng thái: ");
                String tt = sc.nextLine();
                // while (!tt.equalsIgnoreCase("còn") || !tt.equalsIgnoreCase("hết")) {
                //     System.out.println("# Nhập sai trạng thái!");
                //     System.out.print("# Vui lòng nhập lại: ");
                //     tt = sc.nextLine();
                // }

                System.out.print(">> Mã nhà xuất bản: ");
                String mnxb = sc.nextLine();

                while (dsnxb.timKiem_TTNXB(mnxb) == null) {
                    System.out.println("! Mã nhà xuất bản này không tồn tại !");
                    System.out.print("# Vui lòng nhập lại: ");
                    mnxb = sc.nextLine();
                }

                System.out.print(">> Năm xuất bản: ");
                String namxb = sc.nextLine();

                System.out.print(">> Đơn giá: ");
                int dg = sc.nextInt();

                System.out.print(">> Số lượng: ");
                int sl = sc.nextInt();
                sc.nextLine();

                int slcl = sl;

                System.out.println(">> Nhập vào lĩnh vực: ");
                String linhVuc = sc.nextLine();

                System.out.println(">> Nhập vào ngôn ngữ: ");
                String ngonNgu = sc.nextLine();

                System.out.println(">> Nhập vào độ tuổi: ");
                int doTuoi = sc.nextInt();
                sc.nextLine();

                s = new Reference(ms, ts, tl, mtg, namxb, mnxb, tt, dg, sl, slcl, linhVuc, ngonNgu, doTuoi);
                dss.them(s);
                break;
            }

            default:
                System.out.println("Loại không hợp lệ.");
                return;
        }
        System.out.println(">> Đã thêm sách thành công.");
    }
}