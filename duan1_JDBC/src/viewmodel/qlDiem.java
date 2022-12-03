/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author HánH
 */
public class qlDiem {

    private String id;
    private String idHocVien;
    private String idMonHoc;
    private String maHV;
    private String hoHV;
    private String tenDemHV;
    private String tenHV;
    private float diemGiuaKy;
    private float diemTongKet;
    private String danhGia;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public qlDiem() {
    }

    public qlDiem(String id, String idHocVien, String idMonHoc, String maHV, String hoHV, String tenDemHV, String tenHV, float diemGiuaKy, float diemTongKet, String danhGia, int trangThai, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.idHocVien = idHocVien;
        this.idMonHoc = idMonHoc;
        this.maHV = maHV;
        this.hoHV = hoHV;
        this.tenDemHV = tenDemHV;
        this.tenHV = tenHV;
        this.diemGiuaKy = diemGiuaKy;
        this.diemTongKet = diemTongKet;
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

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getHoHV() {
        return hoHV;
    }

    public void setHoHV(String hoHV) {
        this.hoHV = hoHV;
    }

    public String getTenDemHV() {
        return tenDemHV;
    }

    public void setTenDemHV(String tenDemHV) {
        this.tenDemHV = tenDemHV;
    }

    public String getTenHV() {
        return tenHV;
    }

    public void setTenHV(String tenHV) {
        this.tenHV = tenHV;
    }

    public float getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(float diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public float getDiemTongKet() {
        return diemTongKet;
    }

    public void setDiemTongKet(float diemTongKet) {
        this.diemTongKet = diemTongKet;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
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

    public qlDiem(float diemGiuaKy, float diemTongKet, String danhGia, int trangThai) {
        this.diemGiuaKy = diemGiuaKy;
        this.diemTongKet = diemTongKet;
        this.danhGia = danhGia;
        this.trangThai = trangThai;
    }

}
