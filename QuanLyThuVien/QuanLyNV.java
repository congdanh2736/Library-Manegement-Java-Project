package QuanLyThuVien;

import NhanVien.NhanVien;

public class QuanLyNV extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        boolean running = true;
        
        while (running) {
            System.out.println();
            System.out.println("+----------------------------------+");
            System.out.println("|      MENU QUẢN LÝ NHÂN VIÊN      |");
            System.out.println("+----------------------------------+");
            System.out.println("| 1) Xem danh sách nhân viên.      |");
            System.out.println("| 2) Thêm nhân viên.               |");
            System.out.println("| 3) Xóa nhân viên.                |");
            System.out.println("| 4) Sửa thông tin nhân viên.      |");
            System.out.println("| 5) Tìm kiếm thông tin theo mã.   |");
            System.out.println("| 6) Tìm kiếm thông tin theo họ.   |");
            System.out.println("| 7) Tìm kiếm thông tin theo tên.  |");
            System.out.println("| 8) Thống kê theo giới tính.      |");
            System.out.println("| 9) Thống kê theo tuổi.           |");
            System.out.println("| 0) Thoát.                        |");
            System.out.println("+----------------------------------+");

            int choosen;
            System.out.print("# Nhập lựa chọn: ");
            choosen = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choosen) {
                case 1: {
                    System.out.println();
                    dsnv.xuat();
                    System.out.println();
                    break;
                }

                case 2: {
                    menu_them();
                    System.out.println();
                    dsnv.ghiDuLieuFile("NhanVien\\nhanvien.txt");
                    break;
                }
                
                case 3: {
                    dsnv.xoaNV();
                    dsnv.ghiDuLieuFile("NhanVien\\nhanvien.txt");
                    System.out.println();
                    break;
                }
                
                case 4: {
                    dsnv.suaTTNV();
                    dsnv.ghiDuLieuFile("NhanVien\\nhanvien.txt");
                    System.out.println();
                    break;
                }

                case 5: {
                    dsnv.timKiemTTNV();
                    System.out.println();
                    break;
                }

                case 6: {
                    dsnv.timKiemTTNV_ho();
                    System.out.println();
                    break;
                }

                case 7: {
                    dsnv.timKiemTTNV_ten();
                    System.out.println();
                    break;
                }

                case 8: {
                    dsnv.thongke();
                    System.out.println();
                    break;
                }

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
                System.out.println("# Bạn đã thoát MENU quản lý nhân viên!");
                break;
            }

            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý nhân viên không (y/n): ");
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
        String maNV;
        do {
            double val = Math.random() * 10000;
            int ran = (int)val;
            maNV = "NV" + ran;
        } while (dsnv.timKiem_TTNV(maNV) != null);

        System.out.print("# Nhập vào họ: ");
        String ho = sc.nextLine();

        System.out.print("# Nhập vào tên: ");
        String ten = sc.nextLine();

        System.out.print("# Nhập vào ngày sinh: ");
        String ngaySinh = sc.nextLine();

        while (!isValidDay(ngaySinh)) {
            System.out.println("# Ngày sinh không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            ngaySinh = sc.nextLine();
        }

        System.out.print("# Nhập vào giới tính: ");
        String gioiTinh = sc.nextLine();

        System.out.print("# Nhập vào số điện thoại: ");
        String soDienThoai = sc.nextLine();

        while (soDienThoai.length() != 10 || soDienThoai.charAt(0) != '0') {
            System.out.println("# Số điện thoại nhập không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            soDienThoai = sc.nextLine();
        }

        System.out.print("# Nhập vào địa chỉ: ");
        String diaChi = sc.nextLine();

        System.out.print("# Nhập vào lương: ");
        int luong = sc.nextInt();
        sc.nextLine();

        NhanVien nv = new NhanVien(maNV, ho, ten, ngaySinh, gioiTinh, soDienThoai, diaChi, luong);
        dsnv.themNV(nv);
    }
}

