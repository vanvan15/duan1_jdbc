/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author HánH
 */
public class lichhocVD {

    private Date ngayHoc;
    private String tenMon;
    private String maLop;
    private String tenLop;
    private String maCa;
    private String hoGV;
    private String tenDemGV;
    private String tenGV;
    private String thoiGian;

    public lichhocVD() {
    }

    public lichhocVD(Date ngayHoc, String tenMon, String maLop, String tenLop, String maCa, String hoGV, String tenDemGV, String tenGV, String thoiGian) {
        this.ngayHoc = ngayHoc;
        this.tenMon = tenMon;
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maCa = maCa;
        this.hoGV = hoGV;
        this.tenDemGV = tenDemGV;
        this.tenGV = tenGV;
        this.thoiGian = thoiGian;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaCa() {
        return maCa;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public String getHoGV() {
        return hoGV;
    }

    public void setHoGV(String hoGV) {
        this.hoGV = hoGV;
    }

    public String getTenDemGV() {
        return tenDemGV;
    }

    public void setTenDemGV(String tenDemGV) {
        this.tenDemGV = tenDemGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

}
