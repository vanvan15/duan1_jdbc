/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author HánH
 *
 */
public class LichDay {

    private String maLop;
    private String tenLop;
    private String tenMon;
    private String maCa;
    private String thoiGian;
    private Date ngayHoc;

    public LichDay() {
    }

    public LichDay(String maLop, String tenLop, String tenMon, String maCa, String thoiGian, Date ngayHoc) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.tenMon = tenMon;
        this.maCa = maCa;
        this.thoiGian = thoiGian;
        this.ngayHoc = ngayHoc;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getMaCa() {
        return maCa;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

}
