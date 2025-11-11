package QuanLyThuVien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import DocGia.DocGia;

public class QuanLyDG extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        boolean running = true;
        
        while (running) {
            System.out.println();
            System.out.println("+-------------------------------------------+");
            System.out.println("|            MENU QUẢN LÝ ĐỘC GIẢ           |");
            System.out.println("+-------------------------------------------+");
            System.out.println("| 1) Xem danh sách độc giả.                 |");
            System.out.println("| 2) Thêm độc giả.                          |");
            System.out.println("| 3) Xóa độc giả.                           |");
            System.out.println("| 4) Sửa thông tin độc giả.                 |");
            System.out.println("| 5) Tìm kiếm thông tin theo mã.            |");
            System.out.println("| 6) Tìm kiếm thông tin theo họ.            |");
            System.out.println("| 7) Tìm kiếm thông tin theo tên.           |");
            System.out.println("| 8) Thống kê theo giới tính.               |");
            System.out.println("| 9) Thống kê theo tuổi.                    |");
            // System.out.println("| 10) Thống kê độc giả tham gia theo năm.   |");
            System.out.println("| 0) Thoát.                                 |");
            System.out.println("+-------------------------------------------+");

            int choosen;
            System.out.print("# Nhập lựa chọn: ");
            choosen = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choosen) {
                case 1: {
                    dsdg.xuat();
                    System.out.println();
                    break;
                }

                case 2: {
                    menu_them();
                    System.out.println();
                    dsdg.ghiDuLieuFile("DocGia\\docgia.txt");
                    break;
                }
                
                case 3: {
                    dsdg.xoaDG();
                    System.out.println();
                    dsdg.ghiDuLieuFile("DocGia\\docgia.txt");
                    break;
                }
                
                case 4: {
                    dsdg.suaTTDG();
                    System.out.println();
                    dsdg.ghiDuLieuFile("DocGia\\docgia.txt");
                    break;
                }

                case 5: {
                    dsdg.timKiemTTDG();
                    System.out.println();
                    break;
                }

                case 6: {
                    dsdg.timKiemTTDG_ho();
                    System.out.println();
                    break;
                }

                case 7: {
                    dsdg.timKiemTTDG_ten();
                    System.out.println();
                    break;
                }

                case 8: {
                    dsdg.thongKeGioiTinh();
                    System.out.println();
                    break;
                }

                case 9: {
                    dsdg.thongKeTuoi();
                    System.out.println();
                    break;
                }

                // case 10: {
                //     thongKeDocGiaTheoNam();
                //     System.out.println();
                //     break;
                // }

                case 0: {
                    running = false;
                    break;
                }

                default: {
                    System.out.println("# Lựa chọn không hợp lệ.");
                    System.out.println();
                    break;
                }
            }

            if (!running) {
                System.out.println();
                System.out.println("# Bạn đã thoát MENU quản lý độc giả!");
                break;
            }

            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý độc giả không (y/n): ");
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
        String maDocGia;
        do {
            double val = Math.random() * 10000;
            int ran = (int)val;
            maDocGia = "DG" + ran;
        } while (dsdg.timKiem_TTDG(maDocGia) != null);

        System.out.print("# Nhập vào họ: ");
        String ho = sc.nextLine();

        System.out.print("# Nhập vào tên: ");
        String ten = sc.nextLine();

        System.out.print("# Nhập vào ngày sinh (DD/MM/YYYY): ");
        String ngaySinh = sc.nextLine();

        // while (ngaySinh.length() != 10) {
        //     System.out.println("# Cú pháp nhập ngày không hợp lệ!");
        //     System.out.print("# Nhập lại theo cú pháp sau --> (ngày sinh)/(tháng sinh)/(năm sinh) : ");
        //     ngaySinh = sc.nextLine();
        // }

        while (!isValidDay(ngaySinh)) {
            System.out.println("# Ngày sinh không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            ngaySinh = sc.nextLine();
        }

        System.out.print("# Nhập vào giới tính: ");
        String gioiTinh =  sc.nextLine();

        System.out.print("# Nhập vào địa chỉ: ");
        String diaChi = sc.nextLine();

        System.out.print("# Nhập vào số điện thoại: ");
        String sdt = sc.nextLine();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngayLapThe = today.format(formatter);
        
        while (ngayLapThe.length() != 10) {
            System.out.println("# Cú pháp nhập ngày không hợp lệ!");
            System.out.print("# Nhập lại theo cú pháp sau --> (ngày sinh)/(tháng sinh)/(năm sinh) : ");
            ngayLapThe = sc.nextLine();
        }

        DocGia dg = new DocGia(maDocGia, ho, ten, ngaySinh, gioiTinh, diaChi, sdt, ngayLapThe);
        dsdg.themDG(dg);
    }

    // public void thongKeDocGiaTheoNam() {}
}


