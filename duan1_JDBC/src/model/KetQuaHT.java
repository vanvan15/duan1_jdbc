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
public class KetQuaHT {

    private String id;
    private String idHocVien;
    private String idMonHoc;
    private float diemGiuaKy;
    private float điemTongKet;
    private String danhGia;
    private String trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public KetQuaHT(String id, String idHocVien, String idMonHoc, float diemGiuaKy, float điemTongKet, String danhGia, String trangThai, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.idHocVien = idHocVien;
        this.idMonHoc = idMonHoc;
        this.diemGiuaKy = diemGiuaKy;
        this.điemTongKet = điemTongKet;
        this.danhGia = danhGia;
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

    public float getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(float diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public float getĐiemTongKet() {
        return điemTongKet;
    }

    public void setĐiemTongKet(float điemTongKet) {
        this.điemTongKet = điemTongKet;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
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
