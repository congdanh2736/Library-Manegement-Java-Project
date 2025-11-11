package QuanLyThuVien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import Author.ListAuthors;
import Book.ListBooks;
import CHITIETPHIEUMUON.DSCHITIET_PM;
import CHITIETPHIEUNHAPHANG.DSCHITIET_PNH;
import DocGia.DS_DocGia;
import NHACUNGCAP.DSNHACUNGCAP;
import NhanVien.DS_NhanVien;
import PHIEUMUON.DSPHIEUMUON;
import PHIEUNHAPHANG.DSPHIEUNHAPHANG;
import PhieuPhat.DS_PhieuPhat;
import Publisher.ListPublishers;
import QuyDinhPhat.DS_QuyDinhPhat;

public class QuanLyThuVien {
    Scanner sc = new Scanner(System.in);

    DS_DocGia dsdg = new DS_DocGia();
    DS_NhanVien dsnv = new DS_NhanVien();
    DS_PhieuPhat dspp = new DS_PhieuPhat();
    DS_QuyDinhPhat dsqdp = new DS_QuyDinhPhat();
    DSCHITIET_PM dsctpm = new DSCHITIET_PM();
    DSCHITIET_PNH dsctpnh = new DSCHITIET_PNH();
    DSPHIEUMUON dspm = new DSPHIEUMUON();
    DSPHIEUNHAPHANG dspnh = new DSPHIEUNHAPHANG();
    DSNHACUNGCAP dsncc = new DSNHACUNGCAP();
    ListAuthors dstg = new ListAuthors();
    ListPublishers dsnxb = new ListPublishers();
    ListBooks dss = new ListBooks();

    public QuanLyThuVien() {
        dsdg.docDuLieuFile("DocGia\\docgia.txt");
        dsnv.docDuLieuFile("NhanVien\\nhanvien.txt");
        dspp.docDuLieuFile("PhieuPhat\\phieuphat.txt");
        dsqdp.docDuLieuFile("QuyDinhPhat\\quydinh.txt");
        dsctpm.docTuFile("CHITIETPHIEUMUON\\chitietpm.txt");
        dsctpnh.docTuFile("CHITIETPHIEUNHAPHANG\\chitietpnh.txt");
        dspm.docTuFile("PHIEUMUON\\phieumuon.txt");
        dspnh.docTuFile("PHIEUNHAPHANG\\phieunhaphang.txt");
        dsncc.docTuFile("NHACUNGCAP\\nhacungcap.txt");
        dstg.readFromFile("Author\\Authors.txt");
        dsnxb.readFromFile("Publisher\\Publishers.txt");
        dss.readFromFile("Book\\Books.txt");
    }

    public void menu_chinh() {}

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
}
