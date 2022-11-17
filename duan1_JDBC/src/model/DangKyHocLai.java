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
public class DangKyHocLai {

    private String idDangKy;
    private String idHocVien;
    private String idHocKy;
    private Date ngayDangKy;
    private BigDecimal hocPhi;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public DangKyHocLai(String idDangKy, String idHocVien, String idHocKy, Date ngayDangKy, BigDecimal hocPhi, int trangThai, Date ngayTao, Date ngaySua) {
        this.idDangKy = idDangKy;
        this.idHocVien = idHocVien;
        this.idHocKy = idHocKy;
        this.ngayDangKy = ngayDangKy;
        this.hocPhi = hocPhi;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public String getIdDangKy() {
        return idDangKy;
    }

    public void setIdDangKy(String idDangKy) {
        this.idDangKy = idDangKy;
    }

    public String getIdHocVien() {
        return idHocVien;
    }

    public void setIdHocVien(String idHocVien) {
        this.idHocVien = idHocVien;
    }

    public String getIdHocKy() {
        return idHocKy;
    }

    public void setIdHocKy(String idHocKy) {
        this.idHocKy = idHocKy;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
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
