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
public class HocVien {

    private String idHocVien;
    private String ho;
    private String tenDem;
    private String ten;
    private String email;
    private String sdt;
    private Date ngaySinh;
    private int trangThai;
    private String matKhau;
    private Date ngayTao;
    private Date ngaySua;

    public HocVien(String idHocVien, String ho, String tenDem, String ten, String email, String sdt, Date ngaySinh, int trangThai, String matKhau, Date ngayTao, Date ngaySua) {
        this.idHocVien = idHocVien;
        this.ho = ho;
        this.tenDem = tenDem;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.trangThai = trangThai;
        this.matKhau = matKhau;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public String getIdHocVien() {
        return idHocVien;
    }

    public void setIdHocVien(String idHocVien) {
        this.idHocVien = idHocVien;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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
