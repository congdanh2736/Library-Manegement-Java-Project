package Book;

import Book.Categogy.Education;
import Book.Categogy.Reference;

import java.io.*;
import java.util.*;

public class ListBooks implements DanhSach {
    private Books[] dss = new Books[0];
    private Scanner sc = new Scanner(System.in);

    public void them() {
        int n = dss.length + 1;
        dss = Arrays.copyOf(dss, n);
        
        System.out.println("# Loại sách: ");
        System.out.println("1. Sách giáo dục.");
        System.out.println("2. Sách tham khảo.");
        System.out.print("# Nhập vào lựa chọn: ");

        int choosen = 0;
        choosen = sc.nextInt();
        sc.nextLine();

        switch (choosen) {
            case 1: {
                dss[n - 1] = new Education();
                dss[n - 1].nhap();
                break;
            }
            
            case 2: {
                dss[n - 1] = new Reference();
                dss[n - 1].nhap();
                break;
            }

            default: {
                System.out.println("Lựa chọn không phù hợp!");
                break;
            }
        }
        System.out.println("# Thêm sách thành công!");
    }

    public void them(Books s){
        int n = dss.length;
        dss = Arrays.copyOf(dss, n + 1);
        if (s instanceof Education) {
            dss[n] = new Education((Education)s);
        } else if (s instanceof Reference) {
            dss[n] = new Reference((Reference)s);
        }
    }

    // void themSach(Books sach, String theLoai) {
    //     sach.nhap();
    //     dss = Arrays.copyOf(dss, dss.length + 1);
    //     dss[dss.length - 1] = sach;
    //     dss[dss.length - 1].setTheLoai(theLoai);
    //     // writeToFile();
    // }

    // public void add() {   
    //     System.out.println("[ THƯ VIỆN ONLINE - THÊM SÁCH ]");
    //     System.out.println("1. Sách khác");
    //     System.out.println("2. Sách giáo dục");
    //     System.out.println("3. Sách tham khảo");
    //     System.out.print("Chọn loại sách: ");
    //     int loai = sc.nextInt();
    //     sc.nextLine();
    //     // Books sach = null;
    //     switch (loai) {
    //         case 1:
    //             themSach(new Books(), "Khác");
    //             break;
    //         case 2:
    //             themSach(new Education(), "Giáo dục");
    //             break;
    //         case 3:
    //             themSach(new Reference(), "Tham khảo");
    //             break;
    //         default:
    //             System.out.println("Loại không hợp lệ.");
    //             return;
    //     }
    //     System.out.println(">> Đã thêm sách thành công.");
    // }

    public void remove() {
        System.out.println("[ THƯ VIỆN ONLINE - XÓA SÁCH ]");
        System.out.print(">> Nhập mã sách bạn muốn xóa: ");
        String ma = sc.nextLine();

        int pos = -1;
        for (int i = 0; i < dss.length; i++) {
            if (dss[i].getMaSach().equals(ma)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println(">> Không tìm thấy sách với mã: " + ma);
            return;
        }

        System.out.println(">> Đã tìm thấy sách: " + dss[pos].getTenSach());
        System.out.print(">> Bạn có chắc chắn muốn xóa sách này không ? (y/n): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            Books[] newDss = new Books[dss.length - 1];
            for (int i = 0, j = 0; i < dss.length; i++) {
                if(i != pos){
                    newDss[j++] = dss[i];
                }
            }
            dss = newDss;
            System.out.println(">> Đã xóa sách thành công");
            // writeToFile();
        } else {
            System.out.println(">> Hủy thao tác xóa");
        }
    }

    public void remove(String ma) {
        boolean flag = false;

        int i;
        for (i = 0; i < dss.length; ++i) {
            if (dss[i].getMaSach().equals(ma)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("# Không tìm thấy sách có mã này!");
            return;
        }

        for (int j = i; j < dss.length - 1; ++i) {
            dss[j] = dss[j + 1];
        }

        dss = Arrays.copyOf(dss, dss.length - 1);
        System.out.println("# Xoá sách thành công!");
    }

    public void showMenu(){
        if (dss.length == 0) {
            System.out.println("Chưa có sách nào.");
            return;
        }

        System.out.println("[ THƯ VIỆN ONLINE - XEM DANH SÁCH SÁCH]");
        System.out.println("1. Tất cả các sách");
        System.out.println("2. Sách giáo dục");
        System.out.println("3. Sách tham khảo");
        System.out.print(">> Nhập vào lựa chọn: ");
        int n = sc.nextInt();
        sc.nextLine();

        switch(n){
            case 1: 
                System.out.printf("+-%-10s-+-%-35s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------");
                System.out.printf("| %-10s | %-35s | %-20s | %-10s | %-6s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                "Mã", "Tên sách", "Thể loại", "Tác giả", "Năm", "NXB", "Trạng thái", "Đơn giá", "Số lượng", "Còn lại");
                System.out.printf("+-%-10s-+-%-25s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------");
                
                for (int i = 0; i < dss.length; i++){
                    System.out.printf("| %-10s | %-35s | %-20s | %-10s | %-6s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                    dss[i].getMaSach(), 
                    dss[i].getTenSach(), 
                    dss[i].getTheLoai(), 
                    dss[i].getMaTG(), 
                    dss[i].getNamXB(),
                    dss[i].getMaNXB(), 
                    dss[i].getTrangThai(), 
                    dss[i].getDonGia(), 
                    dss[i].getSoLuong(), 
                    dss[i].getSoLuongConLai()
                    );
                }   
                System.out.printf("+-%-10s-+-%-35s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------");
                break;
                
            case 2: 
                System.out.printf("+-%-10s-+-%-35s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------", "----------", "----------");
                System.out.printf("| %-10s | %-35s | %-20s | %-10s | %-6s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                "Mã", "Tên sách", "Thể loại", "Tác giả", "Năm", "NXB", "Trạng thái", "Đơn giá", "SL", "Còn lại", "Tên môn", "Lớp");
                System.out.printf("+-%-10s-+-%-35s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------", "----------", "----------");
                
                boolean o = false;
                for (int i = 0; i < dss.length; i++){
                    if(dss[i] instanceof Education edu){
                        o = true;
                        String ct1 = edu.getTenMon();
                        String ct2 = edu.getLop();
                        System.out.printf("| %-10s | %-35s | %-20s | %-10s | %-6s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n",
                        dss[i].getMaSach(), dss[i].getTenSach(), dss[i].getTheLoai(), dss[i].getMaTG(), dss[i].getNamXB(),
                        dss[i].getMaNXB(), dss[i].getTrangThai(), dss[i].getDonGia(), dss[i].getSoLuong(), dss[i].getSoLuongConLai(),
                        ct1, ct2);
                    }
                }
                System.out.printf("+-%-10s-+-%-35s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------", "----------", "----------");
                if(!o) System.out.println(">> Thư viện không có sách thể loại giáo dục");
                break;

            case 3: 
                System.out.printf("+-%-10s-+-%-35s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-15s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------", "----------", "---------------", "----------");
                System.out.printf("| %-10s | %-35s | %-20s | %-10s | %-6s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-15s | %-10s |\n",
                "Mã", "Tên sách", "Thể loại", "Tác giả", "Năm", "NXB", "Trạng thái", "Đơn giá", "SL", "Còn lại", "Lĩnh vực", "Ngôn ngữ", "Độ tuổi");
                System.out.printf("+-%-10s-+-%-35s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------", "----------", "---------------", "----------");
                
                o = false;
                for (int i = 0; i < dss.length; i++){
                    if(dss[i] instanceof Reference ref){
                        o = true;
                        String ct1 = ref.getLinhVuc();
                        String ct2 = ref.getNgonNgu();
                        int ct3 = ref.getDoTuoi();
                        System.out.printf("| %-10s | %-35s | %-20s | %-10s | %-6s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-15s | %-10s |\n",
                        dss[i].getMaSach(), dss[i].getTenSach(), dss[i].getTheLoai(), dss[i].getMaTG(), dss[i].getNamXB(),
                        dss[i].getMaNXB(), dss[i].getTrangThai(), dss[i].getDonGia(), dss[i].getSoLuong(), dss[i].getSoLuongConLai(),
                        ct1, ct2, ct3);
                    }
                }
                System.out.printf("+-%-10s-+-%-35s-+-%-20s-+-%-10s-+-%-6s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-10s-+-%-15s-+-%-10s-+\n", "----------", "-----------------------------------", "--------------------", "----------", "------", "----------", "----------", "----------", "----------", "----------", "----------", "---------------", "----------");
                if(!o) System.out.println(">> Thư viện không có sách thể loại tham khảo");
                break;
        }
    }

    public void findMenu(){
        System.out.println("[ THƯ VIỆN ONLINE - TÌM KIẾM SÁCH ]");
        System.out.println(">> Nhập vào mã sách mà bạn muốn tìm kiếm: ");
        String ms = sc.nextLine();

        System.out.println("[!] Đang tìm kiếm....");
        boolean flag = false;
        for(int i = 0; i < dss.length; i++){
            if(dss[i].getMaSach().equals(ms)){
                System.out.println("[!] Dưới đây là thông tin sách mà bạn muốn tìm: ");
                if(dss[i] instanceof Education edu){
                    System.out.printf("%-10s %-25s %-15s %-10s %-6s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                            "Mã", "Tên sách", "Thể loại", "Mã tác giả", "Năm", "NXB", "Trạng thái", "Đơn giá", "SL", "Còn lại", "Tên môn", "Lớp");
                    System.out.printf("%-10s %-25s %-15s %-10s %-6s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", dss[i].getMaSach(), dss[i].getTenSach(),
                            dss[i].getTheLoai(), dss[i].getMaTG(), dss[i].getNamXB(), dss[i].getMaNXB(), dss[i].getTrangThai(), dss[i].getDonGia(),
                            dss[i].getSoLuong(), dss[i].getSoLuongConLai(), edu.getTenMon(), edu.getLop());
                }else if(dss[i] instanceof Reference ref){
                    System.out.printf("%-10s %-25s %-15s %-10s %-6s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                            "Mã", "Tên sách", "Thể loại", "Tác giả", "Năm", "NXB", "Trạng thái", "Đơn giá", "SL", "Còn lại", "Lĩnh vực", "Ngôn ngữ", "Độ tuổi");
                    System.out.printf("%-10s %-25s %-15s %-10s %-6s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", dss[i].getMaSach(), dss[i].getTenSach(),
                            dss[i].getTheLoai(), dss[i].getMaTG(), dss[i].getNamXB(), dss[i].getMaNXB(), dss[i].getTrangThai(), dss[i].getDonGia(),
                            dss[i].getSoLuong(), dss[i].getSoLuongConLai(), ref.getLinhVuc(), ref.getNgonNgu(), ref.getDoTuoi());
                }else{
                    System.out.printf("%-10s %-25s %-15s %-10s %-6s %-10s %-10s %-10s %-10s %-10s%n",
                            "Mã", "Tên sách", "Thể loại", "Tác giả", "Năm", "NXB", "Trạng thái", "Đơn giá", "SL", "Còn lại");
                    System.out.printf("%-10s %-25s %-15s %-10s %-6s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", dss[i].getMaSach(), dss[i].getTenSach(),
                            dss[i].getTheLoai(), dss[i].getMaTG(), dss[i].getNamXB(), dss[i].getMaNXB(), dss[i].getTrangThai(), dss[i].getDonGia(),
                            dss[i].getSoLuong(), dss[i].getSoLuongConLai());
                }
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println(">> Mã sách bạn cần tìm không tồn tại trong thư viện này");
        }
    }

    public void timKiemS(String ma) {
        boolean flag = false;

        for (int i = 0; i < dss.length; ++i) {
            if (dss[i].getMaSach().equals(ma)) {
                dss[i].xuat();
                flag = true;
                return;
            }
        }

        if (!flag) {
            System.out.println("! Không tìm thấy sách có mã này !");
        }
    }
    
    public Books timKiem(String ma) {
        for (int i = 0; i < dss.length; i++) {
            if (ma.equals(dss[i].getMaSach())) {
                return dss[i];
            }
        }
        return null;
    }

    public void changeInformation(){
        System.out.println("[ THƯ VIỆN ONLINE - CẬP NHẬT THÔNG TIN SÁCH ]");
        System.out.print(">> Nhập vào mã sách mà bạn muốn cập nhật thông tin: ");
        String m = sc.nextLine();

        int pos = -1;
        for(int i = 0; i < dss.length; i++){
            if(dss[i].getMaSach().equals(m)){
                pos = i;
            }
        }

        if(pos != -1){
            String l10 = "", l11 = "", l12 = "";
            if(dss[pos] instanceof Education){
                l10 = "9. Tên môn";
                l11 = "10. Lớp";
            }
            if(dss[pos] instanceof Reference){
                l10 = "9. Lĩnh vực";
                l11 = "10. Ngôn ngữ";
                l12 = "11. Độ tuổi";
            }
            System.out.println(">> Đã tìm thấy sách mà bạn muốn cập nhật, hãy chọn thông tin mà bạn muốn cập nhật");
            System.out.printf("%-30s %-30s %-30s %-30s\n", "1. Tên sách", "4. Năm xuất bản", "7. Đơn giá", l11);
            System.out.printf("%-30s %-30s %-30s %-30s\n", "2. Thể loại", "5. Mã nhà xuất bản", "8. Số lượng", l12);
            System.out.printf("%-30s %-30s %-30s %-30s\n", "3. Mã tác giả", "6. Trạng thái", l10, "");

            System.out.print("# Nhập vào lựa chọn: ");
            int choi = sc.nextInt();
            sc.nextLine();

            switch(choi){
                case 1: {
                    System.out.print(">> Nhập tên sách mới: ");
                    dss[pos].setTenSach(sc.nextLine());
                    break;
                }

                case 2: {
                    // System.out.print(">> Nhập thể loại mới (Khác / Giáo dục / Tham khảo): ");
                    // String newType = sc.nextLine();
                    // Books newB = null;
                    // switch (newType.toLowerCase()) {
                    //     case "khác":
                    //         newB = new Books();
                    //         break;
                    //     case "giáo dục":
                    //         newB = new Education();
                    //         break;
                    //     case "tham khảo":
                    //         newB = new Reference();
                    //         break;
                    //     default:
                    //         System.out.println(">> Thể loại không hợp lệ.");
                    //         return;
                    // }
                    // newB.setMaSach(dss[pos].getMaSach());
                    // newB.setTenSach(dss[pos].getTenSach());
                    // newB.setMaTG(dss[pos].getMaTG());
                    // newB.setNamXB(dss[pos].getNamXB());
                    // newB.setMaNXB(dss[pos].getMaNXB());
                    // newB.setTrangThai(dss[pos].getTrangThai());
                    // newB.setDonGia(dss[pos].getDonGia());
                    // newB.setSoLuong(dss[pos].getSoLuong());
                    // newB.setSoLuongConLai(dss[pos].getSoLuongConLai());
                    // newB.setTheLoai(newType);
                    // if(newB instanceof Education edu){
                    //     System.out.print(">> Nhập tên môn: ");
                    //     edu.setTenMon(sc.nextLine());
                    //     System.out.print(">> Nhập tên lớp: ");
                    //     edu.setLop(sc.nextLine());
                    // }
                    // if(newB instanceof Reference ref){
                    //     System.out.print(">> Nhập lĩnh vực: ");
                    //     ref.setLinhVuc(sc.nextLine());
                    //     System.out.print(">> Nhập ngôn ngữ: ");
                    //     ref.setNgonNgu(sc.nextLine());
                    //     System.out.print(">> Nhập độ tuổi: ");
                    //     ref.setDoTuoi(sc.nextInt());
                    // }
                    // dss[pos] = newB;
                    // break;

                    System.out.print(">> Nhập tên thể loại mới: ");
                    dss[pos].setTheLoai(sc.nextLine());
                }

                case 3: {
                    System.out.print(">> Nhập mã tác giả mới: ");
                    dss[pos].setMaTG(sc.nextLine());
                    break;
                }

                case 4: {
                    System.out.print(">> Nhập năm xuất bản mới: ");
                    dss[pos].setNamXB(sc.nextLine());
                    break;
                }

                case 5: {
                    System.out.print(">> Nhập mã nhà xuất bản mới: ");
                    dss[pos].setMaNXB(sc.nextLine());
                    break;
                }

                case 6: {
                    System.out.print(">> Nhập trạng thái mới: ");
                    dss[pos].setTrangThai(sc.nextLine());
                    break;
                }

                case 7: {
                    System.out.print(">> Nhập đơn giá mới: ");
                    int dg = sc.nextInt();
                    sc.nextLine();
                    dss[pos].setDonGia(dg);
                    break;
                }

                case 8: {
                    System.out.print(">> Nhập số lượng mới: ");
                    int sl = sc.nextInt();
                    sc.nextLine();
                    dss[pos].setSoLuong(sl);
                    break;
                }

                case 9: {
                    if(dss[pos] instanceof Education) {
                        Education edu = (Education) dss[pos];
                        System.out.print(">> Nhập tên môn mới: ");
                        edu.setTenMon(sc.nextLine());
                    } else if (dss[pos] instanceof Reference) {
                        Reference ref = (Reference) dss[pos];
                        System.out.print(">> Nhập lĩnh vực mới: ");
                        ref.setLinhVuc(sc.nextLine());
                    }
                    break;
                }

                case 10: {
                    if(dss[pos] instanceof Education edu){
                        System.out.print(">> Nhập lớp mới: ");
                        edu.setLop(sc.nextLine());
                    } else if(dss[pos] instanceof Reference ref){
                        System.out.print(">> Nhập ngôn ngữ mới: ");
                        ref.setNgonNgu(sc.nextLine());
                    } else {
                        System.out.println("# Lực chọn không hợp lệ!");
                    }
                    break;
                }

                case 11: {
                    if (dss[pos] instanceof Reference ref){
                        System.out.print(">> Nhập độ tuổi mới: ");
                        ref.setDoTuoi(sc.nextInt());
                    } else {
                        System.out.println("# Lựa chọn không hợp lệ!");
                    }
                    break;
                }

                default:
                    System.out.println(">> Lựa chọn không hợp lệ.");
                    break;
            }
            System.out.println(">> Cập nhật thông tin thành công.");
            // writeToFile();
        }else{
            System.out.println(">> Không tồn tại cuốn sách với mã sách mà bạn vừa nhập.");
        }
    }

    public void thongKe(){
        System.out.println("[ THƯ VIỆN ONLINE - THỐNG KÊ SÁCH ]");
        System.out.println("1. Số lượng sách theo thể loại");
        System.out.println("2. Tổng số đầu sách hiện có trong thư viện");
        System.out.println("3. Tổng số lượng sách còn lại trong kho");
        System.out.print(">> Chọn kiểu thống kê: ");
        int chon = Integer.parseInt(sc.nextLine());

        switch (chon) {
            case 1:
                thongKeTheoTheLoai();
                break;
            case 2:
                System.out.println(">> Tổng số đầu sách hiện có trong thư viện: " + dss.length);
                break;
            case 3:
                int tongConLai = 0;
                for(int i = 0; i < dss.length; i++) {
                    tongConLai += dss[i].getSoLuongConLai();
                }
                System.out.println(">> Tổng số lượng sách còn lại trong kho: " + tongConLai);
                break;
            default:
                System.out.println(">> Lựa chọn không hợp lệ.");
        }
    }

    private void thongKeTheoTheLoai() {
        int edu = 0, ref = 0, khac = 0;

        for (int i = 0; i < dss.length; i++) {
            if (dss[i] instanceof Education) {
                edu++;
            } else if (dss[i] instanceof Reference) {
                ref++;
            } else {
                khac++;
            }
        }

        System.out.println(">> Thống kê số lượng sách theo thể loại:");
        System.out.println("- Sách giáo dục: " + edu);
        System.out.println("- Sách tham khảo: " + ref);
        System.out.println("- Sách khác: " + khac);
    }


    public void writeToFile(String filename) {
        File f = new File(filename);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for(int i = 0; i < dss.length; i++){
                String line = "";

                if (dss[i] instanceof Education) {
                    line += "1,";
                } else if (dss[i] instanceof Reference) {
                    line += "2,";
                }

                line += dss[i].getMaSach() + "," +
                        dss[i].getTenSach() + "," +
                        dss[i].getTheLoai() + "," +
                        dss[i].getMaTG() + "," +
                        dss[i].getNamXB() + "," +
                        dss[i].getMaNXB() + "," +
                        dss[i].getTrangThai() + "," +
                        dss[i].getDonGia() + "," +
                        dss[i].getSoLuong() + "," +
                        dss[i].getSoLuongConLai();

                if (dss[i] instanceof Education) {
                    Education sgd = (Education) dss[i];
                    line +=  "," + sgd.getTenMon() + "," + sgd.getLop();
                } else if (dss[i] instanceof Reference) {
                    Reference stk = (Reference) dss[i];
                    line += "," + stk.getLinhVuc() + "," + stk.getNgonNgu() + "," + stk.getDoTuoi();
                }

                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(">> Lỗi ghi file: " + e.getMessage());
        }
    }

    public void readFromFile(String filename) {
        File f = new File(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("1")) {
                    dss = Arrays.copyOf(dss, dss.length + 1);
                    dss[dss.length - 1] = new Education (
                        parts[1], 
                        parts[2], 
                        parts[3], 
                        parts[4], 
                        parts[5],
                        parts[6], 
                        parts[7], 
                        Integer.parseInt(parts[8]), 
                        Integer.parseInt(parts[9]), 
                        Integer.parseInt(parts[10]),
                        parts[11], 
                        parts[12]
                    );
                } else if (parts[0].equals("2")) {
                    dss = Arrays.copyOf(dss, dss.length + 1);
                    dss[dss.length - 1] = new Reference(
                        parts[1], 
                        parts[2], 
                        parts[3], 
                        parts[4], 
                        parts[5],
                        parts[6], 
                        parts[7], 
                        Integer.parseInt(parts[8]), 
                        Integer.parseInt(parts[9]), 
                        Integer.parseInt(parts[10]),
                        parts[11], 
                        parts[12], 
                        Integer.parseInt(parts[13])
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(">> Lỗi đọc file: " + e.getMessage());

        }
    }


    public void setSoLuong(String maS, int sl) {
        int slcl = 0;

        for (int i = 0; i < dss.length; i++) {
            if (maS.equals(dss[i].getMaSach())) {
                slcl = dss[i].getSoLuongConLai() - sl;
                dss[i].setSoLuongConLai(slcl);
            }
        }
    }

    public void setSoLuongNhapHang(String maS, int soluong) {
        int sl = 0;
        int slcl = 0;

        for (int i = 0; i < dss.length; i++) {
            if (maS.equals(dss[i].getMaSach())) {
                sl = dss[i].getSoLuong() + soluong;
                slcl = dss[i].getSoLuongConLai() + soluong;

                dss[i].setSoLuong(sl);
                dss[i].setSoLuongConLai(slcl);
            }
        }
    }
}