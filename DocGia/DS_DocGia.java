package DocGia;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.*;

public class DS_DocGia {
    Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    private int n;
    private DocGia[] dsdg;
    
    public DS_DocGia() {
        n = 0;
        dsdg = new DocGia[0];
    }

    public DS_DocGia(int n, DocGia[] dg) {
        this.n = n;
        this.dsdg = dg;
    }

    public DS_DocGia(DS_DocGia dsdg) {
        this.n = dsdg.n;
        this.dsdg = dsdg.dsdg;
    }

    public int getN() {
        return n;
    }

    public DocGia[] getDSDocGia() {
        return dsdg;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSDocGia(DocGia[] dsdg) {
        this.n = dsdg.length;
        this.dsdg = new DocGia[n];
        for (int i = 0; i < dsdg.length; ++i) {
            this.dsdg[i] = new DocGia(dsdg[i]);
        }
    }

    // public boolean kiemTraSlash(String ngay) {
    //     int count = 0;
    //     for (int i = 0; i < ngay.length(); ++i) 
    //         if (ngay.charAt(i) == '/')
    //             count++;
    //     return count == 2;
    // }

    // public void rangBuocNgay(StringBuilder ngay) {
    //     while (ngay.length() != 10 || !kiemTraSlash(ngay.toString())) {
    //         System.out.println("# Error: Ngày nhập không hợp lệ !");
    //         System.out.print("# Vui lòng nhập lại (DD/MM/YYYY): ");
    //         ngay.setLength(0);
    //         ngay.append(sc.nextLine());
    //     }
    //     int d = Integer.parseInt(ngay.substring(0, 2));
    //     int m = Integer.parseInt(ngay.substring(3, 5));
    //     int y = Integer.parseInt(ngay.substring(6, 10));        
    //     while (d > 31) {
    //         System.out.println("# Error: Ngày phải bé hơn hoặc bằng 31!");
    //         System.out.print("# Vui lòng nhập lại (DD/MM/YYYY): ");
    //         ngay.setLength(0);
    //         ngay.append(sc.nextLine());
    //         d = Integer.parseInt(ngay.substring(0, 2));
    //     }
    //     while (m > 12) {
    //         System.out.println("# Error: Tháng phải bé hơn hoặc bằng 12!");
    //         System.out.print("# Vui lòng nhập lại (DD/MM/YYYY): ");
    //         ngay.setLength(0);
    //         ngay.append(sc.nextLine());
    //         m = Integer.parseInt(ngay.substring(3, 5));
    //     }
    //     while (y > LocalDate.now().getYear()) {
    //         System.out.println("# Error: Năm phải bé hơn " + LocalDate.now().getYear() + "!");
    //         System.out.print("# Vui lòng nhập lại (DD/MM/YYYY): ");
    //         ngay.setLength(0);
    //         ngay.append(sc.nextLine());
    //         y = Integer.parseInt(ngay.substring(6, 10));
    //     }
    // }

    public void docDuLieuFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            int count = 0;
            while(br.readLine() != null) {
                count++;
            }
            br.close();

            dsdg = new DocGia[count];
            n = count;

            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            int index = 0;
            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length == 8) {
                    dsdg[index++] = new DocGia(
                        parts[0], 
                        parts[1], 
                        parts[2], 
                        parts[3], 
                        parts[4], 
                        parts[5], 
                        parts[6], 
                        parts[7]
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
            for (int i = 0; i < n; ++i) {
                bw.write(dsdg[i].getMaDocGia() + "," + dsdg[i].getHo() + "," + dsdg[i].getTen() + "," + dsdg[i].getNS() + "," + dsdg[i].getGT() + "," + dsdg[i].getDC() + "," + dsdg[i].getSDT() + "," + dsdg[i].getNLT());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nhap() {
        System.out.print("# Nhập vào số lượng độc giả: ");
        this.n = sc.nextInt();
        sc.nextLine();

        this.dsdg = new DocGia[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("# Nhập thông tin độc giả thứ " + (i + 1) + ": ");
            dsdg[i] = new DocGia();
            dsdg[i].nhap();
            System.out.println();
        }
    }

    public void xuat() {
        System.out.printf("+ %-20s + %-20s + %-20s + %-20s + %-20s + %-20s + %-20s + %-20s +\n", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã độc giả", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại", "Ngày lập thẻ");
        System.out.printf("+ %-20s + %-20s + %-20s + %-20s + %-20s + %-20s + %-20s + %-20s +\n", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------");
        for (int i = 0; i < n; ++i) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsdg[i].getMaDocGia(), dsdg[i].getHo(), dsdg[i].getTen(), dsdg[i].getNS(), dsdg[i].getGT(), dsdg[i].getDC(), dsdg[i].getSDT(), dsdg[i].getNLT());
        }
        System.out.printf("+ %-20s + %-20s + %-20s + %-20s + %-20s + %-20s + %-20s + %-20s +\n", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------");
    }

    public void themDG() {
        n++;
        dsdg = Arrays.copyOf(dsdg, n);
        System.out.println("# Nhập thông tin độc giả cần thêm vào: ");
        dsdg[n - 1] = new DocGia();
        dsdg[n - 1].nhap();
        System.out.println("# Thêm thông tin độc giả thành công!");
    }

    public void themDG(DocGia dg) {
        n++;
        dsdg = Arrays.copyOf(dsdg, n);
        dsdg[n - 1] = new DocGia(dg);
    }

    public void xoaDG() {
        System.out.print("# Nhập vào mã số độc giả cần xoá: ");
        String ms = sc.nextLine();

        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsdg[i].getMaDocGia())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int j = i; j < n - 1; ++j) {
                dsdg[j] = dsdg[j + 1];
            }
            n--;
            dsdg = Arrays.copyOf(dsdg, n);
            System.out.println("# Xoá thông tin độc giả thành công!");
        } else {
            System.out.println("# Không tồn tại mã số độc giả!");
        }
    }

    public void xoaDG(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsdg[i].getMaDocGia())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int j = i; j < n - 1; ++j) {
                dsdg[j] = dsdg[j + 1];
            }
            n--;
            dsdg = Arrays.copyOf(dsdg, n);
            System.out.println("# Xoá thông tin độc giả!");
        } else {
            System.out.println("# Không tồn tại mã số độc giả!");
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

    public void suaTTDG() {
        System.out.print("# Nhập vào mã độc giả cần sửa thông tin: ");
        String ms = sc.nextLine();
        int i;
        boolean flag = false;
        for (i = 0; i < n; i++) {
            if (ms.equals(dsdg[i].getMaDocGia())) {
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
                System.out.println("7. Ngày lập thẻ.");
                System.out.println("0. Thoát.");
                System.out.println("-----------");

                System.out.print("# Nhập lựa chọn cần sửa: ");
                int choosen = sc.nextInt();
                sc.nextLine();

                switch (choosen) {
                    case 1: {
                        System.out.print("# Nhập vào họ cần sửa: ");
                        
                        String ho = sc.nextLine();
                        dsdg[i].setHo(ho);
                        System.out.println("# Đổi họ thành công!");
                        System.out.println();
                        break;
                    }
                    case 2: {
                        System.out.print("# Nhập tên cần sửa: ");
                        
                        String ten = sc.nextLine();
                        dsdg[i].setTen(ten);
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

                        dsdg[i].setNS(ngaysinh);
                        System.out.println("# Đổi ngày sinh thành công!");
                        System.out.println();
                        break;
                    }
                    case 4: {
                        System.out.print("# Nhập giới tính cần sửa: ");
                        
                        String gt = sc.nextLine();
                        dsdg[i].setGT(gt);
                        System.out.println("# Đổi giới tính thành công!");
                        System.out.println();
                        break;
                    }
                    case 5: {
                        System.out.print("# Nhập địa chỉ cần sửa: ");
                        
                        String diachi = sc.nextLine();
                        dsdg[i].setDC(diachi);
                        System.out.println("# Đổi địa chỉ thành công!");
                        System.out.println();
                        break;
                    }
                    case 6: {
                        System.out.print("# Nhập số điện thoại cuẩ sửa: ");
                        
                        String nganh = sc.nextLine();
                        dsdg[i].setSDT(nganh);
                        System.out.println("# Đổi số điện thoại thành công!");
                        System.out.println();
                        break;
                    }
                    case 7: {
                        System.out.print("# Nhập ngày lập thẻ cần sửa: ");
                        
                        String nlt = sc.nextLine();
                        dsdg[i].setNLT(nlt);
                        System.out.println("# Đổi ngày lập thẻ thành công!");
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
            System.out.println("# Mã số độc giả không tồn tại!!!");
        }
    }

    public void timKiemTTDG() {
        System.out.print("# Nhập vào mã số độc giả cần tìm: ");
        String ms = sc.nextLine();

        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsdg[i].getMaDocGia())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tồn tại mã số độc giả này!");
            return;
        }

        System.out.println();
        System.out.println("* Kết quả tìm kiếm *");
        dsdg[i].xuat();
    }

    public void timKiemTTDG(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsdg[i].getMaDocGia())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tồn tại mã số độc giả này!");
            return;
        }

        System.out.println();
        System.out.println("* Kết quả tìm kiếm *");
        dsdg[i].xuat();
    }

    public DocGia timKiem_TTDG(String ms) {
        // boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsdg[i].getMaDocGia())) {
                // flag = true;
                return dsdg[i];
            }
        }
        
        // if (!flag) {
        //     System.out.println("# Không tồn tại mã số độc giả này!");
        // }

        return null;
    }

    public void timKiemTTDG_ho() {
        System.out.print("# Nhập vào họ độc giả cần tìm: ");
        String ho = sc.nextLine();
        System.out.println();

        System.out.println("# Danh sách độc giả có họ là " + ho + ": ");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã độc giả", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại", "Ngày lập thẻ");
        for (int i = 0; i < n; ++i) {
            if (ho.equals(dsdg[i].getHo()))
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsdg[i].getMaDocGia(), dsdg[i].getHo(), dsdg[i].getTen(), dsdg[i].getNS(), dsdg[i].getGT(), dsdg[i].getDC(), dsdg[i].getSDT(), dsdg[i].getNLT());
        }
    }

    public void timKiemTTDG_ho(String ho) {
        System.out.println("# Danh sách độc giả có họ là " + ho + ": ");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã độc giả", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại", "Ngày lập thẻ");
        for (int i = 0; i < n; ++i) {
            if (ho.equals(dsdg[i].getHo()))
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsdg[i].getMaDocGia(), dsdg[i].getHo(), dsdg[i].getTen(), dsdg[i].getNS(), dsdg[i].getGT(), dsdg[i].getDC(), dsdg[i].getSDT(), dsdg[i].getNLT());
        }
    }

    public void timKiemTTDG_ten() {
        System.out.print("# Nhập vào tên độc giả cần tìm: ");
        String ten = sc.nextLine();
        System.out.println();

        System.out.println("# Danh sách độc giả có tên là " + ten + ": ");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã độc giả", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại", "Ngày lập thẻ");
        for (int i = 0; i < n; ++i) {
            if (ten.equals(dsdg[i].getTen()))
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsdg[i].getMaDocGia(), dsdg[i].getHo(), dsdg[i].getTen(), dsdg[i].getNS(), dsdg[i].getGT(), dsdg[i].getDC(), dsdg[i].getSDT(), dsdg[i].getNLT());
        }
    }

    public void timKiemTTDG_ten(String ten) {
        System.out.println("# Danh sách độc giả có tên là " + ten + ": ");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Mã độc giả", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại", "Ngày lập thẻ");
        for (int i = 0; i < n; ++i) {
            if (ten.equals(dsdg[i].getTen()))
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", dsdg[i].getMaDocGia(), dsdg[i].getHo(), dsdg[i].getTen(), dsdg[i].getNS(), dsdg[i].getGT(), dsdg[i].getDC(), dsdg[i].getSDT(), dsdg[i].getNLT());
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
                    if (dsdg[i].getGT().equalsIgnoreCase("nam")) nam++;
                    if (dsdg[i].getGT().equalsIgnoreCase("nữ")) nu++;
                }

                System.out.println("# Số lượng độc giả là nam: " + nam);
                System.out.println("# Số lượng độc giả là nu: " + nu);

                break;

            case 2:
                int[] tuoi = new int[200];
                int t = 0;
                int year = LocalDate.now().getYear();

                for (int i = 0; i < n; ++i) {
                    t = year - Integer.parseInt(dsdg[i].getNS().substring(6));
                    tuoi[t]++;
                }

                for (int i = 0; i < 200; ++i) {
                    if (tuoi[i] != 0) {
                        System.out.println("# Số độc giả " + i + " tuổi: " + tuoi[i]);
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
            if (dsdg[i].getGT().equalsIgnoreCase("nam")) nam++;
            if (dsdg[i].getGT().equalsIgnoreCase("nu")) nu++;
        }

        System.out.println("# Số lượng độc giả là nam: " + nam);
        System.out.println("# Số lượng độc giả là nu: " + nu);  
    }

    public void thongKeTuoi() {
        int[] tuoi = new int[200];
        int t = 0;
        int year = LocalDate.now().getYear();
        int idx = 0;

        for (int i = 0; i < n; ++i) {
            idx = getIndexOfYear(dsdg[i].getNS()); 

            t = year - Integer.parseInt(dsdg[i].getNS().substring(idx)) + 1;
            tuoi[t]++;
        }

        for (int i = 0; i < 200; ++i) {
            if (tuoi[i] != 0) {
                System.out.println("# Số độc giả " + i + " tuổi: " + tuoi[i]);
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
