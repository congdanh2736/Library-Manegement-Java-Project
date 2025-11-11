package QuanLyThuVien;

import PhieuPhat.PhieuPhat;

public class QuanLyPP extends QuanLyThuVien {

    @Override
    public void menu_chinh() {
        boolean running = true;
        
        while (running) {
            System.out.println();
            System.out.println("+---------------------------------------------------+");
            System.out.println("|              MENU QUẢN LÝ PHIẾU PHẠT              |");
            System.out.println("+---------------------------------------------------+");
            System.out.println("| 1) Xem danh sách phiếu phạt.                      |");
            System.out.println("| 2) Thêm phiếu phạt.                               |");
            System.out.println("| 3) Xóa phiếu phạt.                                |");
            System.out.println("| 4) Sửa thông tin phiếu phạt.                      |");
            System.out.println("| 5) Tìm kiếm thông tin theo mã.                    |");
            System.out.println("| 6) Thống kê tiền phạt của năm theo mã độc giả.    |");
            System.out.println("| 0) Thoát                                          |");
            System.out.println("+---------------------------------------------------+");

            int choosen;
            System.out.print("# Nhập lựa chọn: ");
            choosen = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choosen) {
                case 1: {
                    System.out.println();
                    dspp.xuat();
                    System.out.println();
                    break;
                }

                case 2: {
                    menu_them();
                    System.out.println();
                    dspp.ghiDuLieuFile("PhieuPhat\\phieuphat.txt");
                    break;
                }
                
                case 3: {
                    dspp.xoaPP();
                    System.out.println();
                    dspp.ghiDuLieuFile("PhieuPhat\\phieuphat.txt");
                    break;
                }
                
                case 4: {
                    dspp.suaTTPP();
                    System.out.println();
                    dspp.ghiDuLieuFile("PhieuPhat\\phieuphat.txt");
                    break;
                }
                
                case 5: {
                    dspp.timKiemTTPP();
                    System.out.println();
                    break;
                }

                case 6: {
                    thongKeTienPhatTheoNam();
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
                System.out.println("# Bạn đã thoát MENU quản lý phiếu phạt!");
                break;
            }

            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý danh sách phiếu phạt không (y/n): ");
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
        String maPP;
        do {
            double val = Math.random() * 10000;
            int n = (int)val;
            maPP = "PP" + n;
        } while (dspp.timKiem_TTPP(maPP) != null);

        System.out.print("# Nhập vào mã phiếu mượn: ");
        String maPM = sc.nextLine();

        while (dspm.timkiemMa(maPM) == null) {
            System.out.println("! Mã phiếu mượn không tồn tại !");
            System.out.print("# Vui lòng nhập lại: ");
            maPM = sc.nextLine();
        }

        System.out.print("# Nhập vào mã lý do: ");
        String maLD = sc.nextLine();

        while (dsqdp.timKiem_QD(maLD) == null) {
            System.out.println("# Không tồn tại quy định phạt này!");
            System.out.print("# Vui lòng nhập lại: ");
            maLD = sc.nextLine();
        }

        int soTienPhat = dsqdp.timKiem_QD(maLD).getSoTien();

        PhieuPhat pp = new PhieuPhat(maPP, maPM, maLD, soTienPhat);
        dspp.themPP(pp);
    }

    public void thongKeTienPhatTheoNam() {

    }
}   