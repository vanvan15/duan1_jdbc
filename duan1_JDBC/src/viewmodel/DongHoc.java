/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import model.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author HánH
 */
public class DongHoc {

    private String idDongHP;
    private String idHocVien;
    private String idMonHoc;
    private Date ngayDong;
    private BigDecimal tienDong;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;
    private String tenMon;

    public DongHoc(String idDongHP, String idHocVien, String idMonHoc, Date ngayDong, BigDecimal tienDong, int trangThai, Date ngayTao, Date ngaySua, String tenMon) {
        this.idDongHP = idDongHP;
        this.idHocVien = idHocVien;
        this.idMonHoc = idMonHoc;
        this.ngayDong = ngayDong;
        this.tienDong = tienDong;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.tenMon = tenMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    

    public DongHoc() {
    }
    

    public String getIdDongHP() {
        return idDongHP;
    }

    public void setIdDongHP(String idDongHP) {
        this.idDongHP = idDongHP;
    }

    public String getIdHocVien() {
        return idHocVien;
    }

    public void setIdHocVien(String idHocVien) {
        this.idHocVien = idHocVien;
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

    public BigDecimal getTienDong() {
        return tienDong;
    }

    public void setTienDong(BigDecimal tienDong) {
        this.tienDong = tienDong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
    public String trangThai(int trangThai) {
        if (trangThai == 0) {
            return "Chưa đóng học phí";
        } else {
            return "Đã đóng học phí";
        }
    }

    @Override
    public String toString() {
        return "DongHoc{" + "idDongHP=" + idDongHP + ", idHocVien=" + idHocVien + ", idMonHoc=" + idMonHoc + ", ngayDong=" + ngayDong + ", tienDong=" + tienDong + ", trangThai=" + trangThai + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", tenMon=" + tenMon + '}';
    }
    
}
