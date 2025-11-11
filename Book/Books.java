package Book;

import java.util.*;
// import java.io.*;

public abstract class Books {
    Scanner ip = new Scanner(System.in);

    private String MaSach, TenSach, TheLoai, MaTG, NamXB, TrangThai, MaNXB;
    private int DonGia;
    private int SoLuong;
    private int SoLuongConLai;
    private static int bookCount = 0;

    public Books(){
        this.MaSach = "";
        this.TenSach = "";
        this.TheLoai = "";
        this.MaTG = "";
        this.NamXB = "";
        this.TrangThai = "Còn";
        this.MaNXB = "";
        this.DonGia = 0;
        this.SoLuong = 0;
        this.SoLuongConLai = 0;
        bookCount++;
    }

    public Books(String ms, String ts, String tl, String mtg, String nxb, String mnxb, String tt, int dg, int sl, int slcl){
        this.MaSach = ms;
        this.TenSach = ts;
        this.TheLoai = tl;
        this.MaTG = mtg;
        this.NamXB = nxb;
        this.TrangThai = tt;
        this.MaNXB = mnxb;
        this.DonGia = dg;
        this.SoLuong = sl;
        this.SoLuongConLai = slcl;
        bookCount++;
    }

    // @SuppressWarnings("static-access")
    public Books(Books sach){
        this.MaSach = sach.MaSach;
        this.TenSach = sach.TenSach;
        this.TheLoai = sach.TheLoai;
        this.MaTG = sach.MaTG;
        this.NamXB = sach.NamXB;
        this.TrangThai = sach.TrangThai;
        this.MaNXB = sach.MaNXB;
        this.DonGia = sach.DonGia;
        this.SoLuong = sach.SoLuong;
        this.SoLuongConLai = sach.SoLuongConLai;
        bookCount++;
    }

    public void nhap(){
        System.out.println("[ THƯ VIỆN ONLINE - NHẬP THÔNG TIN SÁCH");
        System.out.println("[!] Vui lòng nhập đúng các thông tin dưới đây.");
        System.out.print(">> Mã cuốn sách: ");
        this.MaSach = ip.nextLine();
        System.out.print(">> Tên sách: ");
        this.TenSach = ip.nextLine();

        System.out.println(">> Thể loại: ");
        this.TheLoai = ip.nextLine();

        // this.TheLoai = "";

        System.out.print(">> Mã tác giả: ");
        this.MaTG = ip.nextLine();
        this.TrangThai = "Còn";
        System.out.print(">> Mã nhà xuất bản: ");
        this.MaNXB = ip.nextLine();
        System.out.print(">> Năm xuất bản: ");
        this.NamXB = ip.nextLine();
        System.out.print(">> Đơn giá: ");
        this.DonGia = ip.nextInt();
        System.out.print(">> Số lượng: ");
        this.SoLuong = ip.nextInt();
        this.SoLuongConLai = this.SoLuong;
    }

    public void xuat() {
        System.out.println("# Thông tin của sách: ");
        System.out.println("# Mã sách: " + MaSach);
        System.out.println("# Tên sách: " + TenSach);
        System.out.println("Thể loại: " + TheLoai);
        System.out.println("# Mã tác giả: " + MaTG);
        System.out.println("# Mã nhà xuất bản: " + MaNXB);
        System.out.println("# Đơn giá: " + DonGia);
        System.out.println("# Số lượng: " + SoLuong);
        System.out.println("# Số lượng còn lại: " + SoLuongConLai);
    }

    public void setMaSach(String ms){this.MaSach = ms;}
    public void setTenSach(String ts){this.TenSach = ts;}
    public void setTheLoai(String tl){this.TheLoai = tl;}
    public void setMaTG(String mtg){this.MaTG = mtg;}
    public void setNamXB(String nxb){this.NamXB = nxb;}
    public void setMaNXB(String mnxb){this.MaNXB = mnxb;}
    public void setDonGia(int dg){this.DonGia = dg;}
    public void setTrangThai(String tt){this.TrangThai = tt;}
    public void setSoLuong(int sl){this.SoLuong = sl;}
    public void setSoLuongConLai(int slcl){this.SoLuongConLai = slcl;}

    public String getMaSach(){return this.MaSach;}
    public String getTenSach(){return this.TenSach;}
    public String getTheLoai(){return this.TheLoai;}
    public String getMaTG(){return this.MaTG;}
    public String getNamXB(){return this.NamXB;}
    public String getMaNXB(){return this.MaNXB;}
    public String getTrangThai(){return this.TrangThai;}
    public int getDonGia(){return this.DonGia;}
    public int getSoLuong(){return this.SoLuong;}
    public int getSoLuongConLai(){return this.SoLuongConLai;}
    
    public static int getBookCount() {
        return bookCount;
    }

    public abstract String getChiTiet();
}
