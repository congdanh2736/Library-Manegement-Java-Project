package QuyDinhPhat;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
// import java.time.LocalDate;

public class DS_QuyDinhPhat {
    Scanner sc = new Scanner(System.in);

    private int n;
    private QuyDinhPhat[] dsqdp;

    public DS_QuyDinhPhat() {
        this.n = 0;
        this.dsqdp = new QuyDinhPhat[0];
    }

    public DS_QuyDinhPhat(int n, QuyDinhPhat[] dsqdp) {
        this.n = n;
        this.dsqdp = dsqdp;
    }

    public DS_QuyDinhPhat(DS_QuyDinhPhat ds) {
        this.n = ds.n;
        this.dsqdp = ds.dsqdp;
    }

    public int getN() {
        return n;
    }

    public QuyDinhPhat[] getDSQDP() {
        return dsqdp;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setDSQDP(QuyDinhPhat[] dsqdp) {
        this.dsqdp = dsqdp;
    }
    public void docDuLieuFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            int count = 0;
            while(br.readLine() != null) {
                count++;
            }
            br.close();

            dsqdp = new QuyDinhPhat[count];
            n = count;

            BufferedReader br2 = new BufferedReader(new FileReader(filename));
            int index = 0;
            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length == 4) {
                    dsqdp[index++] = new QuyDinhPhat(
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
            for (int i = 0; i < n; ++i) {
                bw.write(dsqdp[i].getMaLD() + "," + dsqdp[i].getTenLD() + "," + dsqdp[i].getCachThuc() + "," + dsqdp[i].getSoTien());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nhap() {
        System.out.print("# Nhập vào số lượng quy định phạt: ");
        this.n = sc.nextInt();

        this.dsqdp = new QuyDinhPhat[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("# Nhập vào thông tin quy định phạt thứ " + (i + 1) + ":");
            this.dsqdp[i] = new QuyDinhPhat();
            this.dsqdp[i].nhap();
        }
    }

    public void xuat() {
        System.out.printf("+-%-20s-+-%-30s-+-%-50s-+-%-20s-+\n", "--------------------", "------------------------------", "--------------------------------------------------", "--------------------");
        System.out.printf("| %-20s | %-30s | %-50s | %-20s |\n", "Mã lý do", "Tên lý do", "Cách thức", "Số tiền phạt");
        System.out.printf("+-%-20s-+-%-30s-+-%-50s-+-%-20s-+\n", "--------------------", "------------------------------", "--------------------------------------------------", "--------------------");
        for (int i = 0; i < n; ++i) {
            System.out.printf("| %-20s | %-30s | %-50s | %-20d |\n", this.dsqdp[i].getMaLD(), this.dsqdp[i].getTenLD(), this.dsqdp[i].getCachThuc(), this.dsqdp[i].getSoTien());
        }
        System.out.printf("+-%-20s-+-%-30s-+-%-50s-+-%-20s-+\n", "--------------------", "------------------------------", "--------------------------------------------------", "--------------------");
    }

    public void themQD() {
        n++;
        dsqdp = Arrays.copyOf(dsqdp, n);
        System.out.println("# Nhập thông tin quy định phạt cần thêm vào: ");
        dsqdp[n - 1] = new QuyDinhPhat();
        dsqdp[n - 1].nhap();
        System.out.println("# Thêm thông tin quy định phạt thành công!");
    }

    public void themQD(QuyDinhPhat qd) {
        n++;
        dsqdp = Arrays.copyOf(dsqdp, n);
        dsqdp[n - 1] = new QuyDinhPhat(qd);
    }

    public void xoaQD() {
        System.out.print("# Nhập vào mã lý do cần xoá: ");
        String ms = sc.nextLine();

        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsqdp[i].getMaLD())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int j = i; j < n - 1; ++j) {
                dsqdp[j] = dsqdp[j + 1];
            }
            n--;
            dsqdp = Arrays.copyOf(dsqdp, n);
            System.out.println("# Xoá quy định phạt thành công!");
        } else {
            System.out.println("# Không tồn tại mã số lý do này!");
        }
    }

    public void xoaQD(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsqdp[i].getMaLD())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            for (int j = i; j < n - 1; ++j) {
                dsqdp[j] = dsqdp[j + 1];
            }
            n--;
            dsqdp = Arrays.copyOf(dsqdp, n);
            System.out.println("# Xoá quy định phạt thành công!");
        } else {
            System.out.println("# Không tồn tại mã số lý do này!");
        }
    }

    public void suaTTQD() {
        System.out.print("# Nhập vào mã lý do cần sửa thông tin: ");
        String ms = sc.nextLine();
        int i;
        boolean flag = false;
        for (i = 0; i < n; i++) {
            if (ms.equals(dsqdp[i].getMaLD())) {
                flag = true;
                break;
            }
        }

        if (flag) {
            boolean running = true;
            while (running) {
                System.out.println("-----------");
                System.out.println("1. Tên lý do.");
                System.out.println("2. Cách thức.");
                System.out.println("3. Số tiền phạt.");
                System.out.println("0. Thoát.");
                System.out.println("-----------");

                System.out.print("# Nhập lựa chọn cần sửa: ");
                int choosen = sc.nextInt();
                sc.nextLine();

                switch (choosen) {
                    case 1: {
                        System.out.print("# Nhập vào tên lý do cần sửa: ");
                        
                        String tenLD = sc.nextLine();
                        dsqdp[i].setTenLD(tenLD);
                        System.out.println("# Đổi tên lý do thành công!");
                        System.out.println();
                        break;
                    }
                    case 2: {
                        System.out.print("# Nhập cách thức cần sửa: ");
                        
                        String ct = sc.nextLine();
                        dsqdp[i].setCachThuc(ct);
                        System.out.println("# Đổi cách thức thành công: ");
                        System.out.println();
                        break;
                    }
                    case 3: {
                        System.out.print("# Nhập số tiền phạt cần sửa: ");
                        
                        int t = sc.nextInt();
                        sc.nextLine();

                        dsqdp[i].setSoTien(t);
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
            System.out.println("# Mã số lý do không tồn tại!!!");
        }
    }

    public void timKiemQD() {
        System.out.print("# Nhập vào mã số lý do cần tìm: ");
        String ms = sc.nextLine();

        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsqdp[i].getMaLD())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tồn tại mã số lý do này!");
            return;
        }

        System.out.println();
        System.out.println("* Kết quả tìm kiếm *");
        dsqdp[i].xuat();
    }

    public void timKiemQD(String ms) {
        boolean flag = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsqdp[i].getMaLD())) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tồn tại mã số lý do này!");
            return;
        }

        System.out.println();
        System.out.println("* Kết quả tìm kiếm *");
        dsqdp[i].xuat();
    }

    public QuyDinhPhat timKiem_QD(String ms) {
        int i;
        for (i = 0; i < n; ++i) {
            if (ms.equals(dsqdp[i].getMaLD())) {
                return dsqdp[i];
            }
        }

        return null;
    }

    public void generateMaQD(){
        
    }
}
