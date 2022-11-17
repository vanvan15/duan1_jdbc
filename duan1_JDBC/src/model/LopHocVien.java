/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author HánH
 */
public class LopHocVien {

    private String idLopHV;
    private String idLop;
    private String idHocVien;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public LopHocVien(String idLopHV, String idLop, String idHocVien, int trangThai, Date ngayTao, Date ngaySua) {
        this.idLopHV = idLopHV;
        this.idLop = idLop;
        this.idHocVien = idHocVien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public String getIdLopHV() {
        return idLopHV;
    }

    public void setIdLopHV(String idLopHV) {
        this.idLopHV = idLopHV;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getIdHocVien() {
        return idHocVien;
    }

    public void setIdHocVien(String idHocVien) {
        this.idHocVien = idHocVien;
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
