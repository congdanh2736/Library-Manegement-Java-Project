package NhanVien;

import java.util.Arrays;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

public class DS_NhanVien {
    Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    private int n;
    private NhanVien[] dsnv;
    
    public DS_NhanVien() {
        n = 0;
        dsnv = new NhanVien[0];
    }

    public DS_NhanVien(int n, NhanVien[] nv) {
        this.n = n;
        this.dsnv = nv;
    }

    public DS_NhanVien(DS_NhanVien dsnv) {
        this.n = dsnv.n;
        this.dsnv = dsnv.dsnv;
    }

    public int getN() {
        return n;
    }

    public NhanVien[] getDSNhanVien() {
        return dsnv;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSNhanVien(NhanVien[] dsnv) {
        this.n = dsnv.length;
        this.dsnv = new NhanVien[n];
        for (int i = 0; i < dsnv.length; ++i) {
            this.dsnv[i] = new NhanVien(dsnv[i]);
        }
    }

    public void docDuLieuFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            int count = 0;
            while(br.readLine() != null) {
                count++;
            }
            br.close();

            dsnv = new NhanVien[count];
            n = count;

            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            int index = 0;
            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length == 8) {
                    dsnv[index++] = new NhanVien(
                        parts[0], 
                        parts[1], 
                        parts[2], 
                        parts[3], 
                        parts[4], 
                        parts[5], 
                        parts[6],
                        Integer.parseInt(parts[7])
                    );
                } else {
                    System.out.println("# Du lieu hong hop le!!");
                }
            }
            br2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ghiDuLieuFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (NhanVien nv : dsnv) {
                bw.write(nv.getMaNV() + "," + nv.getHo() + "," + nv.getTen() + "," + nv.getNS() + "," + nv.getGT() + "," + nv.getSDT() + "," + nv.getDC() + "," + nv.getLuong());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nhap() {
        System.out.print("# Nhập vào số lượng nhân viên: ");
        this.n = sc.nextInt();
        sc.nextLine();

        this.dsnv = new NhanVien[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("# Nhập thông tin nhân viên thứ " + (i + 1) + ": ");
            dsnv[i] = new NhanVien();
            dsnv[i].nhap();
            System.out.println();
        }
    }

    public void xuat() {
        System.out.printf("+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+\n", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã nhân viên", "Họ", "Tên", "Ngày sinh", "Giới tính",  "Địa chỉ", "Số điện thoại", "Lương");
        System.out.printf("+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+\n", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------");
        for (int i = 0; i < n; ++i) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20d |\n", dsnv[i].getMaNV(), dsnv[i].getHo(), dsnv[i].getTen(), dsnv[i].getNS(), dsnv[i].getGT(), dsnv[i].getDC(), dsnv[i].getSDT(), dsnv[i].getLuong());
        }
        System.out.printf("+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+-%-20s-+\n", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------");
    }

    public void themNV() {
        n++;
        dsnv = Arrays.copyOf(dsnv, n);
        System.out.println("# Nhập thông tin nhân viên cần thêm vào: ");
        dsnv[n - 1] = new NhanVien();
        dsnv[n - 1].nhap();
        System.out.println("# Thêm thông tin nhân viên thành công!");
    }

    public void themNV(NhanVien nv) {
        n++;
        dsnv = Arrays.copyOf(dsnv, n);
        dsnv[n - 1] = new NhanVien(nv);
    }

    public void xoaNV() {
        System.out.print("# Nhập vào mã số nhân viên cần xoá: ");
        String ms = sc.nextLine();

        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsnv[i].getMaNV())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int j = i; j < n - 1; ++j) {
                dsnv[j] = dsnv[j + 1];
            }
            n--;
            dsnv = Arrays.copyOf(dsnv, n);
            System.out.println("# Xoá thông tin nhân viên thành công!");
        } else {
            System.out.println("# Không tồn tại mã số nhân viên!");
        }
    }

    public void xoaNV(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsnv[i].getMaNV())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int j = i; j < n - 1; ++j) {
                dsnv[j] = dsnv[j + 1];
            }
            n--;
            dsnv = Arrays.copyOf(dsnv, n);
            System.out.println("# Xoá thông tin nhân viên!");
        } else {
            System.out.println("# Không tồn tại mã số nhân viên!");
        }
    }

    public boolean isValidDay(String day) {
        String dateStr = day;

        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("d/M/yyyy").toFormatter();

        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void suaTTNV() {
        System.out.print("# Nhập vào mã nhân viên cần sửa thông tin: ");
        String ms = sc.nextLine();
        int i;
        boolean flag = false;
        for (i = 0; i < n; i++) {
            if (ms.equals(dsnv[i].getMaNV())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            boolean running = true;
            while (running) {
                System.out.println("-----------");
                System.out.println("1. Họ.");
                System.out.println("2. Tên.");
                System.out.println("3. Ngày sinh.");
                System.out.println("4. Giới tính.");
                System.out.println("5. Địa chỉ.");
                System.out.println("6. Số điện thoại.");
                System.out.println("7. Lương.");
                System.out.println("0. Thoát.");
                System.out.println("-----------");

                System.out.print("# Nhập lựa chọn cần sửa: ");
                int choosen = sc.nextInt();
                sc.nextLine();

                switch (choosen) {
                    case 1: {
                        System.out.print("# Nhập vào họ cần sửa: ");
                        
                        String ho = sc.nextLine();
                        dsnv[i].setHo(ho);
                        System.out.println("# Đổi họ thành công!");
                        System.out.println();
                        break;
                    }
                    case 2: {
                        System.out.print("# Nhập tên cần sửa: ");
                        
                        String ten = sc.nextLine();
                        dsnv[i].setTen(ten);
                        System.out.println("# Đổi tên thành công: ");
                        System.out.println();
                        break;
                    }
                    case 3: {
                        System.out.print("# Nhập ngày sinh cần sửa: ");
                        
                        String ngaysinh = sc.nextLine();

                        while (!isValidDay(ngaysinh)) {
                            System.out.println("# Ngày sinh nhập vào không hợp lệ !");
                            System.out.print("# Vui lòng nhập lại: ");
                            ngaysinh = sc.nextLine();
                        }

                        dsnv[i].setNS(ngaysinh);
                        System.out.println("# Đổi ngày sinh thành công!");
                        System.out.println();
                        break;
                    }
                    case 4: {
                        System.out.print("# Nhập giới tính cần sửa: ");
                        
                        String diachi = sc.nextLine();
                        dsnv[i].setDC(diachi);
                        System.out.println("# Đổi giới tính thành công!");
                        System.out.println();
                        break;
                    }
                    case 5: {
                        System.out.print("# Nhập địa chỉ cần sửa: ");
                        
                        String diachi = sc.nextLine();
                        dsnv[i].setDC(diachi);
                        System.out.println("# Đổi địa chỉ thành công!");
                        System.out.println();
                        break;
                    }
                    case 6: {
                        System.out.print("# Nhập số điện thoại cuẩ sửa: ");
                        
                        String nganh = sc.nextLine();
                        dsnv[i].setSDT(nganh);
                        System.out.println("# Đổi số điện thoại thành công!");
                        System.out.println();
                        break;
                    }
                    case 7: {
                        System.out.print("# Nhập lương cần sửa: ");
                        
                        int luong = sc.nextInt();
                        sc.nextLine();

                        dsnv[i].setLuong(luong);
                        System.out.println("# Đổi lương thành công!");
                        System.out.println();
                        break;
                    }

                    case 0: {
                        running = false;
                        break;
                    }
                }

                if (!running) break;

                System.out.print("# Bạn có muốn tiếp tục với chức năng sửa không (y/n): ");
                String c = sc.nextLine();

                while (!c.equalsIgnoreCase("n") && !c.equalsIgnoreCase("y")) {
                    System.out.println("# Chỉ được nhập y hoặc n!!!");
                    System.out.print("# Nhập lại (y/n): ");
                    c = sc.nextLine();
                }

                if (c.equals("n") || c.equals("N")) {
                    break;
                }

            }
        } else {
            System.out.println("# Mã số nhân viên không tồn tại!!!");
        }
    }

    public void timKiemTTNV() {
        System.out.print("# Nhập vào mã số nhân viên cần tìm: ");
        String ms = sc.nextLine();

        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsnv[i].getMaNV())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tồn tại mã số nhân viên này!");
            return;
        }

        System.out.println();
        System.out.println("* Kết quả tìm kiếm *");
        dsnv[i].xuat();
    }

    public void timKiemTTNV(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsnv[i].getMaNV())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tồn tại mã số nhân viên này!");
            return;
        }

        System.out.println();
        System.out.println("* Kết quả tìm kiếm *");
        dsnv[i].xuat();
    }

    public NhanVien timKiem_TTNV(String ms) {
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsnv[i].getMaNV())) {
                return dsnv[i];
            }
        }

        return null;
    }

    public void timKiemTTNV_ho() {
        System.out.print("# Nhập vào họ nhân viên cần tìm: ");
        String ho = sc.nextLine();
        System.out.println();

        System.out.println("# Danh sách nhân viên có họ là " + ho + ": ");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã nhân viên", "Họ", "Tên", "Ngày sinh", "Giới tính",  "Địa chỉ", "Số điện thoại", "Lương");
        for (int i = 0; i < n; ++i) {
            if (ho.equals(dsnv[i].getHo()))
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsnv[i].getMaNV(), dsnv[i].getHo(), dsnv[i].getTen(), dsnv[i].getNS(), dsnv[i].getGT(), dsnv[i].getDC(), dsnv[i].getSDT(), dsnv[i].getLuong());
        }
    }

    public void timKiemTTNV_ho(String ho) {
        System.out.println("# Danh sách nhân viên có họ là " + ho + ": ");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã nhân viên", "Họ", "Tên", "Ngày sinh", "Giới tính",  "Địa chỉ", "Số điện thoại", "Lương");
        for (int i = 0; i < n; ++i) {
            if (ho.equals(dsnv[i].getHo()))
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsnv[i].getMaNV(), dsnv[i].getHo(), dsnv[i].getTen(), dsnv[i].getNS(), dsnv[i].getGT(), dsnv[i].getDC(), dsnv[i].getSDT(), dsnv[i].getLuong());
        }
    }

    public void timKiemTTNV_ten() {
        System.out.print("# Nhập vào tên nhân viên cần tìm: ");
        String ten = sc.nextLine();
        System.out.println();

        System.out.println("# Danh sách có tên là " + ten + ": ");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã nhân viên", "Họ", "Tên", "Ngày sinh", "Giới tính",  "Địa chỉ", "Số điện thoại", "Lương");
        for (int i = 0; i < n; ++i) {
            if (ten.equals(dsnv[i].getTen()))
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsnv[i].getMaNV(), dsnv[i].getHo(), dsnv[i].getTen(), dsnv[i].getNS(), dsnv[i].getGT(), dsnv[i].getDC(), dsnv[i].getSDT(), dsnv[i].getLuong());
        }
    }

    public void timKiemTTNV_ten(String ten) {
        System.out.println("# Danh sách có tên là " + ten + ": ");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã nhân viên", "Họ", "Tên", "Ngày sinh", "Giới tính",  "Địa chỉ", "Số điện thoại", "Lương");
        for (int i = 0; i < n; ++i) {
            if (ten.equals(dsnv[i].getTen()))
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsnv[i].getMaNV(), dsnv[i].getHo(), dsnv[i].getTen(), dsnv[i].getNS(), dsnv[i].getGT(), dsnv[i].getDC(), dsnv[i].getSDT(), dsnv[i].getLuong());
        }
    }

    public void thongke() {
        System.out.println("1. Thống kê theo giới tính.");
        System.out.println("2. Thống kê theo độ tuổi.");
        System.out.print("# Nhập vào lựa chọn: ");
        int choosen = sc.nextInt();
        sc.nextLine();

        switch (choosen) {
            case 1:
                int nam = 0;
                int nu = 0;

                for (int i = 0; i < n; ++i) {
                    if (dsnv[i].getGT().equalsIgnoreCase("nam")) nam++;
                    if (dsnv[i].getGT().equalsIgnoreCase("nu")) nu++;
                }

                System.out.println("# Số lượng nhân viên là nam: " + nam);
                System.out.println("# Số lượng nhân viên là nu: " + nu);

                break;

            case 2:
                int[] tuoi = new int[200];
                int t = 0;
                int year = LocalDate.now().getYear();

                for (int i = 0; i < n; ++i) {
                    t = year - Integer.parseInt(dsnv[i].getNS().substring(6));
                    tuoi[t]++;
                }

                for (int i = 0; i < 200; ++i) {
                    if (tuoi[i] != 0) {
                        System.out.println("# Số nhân viên " + i + " tuổi: " + tuoi[i]);
                    }
                }

                break;
        
            default:
                break;
        }
    }

    public void thongKeGioiTinh() {
        int nam = 0;
        int nu = 0;

        for (int i = 0; i < n; ++i) {
            if (dsnv[i].getGT().equalsIgnoreCase("nam")) nam++;
            if (dsnv[i].getGT().equalsIgnoreCase("nu")) nu++;
        }

        System.out.println("# Số lượng nhân viên là nam: " + nam);
        System.out.println("# Số lượng nhân viên là nữ: " + nu);
    }

    public void thongKeTuoi() {
        int[] tuoi = new int[200];
        int t = 0;
        int year = LocalDate.now().getYear();
        int idx;

        for (int i = 0; i < n; ++i) {
            idx = getIndexOfYear(dsnv[i].getNS());
            t = year - Integer.parseInt(dsnv[i].getNS().substring(idx));
            tuoi[t]++;
        }

        for (int i = 0; i < 200; ++i) {
            if (tuoi[i] != 0) {
                System.out.println("# Số nhân viên " + i + " tuổi: " + tuoi[i]);
            }
        }
    }

    public int getIndexOfYear(String str) {
        int count = 0;
        int index;
        for (index = 0; index < str.length(); index++) {
            if (count == 2) 
                return index;

            if (str.charAt(index) == '/')
                count++;
        }

        return -1;
    }

}
