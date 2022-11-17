/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author HánH
 */
public class DongHocPhi {

    private String idDongHP;
    private String idHocVien;
    private String idMonHoc;
    private Date ngayDong;
    private BigDecimal tienDong;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public DongHocPhi(String idDongHP, String idHocVien, String idMonHoc, Date ngayDong, BigDecimal tienDong, int trangThai, Date ngayTao, Date ngaySua) {
        this.idDongHP = idDongHP;
        this.idHocVien = idHocVien;
        this.idMonHoc = idMonHoc;
        this.ngayDong = ngayDong;
        this.tienDong = tienDong;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
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

}
