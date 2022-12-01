/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class hocPhi {
 

    private String idMonHoc;
    private String maHV;
    private int hocKy;
    private String tenMon;
    private BigDecimal hocPhi;
    private int trangThai;
    private BigDecimal soDuVi;
    private Date ngayDong;
    private Date NgaySua;

    public Date getNgaySua() {
        return NgaySua;
    }

    public void setNgaySua(Date NgaySua) {
        this.NgaySua = NgaySua;
    }

    public hocPhi() {
    }

    public hocPhi(String idMonHoc, String maHV, int hocKy, String tenMon, BigDecimal hocPhi, int trangThai, BigDecimal soDuVi, Date ngayDong, Date NgaySua) {
        this.idMonHoc = idMonHoc;
        this.maHV = maHV;
        this.hocKy = hocKy;
        this.tenMon = tenMon;
        this.hocPhi = hocPhi;
        this.trangThai = trangThai;
        this.soDuVi = soDuVi;
        this.ngayDong = ngayDong;
        this.NgaySua = NgaySua;
    }

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public Date getNgayDong() {
        return ngayDong;
    }

    public void setNgayDong(Date ngayDong) {
        this.ngayDong = ngayDong;
    }

    public BigDecimal getSoDuVi() {
        return soDuVi;
    }

    public void setSoDuVi(BigDecimal soDuVi) {
        this.soDuVi = soDuVi;
    }

    @Override
    public String toString() {
        return "hocPhi{" + "idMonHoc=" + idMonHoc + ", maHV=" + maHV + ", hocKy=" + hocKy + ", tenMon=" + tenMon + ", hocPhi=" + hocPhi + ", trangThai=" + trangThai + ", soDuVi=" + soDuVi + ", ngayDong=" + ngayDong + ", NgaySua=" + NgaySua + '}';
    }

   

    public hocPhi(String maHV, int hocKy, String tenMon, BigDecimal hocPhi, int trangThai) {
        this.maHV = maHV;
        this.hocKy = hocKy;
        this.tenMon = tenMon;
        this.hocPhi = hocPhi;
        this.trangThai = trangThai;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public BigDecimal getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(BigDecimal hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String trangThai(int trangThai) {
        if (trangThai == 0) {
            return "Chưa đóng học phí";
        } else {
            return "Đã đóng học phí";
        }
    }

}


