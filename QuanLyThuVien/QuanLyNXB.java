package QuanLyThuVien;

public class QuanLyNXB extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        int n;
        boolean running = true;
        while (running) {
            System.out.println("+--------------------------------------------+");
            System.out.println("|   THƯ VIỆN ONLINE - QUẢN LÝ NHÀ XUẤT BẢN   |");
            System.out.println("+--------------------------------------------+");
            System.out.println("| 1. Danh sách các nhà xuất bản của thư viện |");
            System.out.println("| 2. Thêm nhà xuất bản                       |");
            System.out.println("| 3. Cập nhật thông tin nhà xuất bản         |");
            System.out.println("| 4. Tìm kiếm nhà xuất bản                   |");
            System.out.println("| 5. Xóa nhà xuất bản                        |");
            System.out.println("| 0. Thoát.                                  |");
            System.out.println("+--------------------------------------------+");

            System.out.print(">> Nhập số tương ứng với chức năng mà bạn muốn: ");
            n = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (n) {
                case 1:
                    dsnxb.show();
                    break;
                case 2:
                    dsnxb.add();
                    dsnxb.writeToFile("Publisher\\Publishers.txt");
                    break;
                case 3:
                    dsnxb.changeInformation();
                    dsnxb.writeToFile("Publisher\\Publishers.txt");
                    break;
                case 4:
                    dsnxb.find();
                    break;
                case 5:
                    dsnxb.remove();
                    dsnxb.writeToFile("Publisher\\Publishers.txt");
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
                System.out.println("# Bạn đã thoát MENU quản lý nhà xuất bản!");
                break;
            }

            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý nhà xuất bản không (y/n): ");
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
