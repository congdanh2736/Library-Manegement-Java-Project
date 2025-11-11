package QuanLyThuVien;

import Author.Authors;

public class QuanLyTG extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        int n;
        boolean running = true;
        while (running) {
            System.out.println("+------------------------------------+");
            System.out.println("| THƯ VIỆN ONLINE - QUẢN LÝ TÁC GIẢ  |");
            System.out.println("+------------------------------------+");
            System.out.println("| 1. Danh sách các tác giả           |");
            System.out.println("| 2. Thêm tác giả                    |");
            System.out.println("| 3. Thay đổi thông tin của tác giả  |");
            System.out.println("| 4. Tìm kiếm tác giả                |");
            System.out.println("| 5. Xóa tác giả                     |");
            System.out.println("| 6. Thống kê theo giới tính         |");
            System.out.println("| 7. Thống kê theo tuổi              |");
            System.out.println("| 0. Thoát.                          |");
            System.out.println("+------------------------------------+");

            System.out.print(">> Nhập số tương ứng với chức năng mà bạn muốn: ");
            n = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (n) {
                case 1:
                    dstg.show();
                    break;
                case 2:
                    menu_them();
                    dstg.writeToFile("Author\\Authors.txt");
                    break;
                case 3:
                    dstg.changeInformation();
                    dstg.writeToFile("Author\\Authors.txt");
                    break;
                case 4:
                    dstg.find();
                    break;
                case 5:
                    dstg.remove();
                    dstg.writeToFile("Author\\Authors.txt");
                    break;

                case 6: {
                    dstg.thongKeGioiTinh();
                    break;
                }

                case 7: {
                    dstg.thongKeTuoi();
                    break;
                }

                case 0: {
                    running = false;
                    break;
                }

                default: {
                    System.out.println("# Lựa chọn không hợp lệ !");
                }
            }

            if (!running) {
                System.out.println();
                System.out.println("# Bạn đã thoát MENU quản lý tác giả!");
                break;
            }

            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý tác giả không (y/n): ");
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
        String mtg;
        do {
            double val = Math.random() * 10000;
            int ran = (int)val;
            mtg = "TG" + ran;
        } while (dstg.timKiem_TTTG(mtg) != null);

        System.out.print(">> Họ: ");
        String ho = sc.nextLine();
        System.out.print(">> Tên: ");
        String ten = sc.nextLine();

        System.out.println(">> Giới tính: ");
        String gt = sc.nextLine();

        System.out.print(">> Ngày sinh: ");
        String ns = sc.nextLine();

        while (!isValidDay(ns)) {
            System.out.println("# Ngày sinh không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            ns = sc.nextLine();
        }

        System.out.print(">> Số điện thoại: ");
        String sdt = sc.nextLine();

        while (sdt.length() != 10 || sdt.charAt(0) != '0') {
            System.out.println("# Số điện thoại nhập không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            sdt = sc.nextLine();
        }

        System.out.print(">> Email: ");
        String email = sc.nextLine();

        Authors tg = new Authors(mtg, ho, ten, gt, ns, sdt, email);
        dstg.add(tg);

        System.out.println("# Thêm tác giả thành công !");
    }
}