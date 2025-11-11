package PhieuPhat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
// import java.time.LocalDate;

public class DS_PhieuPhat {
    Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    private int n;
    private PhieuPhat[] dspp;

    public DS_PhieuPhat() {
        this.n = 0;
        this.dspp = new PhieuPhat[0];
    }

    public DS_PhieuPhat(int n, PhieuPhat[] dspp) {
        this.n = n;
        this.dspp = new PhieuPhat[n];
        for (int i = 0; i < n; i++) {
            this.dspp[i] = new PhieuPhat(dspp[i]);
        }
    }

    public DS_PhieuPhat(DS_PhieuPhat dspp) {
        this.n = dspp.n;
        this.dspp = new PhieuPhat[this.n];
        for (int i = 0; i < n; ++i) {
            this.dspp[i] = new PhieuPhat(dspp.dspp[i]);
        }
    }

    public int getN() {
        return n;
    }

    public PhieuPhat[] getDSPP() {
        return dspp;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSPP(PhieuPhat[] dspp) {
        this.dspp = dspp;
    }

    public void docDuLieuFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            int count = 0;
            while(br.readLine() != null) {
                count++;
            }
            br.close();

            dspp = new PhieuPhat[count];
            n = count;

            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            int index = 0;
            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length == 4) {
                    dspp[index++] = new PhieuPhat(
                        parts[0], 
                        parts[1], 
                        parts[2], 
                        Integer.parseInt(parts[3])
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
            for (PhieuPhat pp : dspp) {
                bw.write(pp.getMaPP() + "," + pp.getMaPM() + "," + pp.getMaLD() + "," + pp.getSoTienPhat());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nhap() {
        System.out.print("# Nhập vào số lượng phiếu phạt: ");
        this.n = sc.nextInt();
        sc.nextLine();

        this.dspp = new PhieuPhat[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("# Nhập vào thông tin phiếu phạt thứ " + (i + 1) + ":");
            this.dspp[i] = new PhieuPhat();
            this.dspp[i].nhap();
        }
    }

    public void xuat() {
        System.out.printf("+-%-20s-+-%-20s-+-%-20s-+-%-20s-+\n", "--------------------", "--------------------", "--------------------", "--------------------");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n", "Mã phiếu phạt", "Mã phiếu mượn", "Mã lý do", "Số tiền phạt");
        System.out.printf("+-%-20s-+-%-20s-+-%-20s-+-%-20s-+\n", "--------------------", "--------------------", "--------------------", "--------------------");
        for (int i = 0; i < n; ++i) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n", dspp[i].getMaPP(), dspp[i].getMaPM(), dspp[i].getMaLD(), dspp[i].getSoTienPhat());
        }
        System.out.printf("+-%-20s-+-%-20s-+-%-20s-+-%-20s-+\n", "--------------------", "--------------------", "--------------------", "--------------------");
    }

    public void themPP() {
        n++;
        dspp = Arrays.copyOf(dspp, n);
        System.out.println("# Nhập thông tin phiếu phạt cần thêm vào: ");
        dspp[n - 1] = new PhieuPhat();
        dspp[n - 1].nhap();
        System.out.println("# Thêm thông tin phiếu phạt thành công!");
    }

    public void themPP(PhieuPhat pp) {
        n++;
        dspp = Arrays.copyOf(dspp, n);
        dspp[n - 1] = new PhieuPhat(pp);
    }

    public void xoaPP() {
        System.out.print("# Nhập vào mã phiếu phạt cần xoá: ");
        String ms = sc.nextLine();

        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dspp[i].getMaPP())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int j = i; j < n - 1; ++j) {
                dspp[j] = dspp[j + 1];
            }
            n--;
            dspp = Arrays.copyOf(dspp, n);
            System.out.println("# Xoá phiếu phạt thành công!");
        } else {
            System.out.println("# Không tồn tại mã số phiếu phạt!");
        }
    }

    public void xoaPP(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dspp[i].getMaPP())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int j = i; j < n - 1; ++j) {
                dspp[j] = dspp[j + 1];
            }
            n--;
            dspp = Arrays.copyOf(dspp, n);
            System.out.println("# Xoá phiếu phạt thành công!");
        } else {
            System.out.println("# Không tồn tại mã số phiếu phạt!");
        }
    }

    public void suaTTPP() {
        System.out.print("# Nhập vào mã phiếu phạt cần sửa thông tin: ");
        String ms = sc.nextLine();
        int i;
        boolean flag = false;
        for (i = 0; i < n; i++) {
            if (ms.equals(dspp[i].getMaPP())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            boolean running = true;
            while (running) {
                System.out.println("-----------");
                System.out.println("1. Mã phiếu mượn.");
                System.out.println("2. Mã lý do.");
                System.out.println("3. Số tiền phạt.");
                System.out.println("0. Thoát.");
                System.out.println("-----------");

                System.out.print("# Nhập lựa chọn cần sửa: ");
                int choosen = sc.nextInt();
                sc.nextLine();

                switch (choosen) {
                    case 1: {
                        System.out.print("# Nhập vào mã phiếu mượn cần sửa: ");
                        
                        String ma = sc.nextLine();
                        dspp[i].setMaPM(ma);
                        System.out.println("# Đổi mã phiếu mượn thành công!");
                        System.out.println();
                        break;
                    }
                    case 2: {
                        System.out.print("# Nhập mã lý do cần sửa: ");
                        
                        String ma = sc.nextLine();
                        dspp[i].setMaLD(ma);
                        System.out.println("# Đổi mã lý do thành công: ");
                        System.out.println();
                        break;
                    }
                    case 3: {
                        System.out.print("# Nhập số tiền phạt cần sửa: ");
                        
                        int t = sc.nextInt();
                        sc.nextLine();

                        dspp[i].setSoTienPhat(t);
                        System.out.println("# Đổi số tiền phạt thành công!");
                        System.out.println();
                        break;
                    }
                    
                    case 0: {
                        running = false;
                        break;
                    }
                }

                if (!running) break;

                System.out.print("# Bạn có muốn tiếp tục với chức năng này không (y/n): ");
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

    public void timKiemTTPP() {
        System.out.print("# Nhập vào mã số phiếu phạt cần tìm: ");
        String ms = sc.nextLine();

        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dspp[i].getMaPP())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tồn tại mã số phiếu phạt này!");
            return;
        }

        System.out.println();
        System.out.println("* Kết quả tìm kiếm *");
        dspp[i].xuat();
    }

    public void timKiemTTPP(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dspp[i].getMaPP())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tồn tại mã số phiếu phạt này!");
            return;
        }

        System.out.println();
        System.out.println("* Kết quả tìm kiếm *");
        dspp[i].xuat();
    }

    public PhieuPhat timKiem_TTPP(String ms) {
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dspp[i].getMaPP())) {
                return dspp[i];
            }
        }
        return null;
    }

    







}
