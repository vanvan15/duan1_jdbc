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
public class Lop {

    private String id;
    private String idGiangVien;
    private String malop;
    private String tenLop;
    private int slHocVien;
    private int slToiDa;
    private String idCa;
    private String idMonHoc;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public Lop(String id, String idGiangVien, String malop, String tenLop, int slHocVien, int slToiDa, String idCa, String idMonHoc, int trangThai, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.idGiangVien = idGiangVien;
        this.malop = malop;
        this.tenLop = tenLop;
        this.slHocVien = slHocVien;
        this.slToiDa = slToiDa;
        this.idCa = idCa;
        this.idMonHoc = idMonHoc;
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

    public String getIdGiangVien() {
        return idGiangVien;
    }

    public void setIdGiangVien(String idGiangVien) {
        this.idGiangVien = idGiangVien;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSlHocVien() {
        return slHocVien;
    }

    public void setSlHocVien(int slHocVien) {
        this.slHocVien = slHocVien;
    }

    public int getSlToiDa() {
        return slToiDa;
    }

    public void setSlToiDa(int slToiDa) {
        this.slToiDa = slToiDa;
    }

    public String getIdCa() {
        return idCa;
    }

    public void setIdCa(String idCa) {
        this.idCa = idCa;
    }

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
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
