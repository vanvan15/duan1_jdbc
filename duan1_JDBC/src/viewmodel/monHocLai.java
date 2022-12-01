/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author Dell
 */
public class monHocLai {

    private String idMonHoc;
    private String maHV;
    private String tenMon;
    private String tenLop;
    private BigDecimal tienHocLai;
    private int trangThai;
    private BigDecimal soDuVi;

    public monHocLai() {
    }

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public monHocLai(String idMonHoc, String maHV, String tenMon, String tenLop, BigDecimal tienHocLai, int trangThai, BigDecimal soDuVi) {
        this.idMonHoc = idMonHoc;
        this.maHV = maHV;
        this.tenMon = tenMon;
        this.tenLop = tenLop;
        this.tienHocLai = tienHocLai;
        this.trangThai = trangThai;
        this.soDuVi = soDuVi;
    }

    public monHocLai(String tenMon, String tenLop, BigDecimal tienHocLai, BigDecimal soDuVi) {
        this.tenMon = tenMon;
        this.tenLop = tenLop;
        this.tienHocLai = tienHocLai;
        this.soDuVi = soDuVi;
    }

    public monHocLai(String maHV, String tenMon, String tenLop, BigDecimal tienHocLai, int trangThai, BigDecimal soDuVi) {
        this.maHV = maHV;
        this.tenMon = tenMon;
        this.tenLop = tenLop;
        this.tienHocLai = tienHocLai;
        this.trangThai = trangThai;
        this.soDuVi = soDuVi;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public BigDecimal getTienHocLai() {
        return tienHocLai;
    }

    public void setTienHocLai(BigDecimal tienHocLai) {
        this.tienHocLai = tienHocLai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public BigDecimal getSoDuVi() {
        return soDuVi;
    }

    public void setSoDuVi(BigDecimal soDuVi) {
        this.soDuVi = soDuVi;
    }

    @Override
    public String toString() {
        return "dangkyHocLai{" + "tenMon=" + tenMon + ", tenLop=" + tenLop + ", tienHocLai=" + tienHocLai + ", soDuVi=" + soDuVi + '}';
    }
}
