package Publisher;

public class Publishers {
    private String MaNXB, tenNXB, DC, SDT, Email;

    public Publishers(){}
    public Publishers(String manxb, String t, String dc, String sdt, String email){
        this.MaNXB = manxb;
        this.tenNXB = t;
        this.DC = dc;
        this.SDT = sdt;
        this.Email = email;
    }
    public Publishers(Publishers nxb){
        this.MaNXB = nxb.MaNXB;
        this.tenNXB = nxb.tenNXB;
        this.DC = nxb.DC;
        this.SDT = nxb.SDT;
        this.Email = nxb.Email;
    }

    public void setMaNXB(String manxb){this.MaNXB = manxb;}

    public void setTenNXB (String t) {
        this.tenNXB = t;
    }

    public void setMaDiaChi(String madc){this.DC = madc;}
    public void setSDT(String sdt){this.SDT = sdt;}
    public void setEmail(String email){this.Email = email;}

    public String getMaNXB(){return MaNXB;}

    public String getTenNXB() {
        return this.tenNXB;
    }

    public String getMaDiaChi(){return DC;}
    public String getSDT(){return SDT;}
    public String getEmail(){return Email;}
}
