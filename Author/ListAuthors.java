package Author;

import java.util.*;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class ListAuthors {
    Authors[] dstg = new Authors[0];
    Scanner sc = new Scanner(System.in);

    public ListAuthors() {
    }

    public void show() {
        // System.out.println("[ THƯ VIỆN ONLINE - DANH SÁCH CÁC TÁC GIẢ ]");
        System.out.printf("+-%-25s-+-%-25s-+-%-25s-+-%-25s-+-%-25s-+-%-25s-+\n", "-------------------------", "-------------------------", "-------------------------", "-------------------------", "-------------------------", "-------------------------");
        System.out.printf("| %-25s | %-25s | %-25s | %-25s | %-25s | %-25s |\n", "Mã tác giả", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email");
        System.out.printf("+-%-25s-+-%-25s-+-%-25s-+-%-25s-+-%-25s-+-%-25s-+\n", "-------------------------", "-------------------------", "-------------------------", "-------------------------", "-------------------------", "-------------------------");
        for (int i = 0; i < dstg.length; i++) {
            System.out.printf("| %-25s | %-25s | %-25s | %-25s | %-25s | %-25s |\n", dstg[i].getMaTG(), dstg[i].getHoTen(),dstg[i].getGioiTinh(), dstg[i].getNamSinh(), dstg[i].getSDT(), dstg[i].getEmail());
        }
        System.out.printf("+-%-25s-+-%-25s-+-%-25s-+-%-25s-+-%-25s-+-%-25s-+\n", "-------------------------", "-------------------------", "-------------------------", "-------------------------", "-------------------------", "-------------------------");
    }

    public void add() {
        System.out.println("[ THƯ VIỆN ONLINE - THÊM TÁC GIẢ MỚI ]");

        System.out.println(">> Mã tác giả: ");
        String mtg = sc.nextLine();

        System.out.print(">> Họ: ");
        String ho = sc.nextLine();
        System.out.print(">> Tên: ");
        String ten = sc.nextLine();

        System.out.println(">> Giới tính: ");
        String gt = sc.nextLine();

        System.out.print(">> Năm sinh: ");
        String ns = sc.nextLine();

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
        dstg = Arrays.copyOf(dstg, dstg.length + 1);
        dstg[dstg.length - 1] = tg;

        System.out.println(">> Đã thêm tác giả thành công.");
        // writeToFile();
    }

    public void add(Authors tg) {
        dstg = Arrays.copyOf(dstg, dstg.length + 1);
        dstg[dstg.length - 1] = tg;
    }

    public boolean isValidDay(String day) {
        String dayStr = day;
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("d/M/yyyy").toFormatter();

        try {
            LocalDate.parse(dayStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void changeInformation() {
        System.out.println("[ THƯ VIỆN ONLINE - THAY ĐỔI THÔNG TIN ]");
        System.out.print(">> Nhập mã tác giả cần sửa: ");
        String ma = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < dstg.length; i++) {
            if(dstg[i].getMaTG().equalsIgnoreCase(ma)) {

                System.out.println("# Menu thông tin cần sửa: ");
                System.out.println("1. Họ.");
                System.out.println("2. Tên.");
                System.out.println("3. Giới tính.");
                System.out.println("4. Ngày sinh.");
                System.out.println("5. Số điện thoại.");
                System.out.println("6. Email.");
                System.out.print("# Nhập vào lựa chọn cần sửa: ");
                int choosen = sc.nextInt();
                sc.nextLine();

                switch (choosen) {
                    case 1: {
                        System.out.print(">> Họ mới: ");
                        dstg[i].setHo(sc.nextLine());
                        break;
                    }

                    case 2: {
                        System.out.print(">> Tên mới: ");
                        dstg[i].setTen(sc.nextLine());
                        break;
                    }

                    case 3: {
                        System.out.print(">> Giới tính mới: ");
                        dstg[i].setGioiTinh(sc.nextLine());
                    }

                    case 4: {
                        System.out.print(">> Ngày sinh mới: ");
                        String ns = sc.nextLine();

                        while (!isValidDay(ns)) {
                            System.out.println("# Ngày sinh nhập vào không hợp lệ !");
                            System.out.print("# Vui lòng nhập lại: ");
                            ns = sc.nextLine();
                        }

                        dstg[i].setNamSinh(ns);
                        break;
                    }

                    case 5: {
                        System.out.print(">> SĐT mới: ");
                        dstg[i].setSDT(sc.nextLine());
                        break;
                    }

                    case 6: {
                        System.out.print(">> Email mới: ");
                        dstg[i].setEmail(sc.nextLine());
                        break;
                    }
                
                    default:
                        break;
                }

                System.out.println(">> Đã cập nhật thông tin tác giả.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(">> Không tìm thấy tác giả có mã: " + ma);
        }
        // writeToFile();
    }

    public void find(){
        System.out.println("[ THƯ VIỆN ONLINE - TÌM KIẾM TÁC GIẢ ]");
        System.out.print(">> Nhập từ khóa (mã hoặc tên): ");
        String a = sc.nextLine().toLowerCase();

        boolean found = false;
        System.out.println(">> Danh sách các tác giả phù hợp: ");
        for(int i = 0; i < dstg.length; i++){
            if (dstg[i].getMaTG().toLowerCase().contains(a) ||
                    dstg[i].getHoTen().toLowerCase().contains(a)) {
                System.out.printf("%-30s %-30s %-30s\n", dstg[i].getMaTG(), dstg[i].getHoTen(), dstg[i].getNamSinh());
                found = true;
            }
        }

        if (!found) {
            System.out.println(">> Không tìm thấy tác giả nào phù hợp.");
        }
    }

    public Authors timKiem_TTTG(String ms) {
        int i;
        for (i = 0; i < dstg.length; ++i) {
            if (ms.equals(dstg[i].getMaTG())) {
                return dstg[i];
            }
        }
 
        return null;
    }

    public void remove(){
        System.out.println("[ THƯ VIỆN ONLINE - XÓA TÁC GIẢ ]");
        System.out.print(">> Nhập mã tác giả cần xóa: ");
        String ma = sc.nextLine();

        int index = -1;
        for (int i = 0; i < dstg.length; i++) {
            if (dstg[i].getMaTG().equalsIgnoreCase(ma)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println(">> Không tìm thấy tác giả có mã: " + ma);
            return;
        }

        Authors[] temp = new Authors[dstg.length - 1];
        for (int i = 0, j = 0; i < dstg.length; i++) {
            if (i != index) {
                temp[j++] = dstg[i];
            }
        }

        dstg = temp;
        System.out.println(">> Đã xóa tác giả có mã: " + ma);
        // writeToFile();
    }

    public void readFromFile(String filename) {
        File f = new File(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String maTG = parts[0];
                    String ho = parts[1];
                    String ten = parts[2];
                    String gt = parts[3];
                    String namSinh = parts[4];
                    String sdt = parts[5];
                    String email = parts[6];

                    dstg = Arrays.copyOf(dstg, dstg.length + 1);
                    dstg[dstg.length - 1] = new Authors(maTG, ho, ten, gt, namSinh, sdt, email);;
                }
            }
        } catch (IOException e) {
            System.out.println(">> Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void writeToFile(String filename) {
        File f = new File(filename);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 0; i < dstg.length; i++) {
                String line = dstg[i].getMaTG() + "," +
                        dstg[i].getHo() + "," +
                        dstg[i].getTen() + "," +
                        dstg[i].getGioiTinh() + "," +
                        dstg[i].getNamSinh() + "," +
                        dstg[i].getSDT() + "," +
                        dstg[i].getEmail();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(">> Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void thongKeGioiTinh() {
        int nam = 0;
        int nu = 0;

        for (int i = 0; i < dstg.length; i++) 
            if (dstg[i].getGioiTinh().equalsIgnoreCase("nam")) 
                nam++;
            else 
                nu++;
        
        System.out.println("# Số lượng tác giả có giới tính nam: " + nam);
        System.out.println("# Số lượng tác giả có giới tính là nữ: " + nu);
    }

    public void thongKeTuoi() {
        int[] tuoi = new int[200];
        int thisYear = LocalDate.now().getYear();
        int idx;
        int t = 0;
        int len = dstg.length;

        for (int i = 0; i < len; ++i) {
            idx = getYearIndex(dstg[i].getNamSinh());

            t = thisYear - Integer.parseInt(dstg[i].getNamSinh().substring(idx)) + 1;
            tuoi[t]++;
               
        }

        for (int i = 0; i < 200; ++i) {
            if (tuoi[i] != 0) 
                System.out.println("# Số lượng tác giả " + i + " tuổi: " + tuoi[i]);
        }
    }

    public int getYearIndex(String day) {
        int count = 0;

        for (int i = 0; i < day.length(); i++) {
            if (count == 2)
                return i;

            if (day.charAt(i) == '/')
                count++;
        }

        return -1;
    }
    
}
