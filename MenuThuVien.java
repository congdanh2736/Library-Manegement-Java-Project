import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import QuanLyThuVien.*;

public class MenuThuVien {
    Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    QuanLyThuVien qltv;

    public void menu() {
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("+--------------------------------+------------------- [ MENU QUẢN LÝ ] ----------------------------+--------------------------------+");
            System.out.printf("| %-30s | %-30s | %-30s | %-30s |\n", "       THÔNG TIN NGƯỜI", "       THÔNG TIN SÁCH",  "      THÔNG TIN CÁC PHIẾU", "      THÔNG TIN PHẠT");
            System.out.printf("+-%-30s-+-%-30s-+-%-30s-+-%-30s-+\n", "------------------------------", "------------------------------", "------------------------------", "------------------------------");
            System.out.printf("| %-30s | %-30s | %-30s | %-30s |\n", "1. Độc giả.",            "4. Sách.",               "7. Phiếu mượn.",             "10. Quy định phạt.");
            System.out.printf("| %-30s | %-30s | %-30s | %-30s |\n", "2. Nhân viên.",          "5. Nhà xuất bản.",       "8. Phiếu phạt.",             "");
            System.out.printf("| %-30s | %-30s | %-30s | %-30s |\n", "3. Tác giả",             "6. Nhà cung cấp.",       "9. Phiếu nhập hàng.",                           "");
            System.out.println("+----------+---------------------+--------------------------------+--------------------------------+--------------------------------+");
            // System.out.println("--------------");
            System.out.println("| 0. Thoát |");
            System.out.println("+----------+");
            System.out.println();

            System.out.print("# Nhập vào lựa chọn: ");
            int choosen = sc.nextInt();

            switch (choosen) {
                case 1: {
                    qltv = new QuanLyDG();
                    qltv.menu_chinh();
                    break;
                }

                case 2: {
                    qltv = new QuanLyNV();
                    qltv.menu_chinh();
                    break;
                }

                case 3: {
                    qltv = new QuanLyTG();
                    qltv.menu_chinh();
                    break;
                }

                case 4: {
                    qltv = new QuanLyS();
                    qltv.menu_chinh();
                    break;
                }

                case 5: {
                    qltv = new QuanLyNXB();
                    qltv.menu_chinh();
                    break;
                }

                case 6: {
                    qltv = new QuanLyNCC();
                    qltv.menu_chinh();
                    break;
                }

                case 7: {
                    qltv = new QuanLyPM();
                    qltv.menu_chinh();
                    break;
                }

                case 8: {
                    qltv = new QuanLyPP();
                    qltv.menu_chinh();
                    break;
                }

                case 9: {
                    qltv = new QuanLyPNH();
                    qltv.menu_chinh();
                    break;
                }
                
                case 10: {
                    qltv = new QuanLyQDP();
                    qltv.menu_chinh();
                    break;
                }

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
                System.out.println("Tạm biệt! Chúc bạn một ngày tốt lành!");
                break;
            }

            System.out.print("# Bạn có muốn tiếp tục với MENU quản lý không (y/n): ");
            sc.nextLine();
            String c = sc.nextLine();

            while (!c.equalsIgnoreCase("n") && !c.equalsIgnoreCase("y")) {
                System.out.println("# Chỉ được nhập y hoặc n!!!");
                System.out.print("# Nhập lại (y/n): ");
                c = sc.nextLine();
            }

            if (c.charAt(0) == 'n' || c.charAt(0) == 'N') {
                System.out.println("Tạm biệt!");
                break;
            }

            System.out.println();
        }
        
    }
}
