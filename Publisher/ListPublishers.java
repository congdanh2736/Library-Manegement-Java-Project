package Publisher;

import java.io.*;
import java.util.*;

public class ListPublishers {
    Scanner ip = new Scanner(System.in);
    public Publishers[] dsnxb = new  Publishers[0];

    public ListPublishers(){}

    public void show(){
        System.out.println("[ THƯ VIỆN ONLINE - DANH SÁCH CÁC NHÀ XUẤT BẢN ]");
        System.out.printf("%-30s %-30s %-30s %-30s %-30s\n", "Mã nhà xuất bản", "Tên nhà xuấn bản", "Địa chỉ", "SDT", "Email");
        for(int i = 0; i < dsnxb.length; i++){
            System.out.printf("%-30s %-30s %-30s %-30s %-30s\n", dsnxb[i].getMaNXB(), dsnxb[i].getTenNXB(), dsnxb[i].getMaDiaChi(), dsnxb[i].getSDT(), dsnxb[i].getEmail());
        }
    }

    public void add(){
        System.out.println("[ THƯ VIỆN ONLINE - THÊM NHÀ XUẤT BẢN ]");

        System.out.println(">> Nhập mã nhà xuất bản: ");
        String mnxb = ip.nextLine();

        System.out.print(">> Nhập tên nhà xuất bản: ");
        String ten = ip.nextLine();

        System.out.print(">> Nhập địa chỉ: ");
        String mdc = ip.nextLine();

        System.out.print(">> Nhập số điện thoại: ");
        String sdt = ip.nextLine();

        while (sdt.length() != 10 || sdt.charAt(0) != '0') {
            System.out.println("# Số điện thoại nhập không hợp lệ !");
            System.out.print("# Vui lòng nhập lại: ");
            sdt = ip.nextLine();
        }
        
        System.out.print(">> Nhập địa chỉ email: ");
        String email = ip.nextLine();

        dsnxb = Arrays.copyOf(dsnxb, dsnxb.length+1);
        dsnxb[dsnxb.length - 1] = new Publishers(mnxb, ten, mdc, sdt, email);
        System.out.println(">> Đã thêm nhà xuất bản");
        // writeToFile();
    }

    public void remove(){
        System.out.println("[ THƯ VIỆN ONLINE - XÓA NHÀ XUẤT BẢN ]");
        System.out.print(">> Nhập mã nhà xuất bản cần xóa: ");
        String mnxb = ip.nextLine();

        int index = -1;
        for (int i = 0; i < dsnxb.length; i++) {
            if (dsnxb[i].getMaNXB().equalsIgnoreCase(mnxb)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Không tìm thấy nhà xuất bản có mã: " + mnxb);
            return;
        }

        Publishers[] temp = new Publishers[dsnxb.length - 1];
        for (int i = 0, j = 0; i < dsnxb.length; i++) {
            if (i != index) {
                temp[j++] = dsnxb[i];
            }
        }

        dsnxb = temp;
        System.out.println("Đã xóa nhà xuất bản có mã: " + mnxb);
        // writeToFile();

    }

    public void changeInformation(){
        System.out.println("[ THƯ VIỆN ONLINE - CẬP NHẬT NHÀ XUẤT BẢN ]");
        System.out.print(">> Nhập mã nhà xuất bản cần cập nhật: ");
        String mnxb = ip.nextLine();

        int index = -1;
        for (int i = 0; i < dsnxb.length; i++) {
            if (dsnxb[i].getMaNXB().equalsIgnoreCase(mnxb)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println(">> Không tìm thấy nhà xuất bản có mã: " + mnxb);
            return;
        }

        Publishers p = dsnxb[index];
        System.out.println(">> Chọn thông tin cần cập nhật:");
        System.out.println("1. Địa chỉ");
        System.out.println("2. Số điện thoại");
        System.out.println("3. Email");
        System.out.print(">> Nhập lựa chọn: ");
        int choice = Integer.parseInt(ip.nextLine());

        switch (choice) {
            case 1:
                System.out.print(">> Nhập địa chỉ mới: ");
                p.setMaDiaChi(ip.nextLine());
                break;
            case 2:
                System.out.print(">> Nhập số điện thoại mới: ");
                p.setSDT(ip.nextLine());
                break;
            case 3:
                System.out.print(">> Nhập email mới: ");
                p.setEmail(ip.nextLine());
                break;
            default:
                System.out.println(">> Lựa chọn không hợp lệ.");
                return;
        }

        System.out.println(">> Đã cập nhật thông tin nhà xuất bản.");
        // writeToFile();
    }

    public void find(){
        System.out.println("[ THƯ VIỆN ONLINE - TÌM KIẾM NHÀ XUẤT BẢN ]");
        System.out.print(">> Nhập từ khóa (mã hoặc email hoặc SDT): ");
        String a = ip.nextLine().toLowerCase();

        boolean found = false;
        System.out.println(">> Danh sách các nhà xuất bản phù hợp: ");
        for (int i = 0; i < dsnxb.length; i++) {
            if (dsnxb[i].getMaNXB().toLowerCase().contains(a) ||
                    dsnxb[i].getEmail().toLowerCase().contains(a) ||
                    dsnxb[i].getSDT().toLowerCase().contains(a)) {
                System.out.printf("%-30s %-30s %-30s\n", dsnxb[i].getMaNXB(), dsnxb[i].getSDT(), dsnxb[i].getEmail());
                found = true;
            }
        }

        if (!found) {
            System.out.println(">> Không tìm thấy nhà xuất bản nào phù hợp.");
        }
    }

    public Publishers timKiem_TTNXB(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < dsnxb.length; ++i) {
            if (ms.equals(dsnxb[i].getMaNXB())) {
                flag = true;
                return dsnxb[i];
            }
        }
        
        if (!flag) {
            System.out.println("# Không tồn tại mã số nhà xuất bản này!");
        }

        return null;
    }

    public void readFromFile(String filename){
        File f = new File(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String maNXB = parts[0];
                    String tenNXB = parts[1];
                    String diaChi = parts[2];
                    String sdt = parts[3];
                    String email = parts[4];

                    dsnxb = Arrays.copyOf(dsnxb, dsnxb.length + 1);
                    dsnxb[dsnxb.length - 1] = new Publishers(maNXB, tenNXB,  diaChi, sdt, email);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void writeToFile(String filename) {
        File f = new File(filename);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 0; i < dsnxb.length; i++) {
                String line = String.format("%s,%s,%s,%s,%s",
                        dsnxb[i].getMaNXB(),
                        dsnxb[i].getTenNXB(),
                        dsnxb[i].getMaDiaChi(),
                        dsnxb[i].getSDT(),
                        dsnxb[i].getEmail()
                );
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
