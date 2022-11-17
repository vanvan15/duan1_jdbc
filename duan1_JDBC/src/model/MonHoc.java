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
public class MonHoc {

    private String id;
    private String idHocKy;
    private String tenMon;
    private BigDecimal hocPhi;
    private int thoiLuong;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public MonHoc(String id, String idHocKy, String tenMon, BigDecimal hocPhi, int thoiLuong, int trangThai, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.idHocKy = idHocKy;
        this.tenMon = tenMon;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHocKy() {
        return idHocKy;
    }

    public void setIdHocKy(String idHocKy) {
        this.idHocKy = idHocKy;
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

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
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
