package Author;

public class Authors {
    private String MaTG, Ho, Ten, gioiTinh, NamSinh, SDT, Email;

    public Authors(){}
    public Authors(String matg, String h, String t, String gt, String ns, String sdt, String email){
        this.MaTG = matg;
        this.Ho = h;
        this.Ten = t;
        this.gioiTinh = gt;
        this.NamSinh = ns;
        this.SDT = sdt;
        this.Email = email;
    }
    public Authors(Authors tg){
        this.MaTG = tg.MaTG;
        this.Ho = tg.Ho;
        this.Ten = tg.Ten;
        this.gioiTinh = tg.gioiTinh;
        this.NamSinh = tg.NamSinh;
        this.SDT = tg.SDT;
        this.Email = tg.Email;
    }

    public void setMaTG(String maTG){this.MaTG = maTG;}
    public void setHo(String ho){this.Ho = ho;}
    public void setTen(String ten){this.Ten = ten;}
    public void setGioiTinh(String gt) {
        this.gioiTinh = gt;
    }
    public void setNamSinh(String sinh){this.NamSinh = sinh;}
    public void setSDT(String sdt){this.SDT = sdt;}
    public void setEmail(String email){this.Email = email;}

    public String getMaTG(){return MaTG;}
    public String getHo(){return Ho;}
    public String getTen(){return Ten;}

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public String getHoTen(){return Ho + " " + Ten;}
    public String getNamSinh(){return NamSinh;}
    public String getSDT(){return SDT;}
    public String getEmail(){return Email;}
}
