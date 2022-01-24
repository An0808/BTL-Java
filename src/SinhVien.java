
public class SinhVien {
    private String HoTen;
    private String NgaySinh;
    private String MaSV;
    private String GioiTinh;
    private int DiemTB;
    private int DiemRL;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String ngaySinh, String maSV, int diemTB, int diemRL) {
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        MaSV = maSV;
        DiemTB = diemTB;
        DiemRL = diemRL;
    }
    public String getHoTen() {
        return HoTen;
    }
    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }


    public String getMaSV() {
        return MaSV;
    }
    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public int getDiemTB() {
        return DiemTB;
    }
    public void setDiemTB(int diemTB) {
        DiemTB = diemTB;
    }

    public int getDiemRL() {
        return DiemRL;
    }
    public void setDiemRL(int diemRL) {
        DiemRL = diemRL;
    }


}
