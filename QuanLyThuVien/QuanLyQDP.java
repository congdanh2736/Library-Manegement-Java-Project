package QuanLyThuVien;

import QuyDinhPhat.QuyDinhPhat;

public class QuanLyQDP extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        boolean running = true;
        
        while (running) {
            System.out.println();
            System.out.println("+------------------------------------------+");
            System.out.println("|       MENU QUẢN LÝ QUY ĐỊNH PHẠT         |");
            System.out.println("+------------------------------------------+");
            System.out.println("| 1) Xem danh sách quy định phạt.          |");
            System.out.println("| 2) Thêm quy định phạt.                   |");
            System.out.println("| 3) Xóa quy định phạt.                    |");
            System.out.println("| 4) Sửa thông tin quy định phạt.          |");
            System.out.println("| 5) Tìm kiếm thông tin quy định theo mã.  |");
            System.out.println("| 0) Thoát                                 |");
            System.out.println("+------------------------------------------+");

            int choosen;
            System.out.print("# Nhập lựa chọn: ");
            choosen = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choosen) {
                case 1: {
                    System.out.println();
                    dsqdp.xuat();
                    System.out.println();
                    break;
                }

                case 2: {
                    menu_them();
                    System.out.println();
                    dsqdp.ghiDuLieuFile("QuyDinhPhat\\quydinh.txt");
                    break;
                }
                
                case 3: {
                    dsqdp.xoaQD();
                    dsqdp.ghiDuLieuFile("QuyDinhPhat\\quydinh.txt");
                    System.out.println();
                    break;
                }
                
                case 4: {
                    dsqdp.suaTTQD();
                    dsqdp.ghiDuLieuFile("QuyDinhPhat\\quydinh.txt");
                    System.out.println();
                    break;
                }

                case 5: {
                    dsqdp.timKiemQD();
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
                System.out.println("# Bạn đã thoát MENU quản lý quy định phạt!");
                break;
            }

            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý quy định phạt không (y/n): ");
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
        String maLD;
        do {
            double val = Math.random() * 10000;
            int ran = (int)val;
            maLD = "QD" + ran;
        } while (dsqdp.timKiem_QD(maLD) != null);

        System.out.print("# Nhập vào tên lý do: ");
        String tenLD = sc.nextLine();

        System.out.print("# Nhập vào cách thức: ");
        String cachThuc = sc.nextLine();

        System.out.print("# Nhập vào số tiền phạt: ");
        int soTien = sc.nextInt();

        sc.nextLine();

        QuyDinhPhat qd = new QuyDinhPhat(maLD, tenLD, cachThuc, soTien);
        dsqdp.themQD(qd);

        System.out.println("# Thêm thành công quy định phạt");
    }
}