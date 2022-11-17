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
public class Vi {

    private String idVi;
    private String idHocVien;
    private BigDecimal soDuVi;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public Vi(String idVi, String idHocVien, BigDecimal soDuVi, Date ngayTao, Date ngaySua, int trangThai) {
        this.idVi = idVi;
        this.idHocVien = idHocVien;
        this.soDuVi = soDuVi;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getIdVi() {
        return idVi;
    }

    public void setIdVi(String idVi) {
        this.idVi = idVi;
    }

    public String getIdHocVien() {
        return idHocVien;
    }

    public void setIdHocVien(String idHocVien) {
        this.idHocVien = idHocVien;
    }

    public BigDecimal getSoDuVi() {
        return soDuVi;
    }

    public void setSoDuVi(BigDecimal soDuVi) {
        this.soDuVi = soDuVi;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
